package pl.glegdev.pointofsale.input;

import pl.glegdev.pointofsale.exception.InvalidBarCodeException;
import pl.glegdev.pointofsale.model.BarCode;

public interface BarCodeScanner {
    BarCode scan(String code) throws InvalidBarCodeException;
}
