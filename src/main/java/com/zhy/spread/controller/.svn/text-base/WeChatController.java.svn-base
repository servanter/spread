package com.zhy.spread.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhy.spread.common.Constant;
import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Action;
import com.zhy.spread.entity.Area;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.ActionService;
import com.zhy.spread.service.AreaService;
import com.zhy.spread.service.CommentService;
import com.zhy.spread.service.InfoClassService;
import com.zhy.spread.service.WeChatService;
import com.zhy.spread.util.RequestUtils;

/**
 * 微信控制器
 * 
 * @author zhy19890221@gmail.com
 * 
 */
@Controller
public class WeChatController {

    public static Logger logger = Logger.getLogger(WeChatController.class);

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private InfoClassService infoClassService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AreaService areaService;
    
    @Autowired
    private ActionService actionService;

    @RequestMapping("/weChat/weChatDetail.do")
    public ModelAndView weChatDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = Long.parseLong(request.getParameter("weChatId"));
        WeChat weChat = weChatService.findById(id);

        // 浏览
        Action action = actionService.findByWeChatId(id);
        if(action != null){
            action.setRead(action.getRead() + 1);
        } else {
            action = new Action();
            action.setRead(1);
            action.setEnjoy(0);
            action.setShare(0);
            WeChat chat = new WeChat();
            chat.setId(id);
            action.setWeChat(chat);
        }
        actionService.addOrModify(action);
        
        // TODO 猜你喜欢
        InfoClass infoClass = new InfoClass();
        infoClass.setId(10000L);
        infoClass.setPageSize(10);
        Paging<WeChat> likes = weChatService.findByInfoClass(infoClass);
        weChat.setPageSize(Constant.COMMENT_PAGESIZE);
        Paging<Comment> comments = commentService.findByWeChat(weChat);
        int[] sAndE = comments.getStartAndEndRange();
        System.out.println(sAndE[0] + "              " + sAndE[1]);
        request.setAttribute("se", sAndE);
        request.setAttribute("weChat", weChat);
        request.setAttribute("likeWeChats", likes.getResult());
        request.setAttribute("list", comments);
        return new ModelAndView("article.jsp");
    }

    @RequestMapping("/weChat/weChatList.do")
    public ModelAndView weChatList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int page = 1;
        int pageSize = 24;
        Long city = Constant.PROVINCE_AREA_PARENT_ID;
        Long infoClassId = Constant.INFOCLASS_PARENT_ID;
        try {
            if (request.getParameter("page") != null && request.getParameter("page").length() > 0) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (request.getParameter("pageSize") != null && request.getParameter("pageSize").length() > 0) {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            }
            if (request.getParameter("province") != null && request.getParameter("province").length() > 0) {
                city = Long.parseLong(request.getParameter("province"));
            }
            if (request.getParameter("infoClassId") != null && request.getParameter("infoClassId").length() > 0) {
                infoClassId = Long.parseLong(request.getParameter("infoClassId"));
            }
        } catch (Exception e) {
            logger.info("[ErrorParameters]:page:[" + page + "],pageSize:[" + pageSize + "],city:[" + city + "],infoClassId:[" + infoClassId + "]");
        }
        Paging<WeChat> list = null;
        String defaultInfoClassTitle = Constant.ALL_WECHAT_0;
        WeChat weChat = new WeChat();
        weChat.setPageSize(pageSize);
        weChat.setPage(page);
        if (infoClassId == Constant.INFOCLASS_PARENT_ID && city == Constant.PROVINCE_AREA_PARENT_ID) {
            list = weChatService.findWeChats(weChat);
        } else {
            if (infoClassId != Constant.INFOCLASS_PARENT_ID) {
                InfoClass infoClass = new InfoClass();
                infoClass.setId(Long.parseLong(request.getParameter("infoClassId")));
                weChat.setInfoClass(infoClass);
            }
            if (city != Constant.PROVINCE_AREA_PARENT_ID) {
                Area province = new Area();
                province.setId(city);
                weChat.setProvince(province);
            }
            list = weChatService.findByConditions(weChat);
            if (infoClassId != Constant.INFOCLASS_PARENT_ID) {
                defaultInfoClassTitle = infoClassService.findById(infoClassId).getTitle();
            }
        }

        // 最近收录
        Paging<WeChat> lastWeChats = weChatService.findRecentlyWeChats(new Page().setPageSize(10));

        // 排行榜
        Paging<WeChat> hotWeChats = weChatService.findHotWeChats(new Page().setPageSize(10));

        List<InfoClass> classes = infoClassService.findTopClasses();

        List<Area> areas = areaService.findAllProvinces();
        int[] sAndE = list.getStartAndEndRange();
        System.out.println(sAndE[0] + "              " + sAndE[1]);
        request.setAttribute("recentlyWeChats", lastWeChats.getResult());
        request.setAttribute("hotWeChats", hotWeChats.getResult());
        request.setAttribute("list", list);
        request.setAttribute("classes", classes);
        request.setAttribute("areas", areas);
        request.setAttribute("se", sAndE);
        request.setAttribute("city", city);
        request.setAttribute("infoClassId", infoClassId);
        request.setAttribute("infoClassTitle", defaultInfoClassTitle);
        return new ModelAndView("list.jsp");
    }

    @RequestMapping("/weChat/search.do")
    public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int p = RequestUtils.getPage(request);
        Long infoClassId = Constant.INFOCLASS_PARENT_ID;
        try {
            if (request.getParameter("infoClassId") != null && request.getParameter("infoClassId").length() > 0) {
                infoClassId = Long.parseLong(request.getParameter("infoClassId"));
            }
        } catch (Exception e) {
            logger.info("[ErrorParameters]:infoClassId:[" + infoClassId + "]");
        }
        String keyWords = request.getParameter("keywords");
        if (keyWords != null || keyWords.length() > 0) {
            String[] keyArr = keyWords.split(" ");
            WeChat weChat = new WeChat();
            weChat.setPage(p);
            if (infoClassId.longValue() != Constant.INFOCLASS_PARENT_ID) {
                InfoClass infoClass = new InfoClass();
                infoClass.setParentId(infoClassId);
                weChat.setInfoClass(infoClass);
            }
            Paging<WeChat> weChats = weChatService.searchByKeyWords(keyArr, weChat);

            // 前台样式
            if (weChats.getTotalRecord() > 0) {
                for (WeChat w : weChats.getResult()) {
                    for (String key : keyArr) {
                        if (w.getDescription().contains(key)) {
                            initDisplayDesc(w, key);
                            initTitle(w, key);
                        }
                    }
                }
            }
            int[] sAndE = weChats.getStartAndEndRange();
            request.setAttribute("se", sAndE);
            request.setAttribute("list", weChats);
        }
        // 排行榜

        // 类别
        List<InfoClass> classes = infoClassService.findTopClasses();

        // 最近收录
        Paging<WeChat> lastWeChats = weChatService.findRecentlyWeChats(new Page().setPageSize(10));
        Paging<WeChat> hotWeChats = weChatService.findHotWeChats(new Page().setPageSize(10));
        request.setAttribute("keywords", keyWords);
        request.setAttribute("recentlyWeChats", lastWeChats.getResult());
        request.setAttribute("hotWeChats", hotWeChats.getResult());
        request.setAttribute("classes", classes);
        request.setAttribute("infoClassId", infoClassId);
        return "search.jsp";
    }

    private void initDisplayDesc(WeChat w, String key) {
        try {
            String description = w.getDescription();
            int index = description.indexOf(key);
            if (index < 0) {
                return;
            }
            String preStr = description.substring(0, index) + "<b class=\"label\">";
            String result = "";
            int len = key.length();
            String postStr = description.substring(index + len);
            result = preStr + key + "</b>" + postStr;
            w.setDescription(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTitle(WeChat w, String key) {
        try {
            String description = w.getName();
            int index = description.indexOf(key);
            if (index < 0) {
                return;
            }
            String preStr = description.substring(0, index) + "<b class=\"label\">";
            String result = "";
            int len = key.length();
            String postStr = "";
            if (description.length() > len + index) {
                postStr = description.substring(index + len);
            } else {
                postStr = description.substring(index);
            }
            result = preStr + key + "</b>" + postStr;
            w.setDescription(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
