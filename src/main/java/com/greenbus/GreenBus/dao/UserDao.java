package com.greenbus.GreenBus.dao;

import com.greenbus.GreenBus.data.model.entities.User;

public interface UserDao {
    User saveUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}
