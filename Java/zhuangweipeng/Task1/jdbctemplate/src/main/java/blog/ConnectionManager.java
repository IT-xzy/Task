package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://localhost:3306/jdbctemplate?useUnicode=true&characterEncoding=utf8";//autoReconnect=true&
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASSWORD="root123";
    public static Connection getConnection(){
        Connection dbConn = null;
        try{
            Class.forName(DRIVER_CLASS);
            dbConn = DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dbConn;
    }
    public static void closeConnection(Connection conn) {
        try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeStatement(PreparedStatement pstment){
        try{
            pstment.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}