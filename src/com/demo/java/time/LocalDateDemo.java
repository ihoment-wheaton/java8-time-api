package com.demo.java.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Objects;

public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.of(null, LocalTime.now());
        Objects.requireNonNull(localDate);

    }

    public static LocalDate today() {
        return LocalDate.now();
    }
}
