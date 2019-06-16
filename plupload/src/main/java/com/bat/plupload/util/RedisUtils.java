package com.bat.plupload.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
 **/
@Component
public class RedisUtils {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 将 String 值存入 Redis
     *
     * @param key   key
     * @param value value
     * @author ZhengYu
     */
    public void setStringToRedis(String key, String value) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key, value);
    }

    /**
     * 将 String 值存入 Redis 并持有 seconds 秒
     *
     * @param key     key
     * @param value   value
     * @param seconds 秒数
     * @author ZhengYu
     */
    public void setStringToRedis(String key, String value, long seconds) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key, value, seconds, TimeUnit.SECONDS);
    }

    /**
     * 从 Redis 中 读取 key 对应的值
     *
     * @param key key
     * @author ZhengYu
     */
    public String getStringFromRedis(String key) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        return stringStringValueOperations.get(key);
    }

    /**
     * 将 Object 值存入 Redis 并持有 seconds 秒
     *
     * @param key     key
     * @param value   value
     * @param seconds 秒数
     * @author ZhengYu
     */
    public void setObjectToRedis(String key, Object value, long seconds) {
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        stringObjectValueOperations.set(key, value, seconds, TimeUnit.SECONDS);
    }

    /**
     * 从 Redis 中 读取 key 对应的值
     *
     * @param key key
     * @author ZhengYu
     */
    public Object getObjectFromRedis(String key) {
        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        return stringObjectValueOperations.get(key);
    }
}
