package pl.glegdev.pointofsale.controller;


import pl.glegdev.pointofsale.exception.InvalidBarCodeException;
import pl.glegdev.pointofsale.exception.ProductNotFoundException;
import pl.glegdev.pointofsale.model.BarCode;
import pl.glegdev.pointofsale.model.Product;
import pl.glegdev.pointofsale.model.ReceiptData;
import pl.glegdev.pointofsale.service.ProductService;
import pl.glegdev.pointofsale.service.ProductServiceImpl;

public class ProductSaleController {
    private ProductService productService;
    private IOController ioController;

    public ProductSaleController() {
        this.productService = new ProductServiceImpl();
        this.ioController = new IOController();
    }


    public void newSale() {
        ReceiptData receiptData = new ReceiptData();
        while(true) {
            String input = ioController.askForCodeOrExit();
            if (input.equalsIgnoreCase("exit")) {
                ioController.printReceipt(receiptData);
                return;
            } else {
                BarCode barCode = tryToGetBarCodeBy(input);
                Product product = null;
                if (barCode != null) {
                    product = tryToGetProductBy(barCode);
                }
                if (product != null) {
                    receiptData.addProduct(product);
                    ioController.displayProductInfo(product);
                }
            }
        }
    }

    private BarCode tryToGetBarCodeBy(String input) {
        try {
            return ioController.getBarCode(input);
        } catch (InvalidBarCodeException e) {
            ioController.displayInvalidBarCodeMessage();
        }
        return null;
    }

    private Product tryToGetProductBy(BarCode barCode) {
        try {
            return productService.getByBarCode(barCode);
        } catch (ProductNotFoundException e) {
            ioController.displayProductNotFoundMessage();
        }
        return null;
    }


}
