package com.yanld.module.service.impl;

import com.yanld.module.bo.YanldDetailArticleBO;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.util.DateUtils;
import com.yanld.module.service.YanldArticleService;
import com.yanld.module.service.YanldDetailService;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yanan on 16/7/19.
 */
@Service
public class YanldDetailServiceImpl implements YanldDetailService {
    @Resource
    private YanldArticleService articleService;
    @Resource
    private YanldUserService userService;

    @Override
    public YanldDetailArticleBO getDetailArticleBO(long articleId) throws Exception{
        YanldArticleDO articleDO = articleService.selectArticle(articleId);
        YanldDetailArticleBO articleBO = new YanldDetailArticleBO();
        articleBO.setArticleTitle(articleDO.getArticleTitle());
        articleBO.setArticleContent(articleDO.getArticleContent());
        articleBO.setReadNum(articleDO.getArticleReadNum());
        String createTime = DateUtils.convertDateToString(articleDO.getCreateTime(), DateUtils.FORMAT_STRING_ONE);
        articleBO.setCreateTime(createTime);
        YanldUserDO userDO = userService.selectUser(articleDO.getUserId());
        articleBO.setAuthorName(userDO.getUserName());
        return articleBO;
    }

}
