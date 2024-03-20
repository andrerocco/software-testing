package com.github.andrerocco.time;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalDateTest {
    @Test
    public void shouldCreateLocalDate() {
        // Fixture setup
        int year = 2024;
        int month = 3;
        int day = 19;

        // Exercise SUT
        LocalDate date = LocalDate.of(year, month, day);

        // Result verification
        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonthValue());
        assertEquals(day, date.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateInvalidLocalDate() {
        // Fixture setup
        
        // Exercise SUT
        assertThrows(DateTimeException.class, () -> {
            LocalDate.of(2024, 2, 30);
        });

        // Result verification

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalDateFromEpochDay() {
        // Fixture setup
        long epochDay = 18000; // April 14, 2019

        // Exercise SUT
        LocalDate date = LocalDate.ofEpochDay(epochDay);

        // Result verification
        assertEquals(2019, date.getYear());
        assertEquals(4, date.getMonthValue());
        assertEquals(14, date.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalDateFromYearDay() {
        // Fixture setup
        int year = 2024;
        int dayOfYear = 79;

        // Exercise SUT
        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);

        // Result verification
        assertEquals(year, date.getYear());
        assertEquals(3, date.getMonthValue());
        assertEquals(19, date.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalDateFromParse() {
        // Fixture setup
        String dateString = "2024-03-19";

        // Exercise SUT
        LocalDate parsedDate = LocalDate.parse(dateString);

        // Result verification
        assertEquals(2024, parsedDate.getYear());
        assertEquals(3, parsedDate.getMonthValue());
        assertEquals(19, parsedDate.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldNotCreateInvalidDateFromParse() {
        // Fixture setup
        
        // Exercise SUT
        assertThrows(DateTimeException.class, () -> {
            LocalDate.parse("2024-02-30");
        });

        // Result verification
        
        // Fixture teardown
    }

    @Test
    public void shouldGetWeekDay() {
        // Fixture setup
        LocalDate date = LocalDate.of(2000, 1, 1); // January 1, 2000 = Saturday

        // Exercise SUT
        DayOfWeek weekday = date.getDayOfWeek(); // Saturday

        // Result verification
        assertEquals(6, weekday.getValue());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLeapDate() {
        // Fixture setup
        int year = 2024;
        int month = 2;
        int day = 29;

        // Exercise SUT
        LocalDate date = LocalDate.of(year, month, day);

        // Result verification
        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonthValue());
        assertEquals(day, date.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalDateFromPlusDays() {
        // Fixture setup
        LocalDate date = LocalDate.of(2024, 3, 19);
        int daysToAdd = 5;

        // Exercise SUT
        LocalDate newDate = date.plusDays(daysToAdd);

        // Result verification
        assertEquals(2024, newDate.getYear());
        assertEquals(3, newDate.getMonthValue());
        assertEquals(24, newDate.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalDateFromMinusDays() {
        // Fixture setup
        LocalDate date = LocalDate.of(2024, 3, 19);
        int daysToSubtract = 5;

        // Exercise SUT
        LocalDate newDate = date.minusDays(daysToSubtract);

        // Result verification
        assertEquals(2024, newDate.getYear());
        assertEquals(3, newDate.getMonthValue());
        assertEquals(14, newDate.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldCreateLocalDateFromMinusDaysWithNegativeResult() {
        // Fixture setup
        LocalDate date = LocalDate.of(2024, 3, 19);
        int daysToSubtract = 19;

        // Exercise SUT
        LocalDate newDate = date.minusDays(daysToSubtract);

        // Result verification
        assertEquals(2024, newDate.getYear());
        assertEquals(2, newDate.getMonthValue());
        assertEquals(29, newDate.getDayOfMonth());

        // Fixture teardown
    }

    @Test
    public void shouldCalculateDaysBetweenDates() {
        // Fixture setup
        LocalDate startDate = LocalDate.of(2024, 3, 19);
        LocalDate endDate = LocalDate.of(2024, 3, 24);

        // Exercise SUT
        long daysBetween = startDate.until(endDate).getDays();

        // Result verification
        assertEquals(5, daysBetween);

        // Fixture teardown
    }
}
