package com.yanld.module.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yanan on 16/6/26.
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(!request.getServletPath().contains("write")) {
            return true;
        } else {
            Cookie[] cookies = request.getCookies();
            String userName = "";
            for(Cookie cookie : cookies) {
                if("token".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    break;
                }
            }
            if("".equals(userName)) {
                response.sendRedirect(request.getContextPath() + "welcome");
                return false;
            } else {
                request.getSession().setAttribute("","");
            }
        }
        return true;
    }
}
