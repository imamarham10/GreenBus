package com.greenbus.GreenBus.dao.impl;

import com.greenbus.GreenBus.dao.PlaceDao;
import com.greenbus.GreenBus.data.model.entities.Place;
import com.greenbus.GreenBus.repo.PlaceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Repository
public class PlaceDaoImpl implements PlaceDao {
    private final PlaceRepo placeRepo;
    @Override
    public Place savePlace(Place place) {
        return placeRepo.save(place);
    }

    @Override
    public List<Place> getAllPlace() {
        return placeRepo.findAll();
    }

    @Override
    public Place getPlaceByName(String name) {
        return placeRepo.findByName(name).orElseThrow(()-> new NoSuchElementException("There might be no bus for the place: " + name));
    }

    @Override
    public List<Place> getAllPlaceByState(String state) {
        return placeRepo.findByState(state);
    }

    @Override
    public Place getPlaceById(int placeId) {
        return placeRepo.findById(placeId).orElseThrow(()->new NoSuchElementException("No place exists with id " + placeId));
    }
}
