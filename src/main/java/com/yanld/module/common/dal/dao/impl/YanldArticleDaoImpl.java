package com.yanld.module.common.dal.dao.impl;

import com.yanld.module.common.annotation.OperateInRedis;
import com.yanld.module.common.dal.dao.AbstractDao;
import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.mapper.YanldArticleMapper;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldArticleDaoImpl extends AbstractDao implements YanldArticleDao {
    @Override
    @OperateInRedis
    public Long insertArticle(YanldArticleDO yanldArticleDO) {
        sqlSession.getMapper(YanldArticleMapper.class).insertArticle(yanldArticleDO);
        return yanldArticleDO.getId();
    }

    @Override
    @OperateInRedis
    public Long deleteArticle(Long id) {
        return sqlSession.getMapper(YanldArticleMapper.class).deleteArticle(id);
    }

    @Override
    @OperateInRedis
    public Long logicDeleteArticle(Long id) {
        return sqlSession.getMapper(YanldArticleMapper.class).logicDeleteArticle(id);
    }

    @Override
    @OperateInRedis
    public Long updateArticle(YanldArticleDO yanldArticleDO) {
        return sqlSession.getMapper(YanldArticleMapper.class).updateArticle(yanldArticleDO);
    }

    @Override
    @OperateInRedis
    public YanldArticleDO selectArticle(Long id) {
        return sqlSession.getMapper(YanldArticleMapper.class).selectArticle(id);
    }

    @Override
    @OperateInRedis
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        Map<String, List<Long>> idsMap = new HashMap<>();
        idsMap.put("ids", ids);
        return mapper.selectArticlesByIds(idsMap);
    }

    @Override
    @OperateInRedis
    public List<YanldArticleDO> selectArticleQuery(YanldArticleQuery query) {
        return sqlSession.getMapper(YanldArticleMapper.class).selectArticles(query);
    }

    @Override
    @OperateInRedis
    public Long selectArticleCount(YanldArticleQuery query) {
        return sqlSession.getMapper(YanldArticleMapper.class).selectArticleCount(query);
    }
}
