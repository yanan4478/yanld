package com.yanld.module.service;

import com.yanld.module.dal.dataobject.YanldUserDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserService {
    long insertUser();

    int deleteUser();

    int logicDeleteUser();

    int updateUser();

    YanldUserDO selectUser(long id);

    List<YanldUserDO> selectUsers();
}
