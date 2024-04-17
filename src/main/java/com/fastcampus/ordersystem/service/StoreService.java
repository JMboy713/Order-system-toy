package com.fastcampus.ordersystem.service;

import com.fastcampus.ordersystem.domain.StoreProduct;
import com.fastcampus.ordersystem.repository.StoreProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {
    private final StoreProductRepository storeProductRepository;

    public StoreService(StoreProductRepository storeProductRepository) {
        this.storeProductRepository = storeProductRepository;
    }

    public StoreProduct getStoreProduct(int storeId, int productId) {
        Optional<StoreProduct> storeProductOptional = storeProductRepository.findByStoreIdAndProductId(storeId, productId);
        if (storeProductOptional.isEmpty()) {
            throw new RuntimeException("존재하지 않습니다.");
        }
        return storeProductOptional.get();
    }
    public void saveAll(Iterable<StoreProduct> storeProducts){
        storeProductRepository.saveAll(storeProducts);
    }
}
