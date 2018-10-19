package com.zyq.util;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * @author XiaoLuo
 * @ClassName: com.neusoft.controller.util.COSClientUtil
 * @Description: ${todo}
 * @date 2018/3/12 15:37
 */
public class COSClientUtil {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    COSBean cosBean = (COSBean) applicationContext.getBean("cosBean");
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(cosBean.getSecretId(), cosBean.getSecretKey());
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(cosBean.getReginName()));
    // 3 生成cos客户端
    COSClient cosClient = new COSClient(cred, clientConfig);

    private COSClient cOSClient;

    public COSClientUtil() {
        cOSClient = new COSClient(cred, clientConfig);
    }

    /**
     * 销毁
     */
    public void destory() {
        cOSClient.shutdown();
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
