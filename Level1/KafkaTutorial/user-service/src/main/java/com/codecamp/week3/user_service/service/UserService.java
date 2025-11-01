package com.codecamp.week3.user_service.service;

import com.codecamp.week3.user_service.dto.UserDto;
import com.codecamp.week3.user_service.entity.UserEntity;
import com.codecamp.week3.user_service.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto createUser(UserDto createUserRequest){
        UserEntity userEntity = modelMapper.map(createUserRequest, UserEntity.class);
        UserEntity createdUser = userRepository.save(userEntity);

        return modelMapper.map(createdUser, UserDto.class);
    }

}
