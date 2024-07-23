package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity<ApiResponse> sendEmail(String to, String subject, String text);
}
