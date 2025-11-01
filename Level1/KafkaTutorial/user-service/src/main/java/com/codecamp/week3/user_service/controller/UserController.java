package com.codecamp.week3.user_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.user-default-topic}")
    private String KAFKA_DEFAULT_TOPIC;

    @PostMapping("/{message}")
    ResponseEntity<String> sendMessage(@PathVariable String message){

        for(int i=0;i<10000;i++){
            String key = ""+i%2;
            kafkaTemplate.send(KAFKA_DEFAULT_TOPIC, key, message);
        }

        return ResponseEntity.ok("Message sent");
    }

}
