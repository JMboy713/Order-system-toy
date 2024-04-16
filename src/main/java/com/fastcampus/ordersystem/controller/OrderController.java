package com.fastcampus.ordersystem.controller;

import com.fastcampus.ordersystem.domain.CreateOrder;
import com.fastcampus.ordersystem.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/api/v1/orders")
    public Response<Void> NewOrder() {
        HashMap<Integer,Integer> orderMap = new HashMap<>();
        orderMap.put(1, 5);
        orderMap.put(2, 10);
        orderService.newOrder(CreateOrder.builder().customerId(1).quantityByProduct(orderMap).build());
        // customerId(1) 과 orderMap.put은 파라미터로 받아서 추후 post 기능을 할 수 있도록 변경한다.
        return Response.success(null);
    }
}
