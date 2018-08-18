import com.iceneet.Entity.signup;
import com.iceneet.dao.mapper.SignupDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SignupServiceTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private Logger logger = Logger.getLogger(SignupServiceTest.class);
    static {
        //读取mybatis配置文件
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    //插入
    @Test
    public void Testinsert(){
        SqlSession session = sqlSessionFactory.openSession();
        SignupDao signupDao = session.getMapper(SignupDao.class);
        signup SN = new signup();
        SN.setName("七七");
        SN.setQq(651368888);
        signupDao.insertSignup(SN);
        //增删改注意commit
        session.commit();
        logger.info("插入操作成功，用户名为："+SN.getName());
    }
    //查
    @Test
    public void TestSelect(){
        SqlSession session = sqlSessionFactory.openSession();
        SignupDao signupDao = session.getMapper(SignupDao.class);
        List<signup> list= signupDao.selectSignup("一一");
        for (signup sn :list){
            logger.info("查询出来的用户："+sn.getName());
        }
    }
    //更新
    @Test
    public void Testupdate(){
        SqlSession session = sqlSessionFactory.openSession();
        SignupDao signupDao = session.getMapper(SignupDao.class);
        //使用map方式对mybatis进行多参数传参
        Map paramMap = new HashMap();
        paramMap.put("name","一一");
        paramMap.put("name1","七七");
        signupDao.updateSignup(paramMap);
        //增删改注意commit
        session.commit();
        logger.info("update操作成功");
    }

    //删除
    @Test
    public void TestDelete(){
        SqlSession session = sqlSessionFactory.openSession();
        SignupDao signupDao = session.getMapper(SignupDao.class);
        signupDao.deleteSignup("一一");
        session.commit();
        logger.info("删除操作成功");
    }
}
