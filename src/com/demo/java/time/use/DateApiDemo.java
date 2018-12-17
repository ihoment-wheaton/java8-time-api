package com.demo.java.time.use;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.Date;
import java.util.Locale;

public class DateApiDemo {

    public static void main(String[] args) {
        testClock();
        testInstant();
        testZoneId();
        testLocalTime();
        testLocalDate();
        testDateTimeFormatter();
        testTemporal();
        testWeek();
    }

    public static void testClock() {
        Clock clock = Clock.systemUTC();
        long millis = clock.millis();
        Instant instant = clock.instant();
        Date legecyDate = Date.from(instant);

        System.out.println(millis);
        System.out.println(legecyDate);
    }

    public static void testInstant() {
        Instant instant = Instant.now();
        System.out.println(Instant.MAX);
        System.out.println(Instant.MIN);
        System.out.println(Instant.EPOCH.toEpochMilli());
    }

    public static void testZoneId() {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId.getRules());
    }

    public static void testLocalTime() {
        LocalTime time1 = LocalTime.now(ZoneId.of("UTC"));
        LocalTime time2 = LocalTime.now(ZoneId.systemDefault());
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time1.isBefore(time2));

        long hoursBetween = ChronoUnit.HOURS.between(time1, time2);
        long minutesBetween = ChronoUnit.MINUTES.between(time1, time2);
        long seconds = ChronoUnit.SECONDS.between(time1, time2);
        long millis = ChronoUnit.MILLIS.between(time1, time2);

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);
        System.out.println(seconds);
        System.out.println(millis);

        // various factory methods
        LocalTime late = LocalTime.of(23, 59);
        System.out.println(late);
        late = LocalTime.of(23, 59, 59);
        System.out.println(late);
        late = LocalTime.of(23, 59, 59, 177_000_000);
        System.out.println(late);
    }

    public static void testLocalDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);
    }

    public static void testDateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", formatter);
        System.out.println(xmas);
    }

    public static void testTemporal() {
        System.out.println(TemporalAdjusters.firstDayOfMonth());
    }

    public static void testWeek() {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.CHINA);
        System.out.println(date.get(weekFields.weekBasedYear()));
        System.out.println(date.get(weekFields.weekOfWeekBasedYear()));
        System.out.println(date.get(weekFields.weekOfYear()));
    }
}
