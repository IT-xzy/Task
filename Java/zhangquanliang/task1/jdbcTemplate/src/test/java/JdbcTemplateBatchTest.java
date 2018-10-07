import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import utils.DataUtils;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbcTemplate 批量语句
 * @author suger
 * @date 2018-09-14
 */
public class JdbcTemplateBatchTest {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        /*
         * jdbcTemplate.batchUpdate(final String[] sql)
         * 解决多个sql的插入、更新、删除操作在一个Statement中,性能一般
         *
         * jdbcTemplate.batchUpdate(String sql, final BatchPreparedStatementSetter pss)
         * JDBC的PreparedStatement，性能较上着有所提高
          */
        // 插入数据的总数
        final int count = 1000;

        long start = System.currentTimeMillis();
        List<User> userList = new ArrayList<User>(count);
        for(int i = 1;i<=count;i++) {
            User user = new User(DataUtils.getName(), DataUtils.getNumber(10), DataUtils.getProfession(),
                    DataUtils.getDateTime(), DataUtils.getCollege(), DataUtils.getIntNumber(), DataUtils.getLink(),
                    DataUtils.getWish(), DataUtils.getName(), DataUtils.getWay(), DataUtils.getTime(), DataUtils.getTime());
            userList.add(user);
        }
        List<Object[]> params = new ArrayList<>();
        for(User user : userList) {
            params.add(new Object[]{user.getUserName(),user.getQq(),user.getProfession(),user.getStartTime(),
                    user.getGraduatedFrom(),user.getOnlineId(),user.getDailyLink(),user.getWish(),user.getCounselor(),
                    user.getWay(),user.getCreateAt(),user.getUpdateAt()});
        }
        String sql = "insert into user(user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor,way,create_at,update_at)values(?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, params);

       /* jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            //  i 为整个过程中被调用的次数  实际就是 final int count
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                ps.setString(1,DataUtils.getName());
                ps.setString(2,DataUtils.getNumber(10));
                ps.setString(3,DataUtils.getProfession());
                ps.setString(4,DataUtils.getDateTime());
                ps.setString(5,DataUtils.getCollege());
                ps.setInt(6,DataUtils.getIntNumber());
                ps.setString(7,DataUtils.getLink());
                ps.setString(8, DataUtils.getWish());
                ps.setString(9,DataUtils.getName());
                ps.setString(10,DataUtils.getWay());
                ps.setLong(11,DataUtils.getTime());
                ps.setLong(12,DataUtils.getTime());
            }
            @Override
            //返回更新的结果集条数
            public int getBatchSize() {
                return count;
            }
        });*/

        long end = System.currentTimeMillis();
        System.out.println(String.format("插入%d条数据，耗时：%ds", count, (end-start)/100));


    }
}
