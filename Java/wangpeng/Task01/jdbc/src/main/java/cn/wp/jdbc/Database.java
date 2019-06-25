/**
 * Author: 老王
 * Date: 2019/4/13 21:56
 */
package cn.wp.jdbc;

import java.sql.*;

public class Database {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet ret = null;
        //jdbc驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //连接数据库
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "1201";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            stmt = con.createStatement();
            ret = stmt.executeQuery("select * from demo");
            while (ret.next()) {
                String id = ret.getString("id");
                String name = ret.getString("name");
                String qq = ret.getString("qq");
                String school = ret.getString("school");
                System.out.println("ID：" + id);
                System.out.println("姓名：" + name);
                System.out.println("QQ：" + qq);
                System.out.println("学校：" + school);
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        //依次关闭数据库连接资源
        finally {
            if (ret != null) {
                try {
                    ret.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}