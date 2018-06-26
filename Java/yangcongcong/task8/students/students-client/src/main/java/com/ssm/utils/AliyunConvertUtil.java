package com.ssm.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AliyunConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(AliyunConvertUtil.class);

    @Value("${qiniu.accessKeyId}")
    private String ak;
    @Value("${qiniu.accessKeySecret}")
    private String sk;

    @Value("${aliyun.accessKeyId}")
    private String ossAK;
    @Value("${aliyun.accessKeySecret}")
    private String ossSK;

    public String getAk() {
        return ak;
    }
    public String getSk() {
        return sk;
    }

    public String getOssAK() {
        return ossAK;
    }
    public String getOssSK() {
        return ossSK;
    }

    public static List<OSSObjectSummary> getListOfAliyun(String ossAccessKeyId, String ossAccessKeySecret) {
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        String bucketName = "yangcongcong007";

        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, ossAccessKeyId, ossAccessKeySecret);

        final int maxKeys = 500;

        // 列举Object
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(bucketName).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();

        // 关闭client
        ossClient.shutdown();
        return sums;
    }

    public static void uploadToQiniu(String accessKeyId,String accessKeySecret,String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());

        String bucket = "yangcongcong007";
        String remoteSrcUrl = "https://yangcongcong007.oss-cn-shenzhen.aliyuncs.com/"+fileName;
        Auth auth = Auth.create(accessKeyId, accessKeySecret);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //抓取网络资源到空间
        try {
            FetchRet fetchRet = bucketManager.fetch(remoteSrcUrl, bucket, fileName);
            logger.info("fetchRet:" + fetchRet.key);
        } catch (QiniuException ex) {
            logger.error("QiniuException:"+ex.response.toString());
        }
    }
}
