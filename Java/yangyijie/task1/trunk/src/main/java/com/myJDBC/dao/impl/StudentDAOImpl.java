package com.myJDBC.dao.impl;

import com.myJDBC.dao.IStudentDAO;
import com.myJDBC.domain.Student;
import com.myJDBC.util.DruidUtil;
import com.myJDBC.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arike
 * Create_at  2017/11/14 9:31
 */

public class StudentDAOImpl implements IStudentDAO {
    
    
    @Override
    //增加记录
    public void add(Student stu) {
        try {
            Connection con = JdbcUtil.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("insert into t_student(name,age) values(" + "'" + stu.getName() + "'" + "," + stu.getAge() + ")");
            JdbcUtil.close(con, st, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    //删除数据
    public void delete(long id) {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:context://localhost:3306/task1?useSSL=false", "root", "java");
            st = con.createStatement();
            st.executeUpdate("DELETE FROM t_student WHERE id =" + id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    //更新(使用PrepareStatement(预编译)获取可以有占位符号匹配的SQL执行对象)
    public void update(Student stu) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update t_student set name = ? ,age = ? where id = ?";
        try {
            con = JdbcUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, stu.getName());
            ps.setInt(2, stu.getAge());
            ps.setLong(3, stu.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JdbcUtil.close(con, ps, null);
    }
    
    
    @Override
    //根据字段查询
    public Student get(long id) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Student s = null;
        try {
            con = DruidUtil.getConnection();
            ps = con.prepareStatement("SELECT * FROM t_student WHERE id = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            rs.next();
            s = new Student(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DruidUtil.close(con, ps, rs);
        return s;
    }
    
    @Override
    //查询所有
    public List<Student> getall() {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = null;
        List<Student> list = null;
        try {
            con = DruidUtil.getConnection();
            sql = "SELECT * from t_student";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Student s = new Student(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DruidUtil.close(con, ps, rs);
        return list;
    }
}
