package com.yanld.module.common.dal.dao;

import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleDao {
    long insertArticle(YanldArticleDO yanldArticleDO);

    long deleteArticle(long id);

    long logicDeleteArticle(long id);

    long updateArticle(YanldArticleDO yanldArticleDO);

    YanldArticleDO selectArticle(long id);

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids);

    long selectArticleCount(YanldArticleQuery query);
}
