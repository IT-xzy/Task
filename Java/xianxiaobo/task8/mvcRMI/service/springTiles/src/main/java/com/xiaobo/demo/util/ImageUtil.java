package com.xiaobo.demo.util;

import com.qcloud.cos.COSClient;

import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.Base64;
import com.xiaobo.demo.constant.Global;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

@Component
public class ImageUtil {
    private static Logger log = Logger.getLogger(ImageUtil.class);
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials("AKIDgF1dGgVEMLDzb2G9eAA5rbDnFXlu3wqs", "Sly0zCLNKAsU2Z1JUTRGwEVewxEPVW6w");
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
   ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
//   ClientConfig clientConfig = new ClientConfig();

    // 3 生成cos客户端
   COSClient cosClient = new COSClient(cred, clientConfig);
    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    String bucketName = "image-1253487149";
    public Boolean uploadImage(String name, File file){
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,name,file);
        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
//            System.out.println(etag);
            return true;
        } catch (CosServiceException e) {
            e.printStackTrace();
            log.error("上传文件失败异常："+e);

        } catch (CosClientException e) {
            e.printStackTrace();
            log.error("上传文件失败异常2："+e);
        }
        return false;
    }
    public COSObjectInputStream downloadImage(String name){
            // 下载文件
            COSObject cosObject = cosClient.getObject(bucketName,name);


            // 获取输入流
            return cosObject.getObjectContent();

    }
}
