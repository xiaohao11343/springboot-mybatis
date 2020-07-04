package com.atguigu.controller;

import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService; //jdk动态代理

    @GetMapping("/user/findAll")
    public List<User> findAll(){
        System.out.println("userService.getClass() = " + userService.getClass());//class com.sun.proxy.$Proxy67
        return  userService.findAll();
    }
}
