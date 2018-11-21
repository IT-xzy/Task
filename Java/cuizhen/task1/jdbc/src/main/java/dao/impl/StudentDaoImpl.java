package dao.impl;

import dao.StudentDao;
import util.DButil;
import pojo.Student;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class StudentDaoImpl implements StudentDao {
    private static Logger logger = Logger.getLogger(String.valueOf(StudentDao.class));

    @Override
    public long add(Student student) throws Exception {
        String sql = "insert into student1 values(null,?,?,?,?,?,?,?,?,?)";

        Connection con = null;
        PreparedStatement ps = null;
        Long key = null;
        try {
            con = DButil.getCon();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, student.getName());
            ps.setLong(2, student.getQq());
            ps.setString(3, student.getType());
            ps.setString(4, student.getTime());
            ps.setString(5, student.getGraduateInstitutions());
            ps.setString(6, student.getDailyLink());
            ps.setString(7, student.getVolunteer());
            ps.setLong(8, student.getCreateAt());
            ps.setLong(9, student.getUpdateAt());

            int add = ps.executeUpdate();


            if (add != 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                key = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DButil.close(ps, con);
        }
        return key;
    }

    @Override
    public boolean update(Student student) throws Exception {
        String sql = "update student1 set name=?,qq=?,type=?,time=?,graduate_institutions=?," +
                "daily_link=?,volunteer=?,create_at=?,update_at=? where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        int result =0;
        try {
            con = DButil.getCon();
            ps = con.prepareStatement(sql);

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
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DButil.close(ps, con);
        }
//        System.out.println(result);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(long id) throws Exception {
        String sql = "delete from student1 where id=" + id;
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            con = DButil.getCon();
            ps = con.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DButil.close(ps, con);
        }

//        System.out.println(result);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student get(long id) throws Exception {
        Student student = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from student1 where id=" + id;
            con = DButil.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                student = new Student();
                String name = rs.getString(2);
                long qq = rs.getLong(3);
                String type = rs.getString(4);
                String time = rs.getString(5);
                String graduateInstitutions = rs.getString(6);
                String dailyLink = rs.getString(7);
                String volunteer = rs.getString(8);
                long createAt = rs.getLong(9);
                long updateAt = rs.getLong(10);

                student.setName(name);
                student.setQq(qq);
                student.setType(type);
                student.setTime(time);
                student.setGraduateInstitutions(graduateInstitutions);
                student.setDailyLink(dailyLink);
                student.setVolunteer(volunteer);
                student.setCreateAt(createAt);
                student.setUpdateAt(updateAt);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DButil.close(ps, con, rs);
        }

        return student;
    }

    @Override
//    public Student get(String name) throws Exception {
    public List<Student> get(String name) throws Exception {
        List<Student> students = new ArrayList<Student>();
        String sql = "select * from student1 where name = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DButil.getCon();
        ps = con.prepareStatement(sql);
        ps.setString(1, name);
        rs = ps.executeQuery();
        try {
            while (rs.next()) {
                Student student = new Student();
                long id = rs.getLong(1);
                long qq = rs.getLong(3);
                String type = rs.getString(4);
                String time = rs.getString(5);
                String graduateInstitutions = rs.getString(6);
                String dailyLink = rs.getString(7);
                String volunteer = rs.getString(8);
                long createAt = rs.getLong(9);
                long updateAt = rs.getLong(10);
                student.setId(id);
                student.setName(name);
                student.setQq(qq);
                student.setType(type);
                student.setTime(time);
                student.setGraduateInstitutions(graduateInstitutions);
                student.setDailyLink(dailyLink);
                student.setVolunteer(volunteer);
                student.setCreateAt(createAt);
                student.setUpdateAt(updateAt);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DButil.close(ps, con, rs);
        }

        return students;
    }

    @Override
    public List<Student> selectStudent() throws Exception {
        List<Student> students = new ArrayList<Student>();
        String sql = "select * from Student1";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DButil.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();

                long id = rs.getLong(1);
                String name = rs.getString(2);
                long qq = rs.getLong(3);
                String type = rs.getString(4);
                String time = rs.getString(5);
                String graduateInstitutions = rs.getString(6);
                String dailyLink = rs.getString(7);
                String volunteer = rs.getString(8);
                long createAt = rs.getLong(9);
                long updateAt = rs.getLong(10);
                student.setId(id);
                student.setName(name);
                student.setQq(qq);
                student.setType(type);
                student.setTime(time);
                student.setGraduateInstitutions(graduateInstitutions);
                student.setDailyLink(dailyLink);
                student.setVolunteer(volunteer);
                student.setCreateAt(createAt);
                student.setUpdateAt(updateAt);
                students.add(student);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DButil.close(ps, con, rs);
        }
        return students;

    }

}
