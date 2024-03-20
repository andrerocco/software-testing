package com.github.andrerocco.time;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalTimeTest {
    @Test
    public void shouldCreateLocalTime() {
        // Fixture setup
        int hour = 12;
        int minute = 30;
        int second = 45;

        // Exercise SUT
        LocalTime time = LocalTime.of(hour, minute, second);

        // Result verification
        assertEquals(hour, time.getHour());
        assertEquals(minute, time.getMinute());
        assertEquals(second, time.getSecond());
    
        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalTimeFromParse() {
        // Fixture setup
        String time = "12:30:45";

        // Exercise SUT
        LocalTime parsedTime = LocalTime.parse(time);

        // Result verification
        assertEquals(12, parsedTime.getHour());
        assertEquals(30, parsedTime.getMinute());
        assertEquals(45, parsedTime.getSecond());
    
        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalTimeFromSecondOfDay() {
        // Fixture setup
        int secondOfDay = 45045; // 12:30:45

        // Exercise SUT
        LocalTime time = LocalTime.ofSecondOfDay(secondOfDay);

        // Result verification
        assertEquals(12, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(45, time.getSecond());
    
        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalTimeFromNanoOfDay() {
        // Fixture setup
        long nanoOfDay = 45045000000000L; // 12:30:45.045

        // Exercise SUT
        LocalTime time = LocalTime.ofNanoOfDay(nanoOfDay);

        // Result verification
        assertEquals(12, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(45, time.getSecond());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalTimeFromMidnight() {
        // Fixture setup

        // Exercise SUT
        LocalTime midnight = LocalTime.MIDNIGHT;

        // Result verification
        assertEquals(0, midnight.getHour());
        assertEquals(0, midnight.getMinute());
        assertEquals(0, midnight.getSecond());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalTimeFromNoon() {
        // Fixture setup

        // Exercise SUT
        LocalTime noon = LocalTime.NOON;

        // Result verification
        assertEquals(12, noon.getHour());
        assertEquals(0, noon.getMinute());
        assertEquals(0, noon.getSecond());

        // Fixture teardown
    }
    
    // exceptions
    @Test
    public void shouldNotCreateLocalTimeWithInvalidHour() {
        // Fixture setup
        int hour = 24;
        int minute = 0;
        int second = 0;

        // Exercise SUT
        assertThrows(
                DateTimeException.class,
                () -> LocalTime.of(hour, minute, second)
        );

        // Result verification

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateLocalTimeWithInvalidMinute() {
        // Fixture setup
        int hour = 0;
        int minute = 60;
        int second = 0;

        // Exercise SUT
        assertThrows(
                DateTimeException.class,
                () -> LocalTime.of(hour, minute, second)
        );

        // Result verification

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateLocalTimeWithInvalidSecond() {
        // Fixture setup
        int hour = 0;
        int minute = 0;
        int second = 60;

        // Exercise SUT
        assertThrows(
                DateTimeException.class,
                () -> LocalTime.of(hour, minute, second)
        );

        // Result verification

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateLocalTimeFromParseWithInvalidTime() {
        // Fixture setup
        String time = "24:00:00";

        // Exercise SUT
        assertThrows(
                DateTimeException.class,
                () -> LocalTime.parse(time)
        );

        // Result verification

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateLocalTimeFromParseWithInvalidFormat() {
        // Fixture setup
        String time = "12-30-45";

        // Exercise SUT
        assertThrows(
                DateTimeException.class,
                () -> LocalTime.parse(time)
        );

        // Result verification

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateLocalTimeFromSecondOfDayWithInvalidSecond() {
        // Fixture setup
        int secondOfDay = 86400; // 24:00:00
        
        // Exercise SUT
        assertThrows(
                DateTimeException.class,
                () -> LocalTime.ofSecondOfDay(secondOfDay)
        );

        // Result verification

        // Fixture teardown
    }
}
