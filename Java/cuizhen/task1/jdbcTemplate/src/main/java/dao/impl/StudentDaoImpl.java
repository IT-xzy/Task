package dao.impl;

import dao.StudentDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pojo.Student;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    private static Logger logger = Logger.getLogger(String.valueOf(StudentDao.class));

    @Override
    public int add(final Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into student1(name,qq,type ,time,graduate_institutions,daily_link,volunteer,create_at,update_at) " +
                "values(?,?,?,?,?,?,?,?,?)";
//        this.getJdbcTemplate().update(sql,s.getName(),s.getQq(),s.getType(),s.getTime(),s.getGraduateInstitutions()
//                ,s.getDailyLink(),s.getVolunteer(),s.getCreateAt(),s.getUpdateAt());
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setLong(2, student.getQq());
                ps.setString(3, student.getType());
                ps.setString(4, student.getTime());
                ps.setString(5, student.getGraduateInstitutions());
                ps.setString(6, student.getDailyLink());
                ps.setString(7, student.getVolunteer());
                ps.setLong(8, student.getCreateAt());
                ps.setLong(9, student.getUpdateAt());
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        return id;
    }

    @Override
    public boolean update(final Student student) {
        final int[] result = {0};

        final String sql = "update student1 set name=?,qq=?,type=?,time=?,graduate_institutions=?,daily_link=?," +
                "volunteer=?,create_at=?,update_at= ? where id=?";
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
                                          @Override
                                          public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                                              PreparedStatement ps = connection.prepareStatement(sql);
                                              ps.setString(1, student.getName());
                                              ps.setLong(2, student.getQq());
                                              ps.setString(3, student.getType());
                                              ps.setString(4, student.getTime());
                                              ps.setString(5, student.getGraduateInstitutions());
                                              ps.setString(6, student.getDailyLink());
                                              ps.setString(7, student.getVolunteer());
                                              ps.setLong(8, student.getCreateAt());
                                              ps.setLong(9, student.getUpdateAt());
                                              ps.setLong(10, student.getId());
                                              result[0] = ps.executeUpdate();

                                              logger.info("" + result[0]);
                                              return ps;
                                          }
                                      }
        );
        if (result[0] != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(final long id) {
        final int[] result = {0};

        final String sql = "delete from student1 where id=?";
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                result[0] = ps.executeUpdate();
                logger.info("" + result[0]);
                return ps;
            }
        });
        if (result[0] != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student get(long id) {
        String sql = "select *from student1 where id=?";
        Student student=null;
        try {
            student=this.getJdbcTemplate().queryForObject(sql,new  StudentRowMapper(),id);
        }catch (EmptyResultDataAccessException e){
            System.out.println("无此id");
        }return student;
    }


    @Override
    public List<Student> get(String name) {
        String sql = "select *from student1 where name=?";
        return this.getJdbcTemplate().query(sql, new StudentRowMapper(),name);

    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student1";

        return this.getJdbcTemplate().query(sql, new StudentRowMapper());
    }


    class StudentRowMapper implements RowMapper<Student> {
        //rs为返回结果集，以每行为单位封装着
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setQq(rs.getLong("qq"));
            student.setType(rs.getString("type"));
            student.setTime(rs.getString("time"));
            student.setGraduateInstitutions(rs.getString("graduate_institutions"));
            student.setDailyLink(rs.getString("daily_link"));
            student.setVolunteer(rs.getString("volunteer"));
            student.setCreateAt(rs.getLong("create_at"));
            student.setUpdateAt(rs.getLong("update_at"));
            return student;

        }
    }
}

