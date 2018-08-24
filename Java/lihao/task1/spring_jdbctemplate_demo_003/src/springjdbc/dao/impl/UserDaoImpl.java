package springjdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import springjdbc.dao.UserDao;
import springjdbc.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihoo
 * @Title: UserDaoImpl
 * @ProjectName spring_demo_003
 * @Description: TODO
 * @date 2018/7/14-18:20
 */


public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    public List<User> findAllUser() {
        String sql = "select * from myspringjdbcdb";
        final List<User> listAllUser = new ArrayList<User>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                User u = new User();
                u.setuName(resultSet.getString("u_name"));
                u.setuPassword(resultSet.getString("u_password"));
                u.setuId(resultSet.getString("u_id"));
                listAllUser.add(u);
            }
        });
        return listAllUser;
    }

@Override
public void create(String id, String name, String password) {
        String SQL = "insert into myspringjdbcdb (u_id, u_name, u_password) values (?,?,?)";
        jdbcTemplate.update(SQL, id, name, password);
        System.out.println("Create Record Id = " + id + "Name = " name + "Password = " + password);
}

@Override
    public void execInsert(String sql) {
        jdbcTemplate.execute(sql);
}

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


}


