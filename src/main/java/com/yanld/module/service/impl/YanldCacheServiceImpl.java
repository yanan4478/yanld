package com.yanld.module.service.impl;

import com.google.common.base.Splitter;
import com.yanld.module.common.dal.dao.BaseDao;
import com.yanld.module.common.dal.dataobject.BaseDO;
import com.yanld.module.common.dal.query.BaseQuery;
import com.yanld.module.common.util.BeanFactoryUtils;
import com.yanld.module.common.util.RedisUtils;
import com.yanld.module.common.util.StackTraceUtils;
import com.yanld.module.service.BaseService;
import com.yanld.module.service.YanldCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/8/9.
 */
@Service
public class YanldCacheServiceImpl implements YanldCacheService, ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(YanldCacheService.class);
    private boolean isStart = false;

    @Resource
    protected RedisTemplate<Serializable, Serializable> redisTemplate;

    private String getInvokeName(String item, String format) {
        return MessageFormat.format(format, item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        if (!isStart) {
            isStart = true;
            List<String> items = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(YANLD_CACHE_ARRAY);
            for (String item : items) {
                String serviceName = getInvokeName(item, YANLD_SERVICE);
                String queryName = getInvokeName(item, YANLD_QUERY);
                String selectCountMethodName = getInvokeName(item, YANLD_SELECTCOUNT_METHOD);
                String selectListMethodName = getInvokeName(item, YANLD_SELECTLIST_METHOD);
                try {
                    BaseService service = BeanFactoryUtils.getBean(serviceName);
                    Class<?> queryClass = Class.forName(queryName);
                    BaseQuery query = (BaseQuery) queryClass.newInstance();
                    Method selectCountMethod = service.getClass().getDeclaredMethod(selectCountMethodName, queryClass);
                    long count = (long) selectCountMethod.invoke(service, query);
                    Method selectListMethod = service.getClass().getDeclaredMethod(selectListMethodName, queryClass);
                    for (int i = 0; i <= count / 100; i++) {
                        query.setLimit(100);
                        query.setOffset(i * 100);
                        List<BaseDO> dtoList = (List<BaseDO>) selectListMethod.invoke(service, query);
                        Map<String, List<String>> listKeyMap = new HashMap<>();
                        for (BaseDO dto : dtoList) {
                            List<String> listKeys = BaseDao.getListKeys(dto, query);
                            for (String listKey : listKeys) {
                                if (listKeyMap.get(listKey) == null) {
                                    List<String> ids = new ArrayList<>();
                                    ids.add(String.valueOf(dto.getId()));
                                    listKeyMap.put(listKey, ids);
                                } else {
                                    listKeyMap.get(listKey).add(String.valueOf(dto.getId()));
                                }
                            }
                        }
                        RedisUtils.setDataFromDBToRedis(redisTemplate, dtoList, listKeyMap);
                    }
                } catch (Exception e) {
                    logger.error(StackTraceUtils.getStackTrance(e));
                    logger.error("no class for " + serviceName);
                }
            }
        }
    }
}

