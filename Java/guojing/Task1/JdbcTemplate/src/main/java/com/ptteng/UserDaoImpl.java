package com.ptteng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public long insertUser(final User user) {
//        应用上下，解析XML文件
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
//        获取JdbcTemplate的bean，并实例化
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
//        SQL语句，采用占位符赋值的方法
        final String sql = "insert into student (name,QQ,wish,createAt,updateAt) values (?,?,?,?,?)";
//        执行SQL语句，并返回主键。这里的写法不熟练。
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setLong(2, user.getQQ());
                ps.setString(3, user.getWish());
                ps.setLong(4, user.getCreateAt());
                ps.setLong(5, user.getUpdateAt());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }


    @Override
    public List<User> findAll() {
//        应用上下文，解析XML文件
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
//       从xml文件中获取bean的实例化对象
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        String sql = "select * from student";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        return users;
    }


@Override
public List<User> findById(long id){
        ApplicationContext app=new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) app.getBean("jdbcTemplate");
        String sql="select * from student where id=?";
//        通过映射将结果转换为数组的方法
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
//        执行查询，输出结果为数组
        List<User> users=jdbcTemplate.query(sql,rowMapper,id);
        return users;
}





    @Override
    public boolean updateUser(User user) {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        String sql = "update student set name=?,QQ=?,wish=?,createAt=?,updateAt=? where id=?";
        boolean row = false;
        int i = jdbcTemplate.update(sql, user.getName(), user.getQQ(), user.getWish(), user.getCreateAt(),
                user.getUpdateAt(), user.getId());
        if (i == 1) {
            row = true;
        } else {
            row = false;
        }
        return row;
    }

    @Override
    public boolean deleteUser(long id) {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        String sql = "delete from student where id=?";
        boolean row = false;
        int i = jdbcTemplate.update(sql, id);
        if (i == 1) {
            row = true;
        } else {
            row = false;
        }
        return row;
    }
}
