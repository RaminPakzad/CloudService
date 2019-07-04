package com.micro.customers.controller;

import com.micro.customers.configs.CustomerProperties;
import com.micro.customers.model.Customer;
import com.micro.customers.service.CustomerService;
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
//@RefreshScope
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    private CustomerProperties customerProperties;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/testServer")
    public String testServer() {
        return customerProperties.getTest();
    }

    @GetMapping("/customers")
    public List<Customer> getAllStudents() {
        return customerService.getAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.get(id).orElse(null);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteById(id);
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.add(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCustomer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        Optional<Customer> savedCustomer = customerService.get(id);

        if (!savedCustomer.isPresent())
            return ResponseEntity.notFound().build();

        customer.setId(id);

        customerService.update(customer);

        return ResponseEntity.noContent().build();
    }

}
