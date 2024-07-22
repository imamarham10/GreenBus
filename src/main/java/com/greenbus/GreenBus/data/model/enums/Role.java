package com.greenbus.GreenBus.data.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    PASSENGER;

    @Override
    public String getAuthority() {
        return name();
    }
}
