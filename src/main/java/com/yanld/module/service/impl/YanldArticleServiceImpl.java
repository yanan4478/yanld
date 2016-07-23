package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.service.YanldArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
@Service
public class YanldArticleServiceImpl implements YanldArticleService {

    @Resource
    private YanldArticleDao yanldArticleDao;

    @Override
    public long insertArticle(YanldArticleDO yanldArticleDO) {
        return yanldArticleDao.insertArticle(yanldArticleDO);
    }

    @Override
    public int deleteArticle(long id) {
        return yanldArticleDao.deleteArticle(id);
    }

    @Override
    public int logicDeleteArticle(long id) {
        return yanldArticleDao.logicDeleteArticle(id);
    }

    @Override
    public int updateArticle(YanldArticleDO yanldArticleDO) {
        return yanldArticleDao.updateArticle(yanldArticleDO);
    }

    @Override
    public YanldArticleDO selectArticle(long id) {
        return yanldArticleDao.selectArticle(id);
    }

    @Override
    public List<YanldArticleDO> selectArticles(YanldArticleQuery query) {
        return yanldArticleDao.selectArticles(query);
    }

    @Override
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) {
        return yanldArticleDao.selectArticlesByIds(ids);
    }

    @Override
    public long selectArticleCount(YanldArticleQuery query) {
        return yanldArticleDao.selectArticleCount(query);
    }
}
