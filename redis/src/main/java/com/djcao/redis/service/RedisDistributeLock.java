package com.djcao.redis.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/4
 */
@Component
public class RedisDistributeLock {

    private static RedisTemplate<String, String> redisTemplate;

    public static String getLock(String key,int expire) throws RuntimeException {
        String uniq = UUID.randomUUID().toString();
        Boolean result = redisTemplate.opsForValue()
            .setIfAbsent(key, uniq, expire, TimeUnit.SECONDS);
        if (null == result || !result) {
            throw new RuntimeException();
        }
        return uniq;
    }

    public static Boolean release(String key, String uniq) {
        return redisTemplate.execute(
            (RedisCallback<Boolean>) connection -> connection.scriptingCommands()
                .eval(("if redis.call('get',KEYS[1]) == "
                        + "ARGV[1] "
                        + "then "
                        + "return redis.call('del',KEYS[1]) "
                        + "else return 0 end").getBytes(), ReturnType.BOOLEAN,
                    1,
                    key.getBytes() , uniq.getBytes()));
    }

    @Autowired
    public void setRedisTemplate(
        RedisTemplate<String, String> redisTemplate) {
        RedisDistributeLock.redisTemplate = redisTemplate;
    }
}
