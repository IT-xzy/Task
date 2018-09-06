package com.jnshu;

import myBatis.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class myBatisTest {
    @Test
    public void findUserByIdTest() throws SQLException {
        //myBatis的配置文件
        String resource = "config.xml";
        //使用类加载器加载myBatis的配置文件（它也加载关联的映射文件）
        InputStream is = AppTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查，每一个SqlSession代表一次与数据库的对话，
        SqlSession session = sessionFactory.openSession();
        String statement = "myBatis.UserMapper.findUserById";
        //给user 赋值 传参数2 最后输出id=2的对象
        User user = session.selectOne(statement, 1);

        System.out.println(user);
        session.close();

    }

    @Test
    public void findAllTest() {
        String resource = "config.xml";
        InputStream is = AppTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "myBatis.UserMapper.findAll";

        List<User> users = session.selectList(statement);

        System.out.println(users);
        session.close();
    }

    @Test
    public void deleteTest() {
        String resource = "config.xml";
        InputStream is = AppTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "myBatis.UserMapper.deleteUser";
        int a = session.delete(statement, 12);
        if (a > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        session.commit();
        session.close();
    }

    @Test
    public void addUser() {
        String resource = "config.xml";
        InputStream is = AppTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "myBatis.UserMapper.addUser";
        User user = new User();
        user.setName("阿卡华盛顿");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        user.setQq(12345678);
        user.setCourse_type("java");
        user.setEntrance_time(18273123);
        user.setGraduate_school("北京师范大学");
        user.setWish(4487);
        user.setDaily_link("www.jnshu.com/school/28015/daily.");
        user.setSet_to("变胖两斤");
        user.setBrother("李天宇");
        user.setLearn("朋友推荐");
        session.insert(statement, user);
        System.out.println(user.getId());
        session.commit();
        session.close();
    }

    @Test
    public void updateUserTest() {
        String resource = "config.xml";
        InputStream is = AppTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "myBatis.UserMapper.updateUser";
        User user = new User();
        user.setId(50);
        user.setName("小蜜蜂");
        user.setUpdate_at(System.currentTimeMillis());
        user.setQq(1050376715);
        user.setCourse_type("java");
        user.setEntrance_time(18273123);
        user.setGraduate_school("北京师范大学");
        user.setWish(4487);
        user.setDaily_link("www.jnshu.com/school/28015/daily.");
        user.setSet_to("老大最帅");
        user.setBrother("李天宇");
        user.setLearn("朋友推荐");
        int i = session.delete(statement, user);
        if (i > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        session.commit();
        session.close();
    }
}
