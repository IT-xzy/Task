import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    static {
        try{
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }
    public static void release(Connection conn, Statement st, ResultSet rs){
        if (rs !=null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            rs = null;
        }
        if (st!=null){
            try{
                st.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            st = null;
        }
        if (conn!=null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
