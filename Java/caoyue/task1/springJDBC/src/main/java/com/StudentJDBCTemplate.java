package com;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(String name,Integer ID) {
        String SQL = "insert into student (name,ID) values (?,?)";
        jdbcTemplateObject.update(SQL,name,ID);
        return;
    }

//    @Override
//    public Student getStudent(Integer ID) {
//        String SQL = "select * from student where id = ?";
//        Student student = jdbcTemplateObject.query(SQL,new Object[]{ID}, new StudentMapper());
//        return student;
//    }
    
    @Override
    public List<Student> listStudents() {
        String SQL = "select * from student";
        List<Student> students = jdbcTemplateObject.query(SQL,new StudentMapper());
        return students;
    }
    
    @Override
    public void delete(Integer ID) {
        String SQL = "delete from student where ID = ?";
        jdbcTemplateObject.update(SQL,ID);
        System.out.println("Deleted Record with ID =" + ID);
        return;
    }
    
    @Override
    public void update(Integer ID, String name) {
        String SQL = "update student set name = ? where ID = ?";
        jdbcTemplateObject.update(SQL,name,ID);
        System.out.println("Updated Record with ID = "+ ID);
        return;
    }
}
