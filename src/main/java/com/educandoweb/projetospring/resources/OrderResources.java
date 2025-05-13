package com.educandoweb.projetospring.resources;

import com.educandoweb.projetospring.entities.Order;
import com.educandoweb.projetospring.repositories.OrderRepository;
import com.educandoweb.projetospring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class OrderResources {


    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> findAll(){

        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }
}
