package com.arduinoService.RfidRest.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class main {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
//
//        if (dateFormat.format(date) < '23:40:00'){
//
//        }

        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));


        Date currentDate = dateFormat.parse(dateFormat.format(date));

        Calendar cal = Calendar.getInstance();
// remove next line if you're always using the current time.
        cal.setTime(currentDate);
        cal.add(Calendar.HOUR, -1);
        Date oneHourBack = cal.getTime();

        System.out.println(oneHourBack);

    }

}

