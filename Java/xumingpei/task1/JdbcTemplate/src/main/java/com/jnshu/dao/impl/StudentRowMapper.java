package com.jnshu.dao.impl;

import com.jnshu.pojo.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pipiretrak
 * @data 2018/12/30 - 4:53
 */
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setName(resultSet.getString("name"));
        student.setQq(resultSet.getString("qq"));
        student.setType(resultSet.getString("type"));
        student.setEnrolmentTime(resultSet.getLong("enrolmentTime"));
        student.setSchool(resultSet.getString("school"));
        student.setOnlineId(resultSet.getInt("onlineId"));
        student.setDailyUrl(resultSet.getString("dailyUrl"));
        student.setWish(resultSet.getString("wish"));
        student.setBrother(resultSet.getString("brother"));
        student.setWhereToKnowJnshu(resultSet.getString("whereToKnowJnshu"));
        student.setcreateAt(resultSet.getLong("createAt"));
        student.setupdateAt(resultSet.getLong("updateAt"));
        return student;
    }

}

