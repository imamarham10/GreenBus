package com.greenbus.GreenBus.controller;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.BusDto;
import com.greenbus.GreenBus.service.BusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/buses")
@RestController
@Slf4j
public class BusController {
    private final BusService busService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse> createBus(@RequestBody BusDto busDto){
        return busService.createBus(busDto);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllBuses() {
        ResponseEntity<ApiResponse> response = busService.getAllBuses();
        return busService.getAllBuses();
    }

    @GetMapping("/{source}/{destination}")
    public ResponseEntity<ApiResponse> getAllBusesBySourceAndDestination(@PathVariable String source, @PathVariable String destination) {
        return busService.getAllBusesBySourceAndDestination(source, destination);
    }

    @GetMapping("/{source}/{destination}/{date}")
    public ResponseEntity<ApiResponse> getAllBusesBySourceDestinationDate(@PathVariable String source, @PathVariable String destination, @PathVariable String date){
        return busService.getAllBusesBySourceDestinationDate(source, destination, date);
    }
}
