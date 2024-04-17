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
    private final CustomerService customerService;

    public OrderService(OrderRepository orderRepository, StoreService storeService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
        this.customerService = customerService;
    }

    public void newOrder(CreateOrder createOrder) {
        // id 가 없는 회원이 주문했을 시 validation 처리
        if(!customerService.findCustomerById(createOrder.getCustomerId())){
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }




        //

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
