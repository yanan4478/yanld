package com.yanld.module.service;

import com.yanld.module.bo.YanldDetailArticleBO;

/**
 * Created by yanan on 16/7/18.
 */
public interface YanldDetailService {
    YanldDetailArticleBO getDetailArticleBO(long mediaId);
}
