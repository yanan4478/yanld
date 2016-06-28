package com.yanld.module.service;

import com.yanld.module.dal.dataobject.YanldUser;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldUserService {
    List<YanldUser> queryAllYanldUser();
}
