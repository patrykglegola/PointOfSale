package pl.glegdev.pointofsale.output;

import pl.glegdev.pointofsale.model.Product;

public interface LCDDisplay {
    void printProductInfo(Product product);
    void printProductNotFoundMessage();
    void printInvalidBarCodeMessage();
    void printAskForCodeOrExitMessage();
}
