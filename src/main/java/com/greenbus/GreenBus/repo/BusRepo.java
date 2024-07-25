package com.greenbus.GreenBus.repo;

import com.greenbus.GreenBus.data.model.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus, Integer> {
}
