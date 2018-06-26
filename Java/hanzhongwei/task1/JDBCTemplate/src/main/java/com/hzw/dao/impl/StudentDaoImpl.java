package com.hzw.dao.impl;

import com.hzw.dao.StudentDao;
import com.hzw.pojo.Student;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao{

    @Override
    public void addStu(Student student) {
        String sql = "INSERT INTO student VALUES (null,?,?,?,?,?,?)";
        /*这里继承了JdbcDaoSupport类，没有手动写JDBC模板，从父类的方法中获得JDBC模板，根据连接池创建*/
        super.getJdbcTemplate().update(sql,student.getS_name(),student.getS_qq(),
                student.getS_type(),student.getS_num(),student.getCreate_at(),
                student.getUpdate_at());
       /* KeyHolder key=new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator(){
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,student.getS_name());
                ps.setInt(2,student.getS_qq());
                ps.setString(3,student.getS_type());
                ps.setInt(4,student.getS_num());
                ps.setLong(5,student.getCreate_at());
                ps.setLong(6,student.getUpdate_at());
                return ps;
            }
        },key);
        //从主键持有者中获得主键值
        student.setS_id(key.getKey().longValue());
        System.out.println(student.getS_id());*/
    }

    @Override
    public void deleteStu(long s_id) {
        String sql = "DELETE FROM student WHERE s_id = ?";
        super.getJdbcTemplate().update(sql,s_id);
    }

    @Override
    public void updateStu(Student student) {
        String sql = "UPDATE student SET s_name=?,s_qq=?,s_type=?,s_num=?,update_at=? WHERE s_id=?";
        super.getJdbcTemplate().update(sql,student.getS_name(),student.getS_qq(),
                student.getS_type(),student.getS_num(), student.getUpdate_at(),student.getS_id());
    }

    @Override
    public Student getId(long s_id) {
        String sql = "SELECT * FROM student WHERE s_id=?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student stu = new Student();
                stu.setS_id(rs.getLong("s_id"));
                stu.setS_name(rs.getString("s_name"));
                stu.setS_qq(rs.getInt("s_qq"));
                stu.setS_type(rs.getString("s_type"));
                stu.setS_num(rs.getInt("s_num"));
                stu.setCreate_at(rs.getLong("create_at"));
                stu.setUpdate_at(rs.getLong("update_at"));
                return stu;
            }
        },s_id);
    }

    @Override
    public List<Student> getAll() {
        String sql = "SELECT * FROM student";
        List<Student> list = super.getJdbcTemplate().query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student stu = new Student();
                stu.setS_id(rs.getLong("s_id"));
                stu.setS_name(rs.getString("s_name"));
                stu.setS_qq(rs.getInt("s_qq"));
                stu.setS_type(rs.getString("s_type"));
                stu.setS_num(rs.getInt("s_num"));
                stu.setCreate_at(rs.getLong("create_at"));
                stu.setUpdate_at(rs.getLong("update_at"));
                return stu;
            }
        });
        return list;
    }
}
