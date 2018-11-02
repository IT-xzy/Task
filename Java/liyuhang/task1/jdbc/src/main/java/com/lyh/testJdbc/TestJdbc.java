package com.lyh.testJdbc;

import com.lyh.utils.JdbcUtils;
import com.mysql.jdbc.Statement;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbc {
    private static org.apache.log4j.Logger logger = Logger.getLogger(Test.class);
    //根据删除数据
    @Test
    public void delete(){
        String sql = "delete from student where id = ?";
        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement ps  = conn.prepareStatement(sql);
            ps.setInt(1,2);
            boolean x = ps.execute();
            if(x != true) {
                logger.debug("true");
            } else {logger.debug("false");
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据id修改数据
    @Test
    public void update(){
        String sql = "update student set name = ?,qq = ? ,wish = ?,school = ?,enrolment_time = ?,type = ?,know_from = ?,create_at = ?,update_at = ? where id = ?";
        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"李海");
            ps.setInt(2,87645);
            ps.setString(3,"成功");
            ps.setString(4,"职业技术学院");
            ps.setInt(5,398);
            ps.setString(6,"java");
            ps.setString(7,"网络");
            ps.setInt(8,421);
            ps.setInt(9,2134);
            ps.setInt(10,2);
            int x =ps.executeUpdate();
            conn.close();
            if (x != 0){
                logger.info("true");
            }else {logger.info(false);}
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //查询数据库表全部数据
    @Test
    public void selectAll(){
        String sql = "select * from student";
        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qq = rs.getInt(3);
                String wish = rs.getString(4);
                String school = rs.getString(5);
                int enrolment_time = rs.getInt(6);
                String type = rs.getString(7);
                String know_from = rs.getString(8);
                int create_at = rs.getInt(9);
                int update_at = rs.getInt(10);
                logger.debug(id + "-_" + name + "-_" + qq + "-_" + wish + "-_" + school + "-_" + enrolment_time + "-_" + type + "-_" + know_from + "-_" + create_at + "-_" + update_at);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据学生名字和学生学号查询报名帖
   @Test
    public void selectByIdAndName(){
        String sql = "select * from student where id = ? and name=?";
        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setString(2,"l李");
            //结果集
            ResultSet rs = ps.executeQuery();
            //遍历
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qq = rs.getInt(3);
                String wish = rs.getString(4);
                String school = rs.getString(5);
                int enrolment_time = rs.getInt(6);
                String type = rs.getString(7);
                String know_from = rs.getString(8);
                int create_at = rs.getInt(9);
                int update_at = rs.getInt(10);
                //打印
                logger.debug(id+"-_"+name+"-_"+qq+"-_"+wish+"-_"+school+"-_"+enrolment_time+"-_"+type+"-_"+know_from+"-_"+create_at+"-_"+update_at);
            //返回结果集不用再关闭连接

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //批量插入数据
    @Test
    public void insert(){
        long start = System.currentTimeMillis();
        String prefix = "insert into student(name,qq,wish,school,enrolment_time,type,know_from,create_at,update_at)values";
        //保存sql后缀
        StringBuffer suffix = new StringBuffer();
        //通过实例化调用连接数据库的连接工具类
        Connection conn = JdbcUtils.getConn();
        try {
            //设置事物非自动提交
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("");
            //外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                //第次提交步长，总提交数据量为i*j
                for(int j = 1;j <= 1000;j++){
                    //构建sql后缀
                    suffix.append("('斯祥'," + 123456 + ",'即可了','就会'," + 456 + ",'java','后来'," + 9788 + "," + 954 + "),");
                }
                //构建完整sql语句
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                //添加执行sql
                ps.addBatch(sql);
                ps.executeBatch();
                //提交事务

                //清空上一次添加的数据
                 suffix = new StringBuffer();
            }
            conn.commit();
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //获取结束时间
        long end = System.currentTimeMillis();
        logger.debug("程序运行时间：" + (end - start) + "ms");
    }
    //插入数据返回自增长id
    @Test
    public void insertOne(){
        String sql = "insert into student(name,qq,wish,school,enrolment_time,type,know_from,create_at,update_at) values(?,?,?,?,?,?,?,?,?)";
        Connection conn = JdbcUtils.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"李封");
            ps.setInt(2,2836856);
            ps.setString(3,"养活自己");
            ps.setString(4,"工业大学");
            ps.setInt(5,2017_03_23);
            ps.setString(6,"java");
            ps.setString(7,"网络");
            ps.setInt(8,9775);
            ps.setInt(9,9223);
            // 执行插入语句
            ps.execute();

            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                logger.debug("新增id：" + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
