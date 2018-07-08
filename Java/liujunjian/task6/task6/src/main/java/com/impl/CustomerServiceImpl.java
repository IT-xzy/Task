package com.impl;

import com.dao.CustomerDao;
import com.pojo.Customer;
import com.service.CustomerService;
import com.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private MD5 md5;

    @Override
    //登录检查
    public String login(Customer customer) throws Exception {
        //检查是否有这个用户
        Customer tCustomer = customerDao.findCustomer(customer.getUsername());
        if (tCustomer == null) {
            return "没有此用户！";
        }
        //获取该用户加密的盐
        String salt = tCustomer.getSalt();
//        获取加密加盐后密码
        String key = md5.md5encryption(customer.getPassword() + salt);
        //检查获取加密加盐密码时是否出错
        if (key == null) {
            return "系统错误，请稍后尝试";
        }
        //检查用户加密后的密码和数据库密码是否一致
        if (tCustomer.getPassword().equals(key)) {
            return "true";
        } else {
            return "用户名和密码不匹配";
        }
    }

    //注册条件
    public String check(Customer customer) throws Exception {
        //注册用户名规范
        if (customer.getUsername().trim().length() < 1) {
            return "用户名不符合要求";
        }
        //注册密码规范
        if (customer.getPassword().trim().length() < 6) {
            return "密码不符合要求";
        }
        //检查是否被注册
        if (customerDao.findCustomer(customer.getUsername()) == null) {
            return "true";
        } else {
            return "此用户名已被注册";
        }
    }

    @Override
    //注册用户
    public String register(Customer customer) throws Exception {
        //是否符合注册条件
        String message = check(customer);
//       符合条件则进行注册
        if (message.equals("true")) {
//          对密码进行加密加盐
            String[] key = md5.encryption(customer.getPassword());
            //检查加密是否出错
            if (key[0] == null) {
                return "系统出错，请重试";
            }
            //加密加盐后的密码和盐放入customer
            customer.setPassword(key[0]);
            customer.setSalt(key[1]);
            //注册该用户
            if (customerDao.insertCustomer(customer) > 0) {
                return "true";
            } else {
                return "注册失败，请稍后尝试";
            }
        } else {
            return message;
        }
    }
}
