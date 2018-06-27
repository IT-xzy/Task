package com.jnshu.tools;


import com.alibaba.fastjson.JSONObject;
import com.jnshu.model.StudentCustom;
import com.jnshu.service.ServiceDao;
import com.whalin.MemCached.MemCachedClient;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: SSM_WEB
 * @description: SendCloudMail SDK 工具类
 * @author: Mr.xweiba
 * @create: 2018-06-02 23:39
 **/

public class MailApiSendCloud {
    @Autowired
    MemCachedClient memCachedClient;
    @Autowired
    ServiceDao serviceDao;

    private static Logger logger = LoggerFactory.getLogger(MailApiSendCloud.class);

    // 认证
    private String apiUser;
    private String apiKey;

    // 邮件发送接口
    private String apiUrl;

    // 收件邮箱
    // private String sendTo;
    // 随机数验证
    private String randInt;

    /* 设置默认值 */
    // 邮件主体
    private String subject = "学生管理系统邮箱验证";
    // 邮件内容
    private String sendBodyBegin = "<html><H1><a href=\"";
    private String sendBodyEnd = "\">点击验证邮箱,五分钟后失效</a></H1></html>";
    // 发件人名称
    private String fromName = "小尾巴";

    // 构建http请求
    private HttpPost httpPost;
    private CloseableHttpClient httpClient;

    // http 发送内容
    List<NameValuePair> params;

    MailApiSendCloud(String apiUser, String apiKey, String apiUrl) {
        this.apiUser = apiUser;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    // 外部调用发送方法
    // 只提供发送邮箱
    public boolean sendMail(String httpUrl, StudentCustom studentCustom) {

        return sendMailReal(studentCustom, subject, httpUrl, fromName);
    }

    public boolean sendMail(String httpUrl, StudentCustom studentCustom, String toSubject) {
        return sendMailReal(studentCustom, toSubject, httpUrl, fromName);
    }

    public boolean sendMail(String httpUrl, StudentCustom studentCustom, String toSubject, String fromName) {
        return sendMailReal(studentCustom, toSubject, httpUrl, fromName);
    }

    // 发送方法
    private boolean sendMailReal(StudentCustom studentCustom, String subject, String httpUrl, String fromName) {
        // 拼接验证url httpUrl 当前项目的根目录
        randInt = RandNum.getRandLength(12);
        String sendBody = sendBodyBegin + httpUrl + randInt + sendBodyEnd;
        logger.debug("拼接发送内容: " + sendBody);
        // 设置发信内容
        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", studentCustom.getStuMail()));
        // 该值是我们的发件邮箱, 只能设置sendcloud上绑定的
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", fromName));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", sendBody));

        // 初始化请求
        httpPost = new HttpPost(apiUrl);
        httpClient = HttpClients.createDefault();

        // 发送请求 将数据转换为JSON格式
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            // 接收请求
            HttpResponse response = httpClient.execute(httpPost);

            // 获取请求返回的内容值
            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

            // 判断请求是否发送成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 判断邮件是否发送成功
                if ((Integer)jsonObject.get("statusCode") == 200){
                    // 发送成功将随机验证码存入缓存 5分钟后过期, 通过随机码取出对应用户数据
                    logger.debug("随机验证码:" + randInt);

                    // 写入缓存等待验证, 缓存命中再写入数据库 邮箱账号状态只在用户注册时默认为未激活.
                    studentCustom.setStuMailState(1);

                    logger.debug("邮箱缓存存入时: " + studentCustom.toString());
                    memCachedClient.set(randInt, studentCustom, new Date(1000 * 60 * 5));

                    // 正常处理
                    logger.debug("发送成功~");
                    logger.debug("返回信息: " + jsonObject.toJSONString());
                    return true;
                } else {
                    logger.debug("邮件发送失败~");
                    logger.debug("返回信息: " + jsonObject.toJSONString());
                    return false;
                }
            } else {
                logger.debug("请求发送失败 ~");
                return false;
            }
            // 异常位置可以添加对应错误码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.debug("UrlEncodedFormEntity 转换失败导致发送请求失败");
            return false;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.debug("httpClient.execute(httpPost) 请求接收失败");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("EntityUtils.toString(response.getEntity()) 转换失败");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("数据库写入失败");
            return false;
        }
    }
}
