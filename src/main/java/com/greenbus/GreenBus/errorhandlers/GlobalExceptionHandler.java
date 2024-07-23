package com.greenbus.GreenBus.errorhandlers;

import com.greenbus.GreenBus.data.model.dto.ApiResponse;
import com.greenbus.GreenBus.util.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

@ControllerAdvice
@Slf4j
@SuppressWarnings("unused")
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            atomicInteger.getAndIncrement();
            String errorNumber = "Error " + atomicInteger.get();
            String errorMessage = error.getDefaultMessage();
            errors.put(errorNumber, errorMessage);
        });
        log.error(errors.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        String errorNumber = "Error 1";
        String errorMessage = ex.getMessage();
        errors.put(errorNumber, errorMessage);
        log.error(errors.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        ex.getConstraintViolations().forEach(error -> {
            atomicInteger.getAndIncrement();
            String errorNumber = "Error " + atomicInteger.get();
            String errorMessage = error.getMessage();
            errors.put(errorNumber, errorMessage);
        });
        log.error(errors.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseUtil.getBadRequestResponse(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseUtil.getBadRequestResponse(ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> catchNullPointerException(NullPointerException exception) {
        return ResponseUtil.getBadRequestResponse(exception.getMessage());
    }

//    @ExceptionHandler(DuplicateKeyException.class)
//    public ResponseEntity<ApiResponse> handleDuplicateKeyException(DuplicateKeyException exception){
//        return ResponseUtil.getBadRequestResponse(CommonConstants.DUPLICATE_VALUE_NOT_ALLOWED);
//    }
}
