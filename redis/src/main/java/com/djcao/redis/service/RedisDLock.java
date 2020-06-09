package com.djcao.redis.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import io.netty.util.internal.StringUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/4
 */
@Component
public class RedisDLock implements DistributeLock
{
    ThreadLocal<Map<String,String>> threadLocal = ThreadLocal.withInitial(HashMap::new);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<Object,Object> objectRedisTemplate;

    @Override
    public Boolean lock(String key, Integer timeout, TimeUnit timeUnit) {
        String lockedValue = threadLocal.get().get(key);
        if (!StringUtils.isEmpty(lockedValue)) {
            return true;
        }
        String value = UUID.randomUUID().toString();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, timeUnit);
        if (result != null && result) {
            threadLocal.get().put(key, value);
        }
        return result;
    }

    @Override
    public Boolean unlock(String key) {
        String value = threadLocal.get().get(key);
        if (value == null) {
            return true;
        }
        redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.scriptingCommands().eval(("if redis.call('get', KEYS[1] ) == "
                + "ARGV[1] then return redis.call('del',KEYS[1]) else 0 end").getBytes(),
            ReturnType.BOOLEAN,1,
            key.getBytes(),threadLocal.get().get(key).getBytes()));
        threadLocal.get().remove(key);
        return true;
    }
}
