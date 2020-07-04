package com.atguigu.controller;

import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("/customer/findAll")
    public List<Customer> findAll(){
        return customerService.findCustomers();
    }
}
