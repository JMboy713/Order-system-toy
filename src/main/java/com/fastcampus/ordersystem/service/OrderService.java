package com.fastcampus.ordersystem.service;

import com.fastcampus.ordersystem.domain.CreateOrder;
import com.fastcampus.ordersystem.domain.Order;
import com.fastcampus.ordersystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void newOrder(CreateOrder createOrder) {
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
    }
}
