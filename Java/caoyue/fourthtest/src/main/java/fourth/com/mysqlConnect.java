package fourth.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysqlConnect {
    /**
     * 获取连接
     */
    public static Connection getconnection() {
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabases?characterEncoding=UTF-8";
        String user = "root" ;
        String password = "root";
        Connection con = null ;
        try {

            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con ;
    }

    /**
     * 关闭连接
     */
    public static void free(ResultSet rs, Statement sta, Connection con) {
        try {
            if(null != sta) {
                sta.close();
                sta = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(null != con) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
