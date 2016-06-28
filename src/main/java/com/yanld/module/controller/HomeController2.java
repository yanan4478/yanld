package com.yanld.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController2 {

    @RequestMapping({"/wqq"})
    public void showHomePage(HttpServletResponse response) throws Exception {
        response.getWriter().write("hehe");
    }
}
