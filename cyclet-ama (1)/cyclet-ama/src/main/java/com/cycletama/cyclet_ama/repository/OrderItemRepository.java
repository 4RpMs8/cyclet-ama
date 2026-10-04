package com.cycletama.cyclet_ama.repository;

import com.cycletama.cyclet_ama.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
