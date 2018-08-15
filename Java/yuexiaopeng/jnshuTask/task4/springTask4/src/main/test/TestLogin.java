import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.pojo.Login;
import task.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLogin
{
    static Logger logger=Logger.getLogger(TestLogin.class);
    @Autowired
    private LoginService loginService;

    @Test
    public void testInsertLogin()
    {
        Login login=new Login();
        login.setLoginId(9);
        login.setLoginPassword("jame");
        login.setCreateAt(43423432423L);
        login.setUpdateAt(3422222L);
        logger.info(login);
        loginService.insertLogin(login);
    }
    @Test
    public void testUpdateLogin()
    {
        Login login=new Login();
        login.setLoginId(1);
        login.setLoginPassword("jame");

        login.setUpdateAt(3422222L);
        logger.info(login);
        loginService.updateLogin(login);
    }
    @Test
    public void testSelectLogin()
    {
        Login login=new Login();
        login.setLoginId(1);
//        login.setUpdateAt(3422222L);
//        System.out.println(login);
        Login login1=loginService.selectLogin(login);
       logger.info(login1);
    }

}
