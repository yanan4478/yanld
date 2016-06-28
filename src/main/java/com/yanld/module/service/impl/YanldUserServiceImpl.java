package com.yanld.module.service.impl;

import com.yanld.module.dal.dao.YanldUserDao;
import com.yanld.module.dal.dataobject.YanldUser;
import com.yanld.module.service.YanldUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public class YanldUserServiceImpl implements YanldUserService {

    @Resource
    private YanldUserDao yanldUserDao;

    @Override
    public List<YanldUser> queryAllYanldUser() {
        return yanldUserDao.queryAllYanldUser();
    }
}
