package com.greenbus.GreenBus.dao;

import com.greenbus.GreenBus.data.model.entities.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> getAllUsers();
}
