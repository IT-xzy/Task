package com.jnshu.Spring.daoSpring;

import com.jnshu.Spring.User;
import com.jnshu.Spring.jdbcTemplate.FinfUserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    //得到JdbcTemplae对象
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add(){

        String sql="insert into demo values(?,?,?)";
        jdbcTemplate.update(sql,11,"四娃","ss@ss");
    }

}
