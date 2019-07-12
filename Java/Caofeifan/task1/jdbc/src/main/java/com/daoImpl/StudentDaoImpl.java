package com.daoImpl;

import com.dao.StudentDao;
import com.pojo.Student;
import com.utils.DBUtil;
import org.apache.log4j.Logger;

import java.awt.*;
import java.security.Key;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC的实现类
 *
 * @author Administrator
 */
public class StudentDaoImpl implements StudentDao {

    /**
     * 创建静态的logger方法
     */
    static Logger logger = Logger.getLogger(StudentDaoImpl.class);

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    /**
     * @Override当继承父类的接口缺少或者不一致时报错
     * 增加
     */
    public Student addStudent(Student stu) {
        String sql = "insert into stu values (NULL ,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            /**
             * 调用工具类获取数据库连接
             */
            conn = DBUtil.getConnection();
            /**
             * 通过预编译执行sql语句
             */
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setTimestamp(1, stu.getCreateAt());
            pstmt.setTimestamp(2, stu.getUpdateAt());
            pstmt.setString(3, stu.getName());
            pstmt.setInt(4, stu.getQq());
            pstmt.setString(5, stu.getJob());
            pstmt.setLong(6, stu.getStartTime());
            pstmt.setString(7, stu.getCollege());
            pstmt.setInt(8, stu.getNumber());
            pstmt.setString(9, stu.getDailyUrl());
            pstmt.setString(10, stu.getWish());
            pstmt.setString(11, stu.getBrother());
            pstmt.setString(12, stu.getReferee());
            pstmt.setString(13, stu.getCity());
            pstmt.setString(14, stu.getReview());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            logger.info(rs);
            rs.next();
            long key = rs.getInt(1);
            logger.info(key);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return stu;
    }

    @Override

    /**
     * 删除
     */
    public boolean deleteStudent(Long id) {
        String sql = "delete from stu where id=?";
        boolean flag = false;
        int a = 0;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, id);
            a = pstmt.executeUpdate();
            if (a != 0) {
                flag = true;
                logger.info("删除" + flag);
            } else {
                logger.info("删除" + flag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return false;
    }


    @Override
    /**
     * 更新
     */
    public boolean updateStudent(Student stu) {
        String sql = "update stu set create_at=?,update_at=?,name=?,qq=?,job=?,start_time=?,college=?,number=?," +
                "daily_url=?,wish=?,brother=?,referee=?,city=?,review=? where id=?";
        boolean flag = false;
        int a = 0;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, stu.getCreateAt());
            pstmt.setTimestamp(2, stu.getUpdateAt());
            pstmt.setString(3, stu.getName());
            pstmt.setInt(4, stu.getQq());
            pstmt.setString(5, stu.getJob());
            pstmt.setLong(6, stu.getStartTime());
            pstmt.setString(7, stu.getCollege());
            pstmt.setInt(8, stu.getNumber());
            pstmt.setString(9, stu.getDailyUrl());
            pstmt.setString(10, stu.getWish());
            pstmt.setString(11, stu.getBrother());
            pstmt.setString(12, stu.getReferee());
            pstmt.setString(13, stu.getCity());
            pstmt.setString(14, stu.getReview());
            pstmt.setLong(15, stu.getId());
            a = pstmt.executeUpdate();
            if (a != 0) {
                flag = true;
                logger.info("更新" + flag);
            } else {
                logger.info("更新" + flag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return false;
    }

    @Override
    /**
     * 通过ID查找
     */
    public Student getStudentById(Long id) {
        Student stu = null;
        String sql = "select * from stu where id = ?";
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setId(rs.getLong(1));
                stu.setCreateAt(rs.getTimestamp(2));
                stu.setUpdateAt(rs.getTimestamp(3));
                stu.setName(rs.getString(4));
                stu.setQq(rs.getInt(5));
                stu.setJob(rs.getString(6));
                stu.setStartTime(rs.getLong(7));
                stu.setCollege(rs.getString(8));
                stu.setNumber(rs.getInt(9));
                stu.setDailyUrl(rs.getString(10));
                stu.setWish(rs.getString(11));
                stu.setBrother(rs.getString(12));
                stu.setReferee(rs.getString(13));
                stu.setCity(rs.getString(14));
                stu.setReview(rs.getString(15));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }

        return stu;
    }

    @Override
    /**
     * 通过名字查找
     */
    public Student getStudentByNameAndNumber(String name, int number) {
        Long startTime = System.currentTimeMillis();
        Student stu = null;
        String sql = "select * from stu where name = ? and number =?";
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, number);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setId(rs.getLong(1));
                stu.setCreateAt(rs.getTimestamp(2));
                stu.setUpdateAt(rs.getTimestamp(3));
                stu.setName(rs.getString(4));
                stu.setQq(rs.getInt(5));
                stu.setJob(rs.getString(6));
                stu.setStartTime(rs.getLong(7));
                stu.setCollege(rs.getString(8));
                stu.setNumber(rs.getInt(9));
                stu.setDailyUrl(rs.getString(10));
                stu.setWish(rs.getString(11));
                stu.setBrother(rs.getString(12));
                stu.setReferee(rs.getString(13));
                stu.setCity(rs.getString(14));
                stu.setReview(rs.getString(15));
                conn.setAutoCommit(false);
                Long endTime = System.currentTimeMillis();
                logger.info("用时：" + (endTime - startTime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return stu;
    }

    @Override
    /**
     * 通过ID查找
     */
    public Student getStudentByNumber(int number) {
        Student stu = null;
        String sql = "select * from stu where number = ?";
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setId(rs.getLong(1));
                stu.setCreateAt(rs.getTimestamp(2));
                stu.setUpdateAt(rs.getTimestamp(3));
                stu.setName(rs.getString(4));
                stu.setQq(rs.getInt(5));
                stu.setJob(rs.getString(6));
                stu.setStartTime(rs.getLong(7));
                stu.setCollege(rs.getString(8));
                stu.setNumber(rs.getInt(9));
                stu.setDailyUrl(rs.getString(10));
                stu.setWish(rs.getString(11));
                stu.setBrother(rs.getString(12));
                stu.setReferee(rs.getString(13));
                stu.setCity(rs.getString(14));
                stu.setReview(rs.getString(15));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return stu;
    }


    @Override
    /**
     * 查找全表
     */
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from stu";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getLong(1));
                stu.setCreateAt(rs.getTimestamp(2));
                stu.setUpdateAt(rs.getTimestamp(3));
                stu.setName(rs.getString(4));
                stu.setQq(rs.getInt(5));
                stu.setJob(rs.getString(6));
                stu.setStartTime(rs.getLong(7));
                stu.setCollege(rs.getString(8));
                stu.setNumber(rs.getInt(9));
                stu.setDailyUrl(rs.getString(10));
                stu.setWish(rs.getString(11));
                stu.setBrother(rs.getString(12));
                stu.setReferee(rs.getString(13));
                stu.setCity(rs.getString(14));
                stu.setReview(rs.getString(15));
                students.add(stu);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return students;
    }

    @Override
    /**
     * 通过Name模糊查找
     */
    public List<Student> getStudentsByCondition(String name) {
        List<Student> students = new ArrayList<Student>();
        String sql = "select * from stu where name like ? ";
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, "%" + name + "%");//注意此写法
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getLong(1));
                stu.setCreateAt(rs.getTimestamp(2));
                stu.setUpdateAt(rs.getTimestamp(3));
                stu.setName(rs.getString(4));
                stu.setQq(rs.getInt(5));
                stu.setJob(rs.getString(6));
                stu.setStartTime(rs.getLong(7));
                stu.setCollege(rs.getString(8));
                stu.setNumber(rs.getInt(9));
                stu.setDailyUrl(rs.getString(10));
                stu.setWish(rs.getString(11));
                stu.setBrother(rs.getString(12));
                stu.setReferee(rs.getString(13));
                stu.setCity(rs.getString(14));
                stu.setReview(rs.getString(15));
                students.add(stu);
                logger.info("查找成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
        return students;
    }

    @Override
    /**
     * 百万插入
     */
    public void million(Student stu) {
        Long startTime = System.currentTimeMillis();

        String sql = "INSERT INTO stu (create_at,update_at,name,qq,job,start_time,college,number,daily_url,wish,brother,referee,city,review) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conn = DBUtil.getConnection();
            logger.info(conn + "正在插入");
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, stu.getCreateAt());
            pstmt.setTimestamp(2, stu.getUpdateAt());
            pstmt.setString(3, stu.getName());
            pstmt.setInt(4, stu.getQq());
            pstmt.setString(5, stu.getJob());
            pstmt.setLong(6, stu.getStartTime());
            pstmt.setString(7, stu.getCollege());
            pstmt.setInt(8, stu.getNumber());
            pstmt.setString(9, stu.getDailyUrl());
            pstmt.setString(10, stu.getWish());
            pstmt.setString(11, stu.getBrother());
            pstmt.setString(12, stu.getReferee());
            pstmt.setString(13, stu.getCity());
            pstmt.setString(14, stu.getReview());
            conn.setAutoCommit(false);
            for (int i = 1; i <= 1000000; i++) {
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            conn.commit();
            Long endTime = System.currentTimeMillis();
            logger.info("用时：" + (endTime - startTime) / 1000 + "秒");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(rs, pstmt, conn);
        }
    }
}


