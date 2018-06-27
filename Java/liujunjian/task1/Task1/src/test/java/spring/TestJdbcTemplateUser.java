package spring;

import com.jdbcTemplate.JdbcTemplateUser;
import com.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcTemplateUser {
    private JdbcTemplateUser jdbcTemplateUser;

    @Before
    public void setJdbcTemplateUser() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("userBean.xml");
        jdbcTemplateUser=context.getBean(JdbcTemplateUser.class);
    }

    @Test
    public void testFindUserById() {
        jdbcTemplateUser.findUserById(1);
    }

    @Test
    public void testFindUserByName() {
        jdbcTemplateUser.findUserByName("%胜%");
    }

    @Test
    public void testFindUserByNumber() {
        jdbcTemplateUser.findUserByNumber("%234%");
    }

    @Test
    public void testFindUsers() {
        jdbcTemplateUser.findUsers();
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        Long time = System.currentTimeMillis();
        user.setName("陈");
        user.setNumber("67845");
        user.setCreate_at(time);
        user.setUpdate_at(time);
        jdbcTemplateUser.insertUser(user);
    }

    @Test
    public void testDeleteUser() {
        jdbcTemplateUser.deleteUser(20);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        Long time = System.currentTimeMillis();
        user.setId(4);
        user.setName("陈");
        user.setNumber("67845");
        user.setUpdate_at(time);
        jdbcTemplateUser.updateUser(user);
    }
}
