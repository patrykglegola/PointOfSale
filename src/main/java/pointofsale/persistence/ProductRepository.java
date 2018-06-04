package pointofsale.persistence;

import pointofsale.model.Product;

public interface ProductRepository {
    Product getByBarCodeValue(String barCodeValue);
}
