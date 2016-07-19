package com.yanld.module.common.dal.dao;

import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleDao {
    long insertArticle();

    int deleteArticle();

    int logicDeleteArticle();

    int updateArticle();

    YanldArticleDO selectArticle(long id);

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids);
}
