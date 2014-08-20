package com.zhy.spread.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Area;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.AreaService;
import com.zhy.spread.service.InfoClassService;
import com.zhy.spread.service.WeChatService;

/**
 * 主页控制器
 * 
 * @author zhy19890221@gmail.com
 * 
 */
@Controller
public class IndexController extends MultiActionController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private InfoClassService infoClassService;

    @Autowired
    private WeChatService weChatService;

    @RequestMapping("/index.do")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
//
//        // 省份
//        List<Area> provinces = areaService.findAllProvinces();
//
//        // 分类
//        List<InfoClass> classes = infoClassService.findTopClasses();
//
        // 获取推荐微信
        Recommend recommend = new Recommend();
        recommend.setPageSize(5);
        recommend.setAliasCode(100);
        Paging<WeChat> recommend100WeChats = weChatService.findRecommendWeChats(recommend);
        
        recommend.setPageSize(6);
        recommend.setAliasCode(201);
        Paging<WeChat> recommend201WeChats = weChatService.findRecommendWeChats(recommend);
        
        // 获取推荐微信
        recommend.setAliasCode(202);
        Paging<WeChat> recommend202dWeChats = weChatService.findRecommendWeChats(recommend);
        
        // 获取推荐微信
        recommend.setAliasCode(203);
        Paging<WeChat> recommend203dWeChats = weChatService.findRecommendWeChats(recommend); 
        
        // 最近收录
        Paging<WeChat> lastWeChats = weChatService.findRecentlyWeChats(new Page().setPageSize(10));

        // 排行榜
        Paging<WeChat> hotWeChats = weChatService.findHotWeChats(new Page().setPageSize(10));
        
        
        // 按行业分类
        InfoClass infoClass = new InfoClass();
        infoClass.setPageSize(4);
        
        // 资讯阅读
        infoClass.setId(10000L);
        Paging<WeChat> info10000WeChats = weChatService.findByInfoClass(infoClass);
        
        // 名人明星
        infoClass.setId(20000L);
        Paging<WeChat> info20000WeChats = weChatService.findByInfoClass(infoClass);
        
        // 生活购物
        infoClass.setId(30000L);
        Paging<WeChat> info30000WeChats = weChatService.findByInfoClass(infoClass);
        
        // 行业商家
        infoClass.setId(40000L);
        Paging<WeChat> info40000WeChats = weChatService.findByInfoClass(infoClass);
        
        // 影音娱乐
        infoClass.setId(50000L);
        Paging<WeChat> info50000WeChats = weChatService.findByInfoClass(infoClass);
        
        // 交友社区
        infoClass.setId(60000L);
        Paging<WeChat> info60000WeChats = weChatService.findByInfoClass(infoClass);
        
        // 游戏
        infoClass.setId(90000L);
        Paging<WeChat> info90000WeChats = weChatService.findByInfoClass(infoClass);
        
        
//        request.setAttribute("provinces", provinces);
//        request.setAttribute("classes", classes);
        request.setAttribute("rec100WeChats", recommend100WeChats.getResult());
        request.setAttribute("rec201WeChats", recommend201WeChats.getResult());
        request.setAttribute("rec202WeChats", recommend202dWeChats.getResult());
        request.setAttribute("rec203WeChats", recommend203dWeChats.getResult());
        request.setAttribute("recentlyWeChats", lastWeChats.getResult());
        request.setAttribute("hotWeChats", hotWeChats.getResult());
        request.setAttribute("info10000WeChats", info10000WeChats.getResult());
        request.setAttribute("info20000WeChats", info20000WeChats.getResult());
        request.setAttribute("info30000WeChats", info30000WeChats.getResult());
        request.setAttribute("info40000WeChats", info40000WeChats.getResult());
        request.setAttribute("info50000WeChats", info50000WeChats.getResult());
        request.setAttribute("info60000WeChats", info60000WeChats.getResult());
        request.setAttribute("info90000WeChats", info90000WeChats.getResult());
        return new ModelAndView("index.jsp");
    }
}
