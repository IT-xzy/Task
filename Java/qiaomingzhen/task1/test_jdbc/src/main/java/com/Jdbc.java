package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 14:41$
 **/
public class Jdbc {
    static String URL = "jdbc:mysql://hahaha:3306/two?rewriteBatchedStatements=true";
    static String USER = "Ubuntu";
    static String PASSWORD = "123456";

    //批量插入
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement pst = null;
        //批量插入
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //将事务的提交设为手动提交
            connection.setAutoCommit(false);
            String sql = "insert into user (name,type) values (?,?)";
            pst = connection.prepareStatement(sql);
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 300000; i++) {
                pst.setString(1, "小黄");
                pst.setString(2, "web");
                //Statement.addBatch() 方法为调用语句的命令列表添加一个元素。通过循环将sql命令添加到一个批处理
                pst.addBatch();
                if (i % 1000 == 0) {
                    //提交一批sql执行语句
                    Long time1 = System.currentTimeMillis();
                    pst.executeBatch();
                    pst.clearBatch();
                    connection.commit();
                    System.out.println("时间======" + (System.currentTimeMillis() - time1));
                }
            }
            System.out.println("插入成功");
            pst.executeBatch();
            //提交事务
            connection.commit();
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("出错");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出错");
        } finally {
            connection.commit();
            if (pst != null) {
                pst.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}
