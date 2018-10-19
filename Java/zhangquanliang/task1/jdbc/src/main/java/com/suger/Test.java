package com.suger;


import com.suger.pojo.User;
import com.suger.util.DBUtils;
import com.suger.util.DataUtils;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @author suger
 * @date 2018-09-22
 */
public class Test {
    static Logger log = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        //调用次数
        int count =10;
        long start = System.currentTimeMillis();
        for(int i=0;i<count;i++){
            test();
        }
        long end = System.currentTimeMillis();
        log.info(String.format("插入%d条数据，耗时：%ds", count, (end - start) / 1000));
    }

    public static void test() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

       String sql = "insert into user(user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish," +
               "counselor,way,create_at,update_at) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        User user = new User();
        user.setUserName(DataUtils.getName());
        user.setQq(DataUtils.getNumber(10));
        user.setProfession(DataUtils.getProfession());
        user.setStartTime(DataUtils.getDateTime());
        user.setGraduatedFrom(DataUtils.getCollege());
        user.setOnlineId(DataUtils.getIntNumber());
        user.setDailyLink(DataUtils.getLink());
        user.setWish(DataUtils.getWish());
        user.setCounselor(DataUtils.getProfession());
        user.setWay(DataUtils.getWay());
        user.setCreateAt(DataUtils.getTime());
        user.setUpdateAt(DataUtils.getTime());

        try {
            // 获取连接
            con = DBUtils.open();

            //设置手动提交
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            ps.executeUpdate();
            // 所有sql执行成功，提交事务·
            con.commit();
            rs = ps.getGeneratedKeys();
            rs.next();
            Long id = rs.getLong(1);
            log.info("插入ID："+id);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //只要有一个sql语句出现错误，则将事务回滚
                con.rollback();
            } catch (SQLException e1) {
                if(log.isDebugEnabled()){
                    log.debug("事务失败",e1);
                }
            }
        } finally {
            //关闭 connection 连接
           DBUtils.close(rs,ps,con);
        }
    }
}
