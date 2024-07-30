package com.greenbus.GreenBus.data.model.entities;

import com.greenbus.GreenBus.util.CommonConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = CommonConstants.PLACE_COLLECTION_NAME)
@Data
@EqualsAndHashCode(callSuper = false)
public class Place extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false, unique = true)
    private String pinCode;
}
