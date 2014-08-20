package com.zhy.spread.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhy.spread.common.Constant;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.UserService;
import com.zhy.spread.util.CookieUtils;
import com.zhy.spread.util.MemcachedUtil;

public class LoginFilter implements Filter {

    String[] includeURL = null;

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
        userService = (UserService) webApplicationContext.getBean("userService");
        String value = filterConfig.getInitParameter("exceptURL");
        value = value.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll(", ", ",");
        if (value.indexOf(",") != -1) {
            includeURL = value.split(",");
        } else {
            includeURL = new String[1];
            includeURL[0] = value;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextPath = req.getContextPath();
        String fullURL = req.getRequestURI();
        String targetURL = fullURL.substring(contextPath.length() + 1);

        boolean flag = false;
        if (targetURL == null || targetURL.equals("")) {
            flag = true;

        } else {
            for (int i = 0; i < includeURL.length; i++) {
                if (targetURL.contains(includeURL[i])) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            Object object = MemcachedUtil.getInstance().get("session." + req.getSession().getId());
            if (object == null) {
                String sessionId = CookieUtils.get(req, Constant.COOKIE_SESSION_KEY);
                if (sessionId != null && sessionId.length() > 0) {
                    Object o = MemcachedUtil.getInstance().get("session." + sessionId);
                    if (o == null) {

                        // 已经过期了
                    } else {
                        User user = (User) o;
                        User u = userService.login(user);
                        if (u == null || u.getId() == null || u.getId() == 0L) {

                            // 用户已经修改密码
                            MemcachedUtil.getInstance().delete("session." + sessionId);
                            req.getSession().setAttribute(sessionId, null);
                        } else {

                            // 设置cookie中新的sessionid
                            CookieUtils.add(resp, Constant.COOKIE_SESSION_KEY, req.getSession().getId());

                            // 删除旧的memcached中的sessionid并设置新的sessionid
                            MemcachedUtil.getInstance().delete("session." + sessionId);
                            MemcachedUtil.getInstance().set("session." + req.getSession().getId(), user, MemcachedUtil.MINUTE * 30);
                            req.setAttribute("user", u);
                        }
                    }
                }
            } else {
                req.setAttribute("user", object);
            }
        }
        arg2.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
