package com.xls.fx.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.component
 * @ClassName: RedistQueueHelper
 * @Description: Redis队列辅助类
 * @Author: SkyChen
 * @Create: 2020-04-30 10:23
 * @Version: v1.0
 **/
@Component
public class RedisQueueHelper {
    @Autowired
    private JedisPool jedisPool;

    /**
     * Queue前缀
     */
    @Value("nc:queue")
    private String prefix;
    /**
     * 读取队列
     * @return
     */
    public String pop(String name) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.lpop(prefix + name);
        } finally {
            //jedisPool.returnResourceObject(jedis);
        }
    }

    /**
     * 写入队列
     * @param value
     */
    public void push(String name, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.rpush(prefix + name, value);
        } finally {
            //jedisPool.returnResourceObject(jedis);
        }
    }
}
