package pointofsale.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pointofsale.exception.ProductNotFoundException;
import pointofsale.model.BarCode;
import pointofsale.model.Product;
import pointofsale.persistence.ProductRepository;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private static final BarCode TEST_BAR_CODE = new BarCode("12345");
    private static final Product TEST_PRODUCT =
            new Product(1L, "test product", TEST_BAR_CODE, new BigDecimal("59.99"));
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_find_product_if_product_with_given_barcode_exist() throws ProductNotFoundException {
        //given
        when(repository.getByBarCodeValue(TEST_BAR_CODE.getValue())).thenReturn(TEST_PRODUCT);
        //when
        Product product = service.getByBarCode(TEST_BAR_CODE);
        //then
        assertNotNull(product);
        assertEquals(product.getBarCode(), TEST_BAR_CODE);
    }

    @Test (expected = ProductNotFoundException.class)
    public void should_not_find_product_if_product_with_given_barcode_not_exists() throws ProductNotFoundException {
        //given
        when(repository.getByBarCodeValue(TEST_BAR_CODE.getValue())).thenReturn(null);
        //when
        Product product = service.getByBarCode(TEST_BAR_CODE);
        //then should throw ProductNotFoundException
    }
}