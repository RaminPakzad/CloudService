package com.micro.customers.service;

import com.micro.customers.dao.CustomerRepository;
import com.micro.customers.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ramin Pakzad
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> get(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
