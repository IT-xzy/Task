package com.jnshu.task7.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class Migration {

    /*
    *   GET / HTTP/1.1
        Host: <BucketName-APPID>.cos.<Region>.myqcloud.com
        Date: GMT Date
        Authorization: Auth String
    *  腾讯云获取桶中所有数据 头文件信息
    *
    *
    * */
    //设定迁移原目标地址
    private static final String FROM = "https://yrx-test-1257944801.cos.ap-beijing.myqcloud.com";
    //设定迁移目的地地址
    private static final String TO = "https://migration-yrx.oss-cn-beijing.aliyuncs.com";


    //从腾讯云到阿里云的图片迁移功能;

    public static List getPictures(){
        //装图片信息的list集合
        List list = new ArrayList();

        try {
            //设置HTTP请求
            HttpClient httpClient = HttpClients.createDefault();
            //get请求;
            HttpGet get = new HttpGet(FROM);
            //获取相应信息(xml)
            HttpResponse response = httpClient.execute(get);
            log.info("响应信息为 : " + response);
            //将相应信息转换为字符串
            String responseString = EntityUtils.toString(response.getEntity());
            //将字符串变集合
            Map responseMap = XML.toJSONObject(responseString).toMap();
            //将集合中的结果集拿到 , 所需要的数据
            Map listBucketResult= (Map) responseMap.get("ListBucketResult");
            //从上述集合中拿到包含图片信息的集合--list中是包含所有图片信息的map
            List<Map> pictures = (List<Map>) listBucketResult.get("Contents");
            //将图片不为空或零的图片名称放在list集合中--在bucket中创建文件夹会有一个size为0的contents选项;
            for (int i = 0; i < pictures.size(); i++) {
                //获取list中Contents的Size为0 的项, 不放入到list中
                Integer size = (Integer) pictures.get(i).get("Size");
                if (!size.equals(0)){
                    String pictureName = pictures.get(i).get("Key").toString();
                    list.add(pictureName);
                }
            }
            log.info("源数据图片个数 为 : " + list.size());

            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static InputStream getInputstorm(String pictureName){
        try {
            //图片路径
            String url = FROM + "/" +  pictureName;
            log.info("picture url is " + url);
            //建立http连接
            HttpClient httpClient = HttpClients.createDefault();
            //设置get请求
            HttpGet get = new HttpGet(url);
            //获取到相应的图片信息
            HttpResponse response = httpClient.execute(get);
            //获取流文件
            return response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //通过流文件上传至阿里云服务器;
    private static void moigrationPicture(){

        //使用HTTP请求发送数据
        CloseableHttpClient response = HttpClients.createDefault();
        //调用getPicture方法, 获取图片名称列表
        List pictures = getPictures();
        //循环遍历集合
        for (int i = 0; i < pictures.size(); i++) {
            //获取图片名称;
            String picture = pictures.get(i).toString();
            log.info("图片名称为 : " + picture );
            //获取流文件
            InputStream is = getInputstorm(picture);
            //拼接目的地址图片路径
            String toUrl = TO + "/" +  picture;
           log.info("上传图片路径为 : " + toUrl);
            try {
                //调用阿里api 上传图片
                HttpPut put = new HttpPut(toUrl);
                //传入流文件
                InputStreamEntity ise = new InputStreamEntity(is);
                put.setEntity(ise);
                response.execute(put);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        moigrationPicture();
    }


}
