package com.greenbus.GreenBus.repo;

import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.data.model.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus, Integer> {
    List<Bus> findBySourceAndDestination(Place source, Place destination);
}
