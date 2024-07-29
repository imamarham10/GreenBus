package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.BusDto;
import com.greenbus.GreenBus.data.model.entities.Bus;
import org.springframework.http.ResponseEntity;

public interface BusService {
    public ResponseEntity<ApiResponse> createBus(BusDto busDto);
}
