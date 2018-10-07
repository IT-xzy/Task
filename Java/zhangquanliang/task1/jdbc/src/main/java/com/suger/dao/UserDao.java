package com.suger.dao;

import com.suger.pojo.User;
import com.suger.util.DBUtils;
import com.suger.util.DataUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现jdbc的crud
 * @author suger
 * @date 2018-09-20
 */
public class UserDao {

    // 插入返回Id
    public Long insert() {
       Connection con = DBUtils.open();
       Long id = null;

       String sql = "insert into user(user_name,qq,profession,start_time,graduated_from,online_id," +
               "daily_link,wish,counselor,way,create_at,update_at) values('"+ DataUtils.getName()+"','"+
               DataUtils.getNumber(10)+"','"+ DataUtils.getProfession()+"','"+ DataUtils.getDateTime()+"','"+
               DataUtils.getCollege()+"','"+ DataUtils.getIntNumber()+"','"+ DataUtils.getLink()+"','"+
               DataUtils.getWish()+"','"+ DataUtils.getName()+"','"+ DataUtils.getWay()+"','"+
               DataUtils.getTime()+"','"+ DataUtils.getTime()+"')";
       try {
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.executeUpdate();
           ResultSet rs = ps.getGeneratedKeys();
           rs.next();
           id = rs.getLong(1);
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           DBUtils.close(con);
       }
       return id;

   }
   // 更新返回true或false
   public Boolean update(User user) {
        int flag = 0;
        Connection con = DBUtils.open();

        String sql = "update user set user_name='"+user.getUserName()+" 'where user_id ="+user.getUserId()+"";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(con);
        }
        if (flag==0){
            return  false;
        }
        return true;
    }
    // 删除返回true或false
   public Boolean delete(Long userId) {

        int flag = 0;
        Connection con = DBUtils.open();
        String sql = "delete from user where user_id = "+userId;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(con);

        }
        if (flag == 0){
            return  false;
        }
        return true;
    }

   public List<User> findAll() {
       List<User> users = new ArrayList<User>();

       Connection con = DBUtils.open();
       String sql = "select user_id,user_name,qq,profession,start_time,graduated_from,online_id,daily_link," +
               "wish,counselor,way,create_at,update_at from user";
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);

           while (rs.next()) {
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
               user.setCounselor(rs.getString("counselor"));
               user.setWay(rs.getString("way"));
               user.setCreateAt(rs.getLong("create_at"));
               user.setUpdateAt(rs.getLong("update_at"));
               users.add(user);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           DBUtils.close(con);
       }
       return users;
    }
    public List<User> getUserByName(String userName) {
        List<User> users = new ArrayList<User>();
        // 获取连接
        Connection con = DBUtils.open();
        String sql = "select  user_id,user_name,qq,profession,start_time,graduated_from,online_id,daily_link," +
                "wish,counselor,way,create_at,update_at from user where user_name ='"+ userName+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
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
                user.setCounselor(rs.getString("counselor"));
                user.setWay(rs.getString("way"));
                user.setCreateAt(rs.getLong("create_at"));
                user.setUpdateAt(rs.getLong("update_at"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(con);
        }
        return users;
    }
   public List<User> getUserByonlineId(int onlineId) {
       List<User> users = new ArrayList<User>();
       // 获取连接
       Connection con = DBUtils.open();
       String sql = "select user_id,user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor," +
               "way,create_at,update_at from user where online_id = "+onlineId;
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
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
               user.setCounselor(rs.getString("counselor"));
               user.setWay(rs.getString("way"));
               user.setCreateAt(rs.getLong("create_at"));
               user.setUpdateAt(rs.getLong("update_at"));
               users.add(user);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           DBUtils.close(con);
       }
       return users;
   }
}
