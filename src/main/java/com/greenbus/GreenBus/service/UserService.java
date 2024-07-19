package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ApiResponse> saveUser(UserDto userDto);
}
