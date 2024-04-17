package com.fastcampus.ordersystem.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "customers")
public class Customer {
    @Id
    private int customerId;

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public static Customer newCustomer(CreateCustomer customer){ // 새 커스터머 만들 때 생성자를 사용하지 않고 생성
        return new Customer(customer.getName(), customer.getAddress(), customer.getPhoneNumber());
    }


}
