package pointofsale.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ReceiptDataTest {

    private static final Product TEST_PRODUCT1 =
            new Product(1L, "test product", new BarCode("123456789"), new BigDecimal("2.50"));
    private static final Product TEST_PRODUCT2 =
            new Product(2L, "test product 2", new BarCode("987654321"), new BigDecimal("5.23"));

    private ReceiptData receiptData;

    @Before
    public void setUp() {
        receiptData = new ReceiptData();
    }

    @Test
    public void should_sum_prices_of_all_added_products() {
        //when
        receiptData.addProduct(TEST_PRODUCT1);
        receiptData.addProduct(TEST_PRODUCT2);
        //then
        assertEquals(receiptData.getTotalPrice(), new BigDecimal("7.73"));
    }
}