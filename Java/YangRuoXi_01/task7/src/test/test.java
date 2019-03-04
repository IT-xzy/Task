import com.alibaba.fastjson.JSONObject;
import com.jnshu.task7.beans.api.MailParams;
import com.jnshu.task7.utils.SendMailUtil;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath*:*.xml"})
public class test {
    @Autowired
    MailParams mailParams;
    @Autowired
    SendMailUtil sendMailUtil;

    @Test
    public void test() throws  Exception{
        String email = "1090481058@qq.com";
        String token = "123";
        HttpPost httpPost = new HttpPost(mailParams.getUrl());
        CloseableHttpClient httpClient = HttpClients.createDefault();

        Map smtpMap = new TreeMap();
        Map smtpMap1 = new TreeMap();

        smtpMap1.put("%name%",new HashSet<>().add(email));
        smtpMap1.put("%url%",new HashSet<>().add(mailParams.getToUrl() + token));

        smtpMap.put("to",new HashSet<>().add(email));
        smtpMap.put("sub",smtpMap1);
        String json = JSONObject.toJSONString(smtpMap);
        System.out.println("json" + json);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", mailParams.getApiUser()));
        params.add(new BasicNameValuePair("apiKey", mailParams.getApiKey()));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("from", mailParams.getFrom()));
        params.add(new BasicNameValuePair("fromName", mailParams.getFromName()));
        params.add(new BasicNameValuePair("subject", mailParams.getSubject()));
//        params.add(new BasicNameValuePair("html", html));
        params.add(new BasicNameValuePair("templateInvokeName", mailParams.getTemplateInvokeName()));
        params.add(new BasicNameValuePair("xsmtpapi",json));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));

        } else {
            System.err.println("error");
        }
        httpPost.releaseConnection();

    }
}
