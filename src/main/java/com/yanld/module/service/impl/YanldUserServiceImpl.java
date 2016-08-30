package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldUserDao;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldUserQuery;
import com.yanld.module.common.util.DataUtils;
import com.yanld.module.common.util.StackTraceUtils;
import com.yanld.module.service.AbstractService;
import com.yanld.module.service.YanldCacheService;
import com.yanld.module.service.YanldSequenceService;
import com.yanld.module.service.YanldUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
@Service
public class YanldUserServiceImpl extends AbstractService implements YanldUserService {
    private static final Logger logger = LoggerFactory.getLogger(YanldUserServiceImpl.class);
    @Resource
    private YanldUserDao yanldUserDao;

    @Override
    public Long insertUser(YanldUserDO yanldUserDO) throws Exception {
        fillDOBaseInfo(yanldUserDO, YanldSequenceService.TABLE_YANLD_USER);
        return getProxyDao(yanldUserDao).insertUser(yanldUserDO);
    }

    @Override
    public Long deleteUser(Long id) throws Exception {
        return getProxyDao(yanldUserDao).deleteUser(id);
    }

    @Override
    public Long logicDeleteUser(Long id) throws Exception {
        return getProxyDao(yanldUserDao).logicDeleteUser(id);
    }

    @Override
    public Long updateUser(YanldUserDO yanldUserDO) throws Exception {
        return getProxyDao(yanldUserDao).updateUser(yanldUserDO);
    }

    @Override
    public YanldUserDO selectUser(Long id) throws Exception {
        return getProxyDao(yanldUserDao).selectUser(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldUserDO> selectUserQuery(YanldUserQuery query) throws Exception {
        return getProxyDao(yanldUserDao).selectUserQuery(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<YanldUserDO> selectUsersByIds(List<Long> ids) throws Exception {
        return getProxyDao(yanldUserDao).selectUsersByIds(ids);
    }

    @Override
    public Long selectUserCount(YanldUserQuery query) throws Exception {
        return getProxyDao(yanldUserDao).selectUserCount(query);
    }

    @Override
    public YanldUserDO userLogin(String userName, String userPassword) {
        try {
            YanldUserQuery userQuery = new YanldUserQuery();
            userQuery.setUserName(userName);
            userQuery.setUserPassword(DigestUtils.md5DigestAsHex(userPassword.getBytes()));
            List<YanldUserDO> userDOs = selectUserQuery(userQuery);
            if(DataUtils.isBlank(userDOs)) {
                return null;
            }
            YanldUserDO user = userDOs.get(0);
            user.setLastLoginTime(new Date());
            updateUser(user);
            return user;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return null;
        }
    }
}
