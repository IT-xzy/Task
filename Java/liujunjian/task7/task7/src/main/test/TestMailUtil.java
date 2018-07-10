import com.tools.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/mail.xml")
public class TestMailUtil {
    @Autowired
    private MailUtil mailUtil;

    @Test
    public void testMMail() throws Exception{
        System.out.println(mailUtil.sendMail("3631017@qq.com"));
    }
}
