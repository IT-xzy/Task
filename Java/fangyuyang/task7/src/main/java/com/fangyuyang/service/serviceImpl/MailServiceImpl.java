package com.fangyuyang.service.serviceImpl;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fangyuyang.model.ALiYunKey;
import com.fangyuyang.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private ALiYunKey aLiYunKey;
    public String mailSend(String mailAddress) {
        String sendStatus = "";
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aLiYunKey.getAccessKeyId(), aLiYunKey.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("test@abc.fyuyang.top");
            request.setFromAlias("老哥");
            request.setAddressType(1);
            request.setTagName("test");
            request.setReplyToAddress(true);
            request.setToAddress(mailAddress);
            request.setSubject("test");
            request.setHtmlBody("请输入验证号123");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            sendStatus = httpResponse.getRequestId();
            if(sendStatus!=null){
                sendStatus = "123";
            }

        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        return sendStatus;
    }
}
