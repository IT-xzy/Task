package com.jnshu.tool;


import com.aliyun.oss.OSSClient;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.InputStream;
import java.util.List;


/**
 * @author pipiretrak
 * @date 2019/5/29 - 12:21
 */
public class Cos {
    private static Logger logger = Logger.getLogger(Cos.class);

    public String accessKey;
    public String secretKey;
    public String regionName;
    public String bucketName;
    public String contentType ;

    public Cos(String accessKey, String secretKey, String regionName, String bucketName, String contentType) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.regionName = regionName;
        this.bucketName = bucketName;
        this.contentType = contentType;
    }

    private COSClient cosClient(){
        COSCredentials cred = new BasicCOSCredentials (accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig (new Region (regionName));
        COSClient cosClient = new COSClient (cred, clientConfig);
        return cosClient;
    }
    // 将本地文件上传到COS
     public String upload(String key, InputStream input) {
        logger.info ("进入文件上传方法，传进来的key为：" + key);
        COSClient cosClient = cosClient();
        logger.info ("客户端生成完毕");
        String url = null;
        ObjectMetadata objectMetadata = new ObjectMetadata ();
        // 从输入流上传必须制定content length, 否则http客户端可能会缓存所有数据，存在内存OOM的情况
        objectMetadata.setContentLength (1024 * 1024 * 1024 * 10);
        // 设置contenttype默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值，单位字节
        objectMetadata.setContentType (contentType);
        //key只要是能够作为一个唯一表示就可以了
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, input, objectMetadata);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            //putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
            logger.info ("文件上传执行后返回的结果为：" + etag);
            if (etag != null) {
                //字符串拼接图片的URL
                url = "https://pipiretrak-1259336178.cos.ap-guangzhou.myqcloud.com/" + key;
            }
            logger.info ("图片上传成功返回的URL为：" + url);
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }finally {
            cosClient.shutdown();
            return url;
        }
    }

    public boolean transfer() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        //获取文件列表并将文件下载到本地文件夹中
        ObjectListing objectListing = cosclient.listObjects(bucketName);
        List<COSObjectSummary> list = objectListing.getObjectSummaries();
        for (COSObjectSummary s : list) {
            String key = s.getKey();
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
            //下载图片到本地,由于图片是字节码传输,所以要放到一个.txt文件里
            ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, new File("C:/Users/Shinelon/Desktop/image/cos.txt"));
        }
        // 关闭客户端(关闭后台线程)
        cosclient.shutdown();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient("http://oss-cn-shenzhen.aliyuncs.com", "LTAIPTqJ3SRkUlmT", "wdyAH2adTy5miKxc4K21BcKQr9q9N5");

        for (COSObjectSummary s : list) {
            String key = s.getKey();
            File file = new File("C:/Users/Shinelon/Desktop/image/cos.txt");
            ossClient.putObject("pipiretrak", key, file);
        }
// 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }
//    // 将本地文件上传到COS
//    public static void main(String[] args) {
//
//// 1 初始化用户身份信息(secretId, secretKey)
//        COSCredentials cred = new BasicCOSCredentials("AKIDKbiU6BWqCYkux3HxyBFNPI5kSIaBm11v", "qwCfxTzrMUSZIH7iBkJ6oRwUyLx2nL1I");
//        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
//        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
//        // 3 生成cos客户端
//        COSClient cosclient = new COSClient(cred, clientConfig);
//        // bucket名需包含appid
//        String bucketName = "pipiretrak-1259336178";
//
//        String key = "123.jpg";
//        File localFile = new File("C:/Users/Shinelon/Desktop/image/242345.jpg");
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
//        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
//        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
//        try {
//            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
//            // putobjectResult会返回文件的etag
//            String etag = putObjectResult.getETag();
//        } catch (CosServiceException e) {
//            e.printStackTrace();
//        } catch (CosClientException e) {
//            e.printStackTrace();
//        }
//// 关闭客户端
//        cosclient.shutdown();
//    }
}
