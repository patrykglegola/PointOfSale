package pointofsale.output;

import pointofsale.model.Product;

public interface LCDDisplay {
    void printProductInfo(Product product);
    void printProductNotFoundMessage();
    void printInvalidBarCodeMessage();
    void printAskForCodeOrExitMessage();
}
