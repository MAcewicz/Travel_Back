package com.kodilla.travel.controller;

import com.kodilla.travel.domain.User;
import com.kodilla.travel.dto.UserDto;
import com.kodilla.travel.exception.UserNotFoundException;
import com.kodilla.travel.mappers.UserMapper;
import com.kodilla.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/travel/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "users")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.getUsers());
    }

    @GetMapping(value = "user/{id}")
    public UserDto getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUserById(id).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "user/{email}")
    public UserDto getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return userMapper.mapToUserDto(userService.getUserByEmail(email).orElseThrow(UserNotFoundException::new));
    }

    @PutMapping(value = "users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.createUser(userMapper.mapToUser(userDto)));
    }
}
