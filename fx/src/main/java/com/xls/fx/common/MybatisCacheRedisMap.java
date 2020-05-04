package com.xls.fx.common;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.common
 * @ClassName: MybatisCacheRedisMap
 * @Description: 使用redis做mybatis的二级缓存 版本三
 * @Author: SkyChen
 * @Create: 2020-05-04 19:35
 * @Version: v1.0
 **/
public class MybatisCacheRedisMap implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(MybatisCacheRedisMap.class);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id; // 在构造函数自动注入，为namespace的名字
    private static RedisTemplate redisTemplate;
    private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间
    public MybatisCacheRedisMap(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
        logger.debug("创建了mybatis的redis缓存"+id);
    }
    @Override
    public String getId() {
        return id;
    }
    /**
     * Put query result to redis
     *
     * @param key
     * @param value
     */
    @Override
    @SuppressWarnings("unchecked")
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        HashOperations opsForHash=redisTemplate.opsForHash();
        opsForHash.put(id,key,value);
        logger.debug("redis cache "+id+" put key: "+key.toString()+" value: "+value.toString());
    }
    /**
     * Get cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        HashOperations opsForHash=redisTemplate.opsForHash();
        logger.debug("redis cache "+id+" get key: "+key.toString());
        return opsForHash.get(id, key);
    }
    /**
     * Remove cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        logger.debug("redis cache "+id+" remove key: "+key.toString());
        HashOperations opsForHash=redisTemplate.opsForHash();
        opsForHash.delete(id, key);
        return null;
    }
    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
            redisTemplate.delete(id);
            return null;
        });
        logger.debug("Clear all the cached query result from redis "+id);
    }
    @Override
    public int getSize() {
        return 0;
    }
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
    private RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public static void setRedisTemplateMap(RedisTemplate redisTemplate) {
        MybatisCacheRedisMap.redisTemplate = redisTemplate;
    }

}
