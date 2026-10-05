package com.cycletama.cyclet_ama.controller;


import com.cycletama.cyclet_ama.entity.Order;
import com.cycletama.cyclet_ama.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> findOrdersByCustomerId(@PathVariable Long customerId){
        return orderService.findOrdersByCustomerId(customerId);
    }
}
