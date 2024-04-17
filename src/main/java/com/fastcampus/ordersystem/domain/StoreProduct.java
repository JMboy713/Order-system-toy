package com.fastcampus.ordersystem.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Getter
@Table(name = "store_products")
public class StoreProduct {
    @Id
    private int storeProductId;

    @Column
    private int storeId;

    @Column
    private int productId;
    @Column
    private int stockQuantity;

    public void adjustStockQuantity(int buyQuantity){
        if(stockQuantity < buyQuantity){
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stockQuantity=this.stockQuantity-buyQuantity;
    }

}
