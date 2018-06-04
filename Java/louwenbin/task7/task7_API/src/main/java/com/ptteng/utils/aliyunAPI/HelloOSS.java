
/**
 * 示例说明
 * <p>
 * HelloOSS是OSS Java SDK的示例程序，您可以修改endpoint、accessKeyId、accessKeySecret、bucketName后直接运行。
 * 运行方法请参考README。
 * <p>
 * 本示例中的并不包括OSS Java SDK的所有功能，详细功能及使用方法，请参看“SDK手册 > Java-SDK”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/preface.html?spm=5176.docoss/sdk/java-sdk/。
 * <p>
 * 调用OSS Java SDK的方法时，抛出异常表示有错误发生；没有抛出异常表示成功执行。
 * 当错误发生时，OSS Java SDK的方法会抛出异常，异常中包括错误码、错误信息，详细请参看“SDK手册 > Java-SDK > 异常处理”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/exception.html?spm=5176.docoss/api-reference/error-response。
 * <p>
 * OSS控制台可以直观的看到您调用OSS Java SDK的结果，OSS控制台地址是：https://oss.console.aliyun.com/index#/。
 * OSS控制台使用方法请参看文档中心的“控制台用户指南”， 指南的来链接地址是：https://help.aliyun.com/document_detail/oss/getting-started/get-started.html?spm=5176.docoss/user_guide。
 * <p>
 * OSS的文档中心地址是：https://help.aliyun.com/document_detail/oss/user_guide/overview.html。
 * OSS Java SDK的文档地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/install.html?spm=5176.docoss/sdk/java-sdk。
 */
package com.ptteng.utils.aliyunAPI;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.ptteng.utils.qiniuyunAPI.QiNiuYunImage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class HelloOSS {
    @Resource
    private QiNiuYunImage qiNiuYunImage;


    // endpoint以杭州为例，其它region请按实际情况填写
    String endpoint;
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    String accessKeyId;
    String accessKeySecret;
    String bucketName;

    public HelloOSS() {
    }

    public HelloOSS(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }

    //上传图片到阿里云
    public void upImage(String name, InputStream file) throws FileNotFoundException {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        ossClient.putObject(bucketName, name, (file));
        // 关闭client
        ossClient.shutdown();
    }

    //获取图片url链接
    public String urlImage(String name) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        URL url = ossClient.generatePresignedUrl(bucketName, name, expiration);

        String imageUrl = String.valueOf(url);
        String[] userParams = imageUrl.split("\\?");
        imageUrl=userParams[0];
        System.out.println("这是获取到的URL。。。。。。。。" + url);
        // 关闭client
        ossClient.shutdown();
        return imageUrl;
    }

    // 上传网络流
    public void httpUrl(String name, String url) throws IOException {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = new URL(url).openStream();
        ossClient.putObject(bucketName, name, inputStream);
        // 关闭client
        ossClient.shutdown();
    }

    //将阿里云图片迁移到七牛云
    public void corsALi() throws IOException {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        // 列出Object
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        for (OSSObjectSummary ossObjectSummary : listing.getObjectSummaries()) {
            //得到图片名称
            String fileName = ossObjectSummary.getKey();
            //得到文件流
            OSSObject ossObject = ossClient.getObject(bucketName, fileName);
            InputStream file = ossObject.getObjectContent();
            //todo
            qiNiuYunImage.upload(fileName, file);
        }
        // 关闭Client。
        ossClient.shutdown();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HelloOSS helloOSS = (HelloOSS) applicationContext.getBean("helloOSS");
        helloOSS.corsALi();
    }


}
