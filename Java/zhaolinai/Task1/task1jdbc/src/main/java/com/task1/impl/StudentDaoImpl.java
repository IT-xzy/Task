package com.task1.impl;

import com.task1.dao.Connector;
import com.task1.dao.StudentDao;
import com.task1.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public long add(Student student) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql="insert into student_info(create_at,update_at,name,qq,curricular,school_time,college,id_num,report_link,goal,refree)values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt =connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setLong(1,student.getCreate_at());
        pstmt.setLong(2,student.getUpdate_at());
        pstmt.setString(3,student.getName());
        pstmt.setLong(4,student.getQq());
        pstmt.setString(5,student.getCurricular());
        pstmt.setString(6,student.getSchool_time());
        pstmt.setString(7,student.getCollege());
        pstmt.setString(8,student.getId_num());
        pstmt.setString(9,student.getReport_link());
        pstmt.setString(10,student.getGoal());
        pstmt.setString(11,student.getRefree());
        pstmt.executeUpdate();
        ResultSet resultSet = pstmt.getGeneratedKeys();
            long key=0;
        while ( resultSet.next()) {
             key = resultSet.getLong(1);
        }

        resultSet.close();
        pstmt.close();
        connection.close();
            return key;

    }

    @Override
    public boolean delete(long id) throws SQLException {
     Connection connection = Connector.getConnection();
     String sql="delete from student_info where id=?";
     PreparedStatement pstmt= connection.prepareStatement(sql);
     pstmt.setLong(1,id);
     int num=  pstmt.executeUpdate();
     pstmt.close();
     connection.close();
     if(num==1){
         return true;
     }
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql="update student_info set  create_at=?,update_at=?,name=?,qq=?,curricular=?,school_time=?,college=?,report_link=?,goal=?,refree=? where id_num=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setLong(1,student.getCreate_at());
        pstmt.setLong(2,student.getUpdate_at());
        pstmt.setString(3,student.getName());
        pstmt.setLong(4,student.getQq());
        pstmt.setString(5,student.getCurricular());
        pstmt.setString(6,student.getSchool_time());
        pstmt.setString(7,student.getCollege());
        pstmt.setString(8,student.getReport_link());
        pstmt.setString(9,student.getGoal());
        pstmt.setString(10,student.getRefree());

        pstmt.setString(11,student.getId_num());
        int num = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        if(num>1){
            return true;
        }
        return false;
    }

    @Override
    public List<Student> showOneN(String name) throws SQLException {
        Connection connection =Connector.getConnection();
        String sql ="select *from student_info where name=?";
        PreparedStatement pstmt= connection.prepareStatement(sql);
        pstmt.setString(1,name);
        ResultSet resultSet = pstmt.executeQuery();

        List<Student> list =new ArrayList<>();
        while (resultSet.next()){
            Student student =new Student();
            student.setId(resultSet.getLong("id"));
            student.setCreate_at(resultSet.getLong("create_at"));
            student.setUpdate_at(resultSet.getLong("update_at"));
            student.setName(resultSet.getString("name"));
            student.setQq(resultSet.getLong("qq"));
            student.setCurricular(resultSet.getString("curricular"));
            student.setSchool_time(resultSet.getString("school_time"));
            student.setCollege(resultSet.getString("college"));
            student.setId_num(resultSet.getString("id_num"));
            student.setReport_link(resultSet.getString("report_link"));
            student.setGoal(resultSet.getString("goal"));
            student.setRefree(resultSet.getString("refree"));
            list.add(student);
        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return list;

    }

    @Override
    public Student showOneI(String id_num) throws SQLException {
        Connection connection =Connector.getConnection();
        String sql = "select *from student_info where id_num=?";
        PreparedStatement pstmt =connection.prepareStatement(sql);
        pstmt.setString(1,id_num);
        ResultSet resultSet = pstmt.executeQuery();
        Student student =new Student();
        while (resultSet.next()){

            student.setId(resultSet.getLong("id"));
            student.setCreate_at(resultSet.getLong("create_at"));
            student.setUpdate_at(resultSet.getLong("update_at"));
            student.setName(resultSet.getString("name"));
            student.setQq(resultSet.getLong("qq"));
            student.setCurricular(resultSet.getString("curricular"));
            student.setSchool_time(resultSet.getString("school_time"));
            student.setCollege(resultSet.getString("college"));
            student.setId_num(resultSet.getString("id_num"));
            student.setReport_link(resultSet.getString("report_link"));
            student.setGoal(resultSet.getString("goal"));
            student.setRefree(resultSet.getString("refree"));

        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return student;
    }

    @Override
    public List<Student> showAll() throws SQLException {
        Connection connection = Connector.getConnection();
        String sql= "select *from student_info";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        List list =new ArrayList();
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setCreate_at(resultSet.getLong("create_at"));
            student.setUpdate_at(resultSet.getLong("update_at"));
            student.setName(resultSet.getString("name"));
            student.setQq(resultSet.getLong("qq"));
            student.setCurricular(resultSet.getString("curricular"));
            student.setSchool_time(resultSet.getString("school_time"));
            student.setCollege(resultSet.getString("college"));
            student.setId_num(resultSet.getString("id_num"));
            student.setReport_link(resultSet.getString("report_link"));
            student.setGoal(resultSet.getString("goal"));
            student.setRefree(resultSet.getString("refree"));
             list.add(student);
        }
        return list;
    }
}
