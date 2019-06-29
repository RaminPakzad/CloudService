package com.micro.products.business.service;

import com.micro.products.business.repository.ProductRepository;
import com.micro.products.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ramin Pakzad
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> get(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
