package com.fjgonmir.lil.learningspring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }


    public static Date createDateFromDateString(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return (dateString != null) ? format.parse(dateString) : new Date();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
