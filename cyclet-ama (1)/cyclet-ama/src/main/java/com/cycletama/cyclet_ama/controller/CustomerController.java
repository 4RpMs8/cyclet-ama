package com.cycletama.cyclet_ama.controller;

import com.cycletama.cyclet_ama.entity.Customer;
import com.cycletama.cyclet_ama.repository.CustomerRepository;
import com.cycletama.cyclet_ama.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<Customer> findAllCustomers() {
       return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }
}
