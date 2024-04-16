package com.fastcampus.ordersystem.repository;


import com.fastcampus.ordersystem.domain.Order;
import com.sun.jdi.InterfaceType;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
