package com.hzw.dao.impl;

import com.hzw.dao.StudentDao;
import com.hzw.pojo.Student;
import com.hzw.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class StudentDaoImpl implements StudentDao {

    static Logger looger = Logger.getLogger(String.valueOf(StudentDaoImpl.class));

    @Override
    //增
    public long addStu(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        long s_id = 0;
        String sql = "INSERT INTO student VALUES(null,?,?,?,?,?,?)";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql,RETURN_GENERATED_KEYS);
            ps.setString(1,student.getS_name());
            ps.setInt(2,student.getS_qq());
            ps.setString(3,student.getS_type());
            ps.setInt(4,student.getS_num());
            ps.setLong(5,student.getCreate_at());
            ps.setLong(6,student.getUpdate_at());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while(rs.next()){
                s_id = rs.getLong(1);
                looger.info("Student id = "+s_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(rs,ps,conn);
        }
        return s_id;
    }

    @Override
    //删
    public void deleteStu(long s_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean b;
        String sql = "DELETE FROM student WHERE s_id = ?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,s_id);
            b = ps.execute();
            looger.info(String.valueOf(b));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(null,ps,conn);
        }
    }

    @Override
    //更新（改）
    public void updateStu(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        int a;
        boolean b = false;
        boolean c = true;
        String sql = "UPDATE student SET s_name=?,s_qq=?,s_type=?,s_num=?,update_at=? WHERE s_id=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,student.getS_name());
            ps.setInt(2,student.getS_qq());
            ps.setString(3,student.getS_type());
            ps.setInt(4,student.getS_num());
            ps.setLong(5,student.getUpdate_at());
            ps.setLong(6,student.getS_id());
            a = ps.executeUpdate();
            System.out.println(a);
            if (a > 0){
                looger.info("更新成功"+b);
            }else{
                looger.info("无更新数据"+c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(null,ps,conn);
        }
    }

    @Override
    //查Id
    public Student getId(long s_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student s = null;
        String sql = "SELECT * FROM student WHERE s_id =?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,s_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                s = new Student();
                s.setS_id(s_id);
                s.setS_name(rs.getString(2));
                s.setS_qq(rs.getInt(3));
                s.setS_type(rs.getNString(4));
                s.setS_num(rs.getInt(5));
                s.setCreate_at(rs.getLong(6));
                s.setUpdate_at(rs.getLong(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return s;
    }

    @Override
    //姓名学号综合查询
    public List<Student> getName(String s_name, int s_num) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        Student s = null;
        String sql = "SELECT * FROM student WHERE s_name=? AND s_num=?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,s_name);
            ps.setInt(2,s_num);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Student();
                s.setS_id(rs.getLong(1));
                s.setS_name(rs.getString(2));
                s.setS_qq(rs.getInt(3));
                s.setS_type(rs.getNString(4));
                s.setS_num(rs.getInt(5));
                s.setCreate_at(rs.getLong(6));
                s.setUpdate_at(rs.getLong(7));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    //查所有
    public List<Student> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student s = null;
        List<Student> list = new ArrayList<Student>();
        String sql = "SELECT * FROM student";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new Student();
                s.setS_id(rs.getLong(1));
                s.setS_name(rs.getString(2));
                s.setS_qq(rs.getInt(3));
                s.setS_type(rs.getNString(4));
                s.setS_num(rs.getInt(5));
                s.setCreate_at(rs.getLong(6));
                s.setUpdate_at(rs.getLong(7));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }
}
