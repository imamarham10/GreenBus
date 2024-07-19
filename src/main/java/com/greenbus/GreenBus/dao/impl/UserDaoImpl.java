package com.greenbus.GreenBus.dao.impl;

import com.greenbus.GreenBus.dao.UserDao;
import com.greenbus.GreenBus.data.model.entities.User;
import com.greenbus.GreenBus.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {
    private final UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
