package com.djcao.redis.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.djcao.redis.service.DistributeLock;
import com.djcao.redis.service.RedisBitHelper;
import com.djcao.redis.service.RedisDistributeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/4
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> stringRedisTemplate;

    @Autowired
    private DistributeLock redisDLock;
    @Autowired
    private RedisBitHelper redisBitHelper;

    @RequestMapping("heath/{key}")
    public String heath(@PathVariable String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping("getLock/{key}")
    public String getLock(@PathVariable String key) {
        return RedisDistributeLock.getLock(key,25);
    }

    @RequestMapping("release/{key}/{uniq}")
    public Boolean release(@PathVariable String key,@PathVariable String uniq) {
        return RedisDistributeLock.release(key,uniq);
    }

    @RequestMapping("getLock2/{key}")
    public Boolean getLock2(@PathVariable String key) {
        return redisDLock.lock(key,25, TimeUnit.SECONDS);
    }

    @RequestMapping("release2/{key}")
    public Boolean release2(@PathVariable String key) {
        return redisDLock.unlock(key);
    }

    @RequestMapping("signSin/{key}")
    public Boolean signSin(@PathVariable Long key) {
        return redisBitHelper.dailySign(key);
    }

    @RequestMapping("isSignIn/{key}")
    public Boolean isSignIn(@PathVariable Long key) {
        return redisBitHelper.isSign(key,new Date());
    }
}
