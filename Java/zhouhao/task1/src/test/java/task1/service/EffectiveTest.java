package task1.service;

import org.junit.Test;

import java.sql.*;
import java.util.Random;

public class EffectiveTest {
    //URL追加属性，开启批量处理功能
    private String url = "jdbc:mysql:" +
            "//localhost:3306/mydata?rewriteBatchedStatements=true";
    private String user = "root";
    private String passWord = "ZH12345";

    @Test
    public void run() {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passWord);
            //关闭事务自动提交
            conn.setAutoCommit(false);
            //随机数用于随机区别数据
            Random random = new Random();

            String sql = " insert into student (name,senior,noturl) " +
                    "value (?,?,'www')";
            pst = conn.prepareStatement(sql);
            int a, b;
            long start = System.currentTimeMillis();
            //外层循环控制总事务提交次数  100
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 10000; j++) {
                    a = random.nextInt(10);
                    b = random.nextInt(10);
                    pst.setString(1, "周浩" + a);
                    pst.setString(2, "" + b);
                    //添加执行语句
                    pst.addBatch();
                }
                //批量执行语句
                pst.executeBatch();
                conn.commit();
            }
            long time = System.currentTimeMillis() - start;
            System.out.println("插入完成，执行时间：" + time);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
