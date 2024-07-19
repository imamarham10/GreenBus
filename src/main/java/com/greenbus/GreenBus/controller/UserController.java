package com.greenbus.GreenBus.controller;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.UserDto;
import com.greenbus.GreenBus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    ResponseEntity<ApiResponse> createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
}
