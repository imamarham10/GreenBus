package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.service.EmailService;
import com.greenbus.GreenBus.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    @Override
    public ResponseEntity<ApiResponse> sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
        return ResponseUtil.getOkResponse("Email sent");
    }
}
