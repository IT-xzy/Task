package com.longhang.Task2.dao.impl;

import com.longhang.Task2.dao.StudentDao;
import com.longhang.Task2.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public StudentDaoImpl() {}
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(Student student) //insert语句
    {
        String sql="insert into students (id,name,qq,wish,create_at) values(?,?,?,?,?)";
            return jdbcTemplate.update(sql,student.getId(),student.getName(),student.getQq(),student.getWish(),student.getCreate_at());
    }
    public int update(Student student) {
        String sql = "update student set wish=? where Id=?";
        return jdbcTemplate.update(sql, student.getWish(), student.getId());
    }

    public int delete(Long id)//delete 语句
    {
        String sql="delete from student where id=?";

        return jdbcTemplate.update(sql,id);
    }

    public Student select(Long id) {
        String sql = "select * from student where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }


    public List<Student> getAll()  //查询字段
    {
        String sql="SELECT Id,Name FROM student";

        List<Student> result=jdbcTemplate.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
               // student.setWish(rs.getString("wish"));
                return student;
            }
        });

        return result;
    }

    }



