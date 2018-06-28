package com.usitrip.test;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateDemo {

    @Test
    public void testDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate date = now.plus(2, ChronoUnit.DAYS);
        System.out.println(date);
        System.out.println(date.isEqual(now));

        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        Year year = Year.now();
        System.out.println(year.toString());

        System.out.println(Period.between(now, date));
        System.out.println(date.getDayOfWeek().toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getNano());
        System.out.println(localDateTime.getSecond());
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }
}
