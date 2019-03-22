package com.jnshu.task7.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;

import java.io.File;

public class DownloadUtil {

    public static void down(String pictureName){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。

        String accessKeyId = "LTAIChkBTW5tQwDd";
        String accessKeySecret = "mZoHA6eQcD0nPmAd3bycV5BzId4mHF";
        String bucketName = "yrx-test";
        String objectName = "test";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("D://picture/" + pictureName + ".jpg"  ));

// 关闭OSSClient。
        ossClient.shutdown();
    }


//    public static void main(String[] args) {
//        down("miku");
//    }


}
