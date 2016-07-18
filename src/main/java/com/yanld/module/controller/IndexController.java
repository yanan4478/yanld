package com.yanld.module.controller;

import com.yanld.module.bo.YanldIndexBO;
import com.yanld.module.service.YanldIndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class IndexController {

    @Resource
    private YanldIndexService indexService;

    @RequestMapping({"/"})
    public String showIndex(Map<String, Object> model) {
        YanldIndexBO indexBO = indexService.getIndexBO(1, 1);
        model.put("indexBO", indexBO);
        return "index";
    }

    @RequestMapping({"/{category:\\d+}-{page:\\d+}"})
    public String showIndex(Map<String, Object> model,
                            @PathVariable("category") int category,
                            @PathVariable("page") int page) {
        YanldIndexBO indexBO = indexService.getIndexBO(category, page);
        model.put("indexBO", indexBO);
        return "index";
    }
}
