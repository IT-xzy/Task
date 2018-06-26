import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Email;
import util.EmailUtil;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class EmailUtilTest {
    @Resource
    Email email;
    @Autowired
    EmailUtil emailUtil;

    @Test
    public void test1() throws MessagingException {
        String  verifiedCode = String.valueOf(new Random().nextInt(899999)+100000); //生成6位数字验证码
        emailUtil.sendMail("275937729@qq.com",verifiedCode);
    }

    @Test
    public void test2(){
        System.out.println(email.getUser());
        System.out.println(email.getPassword());
        System.out.println(email.getProtocol());
        System.out.println(email.getHost());
    }


}