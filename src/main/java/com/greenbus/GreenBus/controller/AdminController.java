package com.greenbus.GreenBus.controller;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String admin() {
        return "Admin only endpoint triggered";
    }

}
