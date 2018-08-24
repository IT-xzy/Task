import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    @Test
    public void Test() throws SQLException {
        Connection conn = JDBC.getConnection("xiuzhen","root","8891960");
        if (conn!=null) {
            System.out.println("获取连接成功");
            insert(conn);
        }else {
            System.out.println("获取连接失败");
        }
    }
    public static void insert(Connection conn) throws SQLException {
        long StartTime = System.currentTimeMillis();
        // sql前缀
        String prefix = "insert into signup(name,qq) values";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement  pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 100000; j++) {
                    // 构建SQL后缀
                    suffix.append("('" +"小小','123456'" +"),");
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        //Long end = new Date().getTime();
        // 耗时
//        System.out.println("1000万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
//        System.out.println("插入完成");
        long EndTime = System.currentTimeMillis();
        System.out.println("插入1000w:"+(EndTime-StartTime)+"ms");
    }
}
