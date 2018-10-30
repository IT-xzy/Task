import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class UserMappTest {
    private SqlSessionFactory sqlSessionFactory;

    @BeforeEach
    public void setUp() throws Exception {
        //创建sqlSessionfactory
        //创建MyBatis配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //根据id查找用户信息
    @Test
    public void TestFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象,mybatis自动生成mapper代理对象
        //获限mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);

    }

    //根据姓名查找用户信息
    @Test
    public void findUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByName("yy");
        System.out.println(user);

    }

    //插入用户信息
    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(14, "李雷", "124", "qq@qq", "2018-12-33");
        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();

    }

    //删除用户信息
    @Test
    public void selectById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(8);
        sqlSession.commit();
        sqlSession.close();
    }
    //更新用户信息
    @Test
    public void updateUser()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1,"123","123","123","132");
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();

    }
}

