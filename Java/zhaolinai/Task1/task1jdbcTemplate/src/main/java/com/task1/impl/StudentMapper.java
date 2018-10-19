package com.task1.impl;


import com.task1.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet,int i ) throws SQLException {
             Student student =new Student();
             student.setId(resultSet.getInt("id"));
             student.setCreate_at(resultSet.getLong("create_at"));
             student.setUpdate_at(resultSet.getLong("update_at"));
             student.setName(resultSet.getString("name"));
             student.setQq(resultSet.getLong("qq"));
             student.setCurricular(resultSet.getString("curricular"));
             student.setSchool_time(resultSet.getString("school_time"));
             student.setCollege(resultSet.getString("college"));
             student.setId_num(resultSet.getString("id_num"));
             student.setReport_link(resultSet.getString("report_link"));
             student.setGoal(resultSet.getString("goal"));
             student.setRefree(resultSet.getString("refree"));
             return student;



    }
}

