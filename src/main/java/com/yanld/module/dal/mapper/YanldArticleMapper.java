package com.yanld.module.dal.mapper;

import com.yanld.module.dal.dataobject.YanldArticleDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleMapper {
    long insertArticle();

    int deleteArticle();

    int logicDeleteArticle();

    int updateArticle();

    YanldArticleDO selectArticle();

    List<YanldArticleDO> selectArticles();
}
