package com.atguigu.service.impl;

import com.atguigu.dao.CustomerDao;
import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao  customerDao;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 先查缓存 没有就从redis中取数据
     *
     * @return
     */
    @Override
    public List<Customer> findCustomers() {
        String key = "allcustomer";
        List<Customer> list = (List<Customer>) redisTemplate.boundValueOps(key).get();
        System.out.println(list);
        if(list != null){
            System.out.println("from redis list = " + list);
            return list;
        }
        list = customerDao.findAll();
        redisTemplate.boundValueOps(key).set(list);
        System.out.println("from mysql list = " + list);

//        if(redisTemplate.opsForValue().get(key)!=null){
//            list = (List<Customer>)redisTemplate.opsForValue().get(key);
//            System.out.println("from redis list = " + list);
//            return list;
//        }
//
//        list = customerDao.findAll();
//        redisTemplate.opsForValue().set(key, list);
//        System.out.println("from mysql list = " + list);


        return list;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.getOne(id);
    }

    @Override
    public void saveCustomer(Customer c) {
            customerDao.save(c);
    }

    @Override
    public void updateCustomer(Customer c) {
            customerDao.save(c);
    }

    @Override
    public void deleteCustomerById(Integer id) {
            customerDao.deleteById(id);
    }
}
