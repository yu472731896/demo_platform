package com.ropeok.integration.cache;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.JedisCluster;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * @auther chenqinglin
 * @create 2018/4/12
 */
public class RedisCacheBuilder{

    @Autowired
    private JedisCluster jedisCluster;

//    @Autowired
//    private ShardedJedisPool jedisPool;

    public RedisCacheBuilder(){}

    public RedisCacheBuilder.RedisCache newCache(String cacheName,int expireSecond){
        return new RedisCache(cacheName,expireSecond);
    }

    public class RedisCache implements Cache {

        private String cacheName;

        private int  xexpireSecond;

        public String getCacheName() {
            return cacheName;
        }

        public void setCacheName(String cacheName) {
            this.cacheName = cacheName;
        }

        public int getXexpireSecond() {
            return xexpireSecond;
        }

        public void setXexpireSecond(int xexpireSecond) {
            this.xexpireSecond = xexpireSecond;
        }

        public RedisCache(){}

        public RedisCache(String cacheName,int xexpireSecond){
            this.cacheName = cacheName;
            this.xexpireSecond = xexpireSecond;
        }

        public RedisCache(String cacheName){
            this(cacheName,3600);
        }

        @Override
        public String getName() {
            return this.cacheName;
        }

        @Override
        public Object getNativeCache() {
            return null;
        }

        @Override
        public ValueWrapper get(Object key) {
            String redisKey = this.generateKeyByCacheNameAndKey(key);
            byte[] keyBytes = SerializationUtils.serialize(redisKey);
//            ShardedJedis jedis = RedisCacheBuilder.this.jedisPool.getResource();
//            byte[] resultBytes = jedis.get(keyBytes);
            byte[] resultBytes = jedisCluster.get(keyBytes);
            Object result = SerializationUtils.deserialize(resultBytes);
            return result == null ? null : new SimpleValueWrapper(result);
        }

        @Deprecated
        @Override
        public <T> T get(Object key, Class<T> type) {
            return null;
        }

        @Deprecated
        @Override
        public <T> T get(Object key, Callable<T> valueLoader) {
            return null;
        }

        @Override
        public void put(Object key, Object value) {
            String redisKey = generateKeyByCacheNameAndKey(key);
            byte[] keyBytes = SerializationUtils.serialize(redisKey);
            byte[] valueBytes = SerializationUtils.serialize(value);
//            ShardedJedis jedis = RedisCacheBuilder.this.jedisPool.getResource();
//            jedis.set(keyBytes,valueBytes);
//            jedis.expire(keyBytes,this.xexpireSecond);
            jedisCluster.set(keyBytes,valueBytes);
            jedisCluster.expire(keyBytes,this.xexpireSecond);
            Set<String> keys = this.getCacheKeys();
            keys.add(key.toString());
//            jedis.set(this.cacheName.getBytes(), SerializationUtils.serialize(keys));
            jedisCluster.set(this.cacheName.getBytes(), SerializationUtils.serialize(keys));
        }

        public Set<String> getCacheKeys() {
//            ShardedJedis jedis = RedisCacheBuilder.this.jedisPool.getResource();
//            Object object = SerializationUtils.deserialize(jedis.get(this.cacheName.getBytes()));
            Object object = SerializationUtils.deserialize(jedisCluster.get(this.cacheName.getBytes()));
            Set<String> keys = null;
            if (object == null) {
                keys = Sets.newHashSet();
            } else {
                keys = (Set)object;
            }
            return keys;
        }

        @Override
        public ValueWrapper putIfAbsent(Object key, Object value) {
            ValueWrapper valueWrapper = this.get(key);
            this.put(key, value);
            return valueWrapper;
        }

        @Override
        public void evict(Object key) {
            String redisKey = generateKeyByCacheNameAndKey(key);
            byte[] keyBytes = SerializationUtils.serialize(redisKey);
//            ShardedJedis jedis = RedisCacheBuilder.this.jedisPool.getResource();
//            jedis.del(keyBytes);
            jedisCluster.del(keyBytes);
            Set<String> keys = this.getCacheKeys();
            keys.remove(key);
//            jedis.set(this.cacheName.getBytes(), SerializationUtils.serialize(keys));
            jedisCluster.set(this.cacheName.getBytes(), SerializationUtils.serialize(keys));
        }

        @Override
        public void clear() {
            Set<String> keys = this.getCacheKeys();
            Iterator var2 = keys.iterator();
            while(var2.hasNext()) {
                String key = (String)var2.next();
                this.evict(key);
            }
//            ShardedJedis jedis = RedisCacheBuilder.this.jedisPool.getResource();
//            jedis.set(this.cacheName.getBytes(), SerializationUtils.serialize(Sets.newConcurrentHashSet()));
            jedisCluster.set(this.cacheName.getBytes(), SerializationUtils.serialize(Sets.newConcurrentHashSet()));
        }


        private String generateKeyByCacheNameAndKey(Object key){
            return this.cacheName.concat("-").concat(key.toString());
        }
    }
}
