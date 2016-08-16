package com.yanld.module.common.dal.dao;

import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldArticleDao extends BaseDao {
    Long insertArticle(YanldArticleDO yanldArticleDO);

    Long deleteArticle(Long id);

    Long logicDeleteArticle(Long id);

    Long updateArticle(YanldArticleDO yanldArticleDO);

    YanldArticleDO selectArticle(Long id);

    List<YanldArticleDO> selectArticleQuery(YanldArticleQuery query);

    List<YanldArticleDO> selectArticlesByIds(List<Long> ids);

    Long selectArticleCount(YanldArticleQuery query);
}
