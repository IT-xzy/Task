package com.mysql.customer.dao;

import com.mysql.customer.model.Customer;

public interface CustomerDAO {

    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}
