package com.fastcampus.ordersystem.controller;

import com.fastcampus.ordersystem.domain.CreateCustomer;
import com.fastcampus.ordersystem.domain.Customer;
import com.fastcampus.ordersystem.domain.dto.CustomerDto;
import com.fastcampus.ordersystem.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Response<CustomerDto> createNewCustomer(@RequestParam String name,
                                         @RequestParam String address,
                                         @RequestParam String phoneNumber) {
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder().address(address).name(name).phoneNumber(phoneNumber).build())
        );
    }


}
