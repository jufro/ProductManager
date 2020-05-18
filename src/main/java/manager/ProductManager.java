package manager;

import domain.Product;
import repository.ProductRepository;
import domain.Book;
import domain.Smartphone;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            return book.getName().equalsIgnoreCase(search);
            return book.getAuthor().equalsIgnoreCase(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            return smartphone.getName().equalsIgnoreCase(search);
            return smartphone.getProducer().equalsIgnoreCase(search);
        }
        return false;
    }
}

