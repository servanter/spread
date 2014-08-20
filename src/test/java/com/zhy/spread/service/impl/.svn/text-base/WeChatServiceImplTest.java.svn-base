package com.zhy.spread.service.impl;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Area;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.User;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.RecommendService;
import com.zhy.spread.service.WeChatService;

public class WeChatServiceImplTest extends SuperTest {

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private RecommendService recommendService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        weChatService = null;
    }

    @Test
    public void testAddOrModify() {
        InfoClass infoClass = new InfoClass();
        infoClass.setId(50000L);
        // infoClass.setParentId(111L);
        // infoClass.setTitle("adsa");
        // infoClass.setContent("asdads");
        WeChat weChat = new WeChat();
        weChat.setInfoClass(infoClass);

        Area area = new Area();
        area.setId(1L);
        // area.setAreaName("北京");
        // area.setAreaEname("beijing");
        // area.setParentId(0L);

        Area city = new Area();
        city.setId(200L);
        // city.setAreaName("昌平");
        // city.setAreaEname("changping");
        // city.setParentId(1L);

        weChat.setName("斌斌逗你玩");
        weChat.setProvince(area);
        weChat.setCity(city);
        weChat.setRowAliasNum("gh_123123132123");
        weChat.setAliasNum("1231sdadad123");
        weChat.setDescription("斌斌逗你玩");
        weChat.setKeywords("斌斌逗你玩");
        weChat.setRowIcon("http://www.weixinju.com/uploadfile/2013/1114/20131114103053153.jpg");
        weChat.setQrCode("http://www.weixinju.com/uploadfile/2013/1114/20131114103053153.jpg");
        weChat.setUrl("www.baidu.com");
        weChat.setUser(new User(1L));
        // List<Recommend> recommends = recommendService.findAllRecommends();
        // for(Recommend recommend : recommends){
        // weChat.getRecommends().add(recommend);
        // }
        Recommend recommend = new Recommend();
        recommend.setId(4L);
        weChat.getRecommends().add(recommend);
//        List<WeResource> wr = new ArrayList<WeResource>();
//        WeResource w = new WeResource();
//        w.setUrl("www.nmmm.cmo");
//        wr.add(w);
//        weChat.setWeResource(wr);
        weChat = weChatService.addOrModify(weChat);
        Assert.assertTrue("Can't save the wechat.", weChat.getId() != null);
    }

    @Test
    public void testFindWeChats() {
        Paging<WeChat> wechats = weChatService.findWeChats(new WeChat());
        Assert.assertTrue("Can't find the wechats.", wechats != null && wechats.getTotalRecord() > 0);
    }

    @Test
    public void testFindRecommendWeChats() {
        Recommend recommend = new Recommend();
        recommend.setAliasCode(100);
        Paging<WeChat> weChats = weChatService.findRecommendWeChats(recommend);
        for(Recommend r : weChats.getResult().get(0).getRecommends()){
            System.out.println(r.getDescription());
        }
    }

    @Test
    public void testSearchKeyWords() {
        String[] keyWords = new String[] { "旅游", "体育" };
        Paging<WeChat> weChats = weChatService.searchByKeyWords(keyWords, new WeChat());
        System.out.println(weChats.getTotalRecord());
        Assert.assertTrue("Can't find the wechats by keywords", weChats.getTotalRecord() > 0);
    }
    
    @Test
    public void testFindHotWeChats(){
        weChatService.findHotWeChats(new Page());
    }
}
