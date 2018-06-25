package com.zyq.daoImpl;

import com.zyq.dao.StudentDao;
import com.zyq.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplJDBC implements StudentDao {
    @Override
    public Long insert(Student student) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "insert into student values (null,?,?,?,?,?,?,?,?,?,?)";
        Long id = null;
        try {
            pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,student.getName());
            pst.setInt(2,student.getQq());
            pst.setString(3,student.getProfession());
            pst.setString(4,student.getUniversity());
            pst.setInt(5,student.getNumber());
            pst.setString(6,student.getDaily());
            pst.setString(7,student.getSenior());
            pst.setString(8,student.getFrom());
            pst.setLong(9,student.getCreateTime());
            pst.setLong(10,student.getUpdateTime());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs!=null&&rs.next()){
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pst,rs);
        }
        return id;
    }

    @Override
    public boolean deleteById(Student student) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        String sql = "delete from student where id = ?";
        int result = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,student.getId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pst,null);
        }
        if (result >= 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        int result = 0;
        String sql = "update student set update_time = ? where name = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,student.getUpdateTime());
            pst.setString(2,student.getName());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pst,null);
        }
        if (result >= 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student selectById(Long id) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Student student = new Student();
        String sql = "select * from student where ID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,id);
            rs = pst.executeQuery();
            while(rs.next()){
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pst,rs);
        }
        return student;
    }

    @Override
    public List<Student> selectByNameAndNum(String name, Integer number) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        String sql = "select * from student where name = ? and number = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,number);
            rs = pst.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getLong(1));
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
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pst,rs);
        }
        return list;
    }

    public Connection getConnection(){
        String URL = "jdbc:mysql:///myjava?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "314317";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public  void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
