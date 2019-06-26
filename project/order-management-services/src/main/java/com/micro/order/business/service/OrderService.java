package com.micro.order.business.service;

import com.micro.order.business.repository.OrderRepository;
import com.micro.order.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> listAll(){
        return (List<Order>) orderRepository.findAll();
    }

}
