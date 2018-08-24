import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.*;


public class JDBCTest {
    //日志配置
    Logger logger = Logger.getLogger(JDBCTest.class);
    //查询测试
    @Test
    public void TestJDBC() throws ClassNotFoundException, SQLException {
        Connection conn = JDBC.getConnection("xiuzhen","root","8891960");
        //3.通过数据库的连接操作数据库，实现增删改查（使用PreparedStatement类）
        //sql语句
        String sql = "SELECT * FROM signup where name = ?";
        //pst会更好些
        PreparedStatement  pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1,"小王");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
//            System.out.println("姓名："+rs.getString("name")+" "+
//                    "QQ\t"+rs.getString("qq"));
            logger.info("姓名："+rs.getString("name")+"  QQ："+rs.getString("qq"));
        }
        //关闭资源
        rs.close();
        pst.close();
        conn.close();
    }
    //插入测试
    @Test
    public void InsertTest() throws SQLException {
        Connection conn = JDBC.getConnection("xiuzhen","root","8891960");
        //Statement st=conn.createStatement();
        String sql="insert into signup(name,qq) values(?,?)";
        PreparedStatement  pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1,"西西");
        pst.setInt(2,555555555);
        try {
            //执行 SQL 语句并返回结果
            int result = pst.executeUpdate();
            if (result != 0) {
//                System.out.println("操作成功,受影响" + result + "行");
                logger.info("插入操作成功,受影响" + result + "行");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pst.close();
            conn.close();
        }
    }
    //更新测试
    @Test
    public void Update() throws SQLException {
        Connection conn = JDBC.getConnection("xiuzhen","root","8891960");
        //Statement st=conn.createStatement();
        String sql = "UPDATE signup SET name = ? WHERE name = ?";
        PreparedStatement  pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1,"哈哈");
        pst.setString(2,"西西");
        try {
            //执行 SQL 语句并返回结果
            int result =pst.executeUpdate();
            if (result != 0) {
//                System.out.println("操作成功,受影响" + result + "行");
                logger.info("更新操作成功,受影响" + result + "行");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pst.close();
            conn.close();
        }
    }
    //删除测试
    @Test
    public void Delete() throws SQLException {
        Connection conn = JDBC.getConnection("xiuzhen","root","8891960");
        //Statement st = conn.createStatement();
        String sql = "DELETE FROM signup WHERE name = ?";
        PreparedStatement  pst = (PreparedStatement) conn.prepareStatement(sql);
        pst.setString(1,"哈哈");
        try {
            //执行 SQL 语句并返回结果
            int result = pst.executeUpdate();
            if (result != 0) {
//                System.out.println("操作成功,受影响" + result + "行");
                logger.info("删除操作成功,受影响" + result + "行");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pst.close();
            conn.close();
        }
    }
}
