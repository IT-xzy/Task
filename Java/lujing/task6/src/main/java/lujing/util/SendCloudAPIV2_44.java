package lujing.util;

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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class SendCloudAPIV2_44 {
    
    public static String convert() {
        
        JSONObject ret = new JSONObject();
        
        JSONArray to = new JSONArray();
        to.put("452604407@qq.com");
        
        JSONArray name = new JSONArray();
        name.put("lujing");
        
        JSONArray code = new JSONArray();
        code.put(8888888);
        
        JSONObject sub = new JSONObject();
        sub.put("%name%", name);
        sub.put("%code%", code);
    
        ret.put("sub", sub);
        ret.put("to", to);
        
    
        return ret.toString();
    }
    
    
    public static void send_template() throws ClientProtocolException, IOException {
        
//        final String url = "http://sendcloud.sohu.com/webapi/mail.send_template.json";
        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";
        
        final String apiUser = "lujing0613_test_bKfyoa";
        final String apiKey = "zQ13mQEoMZM154x6";
        
        String subject = "IT注册验证码";

//        List<A> dataList = new ArrayList<A>();
//        dataList.add(new A("to1@domain.com", "user1", "1000"));
//        dataList.add(new A("to2@domain.com", "user2", "2000"));
        final String xsmtpapi = convert();
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));
//        params.add(new BasicNameValuePair("substitution_vars", xsmtpapi));
        
        params.add(new BasicNameValuePair("templateInvokeName", "test_template_code"));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "Captain Teemor"));
        params.add(new BasicNameValuePair("subject", subject));
        
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        
        HttpResponse response = httpClient.execute(httpPost);
        
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回
            System.out.println(EntityUtils.toString(response.getEntity()));
        } else {
            System.err.println("error");
        }
        httpPost.releaseConnection();
    }
    
    
//    public static void main(String[] args) throws Exception {
//        final String xsmtpapi = convert();
//        System.out.println(xsmtpapi);
//        //send_common();
//        //send_common_with_attachment();
////        send_template();
//        //send_template_maillist();
////        send_template_with_attachment();
//
//    }
}
