import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JDBC {
    public static Connection getConnection(String DBName,String User,String Pwd){
        String URL = "jdbc:mysql://127.0.0.1:3306/"+DBName+"?useUnicode=true&characterEncoding=utf8";
        Connection conn =null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获得数据库链接
        try {
            conn = DriverManager.getConnection(URL,User,Pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
