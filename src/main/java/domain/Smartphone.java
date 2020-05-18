package domain;

import lombok.Data;
import java.util.Objects;

@Data
public class Smartphone extends Product {
    private String madeBy;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String madeBy) {
        super(id, name, price);
        this.madeBy = madeBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return getMadeBy().equals(that.getMadeBy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMadeBy());
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "producer='" + madeBy + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getMadeBy().equalsIgnoreCase(search);
    }
}