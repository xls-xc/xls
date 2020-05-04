package com.xls.fx.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.common
 * @ClassName: RedisCacheTransfer
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-05-04 18:01
 * @Version: v1.0
 **/
@Component
public class RedisCacheTransfer {
    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }

    @Autowired
    public void setRedisTemplateString(RedisTemplate redisTemplate) {
        MybatisRedisCacheString.setRedisTemplateString(redisTemplate);
    }

    @Autowired
    public static void setRedisTemplateMap(RedisTemplate redisTemplate) {
        MybatisCacheRedisMap.setRedisTemplateMap(redisTemplate);
    }
}
