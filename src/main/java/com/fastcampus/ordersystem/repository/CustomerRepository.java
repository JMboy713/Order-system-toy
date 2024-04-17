package com.fastcampus.ordersystem.repository;

import com.fastcampus.ordersystem.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Override
    Optional<Customer> findById(Integer integer);
}
