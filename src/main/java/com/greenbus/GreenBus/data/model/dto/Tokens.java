package com.greenbus.GreenBus.data.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Tokens {
    private String accessToken;
    private String refreshToken;

}
