package com.yanld.module.service;

import com.yanld.module.common.exception.TableNotExistException;

/**
 * Created by yanan on 16/8/2.
 */
public interface YanldSequenceService {
    String TABLE_YANLD_ARTICLE = "yanld_article";

    long getId(String tableName) throws TableNotExistException;
}
