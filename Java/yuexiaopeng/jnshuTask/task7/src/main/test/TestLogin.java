import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxpTask6.pojo.Login;
import yxpTask6.pojo.Student;
import yxpTask6.service.LoginService;
import yxpTask6.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class TestLogin
{
    static Logger logger=Logger.getLogger(TestLogin.class);

    @Autowired
    private LoginService loginService;

    @Test
    public void insertLoginTest()
    {
        long create_at=System.currentTimeMillis();
        long update_at=System.currentTimeMillis();
        Login login=new Login(create_at,update_at,"2","yue3456788",
                "123456789","feifei",
                "/img/","salt","123467890","123456@qq.com");
        loginService.registerLogin(login);
    }

    @Test
    public void deleteLoginTest()
    {

    }

    @Test
    public void updateLogin2Test()
    {
        Login login=new Login();
        login.setUpdateAt(System.currentTimeMillis());
        login.setLoginAccount("yue3456788");
        login.setLoginMobile("8888888");
        login.setLoginMail("abcd@qq.com");
        loginService.updateSecAccount(login);
    }
    @Test
    public void selectStudent()
    {

    }
    @Test
    public void selectAllTest()
    {

    }
    @Test
    public void selectAllTestMap()
    {
//

    }
    @Test
    public void selectAllPageTestList()
    {


    }
    @Test
    public void studentPageTestList()
    {


    }
    @Test
    public void Test111()
    {

    }

    @Test
    public void TestStudyId()
    {

    }
}
