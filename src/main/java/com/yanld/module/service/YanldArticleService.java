package com.yanld.module.service;

import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleService {
    long insertArticle(YanldArticleDO yanldArticleDO);

    long deleteArticle(long id);

    long logicDeleteArticle(long id);

    long updateArticle(YanldArticleDO yanldArticleDO);

    YanldArticleDO selectArticle(long id);

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids);

    long selectArticleCount(YanldArticleQuery query);
}
