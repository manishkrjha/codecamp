package com.codecamp.week3.user_service.event;

import lombok.Data;

@Data
public class UserCreateEvent {

    private Long id;
    private String email;

}
