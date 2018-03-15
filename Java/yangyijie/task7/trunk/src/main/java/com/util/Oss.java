package com.util;

import com.aliyun.oss.OSSClient;
import com.dao.UserDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Arike
 * Create_at 2018/1/22 10:20
 */
public class Oss {
    
    /**
     * 图片上传
     * @param is 输入的流文件
     * @param end  截取的文件后缀名
     * @return 返回图片地址
     */
    public static String fileUp(InputStream is, String end) {
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        String accessKeyId = "LTAIXWs20mDbPOCG";
        String accessKeySecret = "OnWBWPDSJEuiBpuzl9JT9q06U60uzQ";
        // 创建OSSClient实例
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String key = "task7/"+UUID.randomUUID()+"."+end;
        // 使用访问OSS
        // 上传文件流
        client.putObject("head-file", key, is);
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭client
        client.shutdown();
        
        return "http://head-file.oss-cn-beijing.aliyuncs.com/"+key;
    }
}
