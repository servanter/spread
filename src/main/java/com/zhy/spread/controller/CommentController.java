package com.zhy.spread.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zhy.spread.common.Constant;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.User;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.CommentService;
import com.zhy.spread.util.RequestUtils;

/**
 * 主页控制器
 * 
 * @author zhy19890221@gmail.com
 * 
 */
@Controller
public class CommentController extends MultiActionController {

    public static Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment/commentList.do")
    public ModelAndView commentList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        int page = 1;
        int pageSize = Constant.COMMENT_PAGESIZE;
        try {
            if (request.getParameter("page") != null && request.getParameter("page").length() > 0) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (request.getParameter("pageSize") != null && request.getParameter("pageSize").length() > 0) {
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("The page and pagesize of comment is error.");
        }
        Long weChatId = Long.parseLong(request.getParameter("wechat_id"));
        WeChat weChat = new WeChat();
        weChat.setPageSize(pageSize);
        weChat.setPage(page);
        weChat.setId(weChatId);
        Paging<Comment> comments = commentService.findByWeChat(weChat);
        JSONArray array = new JSONArray();
        if (comments != null && comments.getResult() != null) {
            for (Comment comment : comments.getResult()) {
                array.add(comment.toJSON());
            }
        }
        JSONObject object = new JSONObject();
        object.put("data", array);
        object.put("pageSize", pageSize);
        object.put("page", page);
        object.put("totalPage", comments.getTotalPage());
        int[] sAndE = comments.getStartAndEndRange();
        object.put("start", sAndE[0]);
        object.put("end", sAndE[1]);
        response.getWriter().print(object);
        return null;
    }

    @RequestMapping("/comment/comment.do")
    public ModelAndView comment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");

        // TODO
        User u = new User();
        u.setId(1L);
        u.setUserName("hongyan");
        u.setPicUrl("duface.png");
        request.getSession().setAttribute(Constant.SESSION_USER_ALIAS, u);
        Long weChatId = Long.parseLong(request.getParameter("wechat_id"));
        String content = request.getParameter("content");
        WeChat weChat = new WeChat();
        weChat.setId(weChatId);
        Comment comment = new Comment();
        comment.setWeChat(weChat);
        comment.setCommentTime(new Timestamp(System.currentTimeMillis()));
        comment.setContent(content);
        comment.setUser(RequestUtils.getUserInSession(request));
        comment.setUserName(RequestUtils.getUserInSession(request).getUserName());
        comment.setPicUrl(RequestUtils.getUserInSession(request).getPicUrl());
        comment.setIsValid(true);
        comment = commentService.addOrModify(comment);
        JSONObject object = new JSONObject();
        boolean isSuccess = false;
        if (comment.getId() != null && comment.getId() > 0L) {
            isSuccess = true;
            weChatId = Long.parseLong(request.getParameter("wechat_id"));
            weChat = new WeChat();
            weChat.setPageSize(Constant.COMMENT_PAGESIZE);
            weChat.setPage(1);
            weChat.setId(weChatId);
            Paging<Comment> comments = commentService.findByWeChat(weChat);
            JSONArray array = new JSONArray();
            if (comments != null && comments.getResult() != null) {
                for (Comment c : comments.getResult()) {
                    array.add(c.toJSON());
                }
            }
            object.put("data", array);
            object.put("pageSize", Constant.COMMENT_PAGESIZE);
            object.put("page", 1);
            object.put("totalPage", comments.getTotalPage());
            int[] sAndE = comments.getStartAndEndRange();
            object.put("start", sAndE[0]);
            object.put("end", sAndE[1]);
        }
        object.put("isSuccess", isSuccess);
        response.getWriter().print(object);
        return null;
    }
}
