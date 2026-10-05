package com.cycletama.cyclet_ama.service;

import com.cycletama.cyclet_ama.entity.Customer;
import com.cycletama.cyclet_ama.exception.CustomerNotFoundException;
import com.cycletama.cyclet_ama.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }
}
