package cn.wp.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/12 16:24 @Version: 1.0 */
public class EmailUtil {
  private String url;
  private String apiUser;
  private String apiKey;
  private String subject;

  public EmailUtil(String url, String apiUser, String apiKey, String subject) {

    this.url = url;
    this.apiUser = apiUser;
    this.apiKey = apiKey;
    this.subject = subject;
  }

  public void send_common(String mail, String message) throws IOException {
    HttpPost httpPost = new HttpPost(url);
    DefaultHttpClient httpClient = new DefaultHttpClient();

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("apiUser", apiUser));
    params.add(new BasicNameValuePair("apiKey", apiKey));
    params.add(new BasicNameValuePair("to", mail));
    params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
    params.add(new BasicNameValuePair("fromName", "SendCloud"));
    params.add(new BasicNameValuePair("subject", subject));
    params.add(new BasicNameValuePair("html", message));

    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
    // 请求
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
