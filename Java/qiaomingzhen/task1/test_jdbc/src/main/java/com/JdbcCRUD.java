package com;

import java.sql.*;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/29$ 15:16$
 **/
public class JdbcCRUD {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         * URL：数据库连接地址
         * USER：用户名
         * PASSWORD：密码
         * */
        String URL = "jdbc:mysql://hahaha:3306/two";
        String USER = "Ubuntu";
        String PASSWORD = "123456";
        //加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库链接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        //查
        String sql = "select type from user where id=10";
        // 创建Statement，向数据库发送sql语句select
        Statement pst = connection.createStatement();
        //处理数据库执行结果
        ResultSet rs = pst.executeQuery(sql);
        while (rs.next()) {
            System.out.println("id=10的修真类型====" + rs.getString("type"));
        }
        rs.close();
        pst.close();

        //insert增
        String sql2 = "insert into user (name) values ('呵呵')";
        PreparedStatement pst2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
        pst2.executeUpdate();
        ResultSet rs1 = pst2.getGeneratedKeys();
        while (rs1.next()) {
            int id = rs1.getInt(1);
            System.out.println("插入成功，新增用户id=====" + id);
        }
        rs1.close();
        pst2.close();
        //delete删
        PreparedStatement pst1 = connection.prepareStatement("delete from user where name=?");
        pst1.setString(1, "哈哈");
        int i = pst1.executeUpdate();
        if (i > 0) {
            System.out.println("删除成功");
        }
        pst1.close();
        //update改
        PreparedStatement pst4 = connection.prepareStatement("update user set name=? where id=10");
        pst4.setString(1, "江大白");
        int t = pst4.executeUpdate();
        if (i > 0) {
            System.out.println("更新成功");
        }
        pst4.close();
        connection.close();
    }
}

