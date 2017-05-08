package com.yanld.module.controller;

import com.yanld.module.bo.YanldIndexBO;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.service.YanldArticleService;
import com.yanld.module.service.YanldIndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class ArticleController {


    /**
     * 首页展示区
     * @param model
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping({"/article"})
    public String showMainArtile(Map<String, Object> model) throws Exception {

        model.put("lgd", new LongToDate());
        return "/article/article";
    }


    /**
     * 首页展示区
     * @param model
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping({"/article_detail"})
    public String showMainArtileDetail(Map<String, Object> model) throws Exception {

        model.put("lgd", new LongToDate());
        return "/article/article_detail";
    }
}
