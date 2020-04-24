/*
package com.xls.zc.http.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

*/
/**



 *
 * 队列帮助类
 *
 * @author dqw
 * Created 2017/4/17 13:38
 *//*

@Component
public class QueueHelper {

    @Autowired
    private JedisPool jedisPool;

    */
/**
     * Queue前缀
     *//*

    @Value("${queuePrefix}")
    private String prefix;

    */
/**
     * 读取队列
     * @return
     *//*

    public String pop(String name) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.lpop(prefix + name);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    */
/**
     * 写入队列
     * @param value
     *//*

    public void push(String name, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.rpush(prefix + name, value);
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }
}


*/
