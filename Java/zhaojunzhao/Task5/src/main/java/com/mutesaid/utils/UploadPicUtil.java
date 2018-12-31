package com.mutesaid.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class UploadPicUtil {
    private String url;

    private String resize;

    private CloseableHttpClient httpClient;

    public UploadPicUtil(String url, String resize) {
        this.httpClient = HttpClients.createDefault();
        this.url = url;
        this.resize = resize;
    }

    public CloseableHttpResponse upload(InputStream inputStream, String fileName) throws IOException {
        HttpPut httpput = new HttpPut(url + fileName);
        InputStreamEntity in = new InputStreamEntity(inputStream);
        httpput.setEntity(in);
        return httpClient.execute(httpput);
    }

    public String getPic(String picName) {
        return url + picName + "?" + resize;
    }
}
