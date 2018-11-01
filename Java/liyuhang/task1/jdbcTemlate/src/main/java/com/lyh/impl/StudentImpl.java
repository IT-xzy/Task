package com.lyh.impl;

import com.lyh.dao.StudentDao;

import com.lyh.pojo.Student;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Transactional
public class StudentImpl implements StudentDao, Serializable {
    //日志
    
    private static org.apache.log4j.Logger logger = Logger.getLogger(Test.class);

    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    @Override
    public int insert(Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into student(name,qq,wish,school,enrolment_time,type,know_from,create_at,update_at) values(?,?,?,?,?,?,?,?,?)";
         jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException
            {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,"李海");
                ps.setInt(2,87645);
                ps.setString(3,"成功");
                ps.setString(4,"职业技术学院");
                ps.setInt(5,398);
                ps.setString(6,"java");
                ps.setString(7,"网络");
                ps.setInt(8,421);
                ps.setInt(9,2134);
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        System.out.println("id = " + id);
        return id;
    }

    @Override
    public boolean insertBatch(Student student) {
        String sql = "insert into student(name,qq,wish,school,enrolment_time,type,know_from,create_at,update_at) values(?,?,?,?,?,?,?,?,?)";
      int x = jdbcTemplate.update(sql,student.getName(),student.getQq(),student.getWish(),student.getSchool(),student.getEnrolment_time(),student.getType(),student.getKnow_from(),student.getCreate_at(),student.getUpdate_at());
      boolean s = false;
      if (x != 0){
           s = true; }
        return s;
    }

    @Override
    public boolean delete(int id) {
    String sql = "delete from student where id = ?";
    int x = jdbcTemplate.update(sql,id);
        boolean s = false;
        if (x != 0){
            s = true; }
        return s;
    }
    @Override
    public boolean update(Student student) {
      String sql = "update student set name = ? where id = ?";
      int x = jdbcTemplate.update(sql,student.getName(),student.getId());
        boolean s = false;
        if (x != 0){
            s = true;
        }
        logger.info("日志"+s);
        return s;
    }

    @Override
    public void selectByIdAndName(String name,int id) {
      String sql = "select * from student where name = ? and id = ?";
      logger.debug(jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),new Object[]{name,id}));
    }

    @Override
    public List<Student> selectAll() {
        String sql = "select * from student ";
       List x =  jdbcTemplate.queryForList(sql);
       logger.info(x);
       return x;
    }
}
