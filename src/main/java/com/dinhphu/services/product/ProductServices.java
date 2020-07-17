package com.dinhphu.services.product;

import com.dinhphu.model.Product;
import com.dinhphu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices implements IProductServices {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product update(Product model) {
        return productRepository.save(model);
    }

    @Override
    public Product deleteModel(Integer id) {
        Product deleteProduct= productRepository.findOne(id);
        productRepository.delete(id);
        return deleteProduct;
    }
}
