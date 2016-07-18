package com.yanld.module.dal.dao;

import com.yanld.module.dal.dataobject.YanldArticleDO;
import com.yanld.module.dal.query.YanldArticleQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleDao {
    long insertArticle();

    int deleteArticle();

    int logicDeleteArticle();

    int updateArticle();

    YanldArticleDO selectArticle();

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids);
}
