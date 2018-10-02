package dao.impl;

import dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author suger
 * @date 2018-09-13
 */
@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Long insert(User user) {
        String sql = "insert into user(user_name,qq,profession,start_time,graduated_from,online_id,daily_link," +
                "wish,counselor,way,create_at,update_at)values(?,?,?,?,?,?,?,?,?,?,?,?)";
        // 设置主键
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql,new String[]{"user_id"});
                ps.setString(1,user.getUserName());
                ps.setString(2,user.getQq());
                ps.setString(3,user.getProfession());
                ps.setString(4,user.getStartTime());
                ps.setString(5,user.getGraduatedFrom());
                ps.setInt(6,user.getOnlineId());
                ps.setString(7,user.getDailyLink());
                ps.setString(8,user.getWish());
                ps.setString(9,user.getCounselor());
                ps.setString(10,user.getWay());
                ps.setLong(11,user.getCreateAt());
                ps.setLong(12,user.getUpdateAt());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().longValue();
    }
    @Override
    public Boolean update(User user) {
        String sql = "update user set user_name=?, profession=?,update_at=? where user_id = ? ";
        Object[] objects = new Object[]{user.getUserName(),user.getProfession(), user.getUpdateAt(),user.getUserId()};
        boolean flag = false;
        int i =jdbcTemplate.update(sql, objects);
        if(i!=0){
            flag = true;
        }
        return flag;
    }
    @Override
    public Boolean delete(Long userId) {
        String sql = "delete from user where user_id = ?";
        int i = jdbcTemplate.update(sql, userId);
        boolean flag = false;
        if(i!=0){
            flag = true;
        }
        return flag;
    }
    @Override
    public List<User> findAll() {
        String sql = "select user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor," +
                "way,create_at,update_at from user";
        List users = jdbcTemplate.queryForList(sql);
        return users;
    }
    @Override
    public List<User> getUserByName(String userName) {
        //sql中字符串类型必须要包含在引号内
        String sql = "select user_id,user_name,qq,profession,start_time,graduated_from,online_id,daily_link," +
                "wish,way,create_at,update_at from user where user_name = '"+ userName+" ' ";
        final List<User> list = new ArrayList<User>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                // rs.get方法 参数为表字段 ----返回对应实体类属性
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setQq(rs.getString("qq"));
                user.setProfession(rs.getString("profession"));
                user.setStartTime(rs.getString("start_time"));
                user.setGraduatedFrom(rs.getString("graduated_from"));
                user.setOnlineId(rs.getInt("online_id"));
                user.setDailyLink(rs.getString("daily_link"));
                user.setWish(rs.getString("wish"));
                user.setWay(rs.getString("way"));
                user.setCreateAt(rs.getLong("create_at"));
                user.setUpdateAt(rs.getLong("update_at"));
                list.add(user);
            }
        });
        return list;
    }
    @Override
    public List<User> getUserByonlineId(int onlineId) {

        String sql = "select user_id,user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor," +
                "way,create_at,update_at from user where online_id = "+onlineId;
        final List<User> list = new LinkedList<User>();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                // rs.get方法 参数为表字段 ----返回对应实体类属性
                User user = new User();

                user.setUserId(rs.getLong("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setQq(rs.getString("qq"));
                user.setProfession(rs.getString("profession"));
                user.setStartTime(rs.getString("start_time"));
                user.setGraduatedFrom(rs.getString("graduated_from"));
                user.setOnlineId(rs.getInt("online_id"));
                user.setDailyLink(rs.getString("daily_link"));
                user.setWish(rs.getString("wish"));
                user.setWay(rs.getString("way"));
                user.setCreateAt(rs.getLong("create_at"));
                user.setUpdateAt(rs.getLong("update_at"));
                list.add(user);
            }
        });
        return list;
    }
}
