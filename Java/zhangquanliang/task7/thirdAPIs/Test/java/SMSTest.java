import com.suger.util.DataUtils;
import com.suger.util.SMS;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author suger
 * @date 2018/12/15 21:50
 */
public class SMSTest {

    /*ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");

    SMS sms = (SMS) context.getBean("smsSDK");

    @Test
    public  void sendMessage() {

        // 生成6位随机验证码
        String msgCode = DataUtils.getNumber(6);

        String tel = "15637921325";
        sms.sendMessage(tel,msgCode);
    }*/
}
