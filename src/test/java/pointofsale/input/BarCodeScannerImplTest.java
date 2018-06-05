package pointofsale.input;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pointofsale.exception.InvalidBarCodeException;
import pointofsale.model.BarCode;

import static org.junit.Assert.*;

public class BarCodeScannerImplTest {

    private BarCodeScannerImpl barCodeScanner;

    @Before
    public void setUp() {
        barCodeScanner = new BarCodeScannerImpl();
    }

    @Test
    public void should_return_barcode_if_code_not_empty() throws InvalidBarCodeException {
        //given
        String code = "12345";
        //when
        BarCode scannedBarCode = barCodeScanner.scan(code);
        //then
        assertNotNull(scannedBarCode);
    }

    @Test (expected = InvalidBarCodeException.class)
    public void should_throw_exception_if_empty_barcode() throws InvalidBarCodeException{
        //given
        String code = "";
        //when
        BarCode scannedBarCode = barCodeScanner.scan(code);
        //then should throw InvalidBarCodeException
    }
}