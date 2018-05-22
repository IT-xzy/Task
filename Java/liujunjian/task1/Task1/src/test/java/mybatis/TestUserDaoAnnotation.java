package mybatis;

import com.dao.UserDao;
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

public class TestUserDaoAnnotation {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setSqlSessionFactory() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(2);
//        User user = sqlSession.selectOne("com.pojo.User.findUserById", 1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findUserByName("宋");
//        List<User> list = sqlSession.selectList("com.pojo.User.findUserByName", "宋");
        sqlSession.close();
        Iterator user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    @Test
    public void testFindUserByNumber() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findUserByNumber("234");
//        List<User> list = sqlSession.selectList("com.pojo.User.findUserByNumber", "42");
        sqlSession.close();
        Iterator user = list.iterator();
        while (user.hasNext()) {
            System.out.println(user.next());
        }
    }

    @Test
    public void testFindUsers() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findUsers();
//        List<User> list = sqlSession.selectList("com.pojo.User.findUsers");
        sqlSession.close();
        Iterator users = list.iterator();
        while (users.hasNext()) {
            System.out.println(users.next());
        }
    }

    @Test
    public void testInsertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Long time = System.currentTimeMillis();
        User user = new User();
//        user.setId(7);
        user.setName("王尼玛");
        user.setNumber("235314");
        user.setCreate_at(time);
        user.setUpdate_at(time);
        userDao.insertUser(user);
//        sqlSession.insert("com.pojo.User.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("插入成功！id=" + user.getId());
    }

    @Test
    public void testDeleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUser(13);
//        int i = sqlSession.insert("com.pojo.User.deleteUser", 10);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("true！成功删除");
    }

    @Test
    public void testUpdateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Long time = System.currentTimeMillis();
        User user = new User();
        user.setId(10);
        user.setName("一毛钱");
        user.setNumber("235314");
        user.setUpdate_at(time);
//        int i = sqlSession.insert("com.pojo.User.updateUser", user);
        userDao.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("true！更新成功");
    }
}
