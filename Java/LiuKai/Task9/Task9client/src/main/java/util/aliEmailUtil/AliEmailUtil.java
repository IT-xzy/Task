package util.aliEmailUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliEmailUtil {

@Autowired
AliEmailBean aliEmailBean;

    public void sendMail(String emailAdress,String message ) throws ClientException {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliEmailBean.getAccessKeyId(), aliEmailBean.getAccessKeySecret());
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
        //发信地址
        request.setAccountName(aliEmailBean.getAccountName());
        //发件人昵称
        request.setFromAlias(aliEmailBean.getFromAlias());
        request.setAddressType(1);
        //控制台创建的标签
        request.setTagName(aliEmailBean.getTagName());
        request.setReplyToAddress(true);
        //目标地址
        request.setToAddress("hustliukai@163.com");
        //主题
        request.setSubject(aliEmailBean.getSubject());
        //正文
        request.setHtmlBody(message);

        SingleSendMailResponse httpResponse = client.getAcsResponse(request);
    }
}
