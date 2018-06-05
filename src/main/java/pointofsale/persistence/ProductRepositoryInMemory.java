package pointofsale.persistence;

import pointofsale.model.BarCode;
import pointofsale.model.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryInMemory implements ProductRepository {

    private Set<Product> products;
    private Long id = 1L;

    public ProductRepositoryInMemory() {
        this.products = new HashSet<>();
        initRepositoryWithProducts();
    }

    private void initRepositoryWithProducts() {
        addNewProduct("soap", "123498765", 2.49);
        addNewProduct("bread", "225498768", 1.99);
        addNewProduct("ham", "385498762", 7.99);
        addNewProduct("cheese", "185498995", 5.99);
        addNewProduct("butter", "285498794", 4.49);
    }

    private void addNewProduct(String name, String barCodeValue, double price) {
        products.add(new Product(nextId(), name, new BarCode(barCodeValue), new BigDecimal(String.valueOf(price))));
    }

    private Long nextId() {
        return id++;
    }


    @Override
    public Product getByBarCodeValue(String barCodeValue) {
        if (products == null || products.isEmpty()) {
            return null;
        }
        for (Product product : products) {
            if (getBarCodeValue(product).equals(barCodeValue)) {
                return product;
            }
        }
        return null;
    }

    private String getBarCodeValue(Product product) {
        return product.getBarCode().getValue();
    }
}
