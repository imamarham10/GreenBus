package com.greenbus.GreenBus.data.model.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BusDto {
    private String busName;
    private String busNumber;
    private double fare;
    private int source;
    private int destination;
    private int numberOfSeats;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private boolean isRecurring;
}
