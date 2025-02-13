package com.greenbus.GreenBus.dao;

import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.data.model.entities.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusDao {
    Bus saveBus(Bus bus);
    Page<Bus> getAllBuses(Integer pageNumber, Integer pageSize);
    List<Bus> getAllBusesBySourceAndDestination(Place source, Place destination);
    Page<Bus> getSortedBuses(Pageable pageable);
}
