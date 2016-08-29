package com.yanld.module.common.dal.dao;

import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldUserQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserDao extends BaseDao {
    Long insertUser(YanldUserDO yanldUserDO);

    Long deleteUser(Long id);

    Long logicDeleteUser(Long id);

    Long updateUser(YanldUserDO yanldUserDO);

    YanldUserDO selectUser(Long id);

    List<YanldUserDO> selectUserQuery(YanldUserQuery query);

    List<YanldUserDO> selectUsersByIds(List<Long> ids);

    Long selectUserCount(YanldUserQuery query);
}
