package com.jnshu.dao.impl;

import com.jnshu.dao.StudentDao;
import com.jnshu.pojo.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2018/12/30 - 4:53
 */
@Repository(value = "studentDao")
public class StudentDaoImpl implements StudentDao {
    private static Logger logger = Logger.getLogger(StudentDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addStudent(Student student)  {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO STUDENTS (name,qq,type,enrolmentTime,school,onlineId,dailyUrl,wish,brother," +
                "whereToKnowJnshu,createAt,updateAt)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, student.getName());
                    preparedStatement.setString(2, student.getQq());
                    preparedStatement.setString(3, student.getType());
                    preparedStatement.setLong(4, student.getEnrolmentTime());
                    preparedStatement.setString(5, student.getSchool());
                    preparedStatement.setInt(6, student.getOnlineId());
                    preparedStatement.setString(7, student.getDailyUrl());
                    preparedStatement.setString(8, student.getWish());
                    preparedStatement.setString(9, student.getBrother());
                    preparedStatement.setString(10, student.getWhereToKnowJnshu());
                    preparedStatement.setLong(11, student.getcreateAt());
                    preparedStatement.setLong(12, student.getupdateAt());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return preparedStatement;
            }
        },keyHolder);
                    int id = keyHolder.getKey().intValue();
                    System.out.println("id="+id);
                    return id;
            }


    @Override
    public void deleteStudent(int id) {
        String sql = "delete from STUDENTS where id = ?";
        int result = jdbcTemplate.update(sql,id);
        if (result !=0){
            logger.debug("true");
        }else {
            logger.debug("false");
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "update STUDENTS set name = ? where id = ?";
        int result = jdbcTemplate.update(sql,student.getName(),student.getId());
        if (result != 0){
            logger.debug("true");
        }else {
            logger.debug("false");
        }
    }

    @Override
    public Student findByIdAndName(int id,String name) {
        String sql = "select * from STUDENTS where name = ? and id = ?";

        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(),name,id);
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from STUDENTS";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }
}
