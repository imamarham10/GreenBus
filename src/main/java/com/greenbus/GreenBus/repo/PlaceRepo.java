package com.greenbus.GreenBus.repo;

import com.greenbus.GreenBus.data.model.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepo extends JpaRepository<Place,Integer> {
    Optional<Place> findByName(String name);
    List<Place> findByState(String state);
}
