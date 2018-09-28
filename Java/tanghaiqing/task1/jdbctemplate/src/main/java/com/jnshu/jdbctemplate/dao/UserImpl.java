package com.jnshu.jdbctemplate.dao;

import com.jnshu.jdbctemplate.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;

public class UserImpl implements UserDao {
    private Logger logger = Logger.getLogger("log4j.properties");
    private JdbcTemplate jdbcTemplate;

    public UserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(User user) {
        String sql = "insert into user (name,age,gender,salary) values (?,?,?,?);";
        int i = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getGender(), user.getSalary());
        logger.info("执行完毕,影响行数：");
        return i;
    }

    public boolean delect(User user) {
        String sql = "DELETE from `user` where id=?;";
        int i = jdbcTemplate.update(sql, user.getId());
        logger.info("删除完毕，是否已经插入：");
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int updata(User user) {
        String sql = "UPDATE `user`SET name=?,age=?,gender=?,salary=? WHERE id=?;";
        int i = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getGender(), user.getSalary(), user.getId());
        logger.info("插入完成，影响行数：");
        return i;
    }

    public List<User> getAll() {
        String sql = "SELECT * FROM user";
        List<User> result = jdbcTemplate.query(sql, (ResultSet resultSet, int i) -> {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setGender(resultSet.getString("gender"));
            user.setSalary(resultSet.getDouble("salary"));
            return user;
        });
        return result;
    }

    public User getAll(int id) {
        String sql = "select * from USER where id=?";
        return jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNumber) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setGender(rs.getString("gender"));
            user.setSalary(rs.getDouble("salary"));
            return user;
        }, id);
    }

}
