package com.zhy.spread.util;

import javax.servlet.http.HttpServletRequest;

import com.zhy.spread.common.Constant;
import com.zhy.spread.entity.User;

public class RequestUtils {

    public static User getUserInSession(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(Constant.SESSION_USER_ALIAS);
    }

    public static int getPage(HttpServletRequest request) {
        String page = request.getParameter("page");
        if (page == null || page.length() == 0) {
            return Constant.DEFAULT_PAGE;
        }
        int p = Constant.DEFAULT_PAGE;
        try {
            p = Integer.parseInt(page);
        } catch (Exception e) {
            p = Constant.DEFAULT_PAGE;
        }
        return p;
    }
}
