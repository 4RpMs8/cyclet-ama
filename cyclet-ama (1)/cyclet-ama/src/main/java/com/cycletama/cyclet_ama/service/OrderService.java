package com.cycletama.cyclet_ama.service;

import com.cycletama.cyclet_ama.entity.*;
import com.cycletama.cyclet_ama.exception.OrderNotFoundException;
import com.cycletama.cyclet_ama.exception.ProductModelNotFoundException;
import com.cycletama.cyclet_ama.exception.ProductNotFoundException;
import com.cycletama.cyclet_ama.repository.OrderRepository;
import com.cycletama.cyclet_ama.repository.ProductModelRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductModelRepository productModelRepository;


    private BigDecimal calculateTotal(OrderItem orderItem) {
        ProductModel productModel = productModelRepository.findById(orderItem.getProductModel().getId()).orElseThrow(() -> new ProductModelNotFoundException("Product model not found"));
        return productModel.getPricePerCarton().multiply(new BigDecimal(orderItem.getQuantity()));
    }

    public OrderService(OrderRepository orderRepository, ProductModelRepository productModelRepository) {
        this.orderRepository = orderRepository;
        this.productModelRepository = productModelRepository;
    }

    public Order createOrder(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        order.setStatus(OrderStatus.PENDING);
        order.setPaymentStatus(PaymentStatus.UNPAID);
        for(OrderItem item: order.getOrderItems()){
            BigDecimal total = calculateTotal(item);
            item.setUnitPrice(productModelRepository.findById(item.getProductModel().getId()).orElseThrow(()-> new ProductModelNotFoundException("product model not found")).getPricePerCarton());
            item.setTotalPrice(total);
            totalAmount = totalAmount.add(total);
        }
        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException("Order not found"));
    }
}
