package com.greenbus.GreenBus.controller;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.PlaceDto;
import com.greenbus.GreenBus.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse> savePlace(@RequestBody PlaceDto placeDto) {
        return placeService.savePlace(placeDto);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPlaces(){
        return placeService.getAllPlaces();
    }

    @GetMapping("/by-name")
    public ResponseEntity<ApiResponse> getPlaceByName(@RequestParam String name){
        return placeService.getPlaceByName(name);
    }

    @GetMapping("/by-state")
    public ResponseEntity<ApiResponse> getAllPlacesByState(@RequestParam String state){
        return placeService.getAllPlacesByState(state);
    }

}
