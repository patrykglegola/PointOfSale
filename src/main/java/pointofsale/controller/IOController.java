package pointofsale.controller;

import pointofsale.exception.InvalidBarCodeException;
import pointofsale.input.BarCodeScanner;
import pointofsale.input.BarCodeScannerImpl;
import pointofsale.model.BarCode;
import pointofsale.model.Product;
import pointofsale.model.ReceiptData;
import pointofsale.output.LCDDisplay;
import pointofsale.output.ReceiptPrinter;
import pointofsale.output.impl.ConsoleLCDDisplay;
import pointofsale.output.impl.ConsoleReceiptPrinter;

import java.util.Scanner;

public class IOController {
    private ReceiptPrinter printer;
    private LCDDisplay lcdDisplay;
    private BarCodeScanner barCodeScanner;
    private Scanner consoleInput;

    public IOController() {
        this.printer = new ConsoleReceiptPrinter();
        this.lcdDisplay = new ConsoleLCDDisplay();
        this.barCodeScanner = new BarCodeScannerImpl();
        this.consoleInput = new Scanner(System.in);
    }

    public void printReceipt(ReceiptData receiptData) {
        printer.printReceipt(receiptData.getScannedProducts(), receiptData.getTotalPrice());
    }

    public void displayProductInfo(Product product) {
        lcdDisplay.printProductInfo(product);
    }

    public void displayProductNotFoundMessage() {
        lcdDisplay.printProductNotFoundMessage();
    }

    public String askForCodeOrExit() {
        lcdDisplay.printAskForCodeOrExitMessage();
        return consoleInput.nextLine();
    }

    public BarCode tryToGetBarCode(String code) {
        try {
            return barCodeScanner.scan(code);
        } catch (InvalidBarCodeException e) {
            lcdDisplay.printInvalidBarCodeMessage();
        }
        return null;
    }
}
