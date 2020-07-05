package com.atguigu.service;

import com.atguigu.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Integer id);
}
