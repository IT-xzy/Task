package db;

import java.sql.* ;

// 主要功能就是连接数据库、关闭数据库
public class DataBaseConnection{
    //定义数据库驱动类
    private final String DBDRIVER = "com.mysql.jdbc.Driver" ;
    //定义数据库连接URL
    private final String DBURL = "jdbc:mysql://localhost:3306/javaweb" ;
    //定义数据库连接用户名
    private final String DBUSER = "root" ;
    //定义数据库连接密码
    private final String DBPASSWORD = "root" ;
    //定义数据库连接对象
    private Connection conn = null ;
    //构造方法，加载驱动
    public DataBaseConnection(){
        try{
            Class.forName(DBDRIVER) ;
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
        }
        catch (Exception e){
            System.out.println("加载驱动失败");
        }
    }
    // 取得数据库连接
    public Connection getConnection(){
        return conn ;
    }
    // 关闭数据库连接
    public void close(){
        try{
            conn.close() ;
        }catch (Exception e){
            System.out.println("数据库连接关闭失败");
        }
    }
}
