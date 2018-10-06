import com.jnshu.mybatis.myMapper.Mapper;
import com.jnshu.mybatis.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class testUserMapper {
    private SqlSessionFactory sqlSessionFactory;
    @Before //创建sqlSessionFactory
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml"; //mybatis配置文件
        //得到配置文件的流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂SqlSessionFactory,要传入mybaits的配置文件的流
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        Mapper userMapper = sqlSession.getMapper(Mapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testInsertUser()throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Mapper userMapper = sqlSession.getMapper(Mapper.class);
        User user=new User();
        user.setId(12);
        user.setName("五娃");
        user.setEmail("mm@mm");
        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
