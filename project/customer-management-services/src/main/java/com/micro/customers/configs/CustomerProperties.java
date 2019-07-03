package com.micro.customers.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ramin Pakzad
 */

@ConfigurationProperties(prefix = "customer")
public class CustomerProperties {
    private String test;

    public CustomerProperties() {
    }

    public CustomerProperties(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
