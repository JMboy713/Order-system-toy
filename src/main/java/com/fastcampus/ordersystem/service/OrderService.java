package com.fastcampus.ordersystem.service;

import com.fastcampus.ordersystem.domain.CreateOrder;
import com.fastcampus.ordersystem.domain.Order;
import com.fastcampus.ordersystem.domain.StoreProduct;
import com.fastcampus.ordersystem.repository.OrderRepository;
import com.fastcampus.ordersystem.repository.StoreProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository, StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreateOrder createOrder) {
        List<StoreProduct> storeProducts = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : createOrder.getQuantityByProduct().entrySet()) {
            Integer productID = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(createOrder.getStoreId(), productID);

            int stockQuantity = storeProduct.getStockQuantity();
            if (buyQuantity > stockQuantity) {
                throw new RuntimeException("재고가 부족합니다.");
            }
            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);
        }

        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
        storeService.saveAll(storeProducts);
    }
}
