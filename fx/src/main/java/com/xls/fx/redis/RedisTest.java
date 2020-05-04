package com.xls.fx.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.redis
 * @ClassName: RedisTest
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-05-04 15:47
 * @Version: v1.0
 **/
public class RedisTest {
    Jedis jedis = null;

   public void connectRedis() {
        jedis = new Jedis("192.168.216.201",6379);
        jedis.auth("123456");
   }

   @Test
    public void test1() {
       connectRedis();
       jedis.lpush("aaa","333");
   }
}
