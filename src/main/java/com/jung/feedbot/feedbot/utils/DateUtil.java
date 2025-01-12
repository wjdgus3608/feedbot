package com.jung.feedbot.feedbot.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String getDate(){
        LocalDate today = LocalDate.now();

        // DateTimeFormatter를 사용하여 yyyyMMdd 형식으로 포맷
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return today.format(formatter);
    }

    public static String getDate(LocalDate today){
        // DateTimeFormatter를 사용하여 yyyyMMdd 형식으로 포맷
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return today.format(formatter);
    }
}
