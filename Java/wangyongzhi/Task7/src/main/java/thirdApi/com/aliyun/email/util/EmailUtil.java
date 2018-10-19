package thirdApi.com.aliyun.email.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import util.PropertyUtil;

/**
 * @Description: 阿里云发送邮件工具
 */
public class EmailUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String regionId = PropertyUtil.getProperty("regionId");
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static String accessKeyId = PropertyUtil.getProperty("accessKeyId");
    private static String accessKeySecret = PropertyUtil.getProperty("accessKeySecret");

    private static String accountName = PropertyUtil.getProperty("accountName");

    private static String fromAlias = PropertyUtil.getProperty("fromAlias");

    private static String tagName = PropertyUtil.getProperty("tagName");
    private static String subject = PropertyUtil.getProperty("subject");

    public static void sendEmail(String email, String code) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName(accountName);
            request.setFromAlias(fromAlias);
            request.setAddressType(1);
            request.setTagName(tagName);
            request.setReplyToAddress(true);
            request.setToAddress(email);
            request.setSubject(subject);
            request.setHtmlBody("你现在正在进行邮箱绑定，如果本人操作，请点击验证(如果无法点击，请把地址复制到地址栏访问。):" +
                    " http://localhost:8080/u/email/"+ code);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}



