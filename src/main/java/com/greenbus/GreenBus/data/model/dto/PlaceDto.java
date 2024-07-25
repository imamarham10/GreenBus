package com.greenbus.GreenBus.data.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlaceDto {
    @NotBlank(message = "Place name is required")
    @Size(max = 100, message = "Place name should not exceed 100 characters")
    private String name;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State name should not exceed 100 characters")
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country name should not exceed 100 characters")
    private String country;


    @Pattern(regexp = "^\\d{6}$", message = "Pin code should be exactly 6 digits")
    private String pinCode;
}
