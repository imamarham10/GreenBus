package com.greenbus.GreenBus.repo;

import com.greenbus.GreenBus.data.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
