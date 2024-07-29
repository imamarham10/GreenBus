package com.greenbus.GreenBus.dao.impl;

import com.greenbus.GreenBus.dao.BusDao;
import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.repo.BusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BusDaoImpl implements BusDao {
    private final BusRepo busRepo;
    @Override
    public Bus saveBus(Bus bus) {
        return busRepo.save(bus);
    }
}
