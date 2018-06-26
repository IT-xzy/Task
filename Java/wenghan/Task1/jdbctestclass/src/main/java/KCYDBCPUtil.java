import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DBCP配置类
 * @author SUN
 */
public class KCYDBCPUtil{
    //为了在静态方法、静态代码块中使用将成员变量设置为静态
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    //加载DBCP配置文件
    static{//在静态代码块中加载连接池的配置文件
        try{//通过反射机制加载配置文件
            properties.load(KCYDBCPUtil.class.getResourceAsStream("/dbcp.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
        try{//将从配置文件读到的信息传入数据源中，将数据源设置为dbcp连接池
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //从连接池中获取一个连接
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = dataSource.getConnection();//通过连接池的数据源获得连接
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {//sql命令的提交由应用程序负责，程序必须调用commit（提交事务）或者rollback（回滚）方法
            connection.setAutoCommit(false);//设置不使用自动提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;//从连接池返回一个连接对象
    }

    public static void main(String[] args) {
        getConnection();//用于测试工具类能否成功返回一个连接对象
    }
}

