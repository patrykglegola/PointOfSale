package pl.glegdev.pointofsale.service;

import pl.glegdev.pointofsale.exception.ProductNotFoundException;
import pl.glegdev.pointofsale.model.BarCode;
import pl.glegdev.pointofsale.model.Product;

public interface ProductService {
    Product getByBarCode(BarCode barCode) throws ProductNotFoundException;
}
