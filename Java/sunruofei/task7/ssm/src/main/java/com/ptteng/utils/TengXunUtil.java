package com.ptteng.utils;

import com.aliyun.oss.OSSClient;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.util.List;

/**
 * @ClassName TengXunUtil
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/14  2:18
 * @Version 1.0
 **/
public class TengXunUtil {
    public String accessKey;
    public String secretKey;
    public String regionName;
    public String bucketName;

    public TengXunUtil(String accessKey, String secretKey, String regionName, String bucketName) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.regionName = regionName;
        this.bucketName = bucketName;
    }


    // 将本地文件上传到COS
    public boolean image(String key, File file) {

        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);

        //key只要是能够作为一个唯一表示就可以了
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);


        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosclient.shutdown();
        return true;
    }
    /*
     * @Author 孙若飞
     * @Description //从腾讯云迁移到阿里云 ,先将腾讯云里的图片全部下载,然后全部上传到阿里云
     * @Date 14:37 2019/3/16
     * @Param []
     * @return boolean
     **/

    public static boolean transfer() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDVbYUCfnEKLLBSYt2OoKtDpdJ0OGy4sbg", "5C6A1d1CRZbRmrlTxC7lGvUkkx5DGRaZ");
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);


        //获取文件列表并将文件下载到本地文件夹中
        ObjectListing objectListing = cosclient.listObjects("sunxiaomao-1258817510");
        List<COSObjectSummary> list = objectListing.getObjectSummaries();
        for (COSObjectSummary s : list) {
            String key = s.getKey();
            GetObjectRequest getObjectRequest = new GetObjectRequest("sunxiaomao-1258817510", key);
            //下载图片到本地,由于图片是字节码传输,所以要放到一个.txt文件里
            ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, new File("D:/picture/test.txt"));
        }
        // 关闭客户端(关闭后台线程)
        cosclient.shutdown();


        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient("http://oss-cn-beijing.aliyuncs.com", "LTAIe00haO3zH3SR", "GYJpO2NPHbfWKteZrvLC5smoEVIYpb");

        for (COSObjectSummary s : list) {
            String key = s.getKey();
            File file = new File("D:/picture/test.txt");
            ossClient.putObject("sundamao", key, file);
        }
// 关闭OSSClient。
        ossClient.shutdown();

        return true;
    }

    public static void main(String[] args) {
        transfer();
    }
}
