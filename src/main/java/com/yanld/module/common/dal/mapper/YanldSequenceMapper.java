package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.dataobject.YanldSequenceDO;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldSequenceMapper {

    int updateSequence(YanldSequenceDO yanldSequenceDO);

    YanldSequenceDO selectSequence(String tableName);

}
