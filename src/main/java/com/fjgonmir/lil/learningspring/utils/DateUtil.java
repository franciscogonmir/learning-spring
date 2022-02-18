package com.fjgonmir.lil.learningspring.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDateString(String dateString) {
        Date date = null;
        try {
            date = (dateString != null) ? DATE_FORMAT.parse(dateString) : new Date();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return date;
        }

    }
}
