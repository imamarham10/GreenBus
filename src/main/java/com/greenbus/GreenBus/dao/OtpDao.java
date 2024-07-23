package com.greenbus.GreenBus.dao;

import com.greenbus.GreenBus.data.model.entities.Otp;

public interface OtpDao {
    void saveOtp(Otp otp);
    Otp findByEmailAndOtp(String email, String otp);
    void deleteOtp(Otp otp);
}
