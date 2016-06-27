package com.yanld.module.controller;

import com.yanld.module.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController {
    public static final int DEFAULT_DATE_PER_PAGE = 20;

    @Resource
    private HomeService homeService;

//    public HomeController(HomeService homeService) {
//        this.homeService = homeService;
//    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("/spring/yanld.xml");
        //HomeService homeService = (HomeService)context.getBean("homeService");
        //homeService.print();
//        model.put("doudous", homeService.getDoudous(DEFAULT_DATE_PER_PAGE));
        homeService.print();
        model.put("doudou", "sqk");
        return "home";
    }
}
