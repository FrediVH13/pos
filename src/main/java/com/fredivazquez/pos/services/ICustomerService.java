package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
}
