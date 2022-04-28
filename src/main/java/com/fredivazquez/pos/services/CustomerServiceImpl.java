package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.Customer;
import com.fredivazquez.pos.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getCustomers() {
        return repository.findAll();
    }
}
