package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldArticleDao;
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

    @Override
    public Long insertArticle(YanldArticleDO yanldArticleDO) throws Exception {
        fillDOBaseInfo(yanldArticleDO);
        return getProxyDao(yanldArticleDao).insertArticle(yanldArticleDO);
    }

    @Override
    public Long deleteArticle(Long id) throws Exception {
        return getProxyDao(yanldArticleDao).deleteArticle(id);
    }

    @Override
    public Long logicDeleteArticle(Long id) throws Exception {
        return getProxyDao(yanldArticleDao).logicDeleteArticle(id);
    }

    @Override
    public Long updateArticle(YanldArticleDO yanldArticleDO) throws Exception {
        return getProxyDao(yanldArticleDao).updateArticle(yanldArticleDO);
    }

    @Override
    public YanldArticleDO selectArticle(Long id) throws Exception {
        return getProxyDao(yanldArticleDao).selectArticle(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldArticleDO> selectArticleQuery(YanldArticleQuery query) throws Exception {
        return getProxyDao(yanldArticleDao).selectArticleQuery(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) throws Exception {
        return getProxyDao(yanldArticleDao).selectArticlesByIds(ids);
    }

    @Override
    public Long selectArticleCount(YanldArticleQuery query) throws Exception {
        return getProxyDao(yanldArticleDao).selectArticleCount(query);
    }
}
