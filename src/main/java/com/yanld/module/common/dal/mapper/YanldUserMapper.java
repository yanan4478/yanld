package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldUserQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserMapper {
    Long insertUser(YanldUserDO yanldUserDO);

    Long deleteUser(long id);

    Long logicDeleteUser(long id);

    Long updateUser(YanldUserDO yanldUserDO);

    YanldUserDO selectUser(long id);

    List<YanldUserDO> selectUsers(YanldUserQuery query);

    List<YanldUserDO> selectUsersByIds(Map<String, List<Long>> idsMap);

    Long selectUserCount(YanldUserQuery query);


}
