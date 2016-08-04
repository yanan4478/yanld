package com.yanld.module.common.dal.dao;

import com.yanld.module.common.dal.dataobject.YanldSequenceDO;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldSequenceDao {
    int updateSequence(YanldSequenceDO yanldSequenceDO);

    YanldSequenceDO selectSequence(String tableName);
}
