package com.project.c2cbooking.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Util {
    public static Timestamp convertStringToTimestamp(String dateString){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(dateString);
            return new Timestamp(date.getTime());
        }catch (Exception e){
            System.out.print("Exception: " + e);
            return null;
        }
    }
    public static String convertTimestampToString(Timestamp date){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(date);
        }catch (Exception e){
            System.out.print("Exception: " + e);
            return null;
        }
    }
    public static String formatNumber(String value) {
        if (value.split("\\.").length > 1) {
            while (true) {
                if (value.endsWith("0")) {
                    value = value.substring(0, value.length() - 1);
                } else {
                    if (value.endsWith(".")) value = value.substring(0, value.length() - 1);
                    break;
                }
            }

        }
        return value;
    }
}
