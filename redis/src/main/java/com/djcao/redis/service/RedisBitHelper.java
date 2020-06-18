package com.djcao.redis.service;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/18
 */
@Component
public class RedisBitHelper {

    public static final int DAY_MILLS = 24 * 60 * 60 * 1000;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public Boolean dailySign(Long userId) {
        redisTemplate.opsForValue().setBit(userId.toString(), todayToDayOfYear(), true);
        return Boolean.TRUE;
    }

    private long dateToDayOfYear(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.MONTH, 0);
        instance.set(Calendar.DATE, 1);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);

        return  (System.currentTimeMillis() - instance.getTimeInMillis() ) / DAY_MILLS + 1;
    }

    private long todayToDayOfYear() {
        return dateToDayOfYear(new Date());
    }

    public Boolean isSign(Long userId,Date date) {
        return redisTemplate.opsForValue().getBit(userId.toString(), dateToDayOfYear(date));
    }

}
