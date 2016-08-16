package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dao.YanldDaoProxy;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.service.AbstractService;
import com.yanld.module.service.YanldArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
@Service
public class YanldArticleServiceImpl extends AbstractService implements YanldArticleService {

    @Resource
    private YanldArticleDao yanldArticleDao;

    @Resource
    private YanldDaoProxy yanldDaoProxy;

    @Override
    public Long insertArticle(YanldArticleDO yanldArticleDO) throws Exception {
        fillDOBaseInfo(yanldArticleDO);
        return yanldDaoProxy.invoke(yanldArticleDao, yanldArticleDO, Long.class);
    }

    @Override
    public Long deleteArticle(Long id) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, id, Long.class);
    }

    @Override
    public Long logicDeleteArticle(Long id) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, id, Long.class);
    }

    @Override
    public Long updateArticle(YanldArticleDO yanldArticleDO) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, yanldArticleDO, Long.class);
    }

    @Override
    public YanldArticleDO selectArticle(Long id) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, id, YanldArticleDO.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldArticleDO> selectArticleQuery(YanldArticleQuery query) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, query, List.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, ids, List.class);
    }

    @Override
    public Long selectArticleCount(YanldArticleQuery query) throws Exception {
        return yanldDaoProxy.invoke(yanldArticleDao, query, Long.class);
    }
}
