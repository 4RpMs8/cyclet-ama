package com.cycletama.cyclet_ama.repository;

import com.cycletama.cyclet_ama.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
