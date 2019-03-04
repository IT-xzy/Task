package com.jnshu.task7.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class PhoneCodeUtil {

    static Logger logger = LoggerFactory.getLogger(PhoneCodeUtil.class);

    private static final String ACCOUNTSID ="8a216da867e881cb0168119d1d051653";
    private static final String APPID ="8a216da867e881cb0168119d1d55165a";
    private static final String TOKEN = "5a8a77089a1d4ad1a26c6637f9b41c36";

    public static String  sendPhoneCode(String phone,String number) throws IOException {
        //转换时间戳
        Long  time = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
       String newTime = simpleDateFormat.format(time);
        String nowTime = TimeUtil.newTime();
        //url

        String SigParameter = Md5Util.digest((ACCOUNTSID + TOKEN + nowTime));
        String url = "https://app.cloopen.com:8883/2013-12-26/Accounts/" + ACCOUNTSID + "/SMS/TemplateSMS?sig=" + SigParameter.toUpperCase();

        //http头字段
        String httpHeadInfo =  ACCOUNTSID + ":" + nowTime;
        String Authorization = Base64.encodeBase64String(httpHeadInfo.getBytes());

        HttpPost httpPost = new HttpPost(url);
        //http体
        Map httpBodyInfo = new HashMap();

        httpBodyInfo.put("to",phone);
        httpBodyInfo.put("appId",APPID);
        httpBodyInfo.put("templateId","1");
        httpBodyInfo.put("datas",new String[]{number,"5"});

        String httpBodyJson = JSONObject.toJSONString(httpBodyInfo);

        System.out.println("httpbodyjson" + httpBodyJson);
        //http请求
        StringEntity stringEntity = new StringEntity(httpBodyJson,"utf-8");
        stringEntity.setContentType("application/json");
        httpPost.addHeader("Authorization",Authorization);
        httpPost.addHeader("Accept","application/json");

        httpPost.setEntity(stringEntity);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpPost);
        System.out.println("response" + response);
        return EntityUtils.toString(response.getEntity());
    }

    public static Boolean PhoneCode(String phone,String number) throws IOException {
        String xml =sendPhoneCode(phone,number);
        Map json = XML.toJSONObject(xml).toMap();
        Map info = (Map) json.get("Response");
        String successCode = "000000";
        if (!successCode.equals(info.get("statusCode"))) {
            logger.error("error" + info.get("statusCode"));
            return false;
        }
        return true;
    }

    /**
     * 随机生成6位随机验证码
     * 方法说明
     * @Discription:扩展说明
     * @return
     * @return String
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
    public static void main(String[] args) throws IOException {
        String  info = PhoneCodeUtil.sendPhoneCode("17600976719",createRandomVcode());
        System.out.println(info);
//        String phoneInfo = PhoneCodeUtil.initPhoneCode("17600976719","123456");
//        System.out.println(phoneInfo);
//
    }

}






