import com.jnshu.mybatis.myMapper.Mapper;
import com.jnshu.mybatis.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testUserList {
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
        public void testForList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        Mapper map=sqlSession.getMapper(Mapper.class);
        //创建包装对象，设置查询条件
        User user = new User();
        //传入多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        user.setIds(ids);
        List<User> list=map.findUserList(ids);
       System.out.println(list);
    }

}
