package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.dataobject.YanldUserDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserMapper {
    long insertUser();

    int deleteUser();

    int logicDeleteUser();

    int updateUser();

    YanldUserDO selectUser(long id);

    List<YanldUserDO> selectUsers();
}
