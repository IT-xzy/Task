package contror;

import mapper.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 21:36$
 **/
public class TestOne {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("User-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("烬");
        user.setQq(1111111);
        user.setType("web");
//        增加用户
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("添加成功");
    }
}