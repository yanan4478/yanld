package com.yanld.module.common.dal.dao.impl;

import com.google.common.collect.Lists;
import com.yanld.module.common.dal.dao.BaseDao;
import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.mapper.YanldArticleMapper;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldArticleDaoImpl extends BaseDao implements YanldArticleDao {
    @Override
    public long insertArticle() {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.insertArticle();
    }

    @Override
    public int deleteArticle() {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.deleteArticle();
    }

    @Override
    public int logicDeleteArticle() {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.logicDeleteArticle();
    }

    @Override
    public int updateArticle() {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.updateArticle();
    }

    @Override
    public YanldArticleDO selectArticle(long id) {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticle(id);
    }

    @Override
    public List<YanldArticleDO> selectArticles(YanldArticleQuery query) {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticles(query);
    }

    @Override
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) {
        if (ids.isEmpty()) {
            return Lists.newArrayList();
        }
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        Map<String, List<Long>> idsMap = new HashMap<>();
        idsMap.put("ids", ids);
        return mapper.selectArticlesByIds(idsMap);
    }
}
