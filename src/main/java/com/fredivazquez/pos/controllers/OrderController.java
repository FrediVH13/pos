package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.Order;
import com.fredivazquez.pos.services.IOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order saveOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }

}
