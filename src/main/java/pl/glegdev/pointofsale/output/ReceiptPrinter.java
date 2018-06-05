package pl.glegdev.pointofsale.output;

import pl.glegdev.pointofsale.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ReceiptPrinter {
    void printReceipt(List<Product> products, BigDecimal sumOfPrices);

}
