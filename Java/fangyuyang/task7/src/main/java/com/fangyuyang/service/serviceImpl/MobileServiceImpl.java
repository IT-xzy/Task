package com.fangyuyang.service.serviceImpl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fangyuyang.model.ALiYunKey;
import com.fangyuyang.service.MobileService;
import com.fangyuyang.subsidiary.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileServiceImpl implements MobileService {
   @Autowired
   private ALiYunKey aLiYunKey;
   @Override
    public String sendMessages(String number)  {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);
        String mobileMessage = "";
        //设置超时时间-可自行调整
        logger.info("c测试到哪");
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        logger.info("c测试到哪");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = aLiYunKey.getAccessKeyId();//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = aLiYunKey.getAccessKeySecret();//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region（请勿修改）
        logger.info("c测试到哪");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        logger.info("测试到这");
        try{
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        }catch (ClientException e){
            logger.info("测试到哪，{}",e.getErrCode());
        }

        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(number);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("方逾阳");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_136000184");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{\"code\":\"123\"}");
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        try {

            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            logger.info("测试到这，{}",sendSmsResponse.getCode());
            mobileMessage = sendSmsResponse.getCode();
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//请求成功
                mobileMessage = "123";
                logger.info(",,{}",sendSmsResponse.getCode());

            }
        }catch (ClientException E){
            E.getErrCode();
        }
        return mobileMessage;
    }

    @Override
    public String MessagesCheck(String number) {
        String errorCode = "";
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //云通信产品-短信API服务产品名称（短信产品名固定，无需修改）
        final String product = "Dysmsapi";
        //云通信产品-短信API服务产品域名（接口地址固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";
        //此处需要替换成开发者自己的AK信息
        final String accessKeyId = aLiYunKey.getAccessKeyId();
        final String accessKeySecret = aLiYunKey.getAccessKeySecret();
        //初始化ascClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
       try {
           DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
       }catch (ClientException e){
           errorCode = e.getErrCode();
       }

        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(number);
        //可选-调用发送短信接口时返回的BizId
//        request.setBizId("1234567^8901234");
        //必填-短信发送的日期 支持30天内记录查询（可查其中一天的发送数据），格式yyyyMMdd
        request.setSendDate("20180527");
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);
        //hint 此处可能会抛出异常，注意catch
        try {
            QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
            //获取返回结果
            errorCode = querySendDetailsResponse.getCode();
            if(querySendDetailsResponse.getCode() != null && querySendDetailsResponse.getCode().equals("OK")){
                //代表请求成功
            }
        }catch (ServerException e){
            errorCode = e.getErrCode();
        }catch (ClientException e){
            errorCode = e.getErrCode();
        }

       return errorCode;
    }

    @Override
    public String sendMoreMessages() {
       return null;
//        //设置超时时间-可自行调整
//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
////初始化ascClient需要的几个参数
//        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
//        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
////替换成你的AK
//        final String accessKeyId = "yourAccessKeyId";//你的accessKeyId,参考本文档步骤2
//        final String accessKeySecret = "yourAccessKeySecret";//你的accessKeySecret，参考本文档步骤2
////初始化ascClient,暂时不支持多region（请勿修改）
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
//                accessKeySecret);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);
//        //组装请求对象
//        SendBatchSmsRequest request = new SendBatchSmsRequest();
//        //使用post提交
//        request.setMethod(MethodType.POST);
//        //必填:待发送手机号。支持JSON格式的批量调用，批量上限为100个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
//        request.setPhoneNumberJson("[\"1500000000\",\"1500000001\"]");
//        //必填:短信签名-支持不同的号码发送不同的短信签名
//        request.setSignNameJson("[\"云通信\",\"云通信\"]");
//        //必填:短信模板-可在短信控制台中找到
//        request.setTemplateCode("SMS_1000000");
//        //必填:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
//        request.setTemplateParamJson("[{\"name\":\"Tom\", \"code\":\"123\"},{\"name\":\"Jack\", \"code\":\"456\"}]");
//        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
//        //request.setSmsUpExtendCodeJson("[\"90997\",\"90998\"]");
////请求失败这里会抛ClientException异常
//        SendBatchSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
////请求成功
//        }
    }
}
