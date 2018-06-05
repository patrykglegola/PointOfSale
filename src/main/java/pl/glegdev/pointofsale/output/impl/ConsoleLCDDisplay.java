package pl.glegdev.pointofsale.output.impl;

import pl.glegdev.pointofsale.model.Product;
import pl.glegdev.pointofsale.output.LCDDisplay;
import pl.glegdev.pointofsale.service.ProductService;
import pl.glegdev.pointofsale.service.ProductServiceImpl;

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
        System.out.println("Scan next bar code or type 'exit' to print receipt.");
    }
}