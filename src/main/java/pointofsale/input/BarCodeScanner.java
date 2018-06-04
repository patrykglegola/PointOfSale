package pointofsale.input;

import pointofsale.exception.InvalidBarCodeException;
import pointofsale.model.BarCode;

public interface BarCodeScanner {
    BarCode scan(String code) throws InvalidBarCodeException;
}
