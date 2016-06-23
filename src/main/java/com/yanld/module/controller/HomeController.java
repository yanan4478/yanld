package com.yanld.module.controller;

import com.yanld.module.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController {
    public static final int DEFAULT_DATE_PER_PAGE = 20;
    private HomeService homeService = new HomeService();

//    @Inject
//    public HomeController(HomeService homeService) {
//        this.homeService = homeService;
//    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("doudous", homeService.getDoudous(DEFAULT_DATE_PER_PAGE));
        model.put("doudou", "sqk");
        return "home";
    }
}
