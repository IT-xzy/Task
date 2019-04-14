package com.jnshu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentImp implements StudentDao {
    static ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    static JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");

    @Override
    public int add(final Student student) {
        final String sql = "insert into student (name,qq,type,admission_date,graduate_school,student_number,daily_link,wish,instructor,information_source)values(?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setLong(2, student.getQq());
                ps.setString(3, student.getType());
                ps.setString(4, student.getAdmission_date());
                ps.setString(5, student.getGraduate_school());
                ps.setInt(6, student.getStudent_number());
                ps.setString(7, student.getDaily_link());
                ps.setString(8, student.getWish());
                ps.setString(9, student.getInstructor());
                ps.setString(10, student.getInformation_source());
                ps.executeUpdate();
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().byteValue();
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id = ?";
        int pp = jdbcTemplate.update(sql, id);
        if (pp > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        String sql = "update student set name=? ,qq=?,type=?,admission_date=?,graduate_school=?,student_number=?,daily_link=?,wish=?,instructor=?,information_source=? where id =?";
        int pp = jdbcTemplate.update(sql,
                student.getName(), student.getQq(), student.getType(), student.getAdmission_date(), student.getGraduate_school(), student.getStudent_number(), student.getDaily_link(), student.getWish(), student.getInstructor(), student.getInformation_source(), student.getId());
        if (pp > 0) {
            return true;
        } else {

            return false;
        }
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        final List<Student> ListAllStudent = new ArrayList<>();
        final Student student = new Student();
        jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setQq(resultSet.getLong("qq"));
                student.setType(resultSet.getString("type"));
                student.setAdmission_date(resultSet.getString("admission_date"));
                student.setGraduate_school(resultSet.getString("graduate_school"));
                student.setStudent_number(resultSet.getInt("student_number"));
                student.setDaily_link(resultSet.getString("daily_link"));
                student.setWish(resultSet.getString("wish"));
                student.setInstructor(resultSet.getString("instructor"));
                student.setInformation_source(resultSet.getString("information_source"));
                ListAllStudent.add(student);
                return ListAllStudent;
            }
        });
        return ListAllStudent;
    }

    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ?";
        final Student student = new Student();
        jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setQq(resultSet.getLong("qq"));
                student.setType(resultSet.getString("type"));
                student.setAdmission_date(resultSet.getString("admission_date"));
                student.setGraduate_school(resultSet.getString("graduate_school"));
                student.setStudent_number(resultSet.getInt("student_number"));
                student.setDaily_link(resultSet.getString("daily_link"));
                student.setWish(resultSet.getString("wish"));
                student.setInstructor(resultSet.getString("instructor"));
                student.setInformation_source(resultSet.getString("information_source"));
                return student;
            }
        }, id);
        return student;
    }
}
