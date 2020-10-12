package com.dj.aop.boot.demo.boot;

import java.util.concurrent.TimeUnit;

import org.springframework.web.client.RestTemplate;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/10
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(TimeUnit.MINUTES.toMillis(4 * 60 + 10));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate
            .postForObject("10.8.81.160:8080/wyvern-waybill/restful/waybillFix", "", String.class);
    }
}
