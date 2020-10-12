package com.djcao.redis.config;

import javax.annotation.PostConstruct;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/18
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Bean
    public RedissonClient init() {
        Config config = new Config();
        config.useSingleServer().setAddress(host)
        ;
       return Redisson.create(config);
    }
}
