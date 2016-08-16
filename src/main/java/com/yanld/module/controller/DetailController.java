package com.yanld.module.controller;

import com.yanld.module.bo.YanldDetailArticleBO;
import com.yanld.module.bo.YanldIndexBO;
import com.yanld.module.service.YanldDetailService;
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
public class DetailController {

    @Resource
    private YanldDetailService detailService;

    @RequestMapping({"/detail/article/{articleId:\\d+}"})
    public String showIndex(Map<String, Object> model,
                            @PathVariable("articleId") long articleId) {
        try {
            YanldDetailArticleBO detailArticleBO = detailService.getDetailArticleBO(articleId);
            model.put("detailArticleBO", detailArticleBO);
            return "detailArticle";
        } catch (Exception e) {
            return "redirect:error";
        }
    }
}
