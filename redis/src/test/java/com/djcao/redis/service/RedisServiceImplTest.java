package com.djcao.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/8
 */
@Component
public class RedisServiceImplTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void test() {
        List<Object> objects = redisTemplate
            .executePipelined((RedisCallback<List<Object>>) connection -> {
                connection.openPipeline();
                return connection.closePipeline();
            });

    }
}
