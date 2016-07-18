package com.yanld.module.dal.dao.impl;

import com.yanld.module.dal.dao.BaseDao;
import com.yanld.module.dal.dao.YanldArticleDao;
import com.yanld.module.dal.dataobject.YanldArticleDO;
import com.yanld.module.dal.mapper.YanldArticleMapper;
import com.yanld.module.dal.query.YanldArticleQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldArticleDaoImpl extends BaseDao implements YanldArticleDao
{
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
    public YanldArticleDO selectArticle() {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticle();
    }

    @Override
    public List<YanldArticleDO> selectArticles(YanldArticleQuery query) {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticles(query);
    }

    @Override
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) {
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticlesByIds(ids);
    }
}
