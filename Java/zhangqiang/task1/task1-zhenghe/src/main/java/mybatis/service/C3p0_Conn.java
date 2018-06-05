package mybatis.service;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
/*
 *
 * 测试连接池
 *
 * 连接池控制类
 *
 */

@Component
public class C3p0_Conn {

    private static ComboPooledDataSource dataSource = null;
    private static Properties properties = null;
    private static C3p0_Conn c3p0_conn;

    static {

        c3p0_conn = new C3p0_Conn();
        dataSource = new ComboPooledDataSource();
        properties = new Properties();

        try {

            properties.load(C3p0_Conn.class.getClassLoader().getResourceAsStream("c3p0.properties"));

            System.out.print("\n\n" + properties.getProperty("driverClass") + "\n\n");

            dataSource.setDriverClass(properties.getProperty("driverClass"));
            dataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
            dataSource.setUser(properties.getProperty("user"));
            dataSource.setPassword(properties.getProperty("password"));

            dataSource.setMaxPoolSize(Integer.parseInt(properties.getProperty("max_size")));
            dataSource.setMinPoolSize(Integer.parseInt(properties.getProperty("min_size")));
            dataSource.setInitialPoolSize(Integer.parseInt(properties.getProperty("initialPoolSize")));
            dataSource.setMaxStatements(Integer.parseInt(properties.getProperty("max_statements")));
            dataSource.setMaxIdleTime(Integer.parseInt(properties.getProperty("maxIdleTime")));

        }catch (Exception e){
            e.fillInStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public Connection getConn(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return conn;
    }

    public void closeConn(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
