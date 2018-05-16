package com.entity;

import com.pojo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setNumber(rs.getString("number"));
        user.setCreate_at(rs.getLong("create_at"));
        user.setUpdate_at(rs.getLong("update_at"));
        return user;
    }
}
