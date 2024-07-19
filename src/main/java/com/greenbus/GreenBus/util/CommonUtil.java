package com.greenbus.GreenBus.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CommonUtil {
    private CommonUtil() {}
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonConstants.DD_MM_YYYY_T_HH_MM_SS_SSS_Z);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(CommonConstants.YYYY_MM_DD);


    public static String getCurrentDate() {
        return formatter.format(LocalDateTime.now(ZoneId.of(CommonConstants.ZONE)));
    }

    public static String getExpiryDate() {
        return formatter.format(LocalDateTime.now(ZoneId.of(CommonConstants.ZONE)).plusYears(1));
    }

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }
}
