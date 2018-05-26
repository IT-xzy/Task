package com.ssm.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
@Lazy
public class UploadToOSSUtil implements UploadStrategyDao {

    @Value("${aliyun.accessKeyId}")
    private String ossAK;
    @Value("${aliyun.accessKeySecret}")
    private String ossSK;

    @Autowired
    private UploadToOSSUtil uploadToOSSUtil;

    public String getOssAK() {
        return ossAK;
    }

    public String getOssSK() {
        return ossSK;
    }



    private static final Logger logger = LoggerFactory.getLogger(UploadToOSSUtil.class);

    private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    private static String bucketName = "yangcongcong007";

    public int upload(String fileName, InputStream inputStream) throws IOException {
        OSSClient ossClient = new OSSClient(endpoint, uploadToOSSUtil.getOssAK(), uploadToOSSUtil.getOssSK());
        try {
            ossClient.putObject(bucketName, fileName, inputStream);
        } catch (OSSException | ClientException e) {
            logger.error("OSSException:"+e);
        } finally {
            ossClient.shutdown();
        }
        return 1;
    }
}
