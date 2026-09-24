package com.cycletama.cyclet_ama.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String productCode;
     private BigDecimal price;
     private Integer stock;
     private Integer pricePerCarton;
     private String status;
     private Boolean requestQuote;

     @ManyToOne
    private Product product;

}
