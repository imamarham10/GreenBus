package com.greenbus.GreenBus.data.model.entities;

import com.greenbus.GreenBus.data.model.dto.BaseEntity;
import com.greenbus.GreenBus.data.model.enums.Role;
import com.greenbus.GreenBus.util.CommonConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = CommonConstants.USER)
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private long phoneNumber;
    @Column(nullable = false)
    private String password;
    private Set<Role> roles = new HashSet<>();
}
