package com.yanld.module.controller;

import com.yanld.module.bo.YanldDetailArticleBO;
import com.yanld.module.bo.YanldIndexBO;
import com.yanld.module.service.YanldDetailService;
import com.yanld.module.service.YanldIndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                            @PathVariable("articleId") long articleId, HttpSession session,
                            HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getCookies();
            Cookie cookie = new Cookie("wocao", "sqk");
            response.addCookie(cookie);
            Object o = session.getAttribute("user");
            YanldDetailArticleBO detailArticleBO = detailService.getDetailArticleBO(articleId);
            model.put("detailArticleBO", detailArticleBO);
            return "detailArticle";
        } catch (Exception e) {
            return "redirect:error";
        }
    }
}
