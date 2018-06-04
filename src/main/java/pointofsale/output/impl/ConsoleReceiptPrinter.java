package pointofsale.output.impl;

import pointofsale.model.Product;
import pointofsale.output.ReceiptPrinter;

import java.math.BigDecimal;
import java.util.List;

public class ConsoleReceiptPrinter implements ReceiptPrinter {

    @Override
    public void printReceipt(List<Product> products, BigDecimal totalPrice) {
        System.out.println("Receipt:");
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
        System.out.println("Total price: " + totalPrice);
    }
}
