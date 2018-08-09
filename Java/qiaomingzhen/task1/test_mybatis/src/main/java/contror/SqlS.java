package contror;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/30$ 18:40$
 **/
//获取sqlSession
public class SqlS {
    public SqlSession getSqlSession() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("User-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
