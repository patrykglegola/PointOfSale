package pointofsale.service;

import pointofsale.exception.ProductNotFoundException;
import pointofsale.model.BarCode;
import pointofsale.model.Product;

public interface ProductService {
    Product getByBarCode(BarCode barCode) throws ProductNotFoundException;
}
