package com.yanld.module.controller;

import com.yanld.module.bo.YanldIndexBO;
import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.service.YanldArticleService;
import com.yanld.module.service.YanldIndexService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class IndexController {

    @Resource
    private YanldIndexService indexService;

    @Resource
    private YanldArticleService articleService;

    @RequestMapping({"/"})
    public String showIndex(Map<String, Object> model, @RequestParam(value = "l", defaultValue = "0") String doLogin) throws Exception {
        YanldIndexBO indexBO = indexService.getIndexBO(1, 1);
        articleService.selectArticleCount(new YanldArticleQuery());
        model.put("lgd", new LongToDate());
        model.put("indexBO", indexBO);
        model.put("doLogin", doLogin);
        return "index";
    }

    @RequestMapping({"/{category:\\d+}-{page:\\d+}"})
    public String showIndex(Map<String, Object> model,
                            @PathVariable("category") int category,
                            @PathVariable("page") int page) {
        try {
            YanldIndexBO indexBO = indexService.getIndexBO(category, page);
            model.put("indexBO", indexBO);
            return "index";
        } catch (Exception e) {
            return "redirect:error";
        }
    }

    /**
     * 首页展示区
     * @param model
     * @param doLogin
     * @return
     * @throws Exception
     */
    @RequestMapping({"/index"})
    public String showMainIndex(Map<String, Object> model, @RequestParam(value = "l", defaultValue = "0") String doLogin) throws Exception {
        YanldIndexBO indexBO = indexService.getIndexBO(1, 1);
        articleService.selectArticleCount(new YanldArticleQuery());
        model.put("lgd", new LongToDate());
        model.put("indexBO", indexBO);
        model.put("doLogin", doLogin);
        return "/index/index";
    }
}
