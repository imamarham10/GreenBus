package com.greenbus.GreenBus.service;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.PlaceDto;
import org.springframework.http.ResponseEntity;

public interface PlaceService {
    ResponseEntity<ApiResponse> savePlace(PlaceDto placeDto);
    ResponseEntity<ApiResponse> getAllPlaces();
    ResponseEntity<ApiResponse> getPlaceByName(String name);
    ResponseEntity<ApiResponse> getAllPlacesByState(String state);
}
