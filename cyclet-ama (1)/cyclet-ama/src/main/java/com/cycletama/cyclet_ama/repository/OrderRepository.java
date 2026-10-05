package com.cycletama.cyclet_ama.repository;

import com.cycletama.cyclet_ama.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findOrderByCustomerId(Long customerId);
}
