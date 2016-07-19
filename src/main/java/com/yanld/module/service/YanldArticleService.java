package com.yanld.module.service;

import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleService {
    long insertArticle();

    int deleteArticle();

    int logicDeleteArticle();

    int updateArticle();

    YanldArticleDO selectArticle(long id);

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids);
}
