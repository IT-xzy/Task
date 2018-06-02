package com.Utils;

/**
 * @author: 曹樾
 * @program: task7
 * @description: the API of sendcloud
 * @create: 2018/5/28 下午2:36
 */
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class SendCloud {
    public static String convert(String emailTo ,String userName, String emailCode) {
        
        JSONObject ret = new JSONObject();
        
        JSONArray to = new JSONArray();
        to.put(emailTo);
        
        JSONArray name = new JSONArray();
        name.put(userName);
        
        JSONArray code = new JSONArray();
        code.put(emailCode);
        
        JSONObject sub = new JSONObject();
        sub.put("%name%", name);
        sub.put("%code%", code);
        
        ret.put("sub", sub);
        ret.put("to", to);
        
        
        return ret.toString();
    }
    
    
    public static int send_template(String emailTo ,String userName, String emailCode)  {
        
        
        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";
        
        final String apiUser = "caoyue_test_3xHbDI";
        final String apiKey = "9nQijbojIzJCgdrf";
        
        String subject = "注册验证码";
        
        
        final String xsmtpapi = convert(emailTo,userName,emailCode);
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));
        
        
        params.add(new BasicNameValuePair("templateInvokeName", "test_template_code"));
        params.add(new BasicNameValuePair("from", "sendcloud@mtHzWyqs0PkHBVWi8WzDmBwONye3L3d3.sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "老万"));
        params.add(new BasicNameValuePair("subject", subject));
        
        
        HttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            response = httpClient.execute(httpPost);
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("error");
        }
        
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回
            
            System.out.println(response.getStatusLine().getStatusCode());
            
            return response.getStatusLine().getStatusCode();
            
            
        } else {
            System.err.println("error");
            
        }
        httpPost.releaseConnection();
        return response.getStatusLine().getStatusCode();
    }
//    public static String convert(List<A> dataList) {
//
//        JSONObject ret = new JSONObject();
//
//        JSONArray to = new JSONArray();
//
//        JSONArray names = new JSONArray();
//        JSONArray moneys = new JSONArray();
//
//        for (A a : dataList) {
//            to.put(a.address);
//            names.put(a.name);
//            moneys.put(a.money);
//        }
//
//        JSONObject sub = new JSONObject();
//        sub.put("%name%", names);
//        sub.put("%money%", moneys);
//
//        ret.put("to", to);
//        ret.put("sub", sub);
//
//        return ret.toString();
//    }
//    public static void send_template() throws ClientProtocolException, IOException {
//
//        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";
//
//        final String apiUser = "***";
//        final String apiKey = "***";
//
//        String subject = "...";
//
//        List<A> dataList = new ArrayList<A>();
//        dataList.add(new A("to1@domain.com", "user1", "1000"));
//        dataList.add(new A("to2@domain.com", "user2", "2000"));
//
//        final String xsmtpapi = convert(dataList);
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("apiUser", apiUser));
//        params.add(new BasicNameValuePair("apiKey", apiKey));
//        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));
//        params.add(new BasicNameValuePair("templateInvokeName", "test_template"));
//        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
//        params.add(new BasicNameValuePair("fromName", "SendCloud"));
//        params.add(new BasicNameValuePair("subject", subject));
//
//        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//
//        HttpResponse response = httpClient.execute(httpPost);
//
//        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } else {
//            System.err.println("error");
//        }
//        httpPost.releaseConnection();
//    }
    
    public static void main(String[] args) throws Exception {
        //send_common();
        //send_common_with_attachment();
//        send_template();
        //send_template_maillist();
        send_template("137334398@qq.com","曹樾","1234");
        
    }
}
