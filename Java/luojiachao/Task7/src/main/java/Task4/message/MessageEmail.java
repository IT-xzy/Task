package Task4.message;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class MessageEmail {


    public  static SingleSendMailResponse sampleSent(String email, String link) throws ClientException{

        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIjz8Fwoftg2KX", "XxwUShVA8TFCj7sWmIyps7DARgjkxN");
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}

        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22

            request.setAccountName("luojiac@munian.ink");
            request.setFromAlias("l");
            request.setAddressType(1);
            request.setTagName("luojiac");
            request.setReplyToAddress(true);
            request.setToAddress(email);
            request.setSubject("luojiac");
            request.setHtmlBody("验证：" +link);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            return httpResponse;
    }
}
