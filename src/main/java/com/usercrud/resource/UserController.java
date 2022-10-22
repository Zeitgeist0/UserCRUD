package com.usercrud.resource;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usercrud.domain.User;
import com.usercrud.domain.UserRequestDto;
import com.usercrud.domain.UserResponseDto;
import com.usercrud.service.UserRequestMapper;
import com.usercrud.service.UserResponseMapper;
import com.usercrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void save(@Valid @RequestBody UserRequestDto user) {
        User userRequest = userRequestMapper.convertToEntity(user);
        userService.save(userRequest);
    }


    @DeleteMapping("/deleteById")
    public void deleteById(@RequestBody ObjectNode objectNode) {
        Integer userId = objectNode.get("userId").asInt();
        userService.deleteById(userId);
    }
    @DeleteMapping()
    public void delete(@Valid @RequestBody UserRequestDto user) {
        userService.delete(userRequestMapper.convertToEntity(user));
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }


}
