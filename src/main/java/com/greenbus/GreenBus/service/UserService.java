package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.LoginDto;
import com.greenbus.GreenBus.data.model.dto.UserDto;
import com.greenbus.GreenBus.data.model.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ApiResponse> saveUser(UserDto userDto);
    ResponseEntity<ApiResponse> authenticateLogin(LoginDto userDto);
    ResponseEntity<ApiResponse> authenticateRefreshLogin(HttpServletRequest request, HttpServletResponse response);
}
