package com.greenbus.GreenBus.data.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message = "Username is required and cannot be empty")
    private String username;
    @NotBlank(message = "Password is required and cannot be empty")
    private String password;
    @NotBlank(message = "Email is required and cannot be empty")
    private String email;
}
