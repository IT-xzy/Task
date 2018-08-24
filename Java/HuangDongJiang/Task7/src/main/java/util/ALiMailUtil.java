package util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class ALiMailUtil {
	public static void sendMail(String toAddress){
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIISDNQNV3o1x2", "ckUdqELKCTrcrl2PkQ6YTLQBtjVQfD");

		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();
		try {
			//request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
			request.setAccountName("hdj@ch0918.top");
			request.setFromAlias("陈陈陈");
			request.setAddressType(1);
			request.setTagName("test");
			request.setReplyToAddress(true);
			request.setToAddress(toAddress);
			request.setSubject("测试");
			request.setHtmlBody("这是一封测试邮件");
			SingleSendMailResponse httpResponse = client.getAcsResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
