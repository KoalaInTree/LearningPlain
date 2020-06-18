package com.djcao.redis.config;

import javax.annotation.PostConstruct;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/18
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient init() {
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
       return Redisson.create(config);
    }
}
