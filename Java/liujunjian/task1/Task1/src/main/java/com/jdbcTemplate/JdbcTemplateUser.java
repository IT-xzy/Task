package com.jdbcTemplate;

import com.entity.UserMapper;
import com.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

public class JdbcTemplateUser {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser(final User user) {
        final String sql = "insert into tb_test (name ,number ,create_at,update_at)values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getNumber());
                ps.setLong(3, user.getCreate_at());
                ps.setLong(4, user.getUpdate_at());
                return ps;
            }
        }, keyHolder);
        System.out.println("插入成功！id=" + keyHolder.getKey().intValue());
    }

    public void deleteUser(Integer id) {
        String sql = "delete from tb_test where id=?";
        int i = jdbcTemplate.update(sql, id);
        if (i > 0) {
            System.out.println("true！成功插入" + i + "条数据");
        }
    }

    public void updateUser(User user) {
        String sql = "update tb_test set name=?,number=?,update_at=? where id=?";
        int i = jdbcTemplate.update(sql, user.getName(), user.getNumber(), user.getUpdate_at(), user.getId());
        if (i > 0) {
            System.out.println("true！成功修改" + i + "条数据");
        }
    }

    public void findUsers() {
        String sql = "select * from tb_test";
        List<User> list = jdbcTemplate.query(sql, new UserMapper());
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    public void findUserById(Integer id) {
        String sql = "select * from tb_test where id=?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{id}, new UserMapper());
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    public void findUserByName(String name) {
        String sql = "select * from tb_test where name like ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{name}, new UserMapper());
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    public void findUserByNumber(String number) {
        String sql = "select * from tb_test where number like ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{number}, new UserMapper());
        Iterator<User> user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }
}
