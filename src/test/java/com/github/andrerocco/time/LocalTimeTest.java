package com.github.andrerocco.time;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalTimeTest {
    @Test
    public void shouldCreateLocalTime() {
        int hour = 12;
        int minute = 30;
        int second = 45;

        LocalTime time = LocalTime.of(hour, minute, second);

        assertEquals(hour, time.getHour());
        assertEquals(minute, time.getMinute());
        assertEquals(second, time.getSecond());
    }

    @Test
    public void shouldCreateLocalTimeFromParse() {
        String time = "12:30:45";

        LocalTime parsedTime = LocalTime.parse(time);

        assertEquals(12, parsedTime.getHour());
        assertEquals(30, parsedTime.getMinute());
        assertEquals(45, parsedTime.getSecond());
    }

    @Test
    public void shouldCreateLocalTimeFromSecondOfDay() {
        int secondOfDay = 45045; // 12:30:45

        LocalTime time = LocalTime.ofSecondOfDay(secondOfDay);

        assertEquals(12, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(45, time.getSecond());
    }

    @Test
    public void shouldCreateLocalTimeFromNanoOfDay() {
        long nanoOfDay = 45045000000000L; // 12:30:45.045

        LocalTime time = LocalTime.ofNanoOfDay(nanoOfDay);

        assertEquals(12, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(45, time.getSecond());
    }

    @Test
    public void shouldCreateLocalTimeFromMidnight() {
        LocalTime midnight = LocalTime.MIDNIGHT;

        assertEquals(0, midnight.getHour());
        assertEquals(0, midnight.getMinute());
        assertEquals(0, midnight.getSecond());
    }

    @Test
    public void shouldCreateLocalTimeFromNoon() {
        LocalTime noon = LocalTime.NOON;

        assertEquals(12, noon.getHour());
        assertEquals(0, noon.getMinute());
        assertEquals(0, noon.getSecond());
    }
    
    // exceptions
    @Test
    public void shouldNotCreateLocalTimeWithInvalidHour() {
        int hour = 24;
        int minute = 0;
        int second = 0;

        assertThrows(
                DateTimeException.class,
                () -> LocalTime.of(hour, minute, second)
        );
    }

    @Test
    public void shouldNotCreateLocalTimeWithInvalidMinute() {
        int hour = 0;
        int minute = 60;
        int second = 0;

        assertThrows(
                DateTimeException.class,
                () -> LocalTime.of(hour, minute, second)
        );
    }

    @Test
    public void shouldNotCreateLocalTimeWithInvalidSecond() {
        int hour = 0;
        int minute = 0;
        int second = 60;

        assertThrows(
                DateTimeException.class,
                () -> LocalTime.of(hour, minute, second)
        );
    }

    @Test
    public void shouldNotCreateLocalTimeFromParseWithInvalidTime() {
        String time = "24:00:00";

        assertThrows(
                DateTimeException.class,
                () -> LocalTime.parse(time)
        );
    }

    @Test
    public void shouldNotCreateLocalTimeFromParseWithInvalidFormat() {
        String time = "12-30-45";

        assertThrows(
                DateTimeException.class,
                () -> LocalTime.parse(time)
        );
    }

    @Test
    public void shouldNotCreateLocalTimeFromSecondOfDayWithInvalidSecond() {
        int secondOfDay = 86400; // 24:00:00

        assertThrows(
                DateTimeException.class,
                () -> LocalTime.ofSecondOfDay(secondOfDay)
        );
    }
}
