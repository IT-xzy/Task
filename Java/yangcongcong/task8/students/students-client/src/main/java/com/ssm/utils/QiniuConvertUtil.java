package com.ssm.utils;

import com.aliyun.oss.OSSClient;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class QiniuConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(QiniuConvertUtil.class);

    @Value("${qiniu.accessKeyId}")
    private String ak;
    @Value("${qiniu.accessKeySecret}")
    private String sk;

    @Value("${aliyun.accessKeyId}")
    private String ossAK;
    @Value("${aliyun.accessKeySecret}")
    private String ossSK;

    public String getOssAK() {
        return ossAK;
    }
    public String getOssSK() {
        return ossSK;
    }

    public String getAk() {
        return ak;
    }
    public String getSk() {
        return sk;
    }

    private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    private static String bucketName = "yangcongcong007";

    private static List<String> urlList = new ArrayList<>();

    public static List<String> getListOfQiniu(String accessKey, String secretKey) throws UnsupportedEncodingException {
        Configuration cfg = new Configuration(Zone.zone2());
        String bucket = "yangcongcong007";
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);

        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                String fileName = item.key;
                urlList.add(fileName);
            }
        }
        return urlList;
    }

    public static void uploadToOSS(String ossAccessKeyId,String ossAccessKeySecret,String fileName) throws IOException {
        OSSClient ossClient = new OSSClient(endpoint, ossAccessKeyId, ossAccessKeySecret);
        InputStream inputStream = new URL("http://p8ehxys9h.bkt.clouddn.com/"+fileName).openStream();
        ossClient.putObject(bucketName, fileName, inputStream);
        logger.info("1");
        ossClient.shutdown();
    }
}
