package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import repository.ProductRepository;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "1984", 500, "George Orwell");
    private Book book2 = new Book(2, "Alice’s Adventures in Wonderland", 400, "Lewis Carroll");
    private Book book3 = new Book(3, "One Hundred Years of Solitude", 650, "Gabriel García Márquez");
    private Smartphone smartphone1 = new Smartphone(1, "iPhone 11 Pro Max", 131990, "Apple");
    private Smartphone smartphone2 = new Smartphone(2, "Samsung Galaxy S20+", 79990, "Samsung");
    private Smartphone smartphone3 = new Smartphone(3, "Honor 20 Pro", 29990, "Honor");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("Alice’s Adventures in Wonderland");
        Product[] expected = {book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("iPhone 11 Pro Max");
        Product[] expected = {smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] actual = manager.searchBy("George Orwell");
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneMadeBy() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookNameIfNotExists() {
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}