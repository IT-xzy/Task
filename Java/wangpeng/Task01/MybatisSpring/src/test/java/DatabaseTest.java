import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Author: 老王
 * Date: 2019/4/11 21:53
 */

public class DatabaseTest {

    static Logger logger = Logger.getLogger(String.valueOf(DatabaseTest.class));

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai",
                    "root", "1201");
//           当前时间戳
            long start = System.currentTimeMillis();

            String sql = "insert into Contact values(null,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "阿妹");
            preparedStatement.setString(2, "jj.cn");
            preparedStatement.setInt(3, 111);
            preparedStatement.setString(4, "女");
//            自动提交
            connection.setAutoCommit(false);
            for (int i = 1; i <= 10000; i++) {
                if (i % 1000 != 0) {
//                    加入批量处理
                    preparedStatement.addBatch();
                } else {
                    logger.info(String.valueOf(i));
//                    执行批量处理
                    preparedStatement.executeBatch();
//                    事务提交
                    connection.commit();
                }
            }
            long end = System.currentTimeMillis();
            logger.info("插入时间：" + (end - start) / 1000 + "秒");
            preparedStatement.close();
//            连接关闭
            connection.close();
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

