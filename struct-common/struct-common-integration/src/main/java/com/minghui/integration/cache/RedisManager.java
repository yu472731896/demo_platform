package com.ropeok.integration.cache;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;
import java.util.Map;

/**
 * @auther chenqinglin
 * @create 2018/4/12
 */
public class RedisManager extends AbstractCacheManager implements InitializingBean {

    @Autowired
    private RedisCacheBuilder redisCacheBuilder;

    private int defaultExpireSeconds = 3600;

    private Map<String, Cache> caches = Maps.newConcurrentMap();

    public Map<String, Cache> getCaches() {
        return caches;
    }

    public void setCaches(Map<String, Cache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches.values();
    }

    @Override
    public Cache getCache(String name) {
        if (!this.caches.containsKey(name)) {
            Cache cache = redisCacheBuilder.newCache(name,defaultExpireSeconds);
            this.caches.put(name, cache);
        }
        return this.caches.get(name);
    }
}
