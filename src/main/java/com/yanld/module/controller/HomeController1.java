package com.yanld.module.controller;

import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.service.YanldArticleService;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController1 {

    @Resource
    private YanldArticleService articleService;
    @RequestMapping({"/wqq1"})
    public @ResponseBody String showHomePage(HttpServletRequest request) throws Exception {
        articleService.selectArticleCount(new YanldArticleQuery());
        //return "{\"name\":\"wqq\",\"age\":\"23\"}";
        return "{\"ok\":\"true\",\"code\":\"0\"}";
    }
}
