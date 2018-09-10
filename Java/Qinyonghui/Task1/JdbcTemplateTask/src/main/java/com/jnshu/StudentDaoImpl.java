package com.jnshu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentDaoImpl implements StudentDao{

      @Autowired
      private JdbcTemplate jdbcTemplate;
      @Override
      public long insert(final Student student) {
             final KeyHolder keyHolder = new GeneratedKeyHolder();
             final String sql = "insert into student(name,number,qq,coachName,dailyLink,gradeColleage,create_at,update_at) values(?,?,?,?,?,?,?,?)";
             jdbcTemplate.update(new PreparedStatementCreator() {
                 @Override
                 public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                     PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     pstmt.setString(1, student.getName());
                     pstmt.setInt(2, student.getNumber());
                     pstmt.setInt(3, student.getQq());
                     pstmt.setString(4, student.getCoachName());
                     pstmt.setString(5, student.getDailyLink());
                     pstmt.setString(6, student.getGradeColleage());
                     pstmt.setLong(7, System.currentTimeMillis());
                     pstmt.setLong(8, System.currentTimeMillis());
                     return pstmt;
                 }
             }, keyHolder);
           return keyHolder.getKey().intValue();
         }

    @Override
    public boolean delete(long id) throws ClassNotFoundException, SQLException {
        String sql = "delete from student where id = ?";
        boolean flag = false;
        int row = jdbcTemplate.update(sql,id);
        if(row != 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean update(final Student student) throws ClassNotFoundException, SQLException {
        final String sql = "UPDATE student set name=?,number=?,qq=?,coachName=?,dailyLink=?,gradeColleage=?,update_at=? where id=?";
        boolean flag = false;
       int row = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, student.getName());
                pstmt.setInt(2, student.getNumber());
                pstmt.setInt(3, student.getQq());
                pstmt.setString(4, student.getCoachName());
                pstmt.setString(5, student.getDailyLink());
                pstmt.setString(6, student.getGradeColleage());
                pstmt.setLong(7, System.currentTimeMillis());
                pstmt.setLong(8, student.getId());
                return pstmt;
            }
        });
        if(row != 0){
            flag = true;
        }
        return flag;

    }

    @Override
    public Student find(final long id) throws ClassNotFoundException, SQLException {
        final String sql = "SELECT *FROM student WHERE id=?";
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet,int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setNumber(resultSet.getInt("number"));
                student.setQq(resultSet.getInt("qq"));
                student.setCoachName(resultSet.getString("coachName"));
                student.setDailyLink(resultSet.getString("dailyLink"));
                student.setGradeColleage(resultSet.getString("gradeColleage"));
                student.setCreateAt(resultSet.getLong("create_at"));
                student.setUpdateAt(resultSet.getLong("update_at"));
                return student;
            }
        }, id);
       return student;
    }
    @Override
    public List findAll() throws ClassNotFoundException, SQLException {
        List<Student> studentList = new ArrayList<Student>();
        final Student student = new Student();
        String sql = "SELECT *FROM student";
         studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow( ResultSet resultSet, int i) throws SQLException {
                Student student = new Student(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("number"),
                            resultSet.getInt("qq"),
                            resultSet.getString("coachName"),
                            resultSet.getString("dailyLink"),
                            resultSet.getString("gradeColleage"),
                            resultSet.getLong("create_at"),
                            resultSet.getLong("update_at")
                    );
                return student;
            }
        });
        return studentList;
      }
    }