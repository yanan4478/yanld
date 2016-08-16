package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;

import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleMapper {
    Long insertArticle(YanldArticleDO yanldArticleDO);

    Long deleteArticle(long id);

    Long logicDeleteArticle(long id);

    Long updateArticle(YanldArticleDO yanldArticleDO);

    YanldArticleDO selectArticle(long id);

    List<YanldArticleDO> selectArticles(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(Map<String, List<Long>> idsMap);

    Long selectArticleCount(YanldArticleQuery query);
}
