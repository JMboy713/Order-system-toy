package com.fastcampus.ordersystem.service;

import com.fastcampus.ordersystem.domain.CreateCustomer;
import com.fastcampus.ordersystem.domain.Customer;
import com.fastcampus.ordersystem.domain.dto.CustomerDto;
import com.fastcampus.ordersystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDto newCustomer(CreateCustomer customer) {
        Customer entity = Customer.newCustomer(customer); // customer 객체 생성
        Customer saved  = customerRepository.save(entity); // customer 객체 저장
        return CustomerDto.builder()
                .name(saved.getName())
                .address(saved.getAddress())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }

}
