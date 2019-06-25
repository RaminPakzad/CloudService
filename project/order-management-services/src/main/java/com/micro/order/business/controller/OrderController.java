package com.micro.order.business.controller;

import com.micro.order.model.entity.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @GetMapping(value="/findById/{id}")
    public Order findById(@PathVariable int id){
        return new Order();
    }

    @PostMapping(value="/add")
    public void add(@RequestBody Order order){
        // add new order
    }

}
