package com.micro.customers.dao;

import com.micro.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ramin Pakzad
 */

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
