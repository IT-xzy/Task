package com.xiaobo.demo.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.RowMapper;
import com.xiaobo.demo.dto.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.xiaobo.demo.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    public List<User> getAll(){
        String sql = "select * from user";
        return this.getJdbcTemplate().query(sql,new UserRowMapper());
    }
    public User getUserById(Integer id){
        String sql = "select * from user where id=?";
        return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(),id);
    }
    public Integer addUser(final User user){
        final String sql = "insert into user (name,hope) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException{
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,user.getName());
                ps.setString(2,user.getHope());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
    public Boolean deleteUser(Integer id){
        String sql = "delete from user where id=?";
        return this.getJdbcTemplate().update(sql,id) == 1?true:false;
    }
    public Boolean updateUser(User user){
        String sql = "update user set name=?,hope=? where id=?";
        return  this.getJdbcTemplate().update(sql,user.getName(),user.getHope(),user.getId()) == 1?true:false;
    }
    class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setHope(rs.getString("hope"));
            return user;
        }

    }
}
