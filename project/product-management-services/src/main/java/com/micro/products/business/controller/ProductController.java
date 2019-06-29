package com.micro.products.business.controller;

import com.micro.products.business.service.ProductService;
import com.micro.products.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * @author Ramin Pakzad
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.get(id).orElse(null);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.add(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable long id) {
        Optional<Product> savedProduct = productService.get(id);

        if (!savedProduct.isPresent())
            return ResponseEntity.notFound().build();

        product.setId(id);

        productService.update(product);

        return ResponseEntity.noContent().build();
    }
}
