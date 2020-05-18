package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String producer;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String madeBy) {
        super(id, name, price);
        this.producer = madeBy;
    }
}