package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldUserDao;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
@Service
public class YanldUserServiceImpl implements YanldUserService {

    @Resource
    private YanldUserDao yanldUserDao;

    @Override
    public long insertUser() {
        return yanldUserDao.insertUser();
    }

    @Override
    public int deleteUser() {
        return yanldUserDao.deleteUser();
    }

    @Override
    public int logicDeleteUser() {
        return yanldUserDao.logicDeleteUser();
    }

    @Override
    public int updateUser() {
        return yanldUserDao.updateUser();
    }

    @Override
    public YanldUserDO selectUser(long id) {
        return yanldUserDao.selectUser(id);
    }

    @Override
    public List<YanldUserDO> selectUsers() {
        return yanldUserDao.selectUsers();
    }
}
