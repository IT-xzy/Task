package JDBCTemplate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TemplateDemo {

        static Connection conn;
        private static String url;
        private static String name;
        private static String password;
        private static String driver;
        static{
            GetProperties q=new GetProperties();
            Properties prop=q.GetProp();
            driver=prop.getProperty("driver");
            url=prop.getProperty("url");
            name=prop.getProperty("name");
            password=prop.getProperty("password");
               }
        public Connection open(){
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                conn= DriverManager.getConnection(url,name,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            System.out.println("连接成功");
            return conn;
        }
   /*     public static void main(String[] args) {
           TemplateDemo con=new TemplateDemo();
           con.open();
        }*/



}