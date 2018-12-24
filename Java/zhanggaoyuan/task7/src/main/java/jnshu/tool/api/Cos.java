package jnshu.tool.api;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 腾讯云存储工具类
 */
public class Cos {
    private Logger logger = Logger.getLogger (Cos.class);

    private String accessKey;

    private String secretKey;

    //      存储桶所在的区域
    private String regionName;

    //     bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式,如 String bucketName = "mybucket-1251668577";
    private String bucketName;

    //设置contenttype默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值
    private String contentType ;


    private COSClient cc() {
        COSCredentials cred = new BasicCOSCredentials (accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig (new Region (regionName));
        COSClient cosClient = new COSClient (cred, clientConfig);
        return cosClient;
    }

    /**
     * 执行 putObject 方法上传对象，支持将输入流上传到 COS。
     *
     * @param key 要存储的对象的名字
     * @return 1为成功，0为失败
     */
    public String upload(String key, InputStream input) {
        logger.info ("_______________________________________________");
        logger.info ("进入文件上传方法，传进来的key为：" + key);

        COSClient cosClient = cc ();
        logger.info ("____________________________________________");
        logger.info ("客户端生成完毕");

        String url = null;

        ObjectMetadata objectMetadata = new ObjectMetadata ();

// 从输入流上传必须制定content length, 否则http客户端可能会缓存所有数据，存在内存OOM的情况
        objectMetadata.setContentLength (1024 * 1024 * 1024 * 10);

// 设置contenttype默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值，单位字节
        objectMetadata.setContentType (contentType);

//        上传文件
        PutObjectRequest putObjectRequest =
                new PutObjectRequest (bucketName, key, input, objectMetadata);

// 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass (StorageClass.Standard);
        try {
            PutObjectResult putObjectResult = cosClient.putObject (putObjectRequest);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag ();

            logger.info ("_______________________________________________");
            logger.info ("文件上传执行后返回的结果为：" + etag);

            if (etag != null) {
//                字符串拼接图片的URL
                url = "https://jnshu-1257664104.cos.ap-guangzhou.myqcloud.com/" + key;
            }
            logger.info ("图片上传成功返回的URL为：" + url);

        } catch ( CosServiceException e ) {
            e.printStackTrace ();
        } catch ( CosClientException e ) {
            e.printStackTrace ();
        } finally {
            // 关闭客户端
            cosClient.shutdown ();
        }

        logger.info ("上传文件最终返回的URL为：" + url);
        return url;
    }


    public List<String> ListCos() {
        logger.info ("_______________________________________________");
//        logger.info ("进入文件上传方法，传进来的key为：" + key);

//        COSCredentials cred = new BasicCOSCredentials (accessKey, secretKey);
//        ClientConfig clientConfig = new ClientConfig (new Region (regionName));
//        COSClient cosClient = new COSClient (cred, clientConfig);
        COSClient cosClient = cc ();
        logger.info ("____________________________________________");
        logger.info ("客户端生成完毕");

        // 获取 bucket 下成员（设置 delimiter）
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest ();
        listObjectsRequest.setBucketName (bucketName);
// 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
        listObjectsRequest.setPrefix ("jnshu/picture/");
//// 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员

// 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
//        listObjectsRequest.setMarker("");
// 设置最多 list 100个成员,（如果不设置, 默认为1000个，最大允许一次 list 1000个 key）
        listObjectsRequest.setMaxKeys (100);

        ObjectListing objectListing = cosClient.listObjects (listObjectsRequest);

// 获取下次 list 的 marker
        String nextMarker = objectListing.getNextMarker ();
        logger.info ("获取下一个list的起点标记为：" + nextMarker);

// 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
        boolean isTruncated = objectListing.isTruncated ();
        logger.info ("如果 list 结束则为false：" + isTruncated);

        List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries ();

        List<String> urlList = new ArrayList<> ();
        for (COSObjectSummary cosObjectSummary : objectSummaries) {
            String key = cosObjectSummary.getKey ();
            urlList.add (key);
        }
        logger.info ("返回的URL集合为：" + JSON.toJSONString (urlList));

        return urlList;
    }


    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
