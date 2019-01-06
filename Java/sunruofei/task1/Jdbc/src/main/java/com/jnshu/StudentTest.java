package com.jnshu;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    Student student = new Student();

    public int add(Student student) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srf", "root", "qwert123");
            String sql = "insert into student (name,qq,type,admission_date,graduate_school,student_number,daily_link,wish,instructor,information_source)values(?,?,?,?,?,?,?,?,?,?)";
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
            ResultSet rs = ps.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            connection.close();
            ps.close();
            return id;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean delete(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srf", "root", "qwert123");
            String sql = "delete from student where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            boolean a = ps.executeUpdate() > 0;
            ps.close();
            connection.close();
            return a;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Student student) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srf", "root", "qwert123");
            String sql = "update student set name=?,qq=?,type=?,admission_date=?,graduate_school=?,student_number=?,daily_link=?,wish=?,instructor=?,information_source=? where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
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
            ps.setInt(11, student.getId());
            ps.executeUpdate();
            ps.close();
            connection.close();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public List<Student> findAll() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srf", "root", "qwert123");
            Statement statement = connection.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
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
                students.add(student);
            }
            statement.close();
            connection.close();
            return students;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student findById(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/srf", "root", "qwert123");
            String sql = "select * from student where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
            }
            ps.close();
            connection.close();
            return student;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
