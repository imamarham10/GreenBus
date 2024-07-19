package com.greenbus.GreenBus.data.model.dto;

import com.greenbus.GreenBus.data.model.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private Set<Role> roles;
}
