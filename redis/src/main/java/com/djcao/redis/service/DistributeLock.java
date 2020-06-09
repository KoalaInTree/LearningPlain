package com.djcao.redis.service;

import java.util.concurrent.TimeUnit;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/5
 */
public interface DistributeLock {

    Boolean lock(String key,Integer timeout, TimeUnit timeUnit);

    Boolean unlock(String key);
}
