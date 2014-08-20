package com.zhy.spread.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhy.spread.common.CommonResponse;
import com.zhy.spread.common.Constant;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.UserService;
import com.zhy.spread.util.CookieUtils;
import com.zhy.spread.util.MD5Utils;
import com.zhy.spread.util.MemcachedUtil;

/**
 * 用户控制器
 * 
 * @author zhy19890221@gmail.com
 * 
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/beforeLogin.do")
    public String beforeLogin(HttpServletRequest request, HttpServletResponse response) {
        return "/login.jsp";
    }

    @RequestMapping("/beforeRegister.do")
    public String beforeRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "register.jsp";
    }

    @RequestMapping("/userLogin.do")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        user.setPassword(MD5Utils.getKeyedDigest(user.getPassword(), ""));
        user = userService.login(user);
        if (user != null && user.getId() > 0L) {
            request.getSession().setAttribute(Constant.SESSION_USER_ALIAS, user);
            return "redirect:/index.do";
        }
        return "login.jsp?sign=false";
    }

    @RequestMapping("/ajaxUserLogin.do")
    public String ajaxUserLogin(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        user.setPassword(MD5Utils.getKeyedDigest(user.getPassword(), ""));
        user = userService.login(user);
        CommonResponse commonResponse = new CommonResponse();
        if (user != null && user.getId() > 0L) {
            MemcachedUtil.getInstance().set("session." + request.getSession().getId(), user, MemcachedUtil.MINUTE * 30);
//            request.getSession().setAttribute(request.getSession().getId(), user);
//            request.getSession().setAttribute("user", user);
            commonResponse.setData(user.toJSON());
            commonResponse.setReturnCode(ReturnCode.OK);
            if(request.getParameter("isCookie") != null && request.getParameter("isCookie").equals("" + Constant.CONSTANT_1)){
                CookieUtils.add(response, Constant.COOKIE_SESSION_KEY, request.getSession().getId());
            }
        } else {
            commonResponse.setReturnCode(ReturnCode.USER_NAME_OR_PASSWROD_ERROR);
        }
        response.getWriter().print(commonResponse.toJSON());
        return null;
    }

    @RequestMapping("/ajaxUserLogout.do")
    public String ajaxUserLoginout(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        if (request.getSession().getAttribute(Constant.SESSION_USER_ALIAS) != null) {
            request.getSession().setAttribute(Constant.SESSION_USER_ALIAS, null);
        }
        return null;
    }

    @RequestMapping("/userRegister.do")
    public String userRegister(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        ReturnCode returnCode = userService.checkParametersIsValid(user);
        if (returnCode == ReturnCode.OK) {
            user = userService.register(user);
            if (user != null && user.getId() > 0L) {
                request.getSession().setAttribute(Constant.SESSION_USER_ALIAS, user);
                return "redirect:/index.do";
            } else {
                returnCode = ReturnCode.SYSTEM_ERROR;
            }
        }
        request.setAttribute("commonResponse", new CommonResponse(returnCode));
        return "register.jsp";
    }

}
