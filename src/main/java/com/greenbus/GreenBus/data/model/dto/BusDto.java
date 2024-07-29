package com.greenbus.GreenBus.data.model.dto;

import com.greenbus.GreenBus.data.model.entities.Place;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BusDto {
    private String busName;
    private String busNumber;
    private double fare;
    private Place source;
    private Place destination;
    private int numberOfSeats;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
}
