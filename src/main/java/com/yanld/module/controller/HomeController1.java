package com.yanld.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController1 {

    @RequestMapping({"/wqq1"})
    public @ResponseBody String showHomePage(HttpServletRequest request) throws Exception {

        //return "{\"name\":\"wqq\",\"age\":\"23\"}";
        return "{\"ok\":\"true\",\"code\":\"0\"}";
    }
}
