package com.usercrud.resource;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usercrud.domain.User;
import com.usercrud.domain.UserRequestDto;
import com.usercrud.domain.UserResponseDto;
import com.usercrud.service.UserRequestMapper;
import com.usercrud.service.UserResponseMapper;
import com.usercrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    @GetMapping("/getById")
    public Optional<UserResponseDto> getById(@RequestBody ObjectNode objectNode) {
        Integer userId = objectNode.get("userId").asInt();
        return userService.findById(userId).map(userResponseMapper::convertToDto);
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAll() {
        return userService.findAll().stream().map(userResponseMapper::convertToDto).collect(Collectors.toList());
    }

    @PostMapping()
    public void save(@RequestBody UserRequestDto user) {
        userService.save(userRequestMapper.convertToEntity(user));
    }


    @DeleteMapping("/deleteById")
    public void deleteById(@RequestBody ObjectNode objectNode) {
        Integer userId = objectNode.get("userId").asInt();
        userService.deleteById(userId);
    }
    @DeleteMapping()
    public void delete(@RequestBody UserRequestDto user) {
        userService.delete(userRequestMapper.convertToEntity(user));
    }

}
