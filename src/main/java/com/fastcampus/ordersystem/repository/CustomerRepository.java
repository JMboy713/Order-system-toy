package com.fastcampus.ordersystem.repository;

import com.fastcampus.ordersystem.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
