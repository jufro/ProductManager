package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchByName() {
        Book book = new Book(1, "1984", 500, "George Orwell");
        boolean actual = book.matches("1984");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(2, "Alice’s Adventures in Wonderland", 400, "Lewis Carroll");
        boolean actual = book.matches("One Hundred Years of Solitude");
        assertFalse(actual);
    }

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(1, "1984", 500, "George Orwell");
        boolean actual = book.matches("George Orwell");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByAuthor() {
            Book book = new Book(2, "Alice’s Adventures in Wonderland", 400, "Lewis Carroll");
            boolean actual = book.matches("George Orwell");
            assertFalse(actual);
        }
}