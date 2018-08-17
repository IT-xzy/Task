import com.iceneet.Entity.signup;
import com.iceneet.dao.mapper.SignupMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.Reader;


public class SignupServiceTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private Logger logger = Logger.getLogger(SignupServiceTest.class);
    static {
        try {
            //io读取文件流(读取mybatis配置文件)
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //配置mybatis和mapper
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(SignupMapper.class);
        } catch (Exception e) {
            //打印exception的位置和原因
            e.printStackTrace();
        }
    }

    //返回sqlSession
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }


    //插入操作
    @Test
    public void  InsertTest(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SignupMapper signupMapper = session.getMapper(SignupMapper.class);
            signup signup  = new signup();
            signup.setName("张三");
            signup.setQq(66644444);
            signupMapper.save(signup);
            //增删改必须加commit
            session.commit();
            logger.info("插入测试成功："+signup);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    //更新操作
    @Test
    public void TestUpdate(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SignupMapper signupMapper = session.getMapper(SignupMapper.class);
            signupMapper.updateSignup("李四","张三");
            session.commit();
            logger.info("");
        }catch (Exception e){
            // 打印出详细的异常信息，异常名称
            e.printStackTrace();
            //打印异常名称
            //e.getMessage();
        }finally {
            session.close();
        }
    }
    //查找操作
    @Test
    public void SelectTest(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SignupMapper signupMapper = session.getMapper(SignupMapper.class);
            logger.info("查找操作测试：\n"+signupMapper.getSignupPerson("一一"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    //删除操作
    @Test
    public void DeleteTest(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SignupMapper signupMapper = session.getMapper(SignupMapper.class);
            signupMapper.deleteSignup("李四");
            //数据更删改需要commit
            session.commit();
            logger.info("删除操作成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
