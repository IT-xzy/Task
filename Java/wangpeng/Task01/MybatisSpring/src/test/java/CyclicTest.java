import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Author: 老王
 * Date: 2019/4/11 18:16
 */

public class CyclicTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();//获取程序执行循环开始时间
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 1000; i++) {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai",
                        "root", "1201");
                Statement statment = connection.createStatement();
                statment.execute("SELECT * from Contact");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("未连接");
        }
        long end = System.currentTimeMillis();//获取程序执行循环完毕时间
        System.out.println("使用连接池程序执行时间：" + (end - start) + "毫秒");//程序执行共耗时
    }
}
