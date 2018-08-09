package com.Tool;

import com.API.qiniuyun.OssApiQiNiuYun;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Component
public class SdkTools {
    private static Logger logger = LoggerFactory.getLogger(SdkTools.class);
     @Autowired
     com.API.aliyun.aliyunSDK aliyunSDK;
     @Autowired
      OssApiQiNiuYun updateImageSDK;

     public static SdkTools sdkTools;
    @PostConstruct
    public void init() {
        sdkTools = this;
    }
    // 七牛文件转存阿里云
    // prefixHttp 需要知道OSS文件外网地址的前缀
    public boolean qiNiuFileToAliyun(String bucketname, String prefixHttp) {
        return qiNiuFileToAliyunReal(bucketname, "", 1000, "", prefixHttp);
    }

    public boolean qiNiuFileToAliyun(String bucketname, String prefix, int limit, String delimiter, String prefixHttp) {
        return qiNiuFileToAliyunReal(bucketname, prefix, limit, delimiter, prefixHttp);
    }

    private boolean qiNiuFileToAliyunReal(String bucketname, String prefix, int limit, String delimiter, String prefixHttp) {
        // 获取七牛OSS中文件列表
        BucketManager.FileListIterator fileListIterator = sdkTools.updateImageSDK.getObjectList(bucketname, prefix, limit, delimiter);
        if (fileListIterator != null) {
            // 遍历
            while (fileListIterator.hasNext()) {
                FileInfo[] items = fileListIterator.next();
                for (FileInfo item : items) {
                    logger.debug(item.key);
                    logger.debug(item.hash);
                    logger.debug(String.valueOf(item.fsize));
                    logger.debug(item.mimeType);
                    logger.debug(String.valueOf(item.putTime));
                    logger.debug(item.endUser);

                    String httpString = prefixHttp + item.key;
                    logger.debug(httpString);
                    // 读取七牛OSS文件
                    InputStream inputStream = HttpDown.httpDownload(httpString);
                    sdkTools.aliyunSDK.updateFile(null,inputStream, item.key, item.mimeType);
                }
            }
            return true;
        }
        logger.debug("fileListIterator 为空");
        return false;
    }
}
