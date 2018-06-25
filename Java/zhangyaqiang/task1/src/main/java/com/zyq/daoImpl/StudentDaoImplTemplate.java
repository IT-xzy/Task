package com.zyq.daoImpl;

import com.zyq.dao.StudentDao;
import com.zyq.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

public class StudentDaoImplTemplate implements StudentDao {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    private JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

    @Override
    public Long insert(final Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pst = connection.prepareStatement("insert into student values (null,?,?,?,?,?,?,?,?,?,?)",
                        new String[]{"id"});
                pst.setString(1,student.getName());
                pst.setInt(2,student.getQq());
                pst.setString(3,student.getProfession());
                pst.setString(4,student.getUniversity());
                pst.setInt(5,student.getNumber());
                pst.setString(6,student.getDaily());
                pst.setString(7,student.getSenior());
                pst.setString(8,student.getFrom());
                pst.setLong(9,student.getUpdateTime());
                pst.setLong(10,student.getUpdateTime());
                return pst;
            }
        },keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean deleteById(Student student) {
        String sql = "delete from student where id = ?";
        int result = jdbcTemplate.update(sql,new Object[]{student.getId()});
        if (result >= 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(final Student student) {
        String sql = "update student set update_time = ? where name = ?";
        int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pst) throws SQLException {
                pst.setLong(1,student.getUpdateTime());
                pst.setString(2,student.getName());
            }
        });
        if (result >= 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student selectById(Long id) {
        Student student;
        try {
            student = (Student) jdbcTemplate.queryForObject("select * from student where ID = ?", new Object[]{id}, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("name"));
                    student.setQq(rs.getInt(3));
                    student.setProfession(rs.getString(4));
                    student.setUniversity(rs.getString(5));
                    student.setNumber(rs.getInt(6));
                    student.setDaily(rs.getString(7));
                    student.setSenior(rs.getString(8));
                    student.setFrom(rs.getString(9));
                    student.setCreateTime(rs.getLong(10));
                    student.setUpdateTime(rs.getLong(11));
                    return student;
                }
            });
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return student;
    }

    @Override
    public List<Student> selectByNameAndNum(String name, Integer number) {
        List<Student> list = jdbcTemplate.query("select * from student where name = ? and number = ?", new Object[]{name,number}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getLong("ID"));
                student.setName(rs.getString("name"));
                student.setQq(rs.getInt(3));
                student.setProfession(rs.getString(4));
                student.setUniversity(rs.getString(5));
                student.setNumber(rs.getInt(6));
                student.setDaily(rs.getString(7));
                student.setSenior(rs.getString(8));
                student.setFrom(rs.getString(9));
                student.setCreateTime(rs.getLong(10));
                student.setUpdateTime(rs.getLong(11));
                return student;
            }
        });
        return list;
    }
}
