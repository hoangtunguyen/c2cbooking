package com.project.c2cbooking.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
