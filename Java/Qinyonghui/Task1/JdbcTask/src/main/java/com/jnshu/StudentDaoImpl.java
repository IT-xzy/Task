package com.jnshu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private static Connection conn;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private long id;
    private boolean flag = false;
    Student student = new Student();

    @Override
    public long insert(final Student student) throws ClassNotFoundException, SQLException {
        try {
            String URL = "jdbc:mysql://localhost:3306/task?useSSL=false";
            String USER_NAME = "root";
            String PASS_WORD = "123456";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            final String sql = "INSERT INTO student(name,number,qq,coachName,dailyLink,gradeColleage,create_at,update_at)values(?,?,?,?,?,?,?,?) ";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getNumber());
            pstmt.setInt(3, student.getQq());
            pstmt.setString(4, student.getCoachName());
            pstmt.setString(5, student.getDailyLink());
            pstmt.setString(6, student.getGradeColleage());
            pstmt.setLong(7, System.currentTimeMillis());
            pstmt.setLong(8, System.currentTimeMillis());
            int row = pstmt.executeUpdate();
            if (row != 0) ;
            {
                    resultSet = pstmt.getGeneratedKeys();
                    if (resultSet.next()) {
                    id = resultSet.getLong(1);
                    }
            }

        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } finally {
            resultSet.close();
            pstmt.close();
            conn.close();
        }
        return id;
    }

    @Override
    public boolean delete(long id) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/task?useSSL=false";
        String USER_NAME = "root";
        String PASS_WORD = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        String sql = "DELETE FROM student where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1,id);
        int row =pstmt.executeUpdate();
        if(row != 0){
          flag = true;
        }
        pstmt.close();
        conn.close();
        return flag;
    }

    @Override
    public boolean update(Student student) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/task?useSSL=false";
        String USER_NAME = "root";
        String PASS_WORD = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        String sql = "UPDATE student set name=?,number=?,qq=?,coachName=?,dailyLink=?,gradeColleage=?,update_at=? where id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getName());
        pstmt.setInt(2, student.getNumber());
        pstmt.setInt(3, student.getQq());
        pstmt.setString(4, student.getCoachName());
        pstmt.setString(5, student.getDailyLink());
        pstmt.setString(6, student.getGradeColleage());
        pstmt.setLong(7, System.currentTimeMillis());
        pstmt.setLong(8, student.getId());
        int row =pstmt.executeUpdate();
        if(row != 0){
            flag = true;
        }
        pstmt.close();
        conn.close();
        return flag;
    }

    @Override
    public Student find(long id) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/task?useSSL=false";
        String USER_NAME = "root";
        String PASS_WORD = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
        String sql = "SELECT *FROM student WHERE id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1,id);
        resultSet = pstmt.executeQuery();
        if(resultSet.next()){
            student = new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("number"),
                    resultSet.getInt("qq"),
                    resultSet.getString("coachName"),
                    resultSet.getString("dailyLink"),
                    resultSet.getString("gradeColleage"),
                    resultSet.getLong("create_at"),
                    resultSet.getLong("create_at")
            );
            resultSet.close();
            pstmt.close();
            conn.close();
    }
        return student;
    }
    @Override
    public List<Student> findAll() throws ClassNotFoundException, SQLException {
        List<Student> students = new ArrayList<Student>();
        String URL = "jdbc:mysql://localhost:3306/task?useSSL=false";
        String USER_NAME = "root";
        String PASS_WORD = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
        String sql = "SELECT *FROM student";
        pstmt = conn.prepareStatement(sql);
        resultSet = pstmt.executeQuery();
        while(resultSet.next()){
            student = new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("number"),
                    resultSet.getInt("qq"),
                    resultSet.getString("coachName"),
                    resultSet.getString("dailyLink"),
                    resultSet.getString("gradeColleage"),
                    resultSet.getLong("create_at"),
                    resultSet.getLong("create_at")
            );
                     students.add(student);
        }
        resultSet.close();
        pstmt.close();
        conn.close();
        return students;
    }

}
