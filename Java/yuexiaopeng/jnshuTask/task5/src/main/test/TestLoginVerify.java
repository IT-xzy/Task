import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxp.util.loginUtil.LoginVerifyUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLoginVerify
{
    @Autowired
    private LoginVerifyUtil loginVerifyUtil;

    @Test
    public void testLogin()
    {
        boolean boo=loginVerifyUtil.loginVerify("yue3456789","12345678");
        System.out.println(boo);
    }

}
