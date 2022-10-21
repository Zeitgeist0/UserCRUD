package com.usercrud.service;

import com.usercrud.domain.User;
import com.usercrud.domain.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserResponseMapper extends DtoMapperFacade<User, UserResponseDto> {


    public UserResponseMapper() {
        super(User.class, UserResponseDto.class);
    }

    @Override
    protected void decorateDto(UserResponseDto dto, User entity) {


    }


}