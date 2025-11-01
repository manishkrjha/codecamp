package com.codecamp.week3.user_service.controller;

import com.codecamp.week3.user_service.dto.UserDto;
import com.codecamp.week3.user_service.event.UserCreateEvent;
import com.codecamp.week3.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<Long, UserCreateEvent> kafkaTemplate;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Value("${kafka.topic.user-default-topic}")
    private String KAFKA_DEFAULT_TOPIC;

    @Value("${kafka.topic.user-creation-topic}")
    private String KAFKA_USER_CREATION_TOPIC;

//    @PostMapping("/{message}")
//    ResponseEntity<String> sendMessage(@PathVariable String message){
//
//        for(int i=0;i<10000;i++){
//            String key = ""+i%2;
//            kafkaTemplate.send(KAFKA_DEFAULT_TOPIC, key, message);
//        }
//
//        return ResponseEntity.ok("Message sent");
//    }

    @PostMapping("/create")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto response = userService.createUser(userDto);

        UserCreateEvent userCreateEvent = modelMapper.map(response, UserCreateEvent.class);

        kafkaTemplate.send(KAFKA_USER_CREATION_TOPIC, response.getId(), userCreateEvent);

        return ResponseEntity.ok(response);
    }

}
