package com.yanld.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController1 {

    @RequestMapping({"/home111"})
    public @ResponseBody String showHomePage() throws Exception {
        return "{\"name\":\"wqq\",\"age\":\"23\"}";
    }
}
