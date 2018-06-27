package com.service;

import com.pojo.Customer;

public interface CustomerService {
    String login(Customer customer) throws Exception;

    String register(Customer customer) throws Exception;
}
