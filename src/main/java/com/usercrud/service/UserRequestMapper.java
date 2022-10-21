package com.usercrud.service;

import com.usercrud.domain.User;
import com.usercrud.domain.UserRequestDto;

import org.springframework.stereotype.Service;



@Service
public class UserRequestMapper extends DtoMapperFacade<User, UserRequestDto> {


    public UserRequestMapper() {
        super(User.class, UserRequestDto.class);
    }


    @Override
    protected void decorateEntity(User entity, UserRequestDto dto) {


    }


}
