package com.greenbus.GreenBus.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CommonConstants {
    public static final String BUS_COLLECTION_NAME = "buses";
    public static final String PLACE_COLLECTION_NAME = "places";
    public static final String SEAT_COLLECTION_NAME = "seats";
    private CommonConstants(){}
    public static final String DD_MM_YYYY_T_HH_MM_SS_SSS_Z = "dd-MM-yyyy'T'HH:mm:ss.SSS'Z'";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String ZONE = "Asia/Kolkata";
    public static final String USER_COLLECTION_NAME = "users";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static LocalDateTime parseDate(String date) {
        try {
            return LocalDateTime.parse(date, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + date, e);
        }
    }

}
