package com.yanld.module.service;

import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.dal.dao.BaseDao;
import com.yanld.module.common.dal.dataobject.BaseDO;
import com.yanld.module.common.exception.TableNotExistException;
import com.yanld.module.common.dal.dao.proxy.DaoProxyFactory;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yanan on 16/7/18.
 */
public abstract class AbstractService {

    @Resource
    private YanldSequenceService sequenceService;

    @Resource
    protected DaoProxyFactory proxyFactory;

    protected <T extends BaseDO> T fillDOBaseInfo(T baseDO, String tableName) throws TableNotExistException {
        long id = sequenceService.getId(tableName);
        Date now = new Date();
        baseDO.setId(id);
        baseDO.setCreateTime(now);
        baseDO.setModifyTime(now);
        baseDO.setIsDeleted(BaseConstant.IS_NOT_DELETED);
        return baseDO;
    }

    protected <T extends BaseDao> T getProxyDao(T dao) {
        return proxyFactory.getProxyDao(dao);
    }
}
