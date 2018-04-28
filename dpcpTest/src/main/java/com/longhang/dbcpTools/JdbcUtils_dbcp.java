package com.longhang.dbcpTools;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils_dbcp
{
    private static DataSource ds=null;
    static
    {
        try {
            InputStream in = JdbcUtils_dbcp.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties prop = new Properties();
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        }
        catch (Exception e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnetion() throws SQLException{
        return ds.getConnection();
    }
    public static void release(Connection conn, Statement st, ResultSet rs)
    {
        if(rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null)
        {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
