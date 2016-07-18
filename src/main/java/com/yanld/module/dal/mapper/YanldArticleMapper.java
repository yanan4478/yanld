package com.yanld.module.dal.mapper;

import com.yanld.module.dal.dataobject.YanldArticleDO;
import com.yanld.module.dal.query.YanldArticleQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleMapper {
    long insertArticle();

    int deleteArticle();

    int logicDeleteArticle();

    int updateArticle();

    YanldArticleDO selectArticle();

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(Map<String, List<Long>> idsMap);
}
