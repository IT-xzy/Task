package com.suger.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.suger.pojo.CosBean;
import com.suger.pojo.SendCloudBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * 简单上传的示例
 * @author suger
 * @date 2018/12/21 15:38
 */


public class COSUtils {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");


    CosBean cosBean = ctx.getBean(CosBean.class);
    // bucket名需包含appid
    String bucketName = cosBean.getRegionName();

    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(cosBean.getSecretId(),cosBean.getSecretKey());
    // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(cosBean.getRegionName()));
    // 3 生成cos客户端
    //COSClient cosclient = new COSClient(cred, clientConfig);

    private COSClient cosClient;
    // 利用构造函数生成客户端
    public COSUtils() {
        cosClient = new COSClient(cred, clientConfig);
    }


    /**
     * 销毁
     */

    public void destory() {
        cosClient.shutdown();
    }

    public COSObjectInputStream getFile(String key){
        GetObjectRequest getObjectRequest = new GetObjectRequest(cosBean.getCosBucketName(), key);
        COSObject cosObject = cosClient.getObject(getObjectRequest);
        COSObjectInputStream cosObjectInput = cosObject.getObjectContent();
        destory();
        return cosObjectInput;
    }

    public String uploadFile(String key,File file){
        PutObjectRequest putObjectRequest = new PutObjectRequest(cosBean.getCosBucketName(), key, file);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        String etag = null;
        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            etag = putObjectResult.getETag();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }
        destory();
        return etag;
    }


}
