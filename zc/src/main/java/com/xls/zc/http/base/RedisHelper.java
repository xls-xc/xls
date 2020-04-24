/*
package com.xls.zc.http.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

*/
/**



 *
 * Redis帮助类
 *
 * @author dqw
 * Created 2017/4/17 13:38
 *//*

@Component
public class RedisHelper {

    @Autowired
    private JedisPool jedisPool;

    */
/**
     * cache前缀
     *//*

    @Value("${cachePrefix}")
    private String cachePrefix;
    */
/**
     * 根据key获取缓存数据
     *
     * @param key
     * @return
     *//*

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(cachePrefix + key);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 获取指定前缀的所有key
     *
     * @param prefix
     * @return
     *//*

    public Set<String> keys(String prefix) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.keys(cachePrefix + prefix);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }


    */
/**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     *//*

    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(cachePrefix + key, value);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     * @param expire
     *//*

    public void set(String key, String value, int expire) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(cachePrefix + key, value);
            jedis.expire(cachePrefix + key, expire);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 根据key删除缓存数据
     *
     * @param key
     *//*

    public void del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(cachePrefix + key);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 设置集合
     * @param name
     * @param value
     *//*

    public void sadd(String name, String... value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.sadd(cachePrefix + name, value);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 获取指定键名的集合中的所有成员
     *
     * @param name
     * @return
     *//*

    public Set<String> smembers(String name) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.smembers(cachePrefix + name);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 移除集合
     *
     * @param name
     * @return
     *//*

    public void spop(String name) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.spop(cachePrefix + name);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 移除集合中的一个或多个元素
     *
     * @param name
     * @return
     *//*

    public void srem(String name, String... key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.srem(cachePrefix + name,key);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }
}


*/
