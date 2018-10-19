package com.lihoo.jnshu.common.util.COSUtil;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;

/**
 * #Title: TencentCOSUtil
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/4-17:14
 */

public class TencentCOSUtil {
//    // 1 初始化用户身份信息(secretId, secretKey)
//    COSCredentials cred = new BasicCOSCredentials("AKIDXXXXXXXX", "1A2Z3YYYYYYYYYY");
//    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
//    ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing-1"));
//    // 3 生成cos客户端
//    COSClient cosclient = new COSClient(cred, clientConfig);
//    // bucket名需包含appid
//    String bucketName = "mybucket-1251668577";
//
//    String key = "/aaa/bbb.txt";
//    File localFile = new File("src/test/resources/len10M.txt");
//    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
//    // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
//    putObjectRequest.setStorageClass(StorageClass.Standard_IA);
//    {
//        try {
//            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
//            // putobjectResult会返回文件的etag
//            String etag = putObjectResult.getETag();
//        } catch (CosServiceException e) {
//            e.printStackTrace();
//        } catch (CosClientException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 关闭客户端
//    cosclient.shutdown();

}
