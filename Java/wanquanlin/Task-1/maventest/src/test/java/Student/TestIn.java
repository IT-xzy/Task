package Student;

import Dao.UserMapperIn;
import POJO.User;
import POJO.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestIn {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfigDaoTest.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserList() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapperIn userMapperIn=sqlSession.getMapper(UserMapperIn.class);
        UserQueryVO userQueryVO=new UserQueryVO();
        User user=new User();
        user.setSex("男");
        user.setUsername("五");
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(3);
        userQueryVO.setIds(ids);
        userQueryVO.setUser(user);
        List<User> p=userMapperIn.findUserList(userQueryVO);
        System.out.println(p);
    }
}
