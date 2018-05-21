package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.User;

public class EmailUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

    public static String convert(User user,String emailcode) {

        JSONObject ret = new JSONObject();

        JSONArray to = new JSONArray();

        JSONArray names = new JSONArray();

        JSONArray emailcode1 = new JSONArray();

        to.put(user.getEmail());
//        names.put(user.getName());
        emailcode1.put(emailcode);

        JSONObject sub = new JSONObject();
//        sub.put("%name%", names);
        sub.put("%emailcode%",emailcode1);

        ret.put("to", to);
        ret.put("sub", sub);

        return ret.toString();
    }

    public static void send_template(User user,String emailcode) throws ClientProtocolException, IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";

        final String apiUser = "ayase_test_4a6PAG";
        final String apiKey = "FweY8sivhvUbpWon";


        final String xsmtpapi = convert(user,emailcode);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));
        params.add(new BasicNameValuePair("templateInvokeName", "emailcode"));
        params.add(new BasicNameValuePair("from", "ayase@lIIpvj1FYjODqUk63hedC34P3s31vU7E.sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            logger.info(EntityUtils.toString(response.getEntity()));
        } else {
           logger.info("error");
        }
        httpPost.releaseConnection();
    }
}
