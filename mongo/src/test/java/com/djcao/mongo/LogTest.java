package com.djcao.mongo;

import java.util.UUID;
import java.util.stream.IntStream;

import com.djcao.mongo.config.JpaConfiguration;
import com.djcao.mongo.model.Log;
import com.djcao.mongo.repository.LogRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/29
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfiguration.class)
@TestPropertySource(locations = {"classpath:application.yml"})
@SpringBootTest
public class LogTest {

    @Autowired
    private LogRepository logRepository;

    @Test
    public void test_insert() {
        IntStream.range(0,1000).forEach(i -> {
            Log log = new Log();
            log.setAge(i);
            log.setMobilePhone(i+System.currentTimeMillis()+"");
            log.setName(UUID.randomUUID().toString());
            log.setPassword(UUID.randomUUID().toString().replace("-",""));
            logRepository.save(log);
        });
    }
}
