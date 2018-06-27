package mybatis;

import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class TestUserInMapperXml {
    private SqlSessionFactory sqlSessionFactory;

    @Before //创建sqlSessionFactory
    public void setSqlSessionFactory() throws Exception {
        String resource = "mybatis-config.xml"; //mybatis配置文件
        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂SqlSessionFactory,要传入mybatis的配置文件的流
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        User user = userDao.findUserById(1);
        User user = sqlSession.selectOne("com.pojo.User.findUserById", 1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> list = userDao.findUserByName("宋");
        List<User> list = sqlSession.selectList("com.pojo.User.findUserByName", "宋");
        sqlSession.close();
        Iterator user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    @Test
    public void testFindUserByNumber() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> list = userDao.findUserByNumber("42");
        List<User> list = sqlSession.selectList("com.pojo.User.findUserByNumber", "42");
        sqlSession.close();
        Iterator user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    @Test
    public void testFindUsers() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> list = userDao.findUsers();
        List<User> list = sqlSession.selectList("com.pojo.User.findUsers");
        sqlSession.close();
        Iterator users = list.iterator();
        while (users.hasNext()) {
            System.out.println(users.next());
        }
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Long time = System.currentTimeMillis();
        User user = new User();
//        user.setId(7);
        user.setName("王尼玛");
        user.setNumber("235314");
        user.setCreate_at(time);
        user.setUpdate_at(time);
//        userMapper.insertUser(user);
        sqlSession.insert("com.pojo.User.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("插入成功！id=" + user.getId());
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        userDao.deleteUser(13);
        int i = sqlSession.insert("com.pojo.User.deleteUser", 10);
        sqlSession.commit();
        sqlSession.close();
        if (i > 0) {
            System.out.println("true！成功删除" + i + "条数据");
        }
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Long time = System.currentTimeMillis();
        User user = new User();
        user.setId(12);
        user.setName("一毛钱");
        user.setNumber("235314");
        user.setUpdate_at(time);
        int i = sqlSession.insert("com.pojo.User.updateUser", user);
//        userDao.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
        if (i > 0) {
            System.out.println("true！成功更新" + i + "条数据");
        }
    }
}

