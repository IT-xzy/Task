package jnshu.api.tencentCloud;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;


import com.sun.deploy.net.URLEncoder;
import com.twitter.finagle.loadbalancer.Metadata;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Storage {

    COSCredentials cred = new BasicCOSCredentials("AKIDP4ED2gFhj4ARXljXf0Rh2EG7zxuhbK92", "rX2MWk9Qn173ucAmW8Ypv680hDaenOp6");
    ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
    COSClient cosClient = new COSClient(cred, clientConfig);
    String bucketName = "object-1256757695";
    String key = "tencent/images/2";


    @Test
    public void upload(){

        // 1 初始化用户身份信息(secretId, secretKey)
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
        // 3 生成cos客户端

        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式

        //简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        //大文件上传请参照 API 文档高级 API 上传
        File localFile = new File("C:\\Users\\user\\Desktop\\yg.png");

        //指定要上传到 COS 上对象键
        //对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名
        // `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg`
        // 中，对象键为 doc1/pic1.jpg,
        // 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
    }

    @Test
    public void download(){
        // 指定要下载到的本地路径
        File downFile = new File("C:\\Users\\user\\Desktop\\206\\ee.png");
        // 指定要下载的文件所在的 bucket 和对象键
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
    }

    @Test
    public void delete(){
        cosClient.deleteObject(bucketName,key);
    }



    public void transferUpload(InputStream inputStream,String fileName,long fileSize){
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(fileSize);
        cosClient.putObject(bucketName,fileName,inputStream,objectMetadata);
    }

    String downOfBucket ="https://object-1256757695.cos.ap-guangzhou.myqcloud.com";

    @Test
    public void dataTransferTN()throws Exception{
        jnshu.api.qiNiuCloud.Storage storage = new jnshu.api.qiNiuCloud.Storage();
        ObjectListing lists =cosClient.listObjects(bucketName);
//        lists.getObjectSummaries().forEach(x-> System.out.println(x.getKey()));
        List<COSObjectSummary>lists2= lists.getObjectSummaries();
        for(COSObjectSummary list:lists2){
            String encodedFileName = URLEncoder.encode(list.getKey(), "utf-8");
            String finalUrl = String.format("%s/%s", downOfBucket, encodedFileName);
            System.out.println(finalUrl);
            URL url = new URL(finalUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream iputstream = httpURLConnection.getInputStream();
            storage.transferUpload(list.getKey(),iputstream);
        }
    }


}
