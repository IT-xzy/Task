package com.jnshu.Spring.jdbcTemplate;

import com.jnshu.Spring.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private User user;
    private ApplicationContext apx;
    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(){
        apx=new ClassPathXmlApplicationContext("mySpringNoAnnotation.xml");
        jdbcTemplate=(JdbcTemplate)apx.getBean("jdbcTemplate");
    }

    public User findById(int id) {
        String sql;
        sql="select * from demo where id=?";
        user=jdbcTemplate.queryForObject(sql,new  FinfUserRowMapper(),id);
        return user;
    }
}
