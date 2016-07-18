package com.yanld.module.service.impl;

import com.yanld.module.dal.dao.YanldArticleDao;
import com.yanld.module.dal.dataobject.YanldArticleDO;
import com.yanld.module.dal.query.YanldArticleQuery;
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
    public long insertArticle() {
        return yanldArticleDao.insertArticle();
    }

    @Override
    public int deleteArticle() {
        return yanldArticleDao.deleteArticle();
    }

    @Override
    public int logicDeleteArticle() {
        return yanldArticleDao.logicDeleteArticle();
    }

    @Override
    public int updateArticle() {
        return yanldArticleDao.updateArticle();
    }

    @Override
    public YanldArticleDO selectArticle() {
        return yanldArticleDao.selectArticle();
    }

    @Override
    public List<YanldArticleDO> selectArticles(YanldArticleQuery query) {
        return yanldArticleDao.selectArticles(query);
    }

    @Override
    public List<YanldArticleDO> selectArticlesByIds(List<Long> ids) {
        return yanldArticleDao.selectArticlesByIds(ids);
    }
}
