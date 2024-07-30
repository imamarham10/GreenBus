package com.greenbus.GreenBus.dao.impl;

import com.greenbus.GreenBus.dao.BusDao;
import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.data.model.entities.Place;
import com.greenbus.GreenBus.repo.BusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BusDaoImpl implements BusDao {
    private final BusRepo busRepo;
    @Override
    public Bus saveBus(Bus bus) {
        return busRepo.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepo.findAll();
    }

    @Override
    public List<Bus> getAllBusesBySourceAndDestination(Place source, Place destination) {
        return busRepo.findBySourceAndDestination(source, destination);
    }
}
