package com.util.task7;
/*
 * @ClassName:EmailUtil
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/24 22:21
 **/

import com.alibaba.fastjson.JSONObject;
import com.model.People;
import com.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmailUtil {
    private static Logger logger = Logger.getLogger("EmailUtil.class");
    private String url;
    private String apiUser;
    private String apiKey;
    private String rcpt_to;
    private String form;
    private String formName;
    private String subject;
    private String html;


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getRcpt_to() {
        return rcpt_to;
    }

    public void setRcpt_to(String rcpt_to) {
        this.rcpt_to = rcpt_to;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public EmailUtil(String url, String apiUser, String apiKey, String form, String formName, String subject) {
        this.url = url;
        this.apiUser = apiUser;
        this.apiKey = apiKey;
        this.form = form;
        this.formName = formName;
        this.subject = subject;
    }

    public boolean sendCommon(String html, String rcpt_to) {
        HttpPost httpPost = new HttpPost(url);
        boolean b = false;
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", form));
        params.add(new BasicNameValuePair("fromName", formName));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(httpPost);

            // 获取请求返回的内容值
            JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

            // 判断请求是否发送成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 判断邮件是否发送成功
                if ((Integer) jsonObject.get("statusCode") == 200) {
                    // 正常处理
                    logger.info("发送成功~");
                    logger.info("返回信息: " + jsonObject.toJSONString());
                    b = true;
                } else {
                    logger.debug("邮件发送失败~");
                    logger.debug("返回信息: " + jsonObject.toJSONString());
                }
            } else {
                logger.debug("请求发送失败 ~");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return b;
    }

    /**
     * @param url, email, name]
     * @return java.lang.String
     * @mathodName getHtml
     * @Description 邮箱html模板
     * @date 2018/8/25 20:08
     */
    public String getHtml(String url, String email, String name, String randCode) {
        String sendBodyBegin = "<html><H1><a href=\"";
        String sendBodyEnd = "\">点击验证邮箱</a></H1></html>";
        String html = sendBodyBegin + url + "randCode=" + randCode + "&email=" + email + "&name=" + name + sendBodyEnd;
        return html;
    }

    /**
     * @param randCode, email]
     * @return boolean
     * @mathodName checkEmail
     * @Description 邮箱验证
     * @date 2018/8/25 20:09
     */
    public boolean checkEmail(String randCode, String name) {
        try {
            People people = userService.selectByName(name);
            //与数据库中验证码对比
            return people.getEmail().equals(randCode);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param request
     * @return java.lang.String
     * @mathodName sentEmail
     * @Description 发送邮箱验证码
     * @date 2018/8/25 20:07
     */
    public boolean sentEmail(HttpServletRequest request, String randCode,String emailType) {
        String email = request.getParameter("email");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/"+emailType + "?";
        System.out.println(url);
        String name = request.getParameter("name");
        String html = this.getHtml(url, email, name, randCode);
        return this.sendCommon(html, email);
    }
}
