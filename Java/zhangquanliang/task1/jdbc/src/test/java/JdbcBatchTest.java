import com.suger.util.DBUtils;
import com.suger.util.DataUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 关于jdbc的批量插入演示
 * @author suger
 * @date 2018-09-12
 */
public class JdbcBatchTest {

    public static void main(String[] args) throws SQLException {

        // 添加开始--------------
        long start = System.currentTimeMillis();
        String sql = "INSERT INTO user(user_name,qq,profession,start_time,graduated_from,online_id," +
                "daily_link,wish,counselor,way,create_at,update_at)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        //申明JDBC变量
        Connection con = DBUtils.open();
        PreparedStatement ps = con.prepareStatement(sql);
        con.setAutoCommit(false);

        /*
         * 生成数据总量为count*batchSize
         * count ：循环次数
         * batchSize：每次提交的数据量
         */

        final int count = 20;
        //每次提交的数据量
        final int batchSize = 50;
        for (int i = 0; i < count; i ++) {
            ps.clearBatch();
            for (int j = 0; j < batchSize; j++) {
                ps.setString(1, DataUtils.getName());
                ps.setString(2, DataUtils.getNumber(10));
                ps.setString(3, DataUtils.getProfession());
                ps.setString(4, DataUtils.getDateTime());
                ps.setString(5, DataUtils.getCollege());
                ps.setInt(6, DataUtils.getIntNumber());
                ps.setString(7, DataUtils.getLink());
                ps.setString(8, DataUtils.getWish());
                ps.setString(9, DataUtils.getName());
                ps.setString(10, DataUtils.getWay());
                ps.setLong(11, DataUtils.getTime());
                ps.setLong(12, DataUtils.getTime());
                ps.addBatch();
            }
           ps.executeBatch();
            if ((i + batchSize - 1) % count == 0) {
                con.commit();
            }
            con.commit();
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("插入%d条数据，耗时：%ds", count*batchSize, (end - start) / 1000));
        // 关闭连接
        DBUtils.close(con);
    }
}

