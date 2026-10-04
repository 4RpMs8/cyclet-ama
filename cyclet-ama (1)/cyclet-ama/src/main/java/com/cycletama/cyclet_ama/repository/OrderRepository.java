package com.cycletama.cyclet_ama.repository;

import com.cycletama.cyclet_ama.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
