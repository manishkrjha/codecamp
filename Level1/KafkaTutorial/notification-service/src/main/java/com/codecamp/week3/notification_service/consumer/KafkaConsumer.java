package com.codecamp.week3.notification_service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "user-creation-topic", groupId = "user-service")
//    public void createUserEventListener(UserCreatedEvent userCreateEvent){
//        log.info("Event Listener: {}", userCreateEvent);
//    }

    @KafkaListener(topics = "user-default-topic", groupId = "user-service")
    public void userTopicListener1(String message){
        log.info("userTopicListener1: {}", message);
    }

    @KafkaListener(topics = "user-default-topic", groupId = "user-service")
    public void userTopicListener2(String message){
        log.info("userTopicListener2: {}", message);
    }

    @KafkaListener(topics = "user-default-topic", groupId = "user-service")
    public void userTopicListener3(String message){
        log.info("userTopicListener3: {}", message);
    }

    @KafkaListener(topics = "user-default-topic", groupId = "user-service")
    public void userTopicListener4(String message){
        log.info("userTopicListener4: {}", message);
    }

}
