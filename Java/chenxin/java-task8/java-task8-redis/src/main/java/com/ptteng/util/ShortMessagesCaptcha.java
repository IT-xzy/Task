package com.ptteng.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发送短信验证码的类
 * 2018年6月1日19点30分
 */
public class ShortMessagesCaptcha {

    //产品名称：云通信短信API产品，开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名，开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    //TODO 此处需要替换成开发者自己的AK（在阿里云访问控制台寻找）
    private static final String accessKeyId = "LTAIQjHpwaV7Kbte";
    private static final String accessKeySecret = "sDwV9p44fKSGcJlnbJnZCUBRgexKNZ";

    /**
     * 时间：2018年6月1日21点07分
     * 发送验证码短信的方法
     * @param phoneNumber
     * @param captcha
     * @return SendSmsResponse
     */
    public static SendSmsResponse sendSms(String phoneNumber,String captcha) throws ClientException{

        //可自助调整超过时间
        System.setProperty("sun.net.client.defaultConnectTimeout","10000" );
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient，暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述找ali文档
        SendSmsRequest request = new SendSmsRequest();
        //必填：待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填：短信签名
        request.setSignName("陈鑫");
        //必填：短信模版
        request.setTemplateCode("SMS_136365085");
        //可选：模版中变量替换JSON串，这里需要自动生成六位的随机数字传进来。
        request.setTemplateParam("{\"code\":\""+ captcha +"\"}");
        //可选：outId为提供业务方扩展字段，最终在短信回执消息中将此值带回给调用者。这里没有用
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    //查询短信发送状态的方法
    /**
     * 2018年6月1日21点07分
     * @param bizId
     * @param phoneNumber
     */
    public static QuerySendDetailsResponse querySendDetails(String bizId, String phoneNumber) throws ClientException{

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hongzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phoneNumber);
        //可选-流水号
        request.setBizId(bizId);
        //必填 -发送日期  支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(dateFormat.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }
}
