package com.xls.fx.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.component
 * @ClassName: RedisHelper
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-05-04 00:38
 * @Version: v1.0
 **/
@Component
public class RedisHelper {
    @Autowired
    private JedisPool jedisPool;

    /**
     * cache前缀
     */
    @Value("fx:cache")
    private String cachePrefix;
    /**
     * 根据key获取缓存数据
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(cachePrefix + key);
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取指定前缀的所有key
     *
     * @param prefix
     * @return
     */
    public Set<String> keys(String prefix) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.keys(cachePrefix + prefix);
        } finally {
            jedis.close();
        }
    }


    /**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(cachePrefix + key, value);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key, String value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(cachePrefix + key, value);
            jedis.expire(cachePrefix + key, expire);
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据key删除缓存数据
     *
     * @param key
     */
    public void del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(cachePrefix + key);
        } finally {
             jedis.close();
        }
    }

    /**
     * 设置集合
     * @param name
     * @param value
     */
    public void sadd(String name, String... value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.sadd(cachePrefix + name, value);
        } finally {
             jedis.close();
        }
    }

    /**
     * 获取指定键名的集合中的所有成员
     *
     * @param name
     * @return
     */
    public Set<String> smembers(String name) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.smembers(cachePrefix + name);
        } finally {
             jedis.close();
        }
    }

    /**
     * 移除集合
     *
     * @param name
     * @return
     */
    public void spop(String name) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.spop(cachePrefix + name);
        } finally {
             jedis.close();
        }
    }

    /**
     * 移除集合中的一个或多个元素
     *
     * @param name
     * @return
     */
    public void srem(String name, String... key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.srem(cachePrefix + name,key);
        } finally {
             jedis.close();
        }
    }
}
