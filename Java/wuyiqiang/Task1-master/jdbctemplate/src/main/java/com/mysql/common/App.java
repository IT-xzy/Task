package com.mysql.common;

import com.mysql.customer.dao.CustomerDAO;
import com.mysql.customer.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer(29, "jdbctemplate", 3);
        //customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByCustomerId(10);
        System.out.println(customer1.getName());
    }
}
