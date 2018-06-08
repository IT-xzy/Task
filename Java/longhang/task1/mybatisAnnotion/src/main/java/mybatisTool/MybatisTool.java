package mybatisTool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTool {
    private static SqlSessionFactory sessionFactory=null;
    private  static void initialFactory()
    {
        String resource="conf.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            sessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession()
    {
        if(sessionFactory==null)
        {
            initialFactory();
        }
        return sessionFactory.openSession();
    }
}
