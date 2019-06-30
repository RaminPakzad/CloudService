package com.micro.order.business.service;

import com.micro.order.business.repository.OrderRepository;
import com.micro.order.model.entity.Order;
import org.aspectj.weaver.ast.Or;
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
    public Order findById( long id ) { return orderRepository.findById(id).get(); }
    public Order add( Order order ){ return orderRepository.save(order); }
    public void delete( long id ) { orderRepository.delete(orderRepository.findById(id).get()); }

}
