package pointofsale.output.impl;

import pointofsale.model.Product;
import pointofsale.output.LCDDisplay;
import pointofsale.service.ProductService;
import pointofsale.service.ProductServiceImpl;

public class ConsoleLCDDisplay implements LCDDisplay {

    private ProductService productService;

    public ConsoleLCDDisplay() {
        this.productService = new ProductServiceImpl();
    }

    @Override
    public void printProductInfo(Product product) {
        System.out.println("Product: " + product.getName());
        System.out.println("Price: " + product.getPrice());
    }

    @Override
    public void printProductNotFoundMessage() {
        System.out.println("Product not found.");
    }

    @Override
    public void printInvalidBarCodeMessage() {
        System.out.println("Invalid bar-code.");
    }

    @Override
    public void printAskForCodeOrExitMessage() {
        System.out.println("Scan next bar code or exit to print receipt.");
    }
}