package com.greenbus.GreenBus.dao;

import com.greenbus.GreenBus.data.model.entities.Bus;
import com.greenbus.GreenBus.data.model.entities.Place;

import java.util.List;

public interface BusDao {
    Bus saveBus(Bus bus);
    List<Bus> getAllBuses();
    List<Bus> getAllBusesBySourceAndDestination(Place source, Place destination);
}
