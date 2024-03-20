package com.github.andrerocco.time;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalDateTest {
    @Test
    public void shouldCreateLocalDate() {
        int year = 2024;
        int month = 3;
        int day = 19;

        LocalDate date = LocalDate.of(year, month, day);

        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonthValue());
        assertEquals(day, date.getDayOfMonth());
    }

    @Test
    public void shouldCreateLocalDateFromEpochDay() {
        long epochDay = 18000; // April 14, 2019

        LocalDate date = LocalDate.ofEpochDay(epochDay);

        assertEquals(2019, date.getYear());
        assertEquals(4, date.getMonthValue());
        assertEquals(14, date.getDayOfMonth());
    }

    @Test
    public void shouldCreateLocalDateFromYearDay() {
        int year = 2024;
        int dayOfYear = 79;

        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);

        assertEquals(year, date.getYear());
        assertEquals(3, date.getMonthValue());
        assertEquals(19, date.getDayOfMonth());
    }

    @Test
    public void shouldCreateLocalDateFromParse() {
        String date = "2024-03-19";

        LocalDate parsedDate = LocalDate.parse(date);

        assertEquals(2024, parsedDate.getYear());
        assertEquals(3, parsedDate.getMonthValue());
        assertEquals(19, parsedDate.getDayOfMonth());
    }

    @Test
    public void shouldGetWeekDay() {
        LocalDate pastDate = LocalDate.of(2000, 1, 1); // January 1, 2000 = Saturday
        LocalDate futureDate = LocalDate.of(3000, 12, 7); // December 7, 3000 = Sunday

        assertEquals(6, pastDate.getDayOfWeek().getValue());
        assertEquals(7, futureDate.getDayOfWeek().getValue());
    }

    @Test
    public void shouldCreateLeapDate() {
        int year = 2024;
        int month = 2;
        int day = 29;

        LocalDate date = LocalDate.of(year, month, day);

        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonthValue());
        assertEquals(day, date.getDayOfMonth());
    }

    @Test
    public void shouldCreateLocalDateFromPlusDays() {
        LocalDate date = LocalDate.of(2024, 3, 19);
        int daysToAdd = 5;

        LocalDate newDate = date.plusDays(daysToAdd);

        assertEquals(2024, newDate.getYear());
        assertEquals(3, newDate.getMonthValue());
        assertEquals(24, newDate.getDayOfMonth());
    }

    @Test
    public void shouldCreateLocalDateFromMinusDays() {
        LocalDate date = LocalDate.of(2024, 3, 19);
        int daysToSubtract = 5;

        LocalDate newDate = date.minusDays(daysToSubtract);

        assertEquals(2024, newDate.getYear());
        assertEquals(3, newDate.getMonthValue());
        assertEquals(14, newDate.getDayOfMonth());
    }

    @Test
    public void shouldCreateLocalDateFromMinusDaysWithNegativeResult() {
        LocalDate date = LocalDate.of(2024, 3, 19);
        int daysToSubtract = 19;

        LocalDate newDate = date.minusDays(daysToSubtract);

        assertEquals(2024, newDate.getYear());
        assertEquals(2, newDate.getMonthValue());
        assertEquals(29, newDate.getDayOfMonth());
    }

    @Test
    public void shouldCalculateDaysBetweenDates() {
        LocalDate startDate = LocalDate.of(2024, 3, 19);
        LocalDate endDate = LocalDate.of(2024, 3, 24);

        long daysBetween = startDate.until(endDate).getDays();

        assertEquals(5, daysBetween);
    }

    @Test
    public void shouldNotCreateInvalidDate() {
        assertThrows(DateTimeException.class, () -> {
            LocalDate.of(2024, 2, 30);
        });
    }

    @Test
    public void shouldNotCreateInvalidDateFromParse() {
        assertThrows(DateTimeException.class, () -> {
            LocalDate.parse("2024-02-30");
        });
    }
}
