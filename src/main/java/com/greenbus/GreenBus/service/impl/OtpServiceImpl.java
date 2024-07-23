package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.dao.OtpDao;
import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.entities.Otp;
import com.greenbus.GreenBus.service.OtpService;
import com.greenbus.GreenBus.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class OtpServiceImpl implements OtpService {
    private final OtpDao otpDao;

    public String generateOtp(){
        return String.valueOf(new Random().nextInt(900000) + 100000);
    }

    public void saveOtp(String email, String otp){
        Otp otpEntity = new Otp();
        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpEntity.setExpirationTime(LocalDateTime.now().plusMinutes(10));
        otpDao.saveOtp(otpEntity);

    }

    public boolean validateOtp(String email, String otp){
        Otp otpEntity = otpDao.findByEmailAndOtp(email, otp);
        if (otpEntity.getExpirationTime().isAfter(LocalDateTime.now())) {
            otpDao.deleteOtp(otpEntity);
            return true;
        }
        return false;
    }


}
