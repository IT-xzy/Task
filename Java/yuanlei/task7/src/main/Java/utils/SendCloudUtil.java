package utils;

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

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclint.Entity.and;

public class SendCloudUtil {

    public static String convert(String mailbox,String mail_code) {

        JSONObject ret = new JSONObject();

        JSONArray to = new JSONArray();


        JSONArray mailCode = new JSONArray();
        mailCode.put(mail_code);


        to.put(mailbox);
        JSONObject sub = new JSONObject();
        sub.put("%email_code%",mailCode);

        ret.put("to", to);
        ret.put("sub", sub);
        System.out.println(ret);
        return ret.toString();

    }


    public static String send_template(String mailbox,String mail_code) throws ClientProtocolException, IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";

        final String apiUser = "18771756855_test_NVaNlQ";
        final String apiKey = "12UDOKr5PfJ82A0U";

        String subject = "大宝剑的邮箱验证";
        String result;


        final String xsmtpapi = convert(mailbox,mail_code);

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("xsmtpapi", xsmtpapi));
        params.add(new BasicNameValuePair("templateInvokeName", "great_sword"));
        params.add(new BasicNameValuePair("from", "18771756855@6VYFZPHudh7cHYzhOFPD0vNvJ2AUb6KG.sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            //response.getEntity()只能取一次
//            System.out.println(EntityUtils.toString(response.getEntity()));
            String str = EntityUtils.toString(response.getEntity());
            System.out.println(str);
//            for (String s :str.split(":|,")){
//                System.out.println(s);
//            }
            String[] strings = str.split(":|,");
            result = strings[1];
            System.out.println(result);

        } else {
            System.err.println("error");
            result = "false";
        }
        httpPost.releaseConnection();
          return result;
    }
}
