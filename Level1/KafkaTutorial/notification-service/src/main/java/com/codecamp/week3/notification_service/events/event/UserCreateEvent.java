package com.codecamp.week3.notification_service.events.event;

import lombok.Data;

@Data
public class UserCreateEvent {

    private Long id;
    private String email;

}
