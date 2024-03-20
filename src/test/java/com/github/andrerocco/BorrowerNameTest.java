package com.github.andrerocco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerNameTest {
    private BorrowerName borrowerName;

    @BeforeEach
    void setUp() {
        borrowerName = new BorrowerName();
    }

    @Test
    void getFullName() {
        borrowerName.setFirstName("João");
        borrowerName.setLastName("Silva");
        assertEquals("João Silva".toUpperCase(), borrowerName.getFullName());
    }

    @Test
    void getFirstName() {
        borrowerName.setFirstName("João");
        assertEquals("João", borrowerName.getFirstName());
    }

    @Test
    void getLastName() {
        borrowerName.setLastName("Silva");
        assertEquals("Silva", borrowerName.getLastName());
    }
}