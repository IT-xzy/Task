package junitLogin;

import com.yxpStu.pojo.Login;
import com.yxpStu.service.LoginService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class JunitTestLogin
{
    @Autowired
    LoginService loginService;


    static Logger logger=Logger.getLogger(JunitTestLogin.class);

    @Test
    public void insertLoginTest()
    {
        Login login=new Login();
        login.setLoginId(81);
        login.setLoginPassword("zhongguo");
        loginService.insertLogin(login);
        logger.info(login);
    }

    @Test
    public void updateLoginTest()
    {
        Login login=new Login();
        login.setLoginId(99);
        login.setLoginPassword("zhongguo");
        loginService.updateLogin(login);
        logger.info(login);
    }

    @Test
    public void selectLoginTest()
    {
        Login login=new Login();
        login.setLoginId(99);
        Login login1=loginService.selectLogin(login);
        logger.info(login1);
    }
}
