package pointofsale.controller;


import pointofsale.exception.ProductNotFoundException;
import pointofsale.model.BarCode;
import pointofsale.model.Product;
import pointofsale.model.ReceiptData;
import pointofsale.service.ProductService;
import pointofsale.service.ProductServiceImpl;

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
                BarCode barCode = ioController.tryToGetBarCode(input);
                Product product = tryToGetProductBy(barCode);
                if(product != null) {
                    receiptData.addProduct(product);
                    ioController.displayProductInfo(product);
                }
            }
        }
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
