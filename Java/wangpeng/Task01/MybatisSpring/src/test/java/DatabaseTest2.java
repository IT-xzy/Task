import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Author: 老王
 * Date: 2019/4/12 16:12
 */

public class DatabaseTest2 {

    //        配置数据库连接参数，以及SQL语句
    private String sql = "insert into Contact value(null,?,?,?,?)";

    //     useServerPrepStmts即预编译提交，这里设置成了false就是阻止程序默认的自动编译SQL语句
//     后面的rewriteBatchedStatement就是批量处理的核心语句了
//     因为jdbc在默认情况下是将这个方法的参数值设置称为false的
//     当我们在连接声明的时候将其设置为true时，程序就能执行批次处理语句了
//     这里是批量插入的关键所在，如果去掉的话就只能执行普通批次的插入了
    private String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai" +
            "&useServerPrepStmts=false&rewriteBatchedStatements=true&useSSL=false";
    private String name = "root";
    private String password = "1201";

    public void doStore() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
//        这里将系统默认的自动事务提交关闭了，所以程序执行的时候，插入数据不会实时动态提交到mysql
        conn.setAutoCommit(false);
//        计数变量
        int count = 0;
//        预编译SQL语句
        PreparedStatement ps = conn.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            ps.setString(1, "玛丽");
            ps.setString(2, "mali.cn");
            ps.setInt(3, 666);
            ps.setString(4, "女");
//            加入批量处理
            ps.addBatch();
            count++;
        }
//        执行批量处理
        ps.executeBatch();
//        事务提交
        conn.commit();
        long end = System.currentTimeMillis();
        System.out.println("数量=" + count);
        System.out.println("插入时间：" + (end - start) / 1000 + "秒");
//        连接关闭
        conn.close();
    }

    public static void main(String[] args) {
        try {
            new DatabaseTest2().doStore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
