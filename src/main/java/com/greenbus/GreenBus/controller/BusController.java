package com.greenbus.GreenBus.controller;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.BusDto;
import com.greenbus.GreenBus.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/bus")
@RestController
public class BusController {
    private final BusService busService;

    @PostMapping
    public ResponseEntity<ApiResponse> createBus(@RequestBody BusDto busDto){
        return busService.createBus(busDto);
    }
}
