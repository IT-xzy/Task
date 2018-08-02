package com.dao;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 15:38$
 **/
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //增加用户，返回id
    @Override
    public long addUser(final User user) {
        String sql = "insert into user (name,qq,type) values (?,?,?)";
//        jdbcTemplate.update(sql, user.getName(), user.getQq(), user.getType());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pst = connection.prepareStatement("insert into user (name,qq,type) values (?,?,?)", new String[]{"id"});
                pst.setString(1, user.getName());
                pst.setInt(2, user.getQq());
                pst.setString(3, user.getType());
                return pst;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    //删除用户，返回boolean类型
    @Override
    public boolean deleteUser(User user) {
        boolean b = false;
        String sql = "delete from user where name=?";
        int i = jdbcTemplate.update(sql, user.getName());
        if (i > 0) {
            b = true;
        }
        return b;
    }

    //更新用户信息，返回boolean类型
    @Override
    public boolean updateUser(User user) {
        boolean b = false;
        String sql = "update user  set type=? where name=?";
        int i = jdbcTemplate.update(sql, user.getType(), user.getName());
        if (i > 0) {
            b = true;
        }
        return b;
    }

    //查询
    @Override
    public User selectUser(User user) {
        String sql = "select type from user  where name=?";
        user.setType(jdbcTemplate.queryForObject(sql, String.class, user.getName()));
        return user;
    }
}
