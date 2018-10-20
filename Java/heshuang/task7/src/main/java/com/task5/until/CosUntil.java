package com.task5.until;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.util.*;

public class CosUntil {
//    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//    static Cos cos = (Cos) applicationContext.getBean("cos");
    static String bucketName = "z20-";
    static String secretId = "";
    static String secretKey = "";
    static String region = "ap-beijing";
    static String appId = "1";
    static String folder= "/img";

    public static COSClient getCosClient(){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));

        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    //上传文件到第三方API，单一测试
    public static Map uploadFile(File file){
        //用来存储返回值
        Map map=new HashMap();
        //cos初始化
        COSClient cosClient=getCosClient();
        //获取文件名
        String fileName=file.getName();
        //新的文件名:第三方目录+当前时间+文件名
        String key=folder+System.currentTimeMillis()+fileName;
        //获取请求信息
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        //上传至第三方API
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        //获取唯一md5Key标签
        String md5Key=putObjectResult.getETag();
        //返回一个md5Key，一个相对于第三方API的路径，为了获取以后的相对应的完整路径。
        map.put("md5Key",md5Key);
        map.put("key",key);
        //关闭cos
        cosClient.shutdown();
        return map;
    }


    //获取bucketName列表文件
    public static ObjectListing getFileList(COSClient cosClient){
        String nextMarker = null;
        //获取bucket下成员
        ListObjectsRequest listObjectsRequest=new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        ObjectListing objectListing;
        //文件列表
        do {
            //获取页数为200的列表信息
            objectListing = cosClient.listObjects(listObjectsRequest.withMarker(nextMarker).withMaxKeys(200));
            //获取对象的列表总结描述中存储的对象bucket。
            List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
            //输出对象bucket下的文件相关信息
            for (COSObjectSummary cosObjectSummary : objectSummaries) {
                //获取文件路径
                String key = cosObjectSummary.getKey();
                //获取文件大小
                long fileSize = cosObjectSummary.getSize();
                //获取文件的md5Key,唯一标签名
                String eTag = cosObjectSummary.getETag();
            }
            //标记使用在未来为了listObjects请求 看到下一个页面的结果截断对象清单
            nextMarker = objectListing.getNextMarker();
            //条件就是，列表是否结束
        }while(objectListing.isTruncated());
        cosClient.shutdown();
        return  objectListing;
    }



    //获取列表文件中的各个key，即各个文件路径集合
    public static List<String> getKey(COSClient cosClient){
        //所有列表
        ObjectListing objectListing=getFileList(cosClient);
        //列表中相对应的bucket下的文件
        List<COSObjectSummary> objectSummaries=objectListing.getObjectSummaries();
        List<String> keys=new ArrayList<>();
        //添加路径到一个string集合
        for(COSObjectSummary cosObjectSummary:objectSummaries){
            keys.add(cosObjectSummary.getKey());
            System.out.println("key值:"+cosObjectSummary.getKey());
        }
        //返回这个路径集合
        return keys;
    }



    //获取第三方API图片绝对路径
    public static String getUrl(COSClient cosClient, String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            //放回路径
            return url.toString();
        }
        return null;
    }


    //上传文件流
    public static String updInputStream(COSClient cosClient, InputStream inputStream, String fileName) throws FileNotFoundException {
        // 上传文件流。
        PutObjectResult result = cosClient.putObject(bucketName, fileName, inputStream,null);
        String MD5Key = result.getETag();
        // 关闭OSSClient。
        cosClient.shutdown();
        return MD5Key;
    }


    //图片上传至服务器
    public static String sendServer(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //获取文件的原始名
        String fileName=multipartFile.getOriginalFilename();
        String newName=new Date().getTime()+ String.valueOf(fileName);
        //获取项目webapps所在的路径
        String pathRoot= request.getSession().getServletContext().getRealPath("");
        String path="/upload/pictures/"+newName;
        File file=new File(pathRoot+path);
        if(!file.getParentFile().exists()){
            //文件父目录不存在，则创建
            file.getParentFile().mkdirs();
        }
        if(!file.exists()){
            //文件不存在，则创建
            file.mkdirs();
        }
        //写入服务器
        multipartFile.transferTo(file);
        //返回图片的服务器路径
        return  pathRoot+path;
    }


    //获取图片的格式类型
    public static String getcontentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        System.out.println();
        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }


    //服务器上传到第三方API
    public static Map uploadFile2COS(COSClient cosClient, File file) {
        Map map=new HashMap();
        try {
            String fileName=file.getName();
            InputStream inputStream=new FileInputStream(file);
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(inputStream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = cosClient.putObject(bucketName, folder + fileName,inputStream, objectMetadata);
            //放回一个唯一标签
            String ret = putResult.getETag();
            map.put("md5Key",ret);
            map.put("key",folder+fileName);
        } catch (IOException e) {
            System.out.println("上传异常");
        }finally{

        }
        return map;
    }

}
