package pointofsale.service;

import pointofsale.exception.ProductNotFoundException;
import pointofsale.model.BarCode;
import pointofsale.model.Product;
import pointofsale.persistence.ProductRepository;
import pointofsale.persistence.ProductRepositoryInMemory;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductRepositoryInMemory();
    }

    @Override
    public Product getByBarCode(BarCode barCode) throws ProductNotFoundException {
        Product product = productRepository.getByBarCodeValue(barCode.getValue());
        if (product == null) {
            throw new ProductNotFoundException();
        }
        return product;
    }
}
