package com.codecamp.week3.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.user-default-topic}")
    private String KAFKA_DEFAULT_TOPIC;

    @Value("${kafka.topic.user-creation-topic}")
    private String KAFKA_USER_CREATION_TOPIC;

    @Bean
    public NewTopic createDefaultTopic(){
        return new NewTopic(KAFKA_DEFAULT_TOPIC, 3, (short) 1);
    }

    @Bean NewTopic createUserCreationTopic(){
        return new NewTopic(KAFKA_USER_CREATION_TOPIC, 2, (short) 1);
    }

}
