package com.greenbus.GreenBus.data.model.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private HttpStatus httpStatus;
    private int statusCode;
    private Object response;
}
