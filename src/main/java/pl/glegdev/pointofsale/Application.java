package pl.glegdev.pointofsale;

import pl.glegdev.pointofsale.controller.ProductSaleController;

public class Application {
    public static void main(String[] args) {
        new ProductSaleController().newSale();
    }
}
