package com.greenbus.GreenBus.data.model.dto;

import com.greenbus.GreenBus.data.model.enums.Role;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    @NotBlank(message = "Username is mandatory and can't be empty")
    private String username;
    @Email(message = "Email should be a valid email address")
    @NotBlank(message = "Email is mandatory and can't be empty")
    private String email;
    @NotBlank(message = "Password is mandatory and can't be empty")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;
    @NotBlank(message = "First name is mandatory and can't be empty")
    private String firstName;
    @NotBlank(message = "Last name is mandatory and can't be empty")
    private String lastName;
    @NotNull(message = "Phone number is mandatory and can't be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    private String phoneNumber;
    @NotNull(message = "Roles are mandatory")
    private Set<Role> roles;
}
