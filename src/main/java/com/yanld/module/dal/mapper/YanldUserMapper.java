package com.yanld.module.dal.mapper;

import com.yanld.module.dal.dataobject.YanldUser;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserMapper {
    List<YanldUser> queryAllYanldUser();
}
