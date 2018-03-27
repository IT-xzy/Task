package com.mysql.customer.dao.impl;

import com.mysql.customer.dao.CustomerDAO;
import com.mysql.customer.model.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class JdbcCustomerDao implements CustomerDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource datasource) {
        this.dataSource = datasource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
     //   jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[] {
                customer.getCustID(),
                customer.getName(),
                customer.getAge()
        });
    }

    public Customer findByCustomerId(int custId) {
        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID =  ?";
     //   jdbcTemplate = new JdbcTemplate(dataSource);
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);
        Customer customer = (Customer) jdbcTemplate.queryForObject(sql, rowMapper, custId);
        return customer;
    }
}
