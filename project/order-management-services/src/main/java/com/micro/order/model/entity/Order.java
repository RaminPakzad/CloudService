package com.micro.order.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String description;


}
