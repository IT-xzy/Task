package com.mysql.customer.rowmapper;


import com.mysql.customer.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getInt(3)
                );
        return customer;
    }
}
