package com.yanld.module.interceptor;

import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldUserQuery;
import com.yanld.module.service.YanldUserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yanan on 16/6/26.
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private YanldUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (isNotPermissionPage(request)) {
            return true;
        }
        if (isUserInSession(request)) {
            return true;
        }
        recoverUserSession(request);
        if (isUserInSession(request)) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "?l=1");
        return false;
    }

    private boolean isNotPermissionPage(HttpServletRequest request) {
        return !request.getServletPath().contains("write");
    }

    private boolean isUserInSession(HttpServletRequest request) {
        return request.getSession() != null && request.getSession().getAttribute("userId") != null;
    }

    private void recoverUserSession(HttpServletRequest request) throws Exception {
        Cookie[] cookies = request.getCookies();
        String token = "";
        String userName = "";
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
            if ("user".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }
        if ("".equals(token) || "".equals(userName)) {
            return;
        }
        YanldUserQuery query = new YanldUserQuery();
        query.setUserName(userName);
        List<YanldUserDO> userDOs = userService.selectUserQuery(query);
        if (userDOs.size() != 1) {
            return;
        }
        YanldUserDO user = userDOs.get(0);
        long lastLoginTime = user.getLastLoginTime().getTime() / 1000;
        String tokenContent = userName + lastLoginTime;
        if (!token.equals(DigestUtils.md5DigestAsHex(tokenContent.getBytes()))
                || (System.currentTimeMillis() / 1000 - lastLoginTime) > BaseConstant.COOKIE_LAST_SECONDS) {
            return;
        }
        request.getSession().setAttribute("userId", user.getId());
    }
}
