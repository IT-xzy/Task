package com.jnshu.task7.utils;

import com.aliyun.oss.OSSClient;
import com.jnshu.task7.beans.api.PictureParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Slf4j
public class UploadPicUtil {

    @Autowired
    private static PictureParams pictureParams;


    @Autowired
    public static void setPictureParams(PictureParams pictureParams) {
        UploadPicUtil.pictureParams = pictureParams;
    }

//    public static String pictureUrl = pictureParams.getPictureUrl();

    /**
     *
     * @param pictureObject
     * @param pictureName
     */
    public static void upload(String pictureObject,String pictureName) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = pictureParams.getEndpoint() ;
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。

        String accessKeyId = pictureParams.getAccessKeyId();
        String accessKeySecret = pictureParams.getAccessKeySecret();
        String bucketName = "";
        String objectName = pictureObject + "/"+ pictureName;


// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。

        ossClient.putObject(bucketName, objectName, new File("D://Miku.jpg"));

// 关闭OSSClient。
        ossClient.shutdown();
    }




    public static void main(String[] args) throws IOException {
        UploadPicUtil.upload("test","miku.jpg");
    }
}
