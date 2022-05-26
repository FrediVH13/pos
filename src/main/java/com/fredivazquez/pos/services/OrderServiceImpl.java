package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.Order;
import com.fredivazquez.pos.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
