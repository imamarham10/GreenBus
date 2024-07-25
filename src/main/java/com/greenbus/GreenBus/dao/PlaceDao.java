package com.greenbus.GreenBus.dao;

import com.greenbus.GreenBus.data.model.entities.Place;

import java.util.List;

public interface PlaceDao {
    Place savePlace(Place place);
    List<Place> getAllPlace();
    Place getPlaceByName(String name);
    List<Place> getAllPlaceByState(String state);

}
