package springTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserImpl implements UserDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public long add(final User user) {

        final String sql = "INSERT INTO TEST (name ,create_at,update_at,qq,course_type," +
                "entrance_time,graduate_school,wish,daily_link,set_to,brother,learn)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setLong(2, user.getCreate_at());
                ps.setLong(3, user.getUpdate_at());
                ps.setLong(4, user.getQq());
                ps.setString(5, user.getCourse_type());
                ps.setLong(6, user.getEntrance_time());
                ps.setString(7, user.getGraduate_school());
                ps.setLong(8, user.getWish());
                ps.setString(9, user.getDaily_link());
                ps.setString(10, user.getSet_to());
                ps.setString(11, user.getBrother());
                ps.setString(12, user.getLearn());

                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().byteValue();
    }


    @Override
    public boolean delete(long id) {
        String sql = "DELETE  FROM TEST WHERE ID=?";

        if (jdbcTemplate.update(sql, id) > 0) {
            return true;
        } else {

            return false;
        }
    }


    @Override
    public User select(long id) {
        String sql = "SELECT *FROM TEST WHERE ID=?";
        final User u = new User();
        jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                u.setId(resultSet.getLong("id"));
                u.setName(resultSet.getString("name"));
                u.setQq(resultSet.getLong("qq"));
                u.setCourse_type(resultSet.getString("course_type"));
                u.setEntrance_time(resultSet.getLong("entrance_time"));
                u.setGraduate_school(resultSet.getString("graduate_school"));
                u.setWish(resultSet.getLong("wish"));
                u.setDaily_link(resultSet.getString("daily_link"));
                u.setSet_to(resultSet.getString("set_to"));
                u.setBrother(resultSet.getString("brother"));
                u.setLearn(resultSet.getString("learn"));
                return u;

            }
        }, id);
        return u;
    }


    @Override
    public String findUser() {
        String sql = "SELECT *FROM TEST";
        final List<User> users = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                User user =new User();

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setCreate_at(resultSet.getLong("create_at"));
                user.setUpdate_at(resultSet.getLong("update_at"));
                user.setQq(resultSet.getLong("qq"));
                user.setCourse_type(resultSet.getString("course_type"));
                user.setEntrance_time(resultSet.getLong("entrance_time"));
                user.setGraduate_school(resultSet.getString("graduate_school"));
                user.setWish(resultSet.getLong("wish"));
                user.setDaily_link(resultSet.getString("daily_link"));
                user.setSet_to(resultSet.getString("set_to"));
                user.setBrother(resultSet.getString("brother"));
                user.setLearn(resultSet.getString("learn"));
                users.add(user);
            }
        });

        return users.toString();
    }


    @Override
    public boolean update(User user) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "UPDATE TEST SET name=?,create_at=?,update_at=?,qq=?,course_type=?,entrance_time=?,graduate_school=?,wish=?,daily_link=?,set_to=?,brother=?,learn=? WHERE ID=?";
        int a = 0;
        a = jdbcTemplate.update(sql, user.getName(), user.getCreate_at(), user.getUpdate_at(), user.getQq(), user.getCourse_type(), user.getEntrance_time(), user.getGraduate_school(),
                user.getWish(), user.getDaily_link(), user.getSet_to(), user.getBrother(), user.getLearn(), user.getId());
        if (a > 0) {
            return true;
        }

        return false;
    }


}
