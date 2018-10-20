package com.jnshu.Spring.jdbcTemplate;

import com.jnshu.Spring.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinfUserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user=new User();
        /*rs.getInt("id"),rs.getString("name"),rs.getString("email")*/
        rs.getInt("id");
        rs.getString("name");
        rs.getString("email");
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));

        return user;
    }
}
