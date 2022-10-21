package com.usercrud.service;

import com.usercrud.domain.User;
import com.usercrud.domain.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRequestMapper extends DtoMapperFacade<User, UserRequestDto> {


    public UserRequestMapper() {
        super(User.class, UserRequestDto.class);
    }


    @Override
    protected void decorateDto(UserRequestDto dto, User entity) {


    }


}
