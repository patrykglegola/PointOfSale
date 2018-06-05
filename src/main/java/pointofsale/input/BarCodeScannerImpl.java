package pointofsale.input;

import pointofsale.exception.InvalidBarCodeException;
import pointofsale.model.BarCode;

public class BarCodeScannerImpl implements BarCodeScanner {
    @Override
    public BarCode scan(String code) throws InvalidBarCodeException {
        if (code.isEmpty()) {
            throw new InvalidBarCodeException();
        }
        return new BarCode(code);
    }
}
