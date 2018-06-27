package com.util.emailutil;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jaime
 * @Date: 2018/5/21 21:23
 * @Description: *
 */
@Component
public class EmailUtil {
    public static String convert(List<Email> dataList) {

        JSONObject ret = new JSONObject();

        JSONArray to = new JSONArray();

        JSONArray names = new JSONArray();
        JSONArray urls = new JSONArray();

        for (Email a : dataList) {
            to.put(a.getAddress());
            names.put(a.getName());
            urls.put(a.getVcode());
        }

        JSONObject sub = new JSONObject();
        sub.put("%name%", names);
        sub.put("%url%", urls);

        ret.put("to", to);
        ret.put("sub", sub);

        return ret.toString();
    }

    public static String send_template(String address, String username, int vcode) throws ClientProtocolException, IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";

        final String apiUser = "jaimewan_test_VOFxjy";
        final String apiKey = "FtOlY7QgDkG42PuK";

        String subject = "来自Jaime的邮件";

        List<Email> dataList = new ArrayList<Email>();
        Email email2=new Email();
        email2.setName(username);
        email2.setAddress(address);
        email2.setVcode(vcode);
        dataList.add(email2);
//		dataList.add(new A("to2@ifaxin.com", "user2", "2000"));
        final String xsmtpapi = convert(dataList);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));
        params.add(new BasicNameValuePair("templateInvokeName", "test_template_active"));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            httpPost.releaseConnection();
            return EntityUtils.toString(response.getEntity());
        } else {
            httpPost.releaseConnection();
            return new String("error");
        }


    }

/*    public static void main(String[] args) throws IOException {

        send_template("1569998206@qq.com", "曹樾", "www.acfun.cn");

    }*/
}
