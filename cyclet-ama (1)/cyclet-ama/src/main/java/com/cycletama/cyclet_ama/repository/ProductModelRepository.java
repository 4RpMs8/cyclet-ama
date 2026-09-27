package com.cycletama.cyclet_ama.repository;

import com.cycletama.cyclet_ama.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByProductId(Long productId);
}

