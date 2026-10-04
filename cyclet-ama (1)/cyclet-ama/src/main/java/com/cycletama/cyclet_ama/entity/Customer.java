package com.cycletama.cyclet_ama.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String companyName;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
