package com.demo.java.time.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalApiDemo {

    public static void main(String[] args) throws Exception {
        LocalDate dayOfWeek = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(dayOfWeek);
    }
}
