package com.greenbus.GreenBus.dao.impl;

import com.greenbus.GreenBus.dao.OtpDao;
import com.greenbus.GreenBus.data.model.entities.Otp;
import com.greenbus.GreenBus.repo.OtpRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Repository
public class OtpDaoImpl implements OtpDao {
    private final OtpRepo otpRepo;
    @Override
    public void saveOtp(Otp otp) {
        otpRepo.save(otp);
    }

    @Override
    public Otp findByEmailAndOtp(String email, String otp) {
        return otpRepo.findByEmailAndOtp(email, otp).orElseThrow(() -> new NoSuchElementException("Invalid otp or email combination"));
    }

    @Override
    public void deleteOtp(Otp otp) {
        otpRepo.delete(otp);
    }
}
