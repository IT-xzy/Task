import com.iceneet.Entity.signup;
import com.iceneet.dao.SignupDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//配置spring配置文件
//在junit要加载配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringMybatisTest {
    //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    //SignupDao signupDao = (SignupDao) context.getBean("SignupDao");
    @Autowired
    private SignupDao signupDao;

    signup signup = new signup();
    Logger logger = Logger.getLogger(SpringMybatisTest.class);
    //插入
    @Test
    public void InsertTest(){
        signup s = new signup();
        s.setName("七七");
        s.setQq(655555);
        try {
            signupDao.insertSignup(s);
            logger.info("插入成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void UpdateTest(){
        boolean b = signupDao.updateSignup("一一","七七");
        logger.info("更新操作"+b);
    }

    @Test
    public void SelectTest(){
        try{
            List<signup>  s= signupDao.selectSignup("一一");
            for (signup sn:s) {
                logger.info("名字："+sn.getName()+"\tqq:"+sn.getQq());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void DeleteTest(){
        boolean b = signupDao.deleteSignup("一一");
        logger.info("删除操作："+b);
    }
}
