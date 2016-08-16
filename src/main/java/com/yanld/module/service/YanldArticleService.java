package com.yanld.module.service;

import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleService {
    Long insertArticle(YanldArticleDO yanldArticleDO) throws Exception;

    Long deleteArticle(Long id) throws Exception;

    Long logicDeleteArticle(Long id) throws Exception;

    Long updateArticle(YanldArticleDO yanldArticleDO) throws Exception;

    YanldArticleDO selectArticle(Long id) throws Exception;

    List<YanldArticleDO> selectArticleQuery(YanldArticleQuery query) throws Exception;

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids) throws Exception;

    Long selectArticleCount(YanldArticleQuery query) throws Exception;
}
