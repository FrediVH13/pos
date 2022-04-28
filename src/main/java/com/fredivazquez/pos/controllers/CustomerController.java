package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.Customer;
import com.fredivazquez.pos.services.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private final ICustomerService service;

    public CustomerController(ICustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> allCustomers() {
        return service.getCustomers();
    }
}
