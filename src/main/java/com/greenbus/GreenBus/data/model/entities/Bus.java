package com.greenbus.GreenBus.data.model.entities;

import com.greenbus.GreenBus.data.model.dto.BaseEntity;
import com.greenbus.GreenBus.util.CommonConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = CommonConstants.BUS_COLLECTION_NAME)
@EqualsAndHashCode(callSuper = false)
@Data
public class Bus extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String busName;
    @Column(nullable = false, unique = true)
    private String busNumber;
    @Column(nullable = false)
    private double fare;
    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private Place source;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Place destination;
    @Column(nullable = false)
    private LocalDateTime departureDate;
    @Column(nullable = false)
    private LocalDateTime arrivalDate;
}
