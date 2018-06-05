package pl.glegdev.pointofsale.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiptData {
    private List<Product> scannedProducts;
    private BigDecimal totalPrice;

    public ReceiptData() {
        this.scannedProducts = new ArrayList<>();
        this.totalPrice = new BigDecimal("0");
    }

    public void addProduct(Product product) {
        scannedProducts.add(product);
        totalPrice = totalPrice.add(product.getPrice());
    }

    public List<Product> getScannedProducts() {
        return scannedProducts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
