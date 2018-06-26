package Task4;

import Task4.message.MessageEmail;
import Task4.message.MessagePhone;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.junit.Test;

public class messageTest {
    @Test
    public void phone() throws Exception {
        SendSmsResponse response = MessagePhone.sendSms("15058434942","122212");
        System.out.println("短信接口返回的数据------");
        System.out.println("code="+response.getCode());
        System.out.println("requesid="+response.getRequestId());
        System.out.println("BizId==="+response.getBizId());
    }
    @Test
    public void email() throws Exception{
        SingleSendMailResponse httpResponse = MessageEmail.sampleSent("751109956@qq.com","111111");
        System.out.println("邮箱接口返回的数据------");
        System.out.println("requestid="+httpResponse.getRequestId());
        System.out.println("requestid="+httpResponse);
    }

}
