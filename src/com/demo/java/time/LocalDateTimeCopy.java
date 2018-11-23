package com.demo.java.time;

import static java.time.temporal.ChronoField.NANO_OF_SECOND;

import java.io.Serializable;
import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

// final修饰,无法被继承
public final class LocalDateTimeCopy
        implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate>, Serializable {

    public static final LocalDateTime MIN = LocalDateTime.of(LocalDate.MIN, LocalTime.MIN);

    public static final LocalDateTime MAX = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);

    private static final long serialVersionUID = 2247548544334102326L;

    private final LocalDate date;

    private final LocalTime time;

    // *******
    public static LocalDateTimeCopy now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTimeCopy now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDateTimeCopy now(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        final Instant now = clock.instant();
        ZoneOffset offset = clock.getZone().getRules().getOffset(now);
        return ofEpochSecond(now.getEpochSecond(), now.getNano(), offset);
    }

    // ******* constructor
    private LocalDateTimeCopy(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    private LocalDateTimeCopy with(LocalDate newDate, LocalTime newTime) {
        if (date == newDate && time == newTime) {
            return this;
        }
        return new LocalDateTimeCopy(newDate, newTime);
    }

    // ****** of
    public static LocalDateTimeCopy of(int year, Month month, int dayOfMonth, int hour, int minute) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute);
        return new LocalDateTimeCopy(date, time);
    }

    public static LocalDateTimeCopy of(int year, Month month, int dayOfMonth, int hour, int minute, int second) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second);
        return new LocalDateTimeCopy(date, time);
    }

    public static LocalDateTimeCopy of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second, nanoOfSecond);
        return new LocalDateTimeCopy(date, time);
    }

    // ******* another of
    public static LocalDateTimeCopy of(int year, int month, int dayOfMonth, int hour, int minute) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute);
        return new LocalDateTimeCopy(date, time);
    }

    public static LocalDateTimeCopy of(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second);
        return new LocalDateTimeCopy(date, time);
    }

    public static LocalDateTimeCopy of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second, nanoOfSecond);
        return new LocalDateTimeCopy(date, time);
    }

    public static LocalDateTimeCopy of(LocalDate date, LocalTime time) {
        Objects.requireNonNull(date, "date");
        Objects.requireNonNull(time, "time");
        return new LocalDateTimeCopy(date, time);
    }

    // TODO 2018-11-23 16:45

    private static final long SECONDS_PER_DAY = 3600 * 24;
    private static final long NANOS_PER_SECONDS = 1000_000_000L;
    public static LocalDateTimeCopy ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset) {
        Objects.requireNonNull(offset, "offset");
        NANO_OF_SECOND.checkValidIntValue(nanoOfSecond);
        long localSecond = epochSecond + offset.getTotalSeconds();
        long localEpochDay = Math.floorDiv(localSecond, SECONDS_PER_DAY);
        int secsOfDay = (int) Math.floorMod(localSecond, SECONDS_PER_DAY);
        LocalDate date = LocalDate.ofEpochDay(localEpochDay);
        LocalTime time = LocalTime.ofNanoOfDay(secsOfDay * NANOS_PER_SECONDS + nanoOfSecond);
        return new LocalDateTimeCopy(date, time);
    }

    @Override
    public LocalDate toLocalDate() {
        return null;
    }

    @Override
    public LocalTime toLocalTime() {
        return null;
    }

    @Override
    public ChronoLocalDateTime<LocalDate> with(TemporalField field, long newValue) {
        return null;
    }

    @Override
    public ChronoLocalDateTime<LocalDate> plus(long amountToAdd, TemporalUnit unit) {
        return null;
    }

    @Override
    public ChronoZonedDateTime<LocalDate> atZone(ZoneId zone) {
        return null;
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return 0;
    }

    @Override
    public boolean isSupported(TemporalField field) {
        return false;
    }

    @Override
    public long getLong(TemporalField field) {
        return 0;
    }
}
