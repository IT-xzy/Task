package com.mutesaid.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.XML;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MoveUtil {
    private final static String FROM_HOST = "https://joeeeee-1257475290.cos.ap-beijing.myqcloud.com/";
    private final static String TO_HOST = "http://joeeeee.oss-cn-beijing.aliyuncs.com/";

    @SuppressWarnings("unchecked")
    public static void move() {
        Objects.requireNonNull(getFileName()).forEach(fileName -> upload((String) fileName, getFileStream((String) fileName)));
    }

    private static void upload(String fileName, InputStream fileStream) {

        try {
            System.out.printf("开始迁移图片文件[%s]\n", fileName);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            String url = TO_HOST + fileName;
            HttpPut httpput = new HttpPut(url);
            InputStreamEntity in = new InputStreamEntity(fileStream);
            httpput.setEntity(in);
            httpclient.execute(httpput);
            System.out.printf("图片文件[%s]迁移成功\n", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getFileStream(String fileName) {
        try {
            String url = FROM_HOST + fileName;
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpget);
            return response.getEntity().getContent();
        } catch (IOException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static List getFileName() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(FROM_HOST);
            CloseableHttpResponse response = httpClient.execute(get);
            String responseContent = EntityUtils.toString(response.getEntity());
            Map responseMap = XML.toJSONObject(responseContent).toMap();
            Map result = (Map) responseMap.get("ListBucketResult");
            ArrayList<Map> contents = (ArrayList<Map>) result.get("Contents");
            List fileName = contents.stream().map(item -> item.get("Key")).collect(Collectors.toList());
            System.out.println("源图片服务器上的图片文件：");
            fileName.forEach(System.out::println);
            return fileName;
        } catch (IOException e) {
            return null;
        }
    }
}
