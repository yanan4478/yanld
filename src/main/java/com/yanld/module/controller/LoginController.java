package com.yanld.module.controller;

import com.sun.deploy.net.HttpResponse;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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
                        @RequestParam(value = "pwd", required = true) String password,
                        HttpServletResponse response) {
        if ("yanan".equals(userName) && "8371593".equals(password)) {
            Cookie cookie = new Cookie("token", userName);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/";
        } else {
            //用户名或密码错误
            return "redirect:/welcome";
        }
    }
}
