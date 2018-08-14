package com.fgh.task2.Utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OSSTest {
    @Autowired
    qiniuOSS qiniuOSS;




    Logger logger = LoggerFactory.getLogger(OSSTest.class);

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;


    OSSTest(String endpoint, String accessKeyId, String accessKeySecret, String bucket) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucket;
    }


    private OSSClient initOSSClient() {
        try {
            return new OSSClient(endpoint, accessKeyId, accessKeySecret);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("未获取到OSS客户端对象");
            return null;
        }
    }


    /**
     * 将图片从七牛云迁移到阿里云
     *
     * @param prefix     文件名前缀
     * @param delimiter  指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
     * @param bucketName 存储空间
     * @throws UnsupportedEncodingException
     */
    public void qiniuToali(String prefix, String delimiter, String bucketName) throws UnsupportedEncodingException {
        // 获取七牛云中文件列表（key 文件名）
        List <String> key = qiniuOSS.getFile(prefix, delimiter, bucketName);
        for (String i : key) {
            //获取七牛云下载URL
            logger.debug("七牛云下载-");
            String Url = qiniuOSS.downLoadUrl(i);
            logger.debug("阿里云上传-");
            this.upLoadUrl(Url, i);
        }
    }

    /**
     * MultipartFile 类型 上传
     *
     * @param uploadFile 图片文件
     * @return
     * @throws Exception
     */
    public boolean picOSS(MultipartFile uploadFile) throws Exception {
        String resultStr = null;
        // 创建OSSClient实例
        OSSClient ossClient = initOSSClient();
        if (ossClient != null) {
            try {
                // 以输入流形式上传文件
                InputStream inputStream = uploadFile.getInputStream();
                // 文件名
                String fileName = uploadFile.getOriginalFilename();
                logger.info("上传文件名：" + fileName);
                // 创建上传的Object的Metadata
                ObjectMetadata metadata = new ObjectMetadata();
                //上传的文件的长度(必须)
                metadata.setContentLength(inputStream.available());
                //指定该Object被下载时的网页的缓存行为
                metadata.setCacheControl("no-cache");
                //指定该Object下设置Header
                metadata.setHeader("Pragma", "no-cache");
                //指定该Object被下载时的内容编码格式
                metadata.setContentEncoding("utf-8");
                // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。
                // 如果用户没有指定则根据Key或文件名的扩展名生成，
                // 如果没有扩展名则填默认值application/octet-stream
                metadata.setContentType(uploadFile.getContentType());
                // 上传
                PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, inputStream, metadata);
                // 解析结果
                resultStr = putObjectResult.getETag();
                logger.info("上传结果：" + resultStr);
                // 关闭client
                ossClient.shutdown();
            } catch (Exception e) {
                logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
            }
            logger.info("图片上传成功！");
            return true;
        } else {
            logger.info("获取OSS实例失败！");
            return false;
        }
//        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
//        String url = ossClient.generatePresignedUrl(bucketName, key, expiration).toString();
//        return url;
    }

    /**
     * URL生成
     *
     * @param uploadFile 上传图片
     * @return
     */
    public String getUrl(MultipartFile uploadFile) {
        logger.info("-----------进入 链接生成函数--------------");
        String url = null;
        String fileName = uploadFile.getOriginalFilename();
        logger.info("获取图片名：" + fileName);
        OSSClient ossClient = initOSSClient();
//        设置URL过期时间为十年（私有最多3600s）
        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
        logger.info("过期时间：" + expiration);
//        生成URL
        try {
            assert ossClient != null;
            url = ossClient.generatePresignedUrl(bucketName, fileName, expiration).toString();
            logger.info("生成URL：" + url);
        } catch (Exception e) {
            logger.info("生成URL失败...");
            e.printStackTrace();
        }
        if (url != null)
            return url;
        return null;
    }


    /**
     * 缩略图  设置缩略高度、宽度、模式
     *
     * @param oriURL 原始URL
     * @param height 高度
     * @param width  宽度
     * @param model  模式  lfit：等比缩放，限制在指定w与h的矩形内的最大图片。
     * @return
     */
    public String thumbnailURL(String oriURL, int height, int width, String model) {
        logger.debug("开始生成thumbnail, 原始链接: " + oriURL);
//        把URL中大写字母准换为小写字母，是否以http开头
        if (oriURL.toLowerCase().startsWith("http:")) {
            String oriURL_s = oriURL.split("\\?")[0];
            logger.debug("分割后的oriURL[0]: " + oriURL_s);
            String begin_thumbnailURL = oriURL_s + "?x-oss-process=image/resize";
            logger.debug("begin_thumbnailURL: " + begin_thumbnailURL);
            StringBuilder result = new StringBuilder();
            result.append(begin_thumbnailURL);
            result.append(",m_");
            result.append(model);
            result.append(",h_");
            result.append(String.valueOf(height));
            result.append(",w_");
            result.append(String.valueOf(width));
            return result.toString();
        } else {
            logger.debug("图片链接错误");
            return oriURL;
        }

    }

    /**
     * 缩略图  已在云服务器中定义
     *
     * @param oriURL 原始URL
     * @param Style  缩略图样式
     * @return
     */
    public String thumbnailURLStyle(String oriURL, String Style) {
        logger.debug("开始生成thumbnail, 原始链接: " + oriURL);
//        把URL中大写字母准换为小写字母，是否以http开头
        if (oriURL.toLowerCase().startsWith("http:")) {
            String oriURL_s = oriURL.split("\\?")[0];
            logger.debug("分割后的oriURL[0]: " + oriURL_s);
            String begin_thumbnailURL = oriURL_s + "?x-oss-process=style/";
            logger.debug("begin_thumbnailURL: " + begin_thumbnailURL);
            StringBuilder result = new StringBuilder();
            result.append(begin_thumbnailURL);
            result.append(Style);
            return result.toString();
        } else {
            logger.debug("图片链接错误");
            return oriURL;
        }

    }


    /**
     * 通过URL上传
     *
     * @param Url
     * @param fileName
     */
    public void upLoadUrl(String Url, String fileName) {
        OSSClient ossClient = initOSSClient();
        try {
            InputStream inputStream = new URL(Url).openStream();
            ossClient.putObject(bucketName, fileName, inputStream);
            ossClient.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param KeyPrefix 列举包含指定前缀的文件
     * @return
     */
    public List <String> getFileName(String KeyPrefix) {
        List <String> keys = new ArrayList <>();
        OSSClient ossClient = initOSSClient();
        ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
        List <OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            keys.add(s.getKey());
        }
        return keys;
    }


    /**
     *  InputStream 下载
     * @param fileName
     * @return
     */
    public InputStream updown(String fileName) throws IOException {
        String line = null;
        OSSClient ossClient = initOSSClient();
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, fileName);
        // 读取文件内容。
        System.out.println("Object content:");
        InputStream objectContent = ossObject.getObjectContent();
        return objectContent;
    }


}
