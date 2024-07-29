package com.greenbus.GreenBus.data.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.greenbus.GreenBus.data.model.dto.BaseEntity;
import com.greenbus.GreenBus.data.model.enums.Gender;
import com.greenbus.GreenBus.data.model.enums.Status;
import com.greenbus.GreenBus.util.CommonConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = CommonConstants.SEAT_COLLECTION_NAME)
@Data
@EqualsAndHashCode(callSuper = false)
public class Seat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String seatNumber;
    @Column(nullable = false)
    private Status seatStatus;
    @Column(nullable = false)
    private Gender passengerGender;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonBackReference
    private Bus bus;
}
