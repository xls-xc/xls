package com.xls.fx.common;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.common
 * @ClassName: MybatisRedisCache2
 * @Description: 使用redis做mybatis的二级缓存 版本二
 * @Author: SkyChen
 * @Create: 2020-05-04 19:28
 * @Version: v1.0
 **/
public class MybatisRedisCacheString implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(MybatisRedisCacheString.class);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id;
    private static RedisTemplate redisTemplate;
    /**
     *  redis过期时间
     */
    private static final long EXPIRE_TIME_IN_MINUTES = 30;

    public MybatisRedisCacheString(String id) {
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
        //redisTemplate进行value操作（key-string）
        ValueOperations opsForValue = redisTemplate.opsForValue();
        //进行字符串操作，放入key和value，redis过期时间=EXPIRE_TIME_IN_MINUTES
        opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
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
        ValueOperations opsForValue = redisTemplate.opsForValue();
        logger.debug("redis cache "+id+" get key: "+key.toString());
        //得到key的value
        return opsForValue.get(key);
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
        //删除这个key
        redisTemplate.delete(key);
        logger.debug("redis cache "+id+" remove key: "+key.toString());
        return null;
    }
    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
            //将数据库清空
            connection.flushDb();
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
    public static void setRedisTemplateString(RedisTemplate redisTemplate) {
        MybatisRedisCacheString.redisTemplate = redisTemplate;
    }
}
