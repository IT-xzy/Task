package com.jnshu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoImpl implements JdbcDao {
    static final String JdbcDriver = "com.mysql.jdbc.Driver";
    static final String JdbcUrl = "jdbc:mysql://localhost:3306/test";
    static final String JdbcUser = "root";
    static final String Jdbcpass = "123456";

    @Override
    public long add(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(JdbcDriver);
            conn = DriverManager.getConnection(JdbcUrl, JdbcUser, Jdbcpass);
            String sql = "INSERT INTO TEST (name ,create_at,update_at,qq,course_type," +
                    "entrance_time,graduate_school,wish,daily_link,set_to,brother,learn)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getName());
            ps.setLong(2, student.getCreate_at());
            ps.setLong(3, student.getUpdate_at());
            ps.setLong(4, student.getQq());
            ps.setString(5, student.getCourse_type());
            ps.setLong(6, student.getEntrance_time());
            ps.setString(7, student.getGraduate_school());
            ps.setLong(8, student.getWish());
            ps.setString(9, student.getDaily_link());
            ps.setString(10, student.getSet_to());
            ps.setString(11, student.getBrother());
            ps.setString(12, student.getLearn());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            long id = 0;
            if (rs.next()) {
                id = rs.getLong(1);
            }
            return id;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1L;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1L;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    ps.close();
                    rs.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean delete(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(JdbcDriver);
            conn = DriverManager.getConnection(JdbcUrl, JdbcUser, Jdbcpass);
            String sql = "DELETE FROM TEST WHERE ID=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    public boolean update(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(JdbcDriver);
            conn = DriverManager.getConnection(JdbcUrl, JdbcUser, Jdbcpass);
            String sql = "UPDATE TEST SET name=?,create_at=?,update_at=?,qq=?,course_type=?,entrance_time=?,graduate_school=?,wish=?,daily_link=?,set_to=?,brother=?,learn=?  where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setLong(2,student.getCreate_at());
            ps.setLong(3,student.getUpdate_at());
            ps.setLong(4,student.getQq());
            ps.setString(5,student.getCourse_type());
            ps.setLong(6,student.getEntrance_time());
            ps.setString(7,student.getGraduate_school());
            ps.setLong(8,student.getWish());
            ps.setString(9,student.getDaily_link());
            ps.setString(10,student.getSet_to());
            ps.setString(11,student.getBrother());
            ps.setString(12,student.getLearn());
            ps.setLong(13,student.getId());

            ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Student select(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = null;
        try {
            Class.forName(JdbcDriver);
            conn = DriverManager.getConnection(JdbcUrl, JdbcUser, Jdbcpass);
            String sql = "SELECT *FROM TEST WHERE ID =?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setCreate_at(rs.getLong("create_at"));
                student.setUpdate_at(rs.getLong("update_at"));
                student.setQq(rs.getLong("qq"));
                student.setCourse_type(rs.getString("course_type"));
                student.setEntrance_time(rs.getLong("entrance_time"));
                student.setGraduate_school(rs.getString("graduate_school"));
                student.setWish(rs.getLong("wish"));
                student.setDaily_link(rs.getString("daily_link"));
                student.setSet_to(rs.getString("set_to"));
                student.setBrother(rs.getString("brother"));
                student.setLearn(rs.getString("learn"));
                return student;

            } else {
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    ps.close();
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Student> findStudents() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(JdbcDriver);
            conn = DriverManager.getConnection(JdbcUrl, JdbcUser, Jdbcpass);
            String sql = "SELECT *FROM TEST";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setCreate_at(rs.getLong(3));
                student.setUpdate_at(rs.getLong(4));
                student.setQq(rs.getLong(5));
                student.setCourse_type(rs.getString(6));
                student.setEntrance_time(rs.getLong(7));
                student.setGraduate_school(rs.getString(8));
                student.setWish(rs.getLong(9));
                student.setDaily_link(rs.getString(10));
                student.setSet_to(rs.getString(11));
                student.setBrother(rs.getString(12));
                student.setLearn(rs.getString(13));
                students.add(student);
            }
            return students;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    ps.close();
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
