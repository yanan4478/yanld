package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;

import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleMapper {
    long insertArticle(YanldArticleDO yanldArticleDO);

    int deleteArticle();

    int logicDeleteArticle();

    int updateArticle();

    YanldArticleDO selectArticle(long id);

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(Map<String, List<Long>> idsMap);

    long selectArticleCount(YanldArticleQuery query);
}
