package com.daoImpl;
/**
 * 实现类
 */

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.pojo.User;
import com.dao.UserDao;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * 创建实现类继承支持类实现Dao接口
 *
 * @author Administrator
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
   private Logger logger = Logger.getLogger(UserDaoImpl.class);
    /**
     *增加
     */
    @Override

    public User addUser(final User user)throws Exception {
        final String sql = "insert into stu values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql, new String[]{"id"});
                pstmt.setTimestamp(1, user.getCreateAt());
                pstmt.setTimestamp(2, user.getUpdateAt());
                pstmt.setString(3, user.getName());
                pstmt.setInt(4, user.getQq());
                pstmt.setString(5, user.getJob());
                pstmt.setLong(6, user.getStartTime());
                pstmt.setString(7, user.getCollege());
                pstmt.setInt(8, user.getNumber());
                pstmt.setString(9, user.getDailyUrl());
                pstmt.setString(10, user.getWish());
                pstmt.setString(11, user.getBrother());
                pstmt.setString(12, user.getReferee());
                pstmt.setString(13, user.getCity());
                pstmt.setString(14, user.getReview());
                return pstmt;
            }
        }, keyHolder);
        logger.info(keyHolder.getKey().longValue());
        return user;
    }
    /**
     *删除
     */
    @Override

    public boolean deleteUser(Long id) {
        String sql = "delete from stu where id = ?";
        boolean fiag = false;
        int a = this.getJdbcTemplate().update(sql, id);
        try {
            if (a != 0) {
                fiag = true;
                logger.info("删除" + fiag);
            } else {
                logger.info("删除" + fiag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *更新
     */
    @Override

    public boolean updateUser(User user) {
        String sql = "update stu set name =?,qq =? where id = ?";
        int a = this.getJdbcTemplate().update(sql, user.getName(), user.getQq(), user.getId());
        boolean flag = false;
        try {
            if (a != 0) {
                flag = true;
                logger.info("更新" + flag);
            } else {
                logger.info("更新" + flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     *通过ID查询Name
     */
    @Override

    public String searchUserName(Long id) throws Exception{
        String sql = "select name from stu where id = ?";
        return this.getJdbcTemplate().queryForObject(sql, String.class, id);
    }
    /**
     * 模糊查询
     */
    @Override
    public User getStudentsByCondition(String name) throws Exception{
        String sql = "select * from stu where name like ?";
        Object args[] = new Object[]{"%" + name + "%"};
        Object user = this.getJdbcTemplate().queryForObject(sql, args, new BeanPropertyRowMapper(User.class));
        return (User) user;
    }

    /**
     *通过ID查询
     */
    @Override
    public User searchUser(Long id)throws Exception {
        String sql = "select * from stu where id = ?";
        Object args[] = new Object[]{id};
        Object user = this.getJdbcTemplate().queryForObject(sql, args, new BeanPropertyRowMapper(User.class));
        return (User) user;

    }
    /**
     * 条件查询
     */
    @Override

    public User searchUserByNameAndNumber(String name, int number) throws Exception{
        String sql = "select * from stu where name = ? and number = ?";
        Object args[] = new Object[]{name, number};
        Object user = this.getJdbcTemplate().queryForObject(sql, args, new BeanPropertyRowMapper(User.class));
        return (User) user;
    }
    /**
     * 查询全表
     */
    @Override

    public List<Map<String, Object>> itemsList() throws Exception{
        String sql = "select * from stu";
        List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql);
        return list;
    }
}


