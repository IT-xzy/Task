package com.JdbcTemplate.DaoImpl;
import com.JdbcTemplate.Dao.StudentDao;
import com.JdbcTemplate.Pojo.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private DriverManagerDataSource dataSource;
//    private JdbcTemplate jdbcTemplate;
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public Long Insert(Student student) {
        String sql = "insert into students (create_at,name,qq,professional,start_time,university,online_id,daily_url,oath,counselor,city) values(?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,student.getCreate_at());
                preparedStatement.setString(2,student.getName());
                preparedStatement.setString(3,student.getQq());
                preparedStatement.setString(4,student.getProfessional());
                preparedStatement.setString(5,student.getStart_time());
                preparedStatement.setString(6,student.getUniversity());
                preparedStatement.setInt(7,student.getOnline_id());
                preparedStatement.setString(8,student.getDaily_url());
                preparedStatement.setString(9,student.getOath());
                preparedStatement.setString(10,student.getCounselor());
                preparedStatement.setString(11,student.getCity());
                return preparedStatement;
            }
            }, keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        System.out.println(generatedId);
        return generatedId;
    }

    @Override
    public boolean Delete(int id) {
        boolean flag = false;
        String sql = "delete from students where id = ?";
        int i = jdbcTemplate.update(sql, id);
        if (i !=0){
            flag = true;
        }
        System.out.println(flag);
        return flag;
    }

    @Override
    public void findAllStudent() {
        String sql = "select * from students";
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> students= jdbcTemplate.query(sql, rowMapper);
        for (Student student : students){
            System.out.println(student);
        }
    }

    @Override
    public List<Student> findByName(String name) {
        String sql = "select id,city from students where name = ?";
//        final List<Student>list = new ArrayList<Student>();
//        jdbcTemplate.query(sql, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                Student student = new Student();
//                student.setId(resultSet.getInt("id"));
//                student.setCity(resultSet.getString("city"));
//                list.add(student);
//            }
//        },name);
//        System.out.println(list);
//        return list;
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("id")+"---"+
                resultSet.getString("city"));
                }
                return student;
            }
        },name);
        }

    @Override
    public List<Student> findByOnlie_id(int online_id) {
        String sql = "select id,name,city from students where online_id = ?";
//        final List<Student>list = new ArrayList<>();
//        jdbcTemplate.query(sql, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                Student student = new Student();
//                student.setId(resultSet.getInt("id"));
//                student.setName(resultSet.getString("name"));
//                student.setCity(resultSet.getString("city"));
//                list.add(student);
//            }
//        },online_id);
//        System.out.println(list);
//        return list;
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("id")+"---->"+resultSet.getString("name")+"----->"+
                    resultSet.getString("city"));
                }
                return student;
            }
        },online_id);
    }

    @Override
    public boolean UpdateStudent(Student student) {
        boolean flag = false;
        String sql = "update students set name=?,city=? where id = ?";
       int i =jdbcTemplate.update(sql,student.getName(),student.getCity(),student.getId());
        if (i !=0){
            flag = true;
        }
        System.out.println(flag);
        return flag;
    }
}
