package pl.glegdev.pointofsale.service;

import pl.glegdev.pointofsale.exception.ProductNotFoundException;
import pl.glegdev.pointofsale.model.BarCode;
import pl.glegdev.pointofsale.model.Product;
import pl.glegdev.pointofsale.persistence.ProductRepository;
import pl.glegdev.pointofsale.persistence.ProductRepositoryInMemory;

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
