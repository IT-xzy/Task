package fourth;

import java.sql.*;

/**
 * Hello world!
 */
public class App //定义一个类APP;
{
    public static void main(String[] args)  //主体函数无返回值;
    {
        Connection c = null;  //定义一个connection对象，代表一个数据库的物理连接;
        Statement s = null;    //定义一个statement对象;
        try {
            Class.forName("com.mysql.jdbc.Driver");  //注册JDBC驱动程序;
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mydatabases?characterEncoding=UTF-8",
                    "root", "root"); //驱动自带的方法，需要数据库名字，用户名，密码;
            s = c.createStatement();                 //用于执行静态SQL语句并返回它所生成的statement对象;
//            String sql = "insert into student values (11,NOW(),NOW(),'韩阳','www.baidu.com',123456, 'PM123','123@qq.com',133123, '20170310', 'PM' ,'梁家健','一姐最胖')";
//            String sql = "delete from student where ID=11";
//            String sql = "update student set name='韩大师' where ID=11";
            String sql = "select * from student";   //静态SQL语句;
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);     //执行sql语句并将结果放到结果集中;
            while (rs.next()) {
                int id = rs.getInt("ID"); //可以使用字段名，从结果集中获取所需对象
                String name = rs.getString(4); //也可以使用字段的顺序，从结果集中获取所需对象
                System.out.printf("%d\t%s%n", id, name);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();
//            s.execute(sql);
//            System.out.println("执行插入语句成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hello");
        } finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null) {
                try {
                    s.close();
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 后关闭Connection
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
    }
}
