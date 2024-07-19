package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.dao.UserDao;
import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.UserDto;
import com.greenbus.GreenBus.data.model.entities.User;
import com.greenbus.GreenBus.service.UserService;
import com.greenbus.GreenBus.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<ApiResponse> saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.createEntity();
        return ResponseUtil.getCreatedResponse(userDao.saveUser(user));
    }
}
