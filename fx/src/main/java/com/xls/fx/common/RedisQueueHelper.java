package com.xls.fx.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.component
 * @ClassName: RedisQueueHelper
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
    @Value("fx:queue")
    private String prefix;
    /**
     * 读取队列
     * @return
     */
    public String pop(String name) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lpop(prefix + name);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 写入队列
     * @param value
     */
    public void push(String name, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.rpush(prefix + name, value);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
    }
}
