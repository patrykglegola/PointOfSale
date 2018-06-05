package pl.glegdev.pointofsale.controller;

import pl.glegdev.pointofsale.exception.InvalidBarCodeException;
import pl.glegdev.pointofsale.input.BarCodeScanner;
import pl.glegdev.pointofsale.input.BarCodeScannerImpl;
import pl.glegdev.pointofsale.model.BarCode;
import pl.glegdev.pointofsale.model.Product;
import pl.glegdev.pointofsale.model.ReceiptData;
import pl.glegdev.pointofsale.output.LCDDisplay;
import pl.glegdev.pointofsale.output.ReceiptPrinter;
import pl.glegdev.pointofsale.output.impl.ConsoleLCDDisplay;
import pl.glegdev.pointofsale.output.impl.ConsoleReceiptPrinter;

import java.util.Scanner;

class IOController {
    private ReceiptPrinter printer;
    private LCDDisplay lcdDisplay;
    private BarCodeScanner barCodeScanner;
    private Scanner consoleInput;

    IOController() {
        this.printer = new ConsoleReceiptPrinter();
        this.lcdDisplay = new ConsoleLCDDisplay();
        this.barCodeScanner = new BarCodeScannerImpl();
        this.consoleInput = new Scanner(System.in);
    }

    void printReceipt(ReceiptData receiptData) {
        printer.printReceipt(receiptData.getScannedProducts(), receiptData.getTotalPrice());
    }

    void displayProductInfo(Product product) {
        lcdDisplay.printProductInfo(product);
    }

    void displayProductNotFoundMessage() {
        lcdDisplay.printProductNotFoundMessage();
    }

    void displayInvalidBarCodeMessage() {
        lcdDisplay.printInvalidBarCodeMessage();
    }

    String askForCodeOrExit() {
        lcdDisplay.printAskForCodeOrExitMessage();
        return consoleInput.nextLine();
    }

    BarCode getBarCode(String code) throws InvalidBarCodeException {
        return barCodeScanner.scan(code);
    }
}
