package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.BusDto;
import com.greenbus.GreenBus.data.model.entities.Bus;
import org.springframework.http.ResponseEntity;

public interface BusService {
    public ResponseEntity<ApiResponse> createBus(BusDto busDto);
    public ResponseEntity<ApiResponse> getAllBuses();
    public ResponseEntity<ApiResponse> getAllBusesBySourceAndDestination(String source, String destination);
    public ResponseEntity<ApiResponse> getAllBusesBySourceDestinationDate(String source, String destination, String date);
}
