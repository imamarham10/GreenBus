package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface OtpService {
    String generateOtp();
    void saveOtp(String email, String otp);
    boolean validateOtp(String email, String otp);
}
