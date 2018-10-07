import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * jdbcTemplate的CRUD demo
 * @author suger
 * @date 2018-09-13
 */
public class JdbcTemplateDemo {
    // --------------日志初始化------------------
    static Logger log = Logger.getLogger("JdbcTemplate");

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        // ------------插入方法---------
        User user1 = new User();
        user1.setUserName("金石开");
        user1.setQq("1050376715");
        user1.setProfession("产品经理");
        user1.setStartTime("2018-07-10");
        user1.setGraduatedFrom("北京师范大学");
        user1.setOnlineId(1359);
        user1.setDailyLink("http://www.jnshu.com/school/28015/daily");
        user1.setWish("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2斤！");
        user1.setCounselor("李天宇");
        user1.setWay("朋友推荐");

        Long time = new Date().getTime();
        user1.setCreateAt(time);
        user1.setUpdateAt(time);
        String sql = "insert into user(user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor,way,create_at,update_at)values(?,?,?,?,?,?,?,?,?,?,?,?)";

        //   转为实体类 插入  采用属性化为数组的方法
        Object[] objects = new Object[]{user1.getUserName(), user1.getQq(), user1.getProfession(), user1.getStartTime(),
                user1.getGraduatedFrom(), user1.getOnlineId(), user1.getDailyLink(), user1.getWish(), user1.getCounselor(),
                user1.getWay(), user1.getCreateAt(), user1.getUpdateAt()};
        log.info("插入："+jdbcTemplate.update(sql,objects));

        // -------------更新方法---------
        sql = "update user set profession = ?,wish = ? where user_id = ? ";
        // ------------单独属性插入测试-----------
        log.info("更新，受影响的行："+jdbcTemplate.update(sql,"前端","养活自己",199999L));

        // -------------删除方法------------
        sql = "delete from user where user_id = ?";
        log.info("删除，受影响的行："+jdbcTemplate.update(sql,15000L));

        //  --------------查询方法----------
        // 根据姓名 查询
        sql = "select * from user where user_name like '金石开%'";

        final List<User> users = new ArrayList<User>();
        System.out.println("-----------queryForList 开始------------");
        List list = jdbcTemplate.queryForList(sql);
        log.info(list);

        System.out.println("-----------重写ReSet------------");
        User user = new User();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getLong("user_id"));
                user.setUserName(rs.getString("user_name"));
               /* user.setQq(rs.getString("qq"));
                user.setProfession(rs.getString("profession"));
                user.setStartTime(rs.getString("start_time"));
                user.setGraduatedFrom(rs.getString("graduated_from"));
                user.setOnlineId(rs.getInt("online_id"));
                user.setDailyLink(rs.getString("daily_link"));
                user.setWish(rs.getString("wish"));
                user.setWay(rs.getString("way"));
                user.setCreateAt(rs.getLong("create_at"));
                user.setUpdateAt(rs.getLong("update_at"));*/
                users.add(user);
            }
        });
        log.info("根据姓名查询："+users);

    }
}
