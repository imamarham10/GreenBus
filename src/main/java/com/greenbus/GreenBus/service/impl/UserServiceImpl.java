package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.dao.UserDao;
import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.data.model.dto.LoginDto;
import com.greenbus.GreenBus.data.model.dto.Tokens;
import com.greenbus.GreenBus.data.model.dto.UserDto;
import com.greenbus.GreenBus.data.model.entities.User;
import com.greenbus.GreenBus.service.EmailService;
import com.greenbus.GreenBus.service.JwtService;
import com.greenbus.GreenBus.service.OtpService;
import com.greenbus.GreenBus.service.UserService;
import com.greenbus.GreenBus.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final OtpService otpService;
    private final EmailService emailService;
    @Override
    public ResponseEntity<ApiResponse> saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setVerified(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.createEntity();
        userDao.saveUser(user);
        String otp = otpService.generateOtp();
        log.info("Otp : {}" + otp);
        otpService.saveOtp(user.getEmail(), otp);
        emailService.sendEmail(user.getEmail(), "OTP Verification", "Your otp is: " + otp);
        return ResponseUtil.getOkResponse("OTP sent to your email");
    }

    public ResponseEntity<ApiResponse> verifyUser(String email, String otp){
        if(otpService.validateOtp(email,otp)){
            User user = userDao.findByEmail(email);
            user.setVerified(true);
            userDao.saveUser(user);
            emailService.sendEmail(user.getEmail(), "Welcome to Green Bus", "Welcome to Green Bus. Thank you for creating your Green Bus profile! Enjoy travelling at affordable prices. ");
            emailService.sendEmail("arhamimam6@gmail.com", "New User Registered", "A new user has registered with email: " + user.getEmail());
            return ResponseUtil.getOkResponse("User verified and welcome email sent");
        }
        return ResponseUtil.getUnAuthorisedResponse("Invalid Otp");
    }

    @Override
    public ResponseEntity<ApiResponse> authenticateLogin(LoginDto userDto) {
        User user = userDao.findByUsername(userDto.getUsername());
        if (user == null) {
            return ResponseUtil.getUnAuthorisedResponse("User not found");
        }

        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword())
            );
            String token = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);
            return ResponseUtil.getOkResponse(Tokens.builder().accessToken(token).refreshToken(refreshToken).build());
        } else {
            return ResponseUtil.getUnAuthorisedResponse("Password Mismatch");
        }
    }

    @Override
    public ResponseEntity<ApiResponse> authenticateRefreshLogin(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseUtil.getUnAuthorisedResponse("Wrong authentication token");
        }

        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);

        User user = userDao.findByUsername(username);

        if(jwtService.isValid(token, user)) {
            String accessToken = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);
            return ResponseUtil.getOkResponse(Tokens.builder().accessToken(accessToken).refreshToken(refreshToken).build());

        }
        return ResponseUtil.getUnAuthorisedResponse("Unauthorized");
    }
}
