import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的简单测试，检验配置是否成功
 * @author suger
 * @date 2018-09-15
 */
public class MyBatisTest {

    static Logger log = Logger.getLogger(MyBatisTest.class);

    public static void main(String[] args) throws IOException {
        String s = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(s);

        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession  = sqlSessionFactory.openSession();
            // 获取Mapper ,执行Sql
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> users = userDao.getUserByonlineId(1359);
            log.info("users = " + users);
            // 提交事务
            sqlSession.commit();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }

        }

    }

}

