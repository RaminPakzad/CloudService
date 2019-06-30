package com.micro.order.business.controller;

import com.micro.order.business.service.OrderService;
import com.micro.order.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value="/listAll")
    public List<Order> listAll(){
        return orderService.listAll();
    }

    @GetMapping(value="/findById/{id}")
    public Order findById(@PathVariable long id){
        return orderService.findById(id);
    }

    @PostMapping(value="/add")
    public Order add(@RequestBody Order order){
        return orderService.add(order);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable long id){
        orderService.delete( id );
    }

}
