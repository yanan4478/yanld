package com.yanld.module.controller;

import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.service.YanldArticleService;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class Home4Controller {

    @Resource
    private YanldArticleService yanldUserService;

    @RequestMapping({"/hehe"})
    public String showHomePage(Map<String, Object> model) {
        YanldArticleDO articleDO = yanldUserService.selectArticle(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(articleDO.getCreateTime());
        articleDO.setArticleTitle(date);
        model.put("articleDO", articleDO);
        return "article";
    }
}
