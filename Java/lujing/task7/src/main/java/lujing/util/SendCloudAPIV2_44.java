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
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class SendCloudAPIV2_44 {
    
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
        
        final String apiUser = "lujing0613_test_bKfyoa";
        final String apiKey = "zQ13mQEoMZM154x6";
        
        String subject = "IT注册验证码";


        final String xsmtpapi = convert(emailTo,userName,emailCode);
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));

        
        params.add(new BasicNameValuePair("templateInvokeName", "test_template_code"));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "Captain Teemor"));
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
    
}
