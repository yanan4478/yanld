package com.yanld.module.common.dal.dao.proxy;

import com.yanld.module.common.dal.dao.BaseDao;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yanan on 16/8/17.
 */
public class DaoProxyFactory {
    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    private static ConcurrentHashMap<String, BaseDao> proxyDaoMap = new ConcurrentHashMap<>();

    private final Object LOCK = new Object();

    @SuppressWarnings("unchecked")
    public <T extends BaseDao> T getProxyDao(T proxy) {
        String key = proxy.getClass().getInterfaces()[0].getSimpleName();
        if (proxyDaoMap.get(key) == null) {
            synchronized (LOCK) {
                if (proxyDaoMap.get(key) == null) {
                    T proxyDao = (T) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                            proxy.getClass().getInterfaces(), new DaoProxy(proxy, redisTemplate));
                    proxyDaoMap.put(key, proxyDao);
                }
            }
        }
        return (T) proxyDaoMap.get(key);
    }
}

