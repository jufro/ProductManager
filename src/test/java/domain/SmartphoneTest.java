package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldMatchByName() {
        Smartphone smartphone = new Smartphone(1, "iPhone 11 Pro Max", 131990, "Apple");
        boolean actual = smartphone.matches("iPhone 11 Pro Max");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Smartphone smartphone = new Smartphone(2, "Samsung Galaxy S20+", 79990, "Samsung");
        boolean actual = smartphone.matches("iPhone 11 Pro Max");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByMadeBy() {
        Smartphone smartphone = new Smartphone(1, "iPhone 11 Pro Max", 131990, "Apple");
        boolean actual = smartphone.matches("Apple");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByMadeBy() {
        Smartphone smartphone = new Smartphone(2, "Samsung Galaxy S20+", 79990, "Samsung");
        boolean actual = smartphone.matches("Honor");
        assertFalse(actual);
    }
}