package com.mutesaid.DBDemo.JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentsJDBC implements StudentsDAO {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    @Override
    public Students getStudent(String onlineId) {
        String sql = "select * from students where online_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Students stu = null;
        try {
            conn = JDBCUtils.getConnection(this.url, this.driverName, this.user, this.password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, onlineId);
            rs = pstmt.executeQuery();
            stu = new Students();

            while (rs.next()) {
                stu.setId(rs.getLong(1));
                stu.setName(rs.getString(2));
                stu.setQq(rs.getLong(3));
                stu.setType(rs.getString(4));
                stu.setTimeOf(rs.getString(5));
                stu.setGradeSchool(rs.getString(6));
                stu.setOnlineId(rs.getString(7));
                stu.setLink(rs.getString(8));
                stu.setWish(rs.getString(9));
                stu.setFellow(rs.getString(10));
                stu.setUnderstand(rs.getString(11));
                stu.setCreateAt(rs.getLong(12)) ;
                stu.setUpdateAt(rs.getLong(13)) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn, pstmt, rs);
        }

        return stu;
    }

    @Override
    public void add(Students stu) {
        String sql = "insert into students values (null,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection(this.url,this.driverName,this.user,this.password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,stu.getName());
            pstmt.setLong(2,stu.getQq());
            pstmt.setString(3,stu.getType());
            pstmt.setString(4,stu.getTimeOf());
            pstmt.setString(5,stu.getGradeSchool());
            pstmt.setString(6,stu.getOnlineId());
            pstmt.setString(7,stu.getLink());
            pstmt.setString(8,stu.getWish());
            pstmt.setString(9,stu.getFellow());
            pstmt.setString(10,stu.getUnderstand());
            pstmt.setLong(11,stu.getCreateAt());
            pstmt.setLong(12,stu.getUpdateAt());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn, pstmt, null);
        }
    }

    @Override
    public void delete(String onlineId) {
        String sql = "delete from students where online_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection(this.url, this.driverName, this.user, this.password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,onlineId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn, pstmt, null);
        }
    }

    @Override
    public void update(String online_id, String key, String value) {
        String sql = "update students set ? = ? where online_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection(this.url, this.driverName, this.user, this.password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, key);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn, pstmt, null);
        }

    }
}
