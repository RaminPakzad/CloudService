package com.micro.products.business.repository;

import com.micro.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ramin Pakzad
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
