package pl.glegdev.pointofsale.persistence;

import pl.glegdev.pointofsale.model.Product;

public interface ProductRepository {
    Product getByBarCodeValue(String barCodeValue);
}
