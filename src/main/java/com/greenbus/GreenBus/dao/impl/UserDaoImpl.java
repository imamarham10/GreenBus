package com.greenbus.GreenBus.dao.impl;

import com.greenbus.GreenBus.dao.UserDao;
import com.greenbus.GreenBus.data.model.entities.User;
import com.greenbus.GreenBus.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {
    private final UserRepo userRepo;
    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new NoSuchElementException("No user found for email " + email));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
