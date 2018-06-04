package pointofsale.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BarCode barCode;
    private BigDecimal price;

    public Product(Long id, String name, BarCode barCode, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.barCode = barCode;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(barCode, product.barCode) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, barCode, price);
    }
}
