package com.dj.web.demo;

import java.util.Collections;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/8/7
 */
@Configuration
public class CustomPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        return new MapPropertySource("customProperty",Collections.singletonMap("property.from",
            "worked as "));
    }
}
