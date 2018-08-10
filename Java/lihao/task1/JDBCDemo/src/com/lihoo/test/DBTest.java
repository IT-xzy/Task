/**
 * @Title: DBTest
 * @ProjectName JDBCDemo
 * @Description: TODO
 * @author lihoo
 * @date 2018/7/912:34
 */

package com.lihoo.test;

        import java.sql.*;

public class DBTest {
    //mysql 驱动包
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private  static final String URL = "jdbc:mysql://localhost:3306/student_task";
    //user_name
    private static final String USER_NAME = "root";
    //password
    private static final String PASSWORD = "774835";


    public static void main(String[] args){
        Connection connection = null;
        try {
            //加载SQL驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL,USER_NAME, PASSWORD);
            //mysql查询语句
            String sql = "SELECT std_name FROM std_list_1";
            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                System.out.println("用户名：" + rs.getString("std_name"));
            }
            rs.close();
            prst.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
