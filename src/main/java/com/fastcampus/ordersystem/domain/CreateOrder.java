package com.fastcampus.ordersystem.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int customerId;
    private Map<Integer, Integer> quantityByProduct; // ["아이스아메리카노",3] 특정 상품 몇개 주문할건지.

}
