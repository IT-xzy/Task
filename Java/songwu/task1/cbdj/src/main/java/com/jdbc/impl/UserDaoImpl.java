package com.jdbc.impl;


import com.jdbc.dao.UserDao;
import com.jdbc.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserDaoImpl implements UserDao {
       private static ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
     private static JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);



    //    插入方法
    @Transactional(rollbackFor=RuntimeException.class)
    public void insert(User user)throws Exception {





        String sql = " insert into user(sex,name,address)  values (?,?,?) ";
//        Object[] j = new Object[1];
//        j[0] = new Object[]{"女", "张珊", 152};
        jdbcTemplate.update(sql, new Object[]{user.getSex(), user.getName(), user.getAddress()});

//        template.update(sql, new Object[]{"女", "张珊", 152});
//
//        throw new RuntimeException();

    }

    //通过传入id删除对应得行的列

    public void delete(int i) {

        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, i);

    }

    //通过传入user对应得id修改name字段
    public void update(User user) {

        String sql = "update  user set name=? where id=?";

        Object objects[] = new Object[]{user.getName(), user.getId()};

      jdbcTemplate.update(sql, objects);
    }

    //通过id查询本行列的所有信息
    public User selectById(int i) {


        String sql = "select * from user where id=?";
        User u = jdbcTemplate.queryForObject(sql, new UserRowMapper(), i);
        return u;
    }

    //查询整个表格
    public List<User> selectAll() {

        String sql = "select * from user ";
        List<User> L = jdbcTemplate.query(sql, new UserRowMapper());
        return L;


    }


    class UserRowMapper implements RowMapper<User> {
        /**
         * rs:结果集.
         * rowNum:行号
         */
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User r = new User();
            r.setId(rs.getInt("id"));
            r.setSex(rs.getString("sex"));
            r.setName(rs.getString("name"));
            r.setAddress((rs.getString("address")));

            return r;


        }

    }
}
