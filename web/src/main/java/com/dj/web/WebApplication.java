package com.dj.web;

import com.dj.web.config.BestConfig;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class WebApplication {

    @Autowired
    private Ser ser;

    @Autowired
    private BestConfig bestConfig;
    @Autowired
    Counter counter;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @GetMapping("health2")
    public String health() {
        counter.inc();
        return "1111ok" + ser.word;
    }

    @GetMapping("health3")
    public String health3() {
        return "1111ok" + bestConfig.toString();
    }

    @Component
    public static class Ser {
        @Value("${property.from}")
        public String word;
    }

    @Bean
    public Counter requestTotalCountCollector( CollectorRegistry collectorRegistry){
        return  Counter.build()
            .name("http_requests_total")
            .help("http请求总计数").register(collectorRegistry);
    }
}
