package com.jnshu.pojo.tool;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/5/28 - 10:02
 */
public class AliyunOss {
    private static Logger logger = Logger.getLogger(AliyunOss.class);

    public String endpoint;
    public String accessKeyId;
    public String accessKeySecret;
    public String bucketName;

    public AliyunOss(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }

    public String uploadImage(String key,InputStream osInput) throws IOException {

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String url = null;
        try {
            if (ossClient.doesBucketExist(bucketName)){
                System.out.println("已创建好Bucket："+bucketName);
            }else{
                System.out.println("您的Bucket不存在");
                ossClient.createBucket(bucketName);
            }
            ObjectMetadata meta = new ObjectMetadata ();
            meta.setContentEncoding ("utf-8");
            PutObjectResult rs = ossClient.putObject (bucketName, key, osInput, meta);
            String etag = rs.getETag ();
            logger.info ("etag为:" + etag);
            ObjectMetadata metadata = ossClient.getObjectMetadata (bucketName, key);
            logger.info ("元数据为：" + metadata.getContentType ());
            if (etag != null) {
                url = "http://pipiretrak.oss-cn-shenzhen.aliyuncs.com/" + key;
                logger.info ("返回的URL：" + url);
            }
        }catch (OSSException oe){
            oe.printStackTrace();
        }catch (ClientException ce){
            ce.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        logger.info("最终的URL："+url);
        return url;
    }

    public boolean transfer() {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        //获取文件列表并将文件下载到本地文件夹中
        //ObjectListing是一个实体类,
        // listObjects是一个返回值为ObjectListing的方法,bucketName作为参数传入,返回对象名(key)
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        //ObjectListing类型的集合list装入bucket里的文件
        List<OSSObjectSummary> oss = objectListing.getObjectSummaries();
        //遍历list,获取所有的key
        for (OSSObjectSummary s : oss) {
            String key = s.getKey();
            ossClient.getObject(new GetObjectRequest("pipiretrak", key), new File("C:/Users/Shinelon/Desktop/image/242345.txt"));
        }
        ossClient.shutdown();
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDKbiU6BWqCYkux3HxyBFNPI5kSIaBm11v", "qwCfxTzrMUSZIH7iBkJ6oRwUyLx2nL1I");
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        //获取文件列表,并将文件上传到腾讯云
        for (OSSObjectSummary c : oss) {
            String key = c.getKey();
            File file = new File("C:/Users/Shinelon/Desktop/image/242345.txt");
            PutObjectRequest putObjectRequest = new PutObjectRequest("pipiretrak-1259336178", key, file);
            cosclient.putObject(putObjectRequest);
        }
        cosclient.shutdown();
        return true;
    }
}
