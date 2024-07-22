package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.entities.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {
    String extractUsername(String token);
    String generateAccessToken(User user);
    String generateRefreshToken(User user);
    boolean isValid(String token, UserDetails user);
}
