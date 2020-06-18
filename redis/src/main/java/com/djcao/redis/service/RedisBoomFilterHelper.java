package com.djcao.redis.service;

import java.util.concurrent.ConcurrentHashMap;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/18
 */
@Component
public class RedisBoomFilterHelper {

    @Autowired
    private RedissonClient redissonClient;

    private ConcurrentHashMap<String, RBloomFilter<String>> cache = new ConcurrentHashMap<>();

    public Boolean add(String key,String value) {
        RBloomFilter<String> stringRBloomFilter = cache.get(key);
        if (stringRBloomFilter == null) {
            stringRBloomFilter = redissonClient.getBloomFilter(key);
            cache.put(key, stringRBloomFilter);
        }
        return stringRBloomFilter.add(value);
    }

    public Boolean contains(String key,String value) {
        RBloomFilter<String> stringRBloomFilter = cache.get(key);
        if (stringRBloomFilter == null) {
            stringRBloomFilter = redissonClient.getBloomFilter(key);
            cache.put(key, stringRBloomFilter);
        }
        return stringRBloomFilter.contains(value);
    }
}
