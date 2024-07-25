package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.dao.PlaceDao;
import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.PlaceDto;
import com.greenbus.GreenBus.data.model.entities.Place;
import com.greenbus.GreenBus.service.PlaceService;
import com.greenbus.GreenBus.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceDao placeDao;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<ApiResponse> savePlace(PlaceDto placeDto) {
        Place place = modelMapper.map(placeDto, Place.class);
        place.createEntity();
        return ResponseUtil.getCreatedResponse(placeDao.savePlace(place));
    }

    @Override
    public ResponseEntity<ApiResponse> getAllPlaces() {
        return ResponseUtil.getOkResponse(placeDao.getAllPlace());
    }

    @Override
    public ResponseEntity<ApiResponse> getPlaceByName(String name) {
        return ResponseUtil.getOkResponse(placeDao.getPlaceByName(name));
    }

    @Override
    public ResponseEntity<ApiResponse> getAllPlacesByState(String state) {
        return ResponseUtil.getOkResponse(placeDao.getAllPlaceByState(state));
    }
}
