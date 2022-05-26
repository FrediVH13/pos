package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrders();
    Order saveOrder(Order order);
}
