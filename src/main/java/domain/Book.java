package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
        private String author;

        public Book() {
        }

    public Book(int id, String name, int price, String author) {
            super(id, name, price);
            this.author = author;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getAuthor().equalsIgnoreCase(search);
    }

}
