package jnshu.tool.api;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Oss {
    static Logger logger = Logger.getLogger (Oss.class);

    private String endpoint;//访问OSS的域名

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;//存储桶

    private String KeyPrefix;//要迁移文件的前缀

    /**
     * 上传文件
     *
     * @param firstKey 上传文件的key
     * @param osInput  文件的流形式
     * @return
     */
    public String upload(String firstKey, InputStream osInput) {

        logger.info ("进入upload方法，传进来的参数为：" + firstKey);

        // 生成OSSClient，您可以指定一些参数，详见“SDK手册 > Java-SDK > 初始化”，
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
        OSSClient ossClient = new OSSClient (endpoint, accessKeyId, accessKeySecret);

        String url = null;
        try {

            // 判断Bucket是否存在。
            if (ossClient.doesBucketExist (bucketName)) {
                System.out.println ("您已经创建Bucket：" + bucketName + "。");
            } else {
                System.out.println ("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
                // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
                ossClient.createBucket (bucketName);
            }

            ObjectMetadata meta = new ObjectMetadata ();
            // 设置内容被下载时的名称。
//            meta.setContentDisposition ("touXian");

//            meta.setContentType ("image/jpeg");
            meta.setContentEncoding ("utf-8");
//          开始上传文件
            PutObjectResult rs = ossClient.putObject (bucketName, firstKey, osInput, meta);
            String etag = rs.getETag ();
            logger.info ("etag为:" + etag);

            ObjectMetadata metadata = ossClient.getObjectMetadata (bucketName, firstKey);
            logger.info ("元数据为：" + metadata.getContentType ());

            if (etag != null) {
                //                字符串拼接图片的URL
                url = "http://jnshuz.oss-cn-shenzhen.aliyuncs.com/" + firstKey;
                logger.info ("图片上传成功返回的URL为：" + url);
            }

        } catch ( OSSException oe ) {
            oe.printStackTrace ();
        } catch ( ClientException ce ) {
            ce.printStackTrace ();
        } catch ( Exception e ) {
            e.printStackTrace ();
        } finally {
            ossClient.shutdown ();
        }

        logger.info ("最终返回的URL为：" + url);
        return url;
    }


    public List<String> ListforOss() {
//        logger.info ("进入upload方法，传进来的参数为：" + firstKey);

//        指定要下载文件的前缀


        OSSClient ossClient = new OSSClient (endpoint, accessKeyId, accessKeySecret);
        // 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects (bucketName, KeyPrefix);

        List<OSSObjectSummary> sums = objectListing.getObjectSummaries ();
        List<String> list = new ArrayList<> ();
        for (OSSObjectSummary s : sums) {
            String key = s.getKey ();
            list.add (key);
        }

// 关闭OSSClient。
        ossClient.shutdown ();
        logger.info (JSON.toJSONString ("阿里云的文件列表为：" + JSON.toJSONString (list)));
        return list;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setKeyPrefix(String keyPrefix) {
        KeyPrefix = keyPrefix;
    }
}
