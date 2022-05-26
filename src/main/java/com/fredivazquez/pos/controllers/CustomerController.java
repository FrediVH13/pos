package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.Customer;
import com.fredivazquez.pos.models.PaymentMethod;
import com.fredivazquez.pos.services.ICustomerService;
import com.fredivazquez.pos.services.IPaymentMethodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private final ICustomerService customerService;
    private final IPaymentMethodService paymentMethodService;

    public CustomerController(ICustomerService customerService, IPaymentMethodService paymentMethodService) {
        this.customerService = customerService;
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public List<Customer> allCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/payment-methods")
    public List<PaymentMethod> allPaymentMethods() {
        return paymentMethodService.getPaymentMethods();
    }

}
