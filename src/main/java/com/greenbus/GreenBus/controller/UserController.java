package com.greenbus.GreenBus.controller;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.LoginDto;
import com.greenbus.GreenBus.data.model.dto.UserDto;
import com.greenbus.GreenBus.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginDto userDto){
        return userService.authenticateLogin(userDto);
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse> verifyUser(@RequestParam String email, @RequestParam String otp){
        return userService.verifyUser(email, otp);
    }


    @GetMapping("/demo")
    public String demo() {
        return "Secret Msg";
    }

    @PostMapping("/refresh")
    public ResponseEntity<Object> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(userService.authenticateRefreshLogin(request, response));
    }

}
