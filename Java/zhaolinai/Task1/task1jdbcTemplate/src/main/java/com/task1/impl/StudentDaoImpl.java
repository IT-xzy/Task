package com.task1.impl;

import com.task1.dao.StudentDao;
import com.task1.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.PreparedStatementCreator;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
   private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(final Student student) throws SQLException {
        final String sql= "insert into student_info(create_at,update_at,name,qq,curricular,school_time,college,id_num,report_link,goal,refree)values(?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setLong(1,student.getCreate_at());
                pstmt.setLong(2,student.getUpdate_at());
                pstmt.setString(3,student.getName());
                pstmt.setLong(4,student.getQq());
                pstmt.setString(5,student.getCurricular());
                pstmt.setString(6,student.getSchool_time());
                pstmt.setString(7,student.getCollege());
                pstmt.setString(8,student.getId_num());
                pstmt.setString(9,student.getReport_link());
                pstmt.setString(10,student.getGoal());
                pstmt.setString(11,student.getRefree());
                     return  pstmt;
            }
        },keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        String sql = "delete from student_info where id=?";
       int num=  jdbcTemplate.update(sql,id);
       if(num==1){
           return true;
       }
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        String sql="update student_info set  create_at=?,update_at=?,name=?,qq=?,curricular=?,school_time=?,college=?,report_link=?,goal=?,refree=? where id_num=?";
        int num= jdbcTemplate.update(sql, student.getCreate_at(),student.getUpdate_at()
        ,student.getName(),student.getQq(),student.getCurricular(),student.getSchool_time()
        ,student.getCollege(),student.getReport_link(),student.getGoal(),student.getRefree(),student.getId_num());
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    public List showOneN(String name) throws SQLException {
        String sql ="select *from student_info where name=?";

        return   jdbcTemplate.query(sql,new StudentMapper(),name);
    }

    @Override
    public Student showOneI(String id_num) throws SQLException {
        String sql="select *from student_info where id_num=?";
        return jdbcTemplate.queryForObject(sql,new StudentMapper(),id_num);
    }

    @Override
    public List<Student> showAll() throws SQLException {
        String sql = "select *from student_info";
        return  jdbcTemplate.query(sql,new StudentMapper());

    }
}
