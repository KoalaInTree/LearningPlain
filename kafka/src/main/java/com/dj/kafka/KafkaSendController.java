package com.dj.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/23
 */
@RestController
@EnableKafka
public class KafkaSendController {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("send")
    public String send() {
        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("cdj", i+"", "hello" + i);
        }
        return "ok";
    }

    @KafkaListener(topics = "cdj")
    public void cdj(List<ConsumerRecord<String,Object>> record) {
        System.out.println(record);
    }

    @KafkaListener(topics = "dj")
    public void dj(List<ConsumerRecord<String,Object>> record) {
        System.out.println(record);
    }


}
