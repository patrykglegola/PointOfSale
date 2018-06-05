package pl.glegdev.pointofsale.input;

import pl.glegdev.pointofsale.exception.InvalidBarCodeException;
import pl.glegdev.pointofsale.model.BarCode;

public class BarCodeScannerImpl implements BarCodeScanner {
    @Override
    public BarCode scan(String code) throws InvalidBarCodeException {
        if (code.isEmpty()) {
            throw new InvalidBarCodeException();
        }
        return new BarCode(code);
    }
}
