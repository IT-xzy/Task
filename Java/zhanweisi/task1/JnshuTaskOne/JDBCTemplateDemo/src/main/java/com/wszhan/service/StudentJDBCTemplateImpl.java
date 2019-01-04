package com.wszhan.service;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.wszhan.pojo.Student;
import com.wszhan.pojo.StudentRowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-31 15:24
 **/
public class StudentJDBCTemplateImpl implements StudentJDBCTemplate{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    // Initialization
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    public int create(final String name, final Integer age) {
        final String INSERT_SQL = "INSERT INTO student (name, age) values (?, ?)";

//        jdbcTemplateObject.update(sql, name, age);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateObject.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_SQL, new String[] {"id"});
                        ps.setString(1, name);
                        ps.setInt(2, age);
                        return ps;
                    }
                },
                keyHolder
        );

        System.out.println("Created record\nName - " +
                name + "\nAge - " + age);

        return keyHolder.getKey().intValue();
    }

    public void insertByBatch(final List<Student> students) {
        String sql = "INSERT INTO student (name, age) values (?, ?)";

        int[] updateCounts = jdbcTemplateObject.batchUpdate(
                sql,
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setString(1, students.get(i).getName());
                        preparedStatement.setInt(2, students.get(i).getAge());
                    }

                    public int getBatchSize() {
                        return students.size();
                    }
                }
        );
    }

    public List<Student> listStudents() {
        String sql = "SELECT id, name, age FROM student";

        List<Student> students = jdbcTemplateObject.query(sql,
                new StudentRowMapper());
        return students;
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        jdbcTemplateObject.update(sql,
                student.getName(),
                student.getAge(),
                student.getId());
        System.out.println("Updated record with ID = " + student.getId());
        return;
    }

    public Student getStudent(Integer id) {
        String sql = "SELECT id, name, age FROM student "
                + "WHERE id = ?";
        Student student = jdbcTemplateObject.queryForObject(
                sql,
                new Object[] { id },
                new StudentRowMapper());
        return student;
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM student WHERE id = ?";
        jdbcTemplateObject.update(sql, id);
        System.out.println("Delete record with ID = " + id);
        return;
    }
}
