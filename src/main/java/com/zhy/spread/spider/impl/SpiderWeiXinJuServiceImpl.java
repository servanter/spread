package com.zhy.spread.spider.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.print.Doc;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.common.Constant;
import com.zhy.spread.entity.Area;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.User;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.ActionService;
import com.zhy.spread.service.AreaService;
import com.zhy.spread.service.CommentService;
import com.zhy.spread.service.WeChatService;
import com.zhy.spread.spider.SpiderWeiXinJuService;
import com.zhy.spread.util.DateUtils;
import com.zhy.spread.util.DownloadUtils;
import com.zhy.spread.util.RandomUtils;

@Service
public class SpiderWeiXinJuServiceImpl implements SpiderWeiXinJuService {

    private Logger logger = Logger.getLogger(SpiderWeiXinJuService.class);
   
    @Autowired
    private WeChatService weChatService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private AreaService areaService;

    @Override
    public void fetch(String url) {
         List<Area> provinces = areaService.findAllProvinces();
         List<Object> areaObj = areaService.findAllAreas();
         Map<Long, List<Area>> secound = (Map<Long, List<Area>>) areaObj.get(1);
         InfoClass infoClass = new InfoClass();
         infoClass.setId(80005L);
         User user = new User();
         user.setId(0L);
        try {
            List<WeChat> needSaveData = Collections.synchronizedList(new ArrayList());
            List<String> links = new ArrayList<String>();
            List<String> errorLinks = new ArrayList<String>();
//            links = getWeiXinJuLinks(url, links);
            
            links = getFromFile(links);
            for (String link : links) {
                logger.info("Fetch " + link + " data...");
                try {
                    Document d = Jsoup.connect(link).get();
                    Elements elements = d.getElementsByClass("gray");
                    WeChat weChat = new WeChat();
                    weChat.setInfoClass(infoClass);
                    weChat.setUser(user);
                    weChat.setName(elements.get(1).text());
                    weChat.setRowAliasNum(elements.get(2).text());
                    weChat.setAliasNum(elements.get(3).text());
                    weChat.setUrl(elements.get(5).text());
                    weChat.setDescription(d.getElementById("briefmore").getElementsByTag("p").get(0).text());
                    
                    // 原图片
                    String pic = d.getElementsByClass("pic").get(0).getElementsByTag("img").attr("src");
                    weChat.setRowIcon(DownloadUtils.downloadPath(pic));
                    
                    // 二维码
                    String code = d.getElementsByClass("piccode").get(0).getElementsByTag("img").attr("src");
                    weChat.setQrCode(DownloadUtils.downloadPath(code));
                    
                    // 关键词
                    String keywords = "";
                    for(Element ee :elements.get(6).getElementsByTag("a")){
                        keywords += ee.text() + " ";
                    }
                    keywords = keywords.trim();
                    weChat.setKeywords(keywords);
                    String[] location = elements.get(7).text().split(">");
                    String thisProvince = "";
                    String thisCity = "";
                    if(location != null && location.length == 2){
                        thisProvince = location[0].trim();
                        thisCity = location[1].trim();
                    }else{
                        thisProvince = location[0].trim();
                    }
                    
                    // 匹配城市
                    loop : for (Area a : provinces) {
                        if (a.getAreaName().equals(thisProvince) || (a.getAreaName() + "市").equals(thisProvince) || (a.getAreaName() + "省").equals(thisProvince)) {
                            weChat.setProvince(a);
                            if(thisCity != null && thisCity.length() > 0){
                                
                                List<Area> cities = secound.get(a.getId());
                                for(Area city : cities){
                                    if ((city.getAreaName() + "市").equals(thisCity) || (city.getAreaName() + "区").equals(thisCity)) {
                                        weChat.setCity(city);
                                        break loop;
                                    }
                                }
                            }
                        }
                    }
                    if(weChat.getProvince() == null){
                        Area ap = new Area();
                        ap.setId(Constant.PROVINCE_AREA_PARENT_ID);
                        weChat.setProvince(ap);
                    }
                    if(weChat.getCity() == null){
                        Area ap = new Area();
                        ap.setId(Constant.PROVINCE_AREA_PARENT_ID);
                        weChat.setCity(ap);
                    }
                    weChat.setCreateTime(new Timestamp(DateUtils.str2Date(elements.get(8).text()).getTime()));
                    needSaveData.add(weChat);
                } catch (Exception e) {
                    logger.error("Error link    " + link);
                    errorLinks.add(link);
                    continue;
                }
                
            }
            weChatService.batchSave(needSaveData);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("d:\\errors\\link.txt"), true));
            for(String error : errorLinks){
                System.out.println(error);
                outputStream.write(error.getBytes());
                outputStream.write("\r\n".getBytes());
            }
            outputStream.flush();
            outputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<String> getFromFile(List<String> links) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\errors\\link.txt")));
        String str = null;
        while((str = reader.readLine()) != null){
            links.add(str);
        }
        return links;
    }

    private List<String> getWeiXinJuLinks(String url, List<String> links) throws IOException {
        Document document = Jsoup.connect(url).timeout(10000).get();
        logger.info("Getting html " + url + "...");
        Elements es = document.getElementsByClass("tjitem");
        for (Element e : es) {
            if (e.attr("href").equals("")) {
                break;
            }
            if (!links.contains(e.attr("href"))) {
                links.add(e.attr("href"));
            }
        }
        if (document.getElementsMatchingOwnText("下一页") != null && document.getElementsMatchingOwnText("下一页").size() > 0) {
            Element next = document.getElementsMatchingOwnText("下一页").get(0);
            if (!next.attr("href").equals(url)) {
                getWeiXinJuLinks(next.attr("href"), links);
            }
        }
        return links;
    }

    private List<String> getJuWeiXinLinks(String url, List<String> links) throws IOException {
        Document document = Jsoup.connect(url).get();
        logger.info("Getting " + url + "...");
        Document listDocument = Jsoup.connect(url).get();
        Elements elements = listDocument.getElementsByClass("items-box");
        Element element = elements.get(0);
        Elements as = element.getElementsByTag("a");
        for (Element a : as) {
            if (!links.contains(a.attr("href"))) {
                System.out.println("Adding " + a.attr("href") + "...");
                links.add(a.attr("href"));
            }
        }
        if (document.getElementsMatchingOwnText("下一页") != null && document.getElementsMatchingOwnText("下一页").size() > 0) {
            Element next = document.getElementsMatchingOwnText("下一页").get(0);
            getJuWeiXinLinks(next.attr("href"), links);
        }
        return links;
    }
}
