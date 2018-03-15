package com.myJDBC.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Arike
 * Create_at  2017/11/14 15:29
 */
public class JdbcUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    
    private JdbcUtil() {
    }
    
    static {
        try {
            //从配置文件中读取驱动,url和账户名密码等.
            Properties p = new Properties();
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
            p.load(in);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //加载驱动并且,获取连接工具,
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
    
  /* 获取结果集工具用以查询
    public static ResultSet getResultset(String str) throws Exception {
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(str);
        return rs;
    }*/
    
    public static void close(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
