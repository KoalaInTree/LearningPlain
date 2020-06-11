package com.djcao.redis.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/6
 */
@Component
public class RedisLimit {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 限制QPS
     *
     * @param ip    key
     * @param limit limit
     * @return
     */
    public Boolean entry(String ip, Long limit) {
        if (BooleanUtils.isTrue(redisTemplate.hasKey(ip))) {
            Boolean result = redisTemplate.opsForValue()
                .setIfAbsent(ip, "1", 1, TimeUnit.SECONDS);
            if (result == null || !result) {
                return incr(ip) > limit;
            }
            return result;
        }
        return incr(ip) > limit;
    }

    private Long incr(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    public Set iterator(String key) {
        Set result = new HashSet();
        Cursor<String> scan = redisTemplate.opsForSet()
            .scan(key, ScanOptions.scanOptions().build());
        while (scan.hasNext()) {
            String next = scan.next();
            result.add(next);
        }
        return result;
    }
}
