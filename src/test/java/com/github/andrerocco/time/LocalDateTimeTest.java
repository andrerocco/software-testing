package com.github.andrerocco.time;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalDateTimeTest {
    @Test
    public void shouldCreateLocalDateTime() {
        int year = 2024;
        int month = 3;
        int day = 19;
        int hour = 12;
        int minute = 30;
        int second = 45;

        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);

        assertEquals(year, dateTime.getYear());
        assertEquals(month, dateTime.getMonthValue());
        assertEquals(day, dateTime.getDayOfMonth());
        assertEquals(hour, dateTime.getHour());
        assertEquals(minute, dateTime.getMinute());
        assertEquals(second, dateTime.getSecond());
    }

    @Test
    public void shouldCreateLocalDateTimeFromParse() {
        String dateTime = "2024-03-19T12:30:45";

        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime);

        assertEquals(2024, parsedDateTime.getYear());
        assertEquals(3, parsedDateTime.getMonthValue());
        assertEquals(19, parsedDateTime.getDayOfMonth());
        assertEquals(12, parsedDateTime.getHour());
        assertEquals(30, parsedDateTime.getMinute());
        assertEquals(45, parsedDateTime.getSecond());
    }

    @Test
    public void shouldCreateLocalDateTimeFromLocalDateAndLocalTime() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 3, 19, 12, 30, 45);

        assertEquals(2024, dateTime.getYear());
        assertEquals(3, dateTime.getMonthValue());
        assertEquals(19, dateTime.getDayOfMonth());
        assertEquals(12, dateTime.getHour());
        assertEquals(30, dateTime.getMinute());
        assertEquals(45, dateTime.getSecond());
    }

    @Test
    public void shouldAddDaysToDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 3, 19, 12, 30, 45);
        int daysToAdd = 5;

        LocalDateTime newDateTime = dateTime.plusDays(daysToAdd);

        assertEquals(2024, newDateTime.getYear());
        assertEquals(3, newDateTime.getMonthValue());
        assertEquals(24, newDateTime.getDayOfMonth());
        assertEquals(12, newDateTime.getHour());
        assertEquals(30, newDateTime.getMinute());
        assertEquals(45, newDateTime.getSecond());
    }

    @Test
    public void shouldSubtractDaysFromDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 3, 19, 12, 30, 45);
        int daysToSubtract = 5;

        LocalDateTime newDateTime = dateTime.minusDays(daysToSubtract);

        assertEquals(2024, newDateTime.getYear());
        assertEquals(3, newDateTime.getMonthValue());
        assertEquals(14, newDateTime.getDayOfMonth());
        assertEquals(12, newDateTime.getHour());
        assertEquals(30, newDateTime.getMinute());
        assertEquals(45, newDateTime.getSecond());
    }

    @Test
    public void shouldSubtractDaysFromDateTimeWithNegativeResult() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 3, 19, 12, 30, 45);
        int daysToSubtract = 19;

        LocalDateTime newDateTime = dateTime.minusDays(daysToSubtract);

        assertEquals(2024, newDateTime.getYear());
        assertEquals(2, newDateTime.getMonthValue());
        assertEquals(29, newDateTime.getDayOfMonth());
        assertEquals(12, newDateTime.getHour());
        assertEquals(30, newDateTime.getMinute());
        assertEquals(45, newDateTime.getSecond());
    }

    @Test
    public void shouldNotCreateLocalDateTimeWithInvalidHour() {
        int year = 2024;
        int month = 3;
        int day = 19;
        int hour = 24;
        int minute = 30;
        int second = 45;

        assertThrows(
                DateTimeException.class,
                () -> LocalDateTime.of(year, month, day, hour, minute, second)
        );
    }

    @Test
    public void shouldNotCreateLocalDateTimeWithInvalidMinute() {
        int year = 2024;
        int month = 3;
        int day = 19;
        int hour = 12;
        int minute = 60;
        int second = 45;

        assertThrows(
                DateTimeException.class,
                () -> LocalDateTime.of(year, month, day, hour, minute, second)
        );
    }

    @Test
    public void shouldNotCreateLocalDateTimeWithInvalidSecond() {
        int year = 2024;
        int month = 3;
        int day = 19;
        int hour = 12;
        int minute = 30;
        int second = 60;

        assertThrows(
                DateTimeException.class,
                () -> LocalDateTime.of(year, month, day, hour, minute, second)
        );
    }
}
