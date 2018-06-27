package com.task.test;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;



public class TestMain {

    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) throws Throwable {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

//        OSSClient ossClient = (OSSClient)context.getBean("oss");
//
//        int maxKeys = 200;
//
//        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest("zhimowen-welcome").withMaxKeys(maxKeys));
//
//        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
//
//        List<String> list = new ArrayList<>();
//        for(OSSObjectSummary objectSummary:sums){
//            list.add(objectSummary.getKey());
//        }
//
//        for(String str:list){
//            System.out.println(str);
//        }

        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDVpuiHZKNuAAuOciGgLmzxhCTVIq9c3dz", "DCxTkncCXdU6TbVBdpmVzEE0XqujJekb");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "zhimowen-1256685643";


//        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
//        // 大文件上传请参照 API 文档高级 API 上传
//        File localFile = new File("D:/1.bat");
//        // 指定要上传到 COS 上对象键
//        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
//        String key = "upload_single_demo.bat";
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
//        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);



        String key = "/aaa/bbb.txt";
        File localFile = new File("D:\\321.txt");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosClient.shutdown();

    }
}
