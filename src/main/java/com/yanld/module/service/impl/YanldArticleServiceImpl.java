package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.common.exception.TableNotExistException;
import com.yanld.module.common.util.StackTraceUtils;
import com.yanld.module.service.BaseService;
import com.yanld.module.service.YanldArticleService;
import com.yanld.module.service.YanldSequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
@Service
public class YanldArticleServiceImpl extends BaseService implements YanldArticleService {

    private final Logger logger = LoggerFactory.getLogger(YanldArticleServiceImpl.class);

    @Resource
    private YanldArticleDao yanldArticleDao;

    @Override
    public long insertArticle(YanldArticleDO yanldArticleDO) {
        long id = 0;
        try {
            fillDOBaseInfo(yanldArticleDO);
            id = yanldArticleDao.insertArticle(yanldArticleDO);
        } catch (TableNotExistException e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            logger.error("table:" + YanldSequenceService.TABLE_YANLD_ARTICLE + "generate id failed!!");
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            logger.error("table:" + YanldSequenceService.TABLE_YANLD_ARTICLE + "insert failed!! id:" + id);
        }
        return id;
    }

    @Override
    public long deleteArticle(long id) {
        return yanldArticleDao.deleteArticle(id);
    }

    @Override
    public long logicDeleteArticle(long id) {
        return yanldArticleDao.logicDeleteArticle(id);
    }

    @Override
    public long updateArticle(YanldArticleDO yanldArticleDO) {
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
