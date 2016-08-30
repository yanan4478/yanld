package com.yanld.module.controller;

import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yanan on 16/8/25.
 */
@Controller
public class LoginController {

    @RequestMapping("/welcome")
    public String login() {
        return "welcome";
    }

    @Resource
    private YanldUserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "uname", required = true) String userName,
                        @RequestParam(value = "pwd", required = true) String userPassword,
                        HttpServletRequest request, HttpServletResponse response) {
        YanldUserDO user = userService.userLogin(userName, userPassword);
        if (user != null) {
            request.getSession().setAttribute("userId", user.getId());
            String tokenContent = userName + user.getLastLoginTime().getTime()/1000;

            Cookie token = new Cookie("token", DigestUtils.md5DigestAsHex(tokenContent.getBytes()));
            token.setMaxAge(BaseConstant.COOKIE_LAST_SECONDS);
            token.setHttpOnly(true);
            token.setPath("/");

            Cookie name = new Cookie("user", userName);
            name.setMaxAge(BaseConstant.COOKIE_LAST_SECONDS);
            name.setPath("/");

            response.addCookie(token);
            response.addCookie(name);
            return "redirect:/";
        } else {
            //用户名或密码错误
            return "redirect:/welcome";
        }
    }
}
