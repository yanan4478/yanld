package com.yanld.module.dal.dao;

import com.yanld.module.dal.dataobject.YanldUserDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserDao {
    List<YanldUserDO> queryAllYanldUser();
}
