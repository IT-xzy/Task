package com.jnshutask.util.thirdUtil;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.jnshutask.pojo.servicePojo.AliyunAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;

@Slf4j
@Component
public class ImageAliyun {
    @Autowired
    AliyunAccount aliyunAccount;

    /**
     * 图片上传方法
     *
     * @param imageName 上传到阿里云的图片名称；
     * @param imgPath   上传的文件原始绝对位置
     * @return 上传到阿里oss后的链接全名称
     */
    public String uploadImg(String imageName, String imgPath) {
        String imgUrl = null;
        String endpoint = aliyunAccount.getEndPoint();
        String accessKeyId = aliyunAccount.getAccessKeyId();
        String accessKeySecret = aliyunAccount.getAccessKeySecret();
        String bucketName = aliyunAccount.getBucketName();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            File file = new File(imgPath);
            String key = imageName;
            InputStream inputStream = new FileInputStream(file);
            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentLength(inputStream.available());
            meta.setContentLength(file.length());
            PutObjectResult putResult = ossClient.putObject(bucketName,
                    key, inputStream, meta);
            System.out.println(putResult.getETag());
            imgUrl = "https://" + bucketName + "." + endpoint + "/" + key + "?x-oss-process=style/userImg";
            return imgUrl;
        } catch (Exception e) {
            log.error("上传图片错误 : " + e);
        }
        return imgUrl;
    }

    /**
     * 从阿里oss上进行图片下载
     *
     * @param imageName 下载的图片名称
     * @param imgPath   下载后的文件存储的具体路径
     * @return 下载结果
     */
    public Boolean downloadImg(String imageName, String imgPath) {
        Boolean boo = false;
        String endpoint = aliyunAccount.getEndPoint();
        String accessKeyId = aliyunAccount.getAccessKeyId();
        String accessKeySecret = aliyunAccount.getAccessKeySecret();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String bucketName = aliyunAccount.getBucketName();
        try {
            // 创建OSSClient实例。
//            OSSClient ossClient2 = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            ossClient.getObject(new GetObjectRequest(bucketName, imageName), new File(imgPath));
            // 关闭OSSClient。
            ossClient.shutdown();
            boo = true;
            return boo;
        } catch (Exception e) {
            log.error("下载图片错误 : " + e);
        }
        return boo;
    }

    /**
     * oss存储的文件列表
     *
     * @param bucket oss的bucket名称;
     * @return 文件名称list集合
     */
    public List imgList(String bucket) {
        List fileList = new Vector();
        String endpoint = aliyunAccount.getEndPoint();
        String accessKeyId = aliyunAccount.getAccessKeyId();
        String accessKeySecret = aliyunAccount.getAccessKeySecret();
        String bucketName = aliyunAccount.getBucketName();
        String KeyPrefix = "";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
//            System.out.println("\t" + s.getKey());
            fileList.add(s.getKey());
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        return fileList;
    }
}
