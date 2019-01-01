package com.mutesaid.rmi_demo_web.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.XML;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "pic")
@Slf4j
public class UploadPicUtil {

    private static String url;

    private static String resize;

    public void setUrl(String url) {
        UploadPicUtil.url = url;
    }

    public void setResize(String resize) {
        UploadPicUtil.resize = resize;
    }

    private static HttpResponse setInfo(InputStream inputStream, String fileName) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url + fileName);
        InputStreamEntity in = new InputStreamEntity(inputStream);
        httpput.setEntity(in);
        return httpClient.execute(httpput);
    }

    public static String uploadPic(InputStream inputStream, String fileName) throws IOException {
        fileName = fileName + System.currentTimeMillis();
        HttpResponse response = setInfo(inputStream, fileName);
        if(!"200".equals(response.getStatusLine().getStatusCode())){
            String xml = EntityUtils.toString(response.getEntity());
            Map json = (Map) XML.toJSONObject(xml).toMap().get("Error");
            log.info("请求错误 msg = {}", json.get("Code"));
            return null;
        }
        return url + fileName+ "?" + resize;
    }
}
