package com.yanld.module.service;

import com.yanld.module.bo.YanldIndexBO;

/**
 * Created by yanan on 16/7/18.
 */
public interface YanldIndexService {
    YanldIndexBO getIndexBO(int category, int page);
}
