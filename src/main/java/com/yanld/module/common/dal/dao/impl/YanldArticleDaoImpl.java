package com.yanld.module.common.dal.dao.impl;

import com.google.common.collect.Lists;
import com.yanld.module.common.dal.dao.BaseDao;
import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.mapper.YanldArticleMapper;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.util.DataUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldArticleDaoImpl extends BaseDao implements YanldArticleDao {
    @Override
    public long insertArticle(YanldArticleDO yanldArticleDO) {
        long result = sqlSession.getMapper(YanldArticleMapper.class).insertArticle(yanldArticleDO);
        if(result > 0) {
            setObjectToRedisWithList(yanldArticleDO);
        }
        return yanldArticleDO.getId();
    }

    @Override
    public long deleteArticle(long id) {
        YanldArticleDO articleDO = selectArticle(id);
        if(articleDO == null) {
            return 0;
        }
        long result = sqlSession.getMapper(YanldArticleMapper.class).deleteArticle(id);
        if(result > 0) {
            deleteObjectInRedis(articleDO);
        }
        return result;
    }

    @Override
    public long logicDeleteArticle(long id) {
        YanldArticleDO articleDO = selectArticle(id);
        if(articleDO == null) {
            return 0;
        }
        long result = sqlSession.getMapper(YanldArticleMapper.class).logicDeleteArticle(id);
        if(result > 0) {
            deleteObjectInRedis(articleDO);
        }
        return result;
    }

    @Override
    public long updateArticle(YanldArticleDO yanldArticleDO) {
        YanldArticleDO articleDO = selectArticle(yanldArticleDO.getId());
        if(articleDO == null) {
            return 0;
        }
        long result = sqlSession.getMapper(YanldArticleMapper.class).updateArticle(yanldArticleDO);
        if(result > 0) {
            setObjectToRedis(yanldArticleDO);
        }
        return result;
    }

    @Override
    public YanldArticleDO selectArticle(long id) {
//        YanldArticleDO yanldArticleDO = getObjectInRedis(getObjectKeyInRedis(this, id), new YanldArticleDO());
//        if (yanldArticleDO != null) {
//            return yanldArticleDO;
//        }
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        YanldArticleDO yanldArticleDO = mapper.selectArticle(id);
        if (yanldArticleDO != null) {
            setObjectToRedis(yanldArticleDO);
        }
        return yanldArticleDO;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) {
        if (ids.isEmpty()) {
            return Lists.newArrayList();
        }
        List<YanldArticleDO> yanldArticleDOs = getObjectListInRedis(toRedisIds(ids, new YanldArticleDO()), new YanldArticleDO());
        if(!DataUtils.isBlank(yanldArticleDOs)) {
            return yanldArticleDOs;
        }
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        Map<String, List<Long>> idsMap = new HashMap<>();
        idsMap.put("ids", ids);
        return mapper.selectArticlesByIds(idsMap);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldArticleDO> selectArticles(YanldArticleQuery query) {
        List<YanldArticleDO> yanldArticleDOs = getObjectListInRedis(query, new YanldArticleDO());
        if(!DataUtils.isBlank(yanldArticleDOs)) {
            return yanldArticleDOs;
        }
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticles(query);
    }

    @Override
    public long selectArticleCount(YanldArticleQuery query) {
        long count = getObjectCount(query);
        if(count != 0) {
            return count;
        }
        YanldArticleMapper mapper = sqlSession.getMapper(YanldArticleMapper.class);
        return mapper.selectArticleCount(query);
    }
}
