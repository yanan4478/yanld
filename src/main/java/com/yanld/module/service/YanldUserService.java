package com.yanld.module.service;

import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldUserQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserService {
    Long insertUser(YanldUserDO yanldUserDO) throws Exception;

    Long deleteUser(Long id) throws Exception;

    Long logicDeleteUser(Long id) throws Exception;

    Long updateUser(YanldUserDO yanldUserDO) throws Exception;

    YanldUserDO selectUser(Long id) throws Exception;

    List<YanldUserDO> selectUserQuery(YanldUserQuery query) throws Exception;

    List<YanldUserDO> selectUsersByIds(List<Long> ids) throws Exception;

    Long selectUserCount(YanldUserQuery query) throws Exception;

    Long getUserId(String userName, String userPassword);
}
