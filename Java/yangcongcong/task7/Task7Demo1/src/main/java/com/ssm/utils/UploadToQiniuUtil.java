package com.ssm.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * 数据流上传
 */
@Component
@Lazy
public class UploadToQiniuUtil implements UploadStrategyDao {

    @Value("${qiniu.accessKeyId}")
    private String ak;
    @Value("${qiniu.accessKeySecret}")
    private String sk;

    @Autowired
    private UploadToQiniuUtil uploadToQiniuUtil;

    public String getAk() {
        return ak;
    }
    public String getSk() {
        return sk;
    }

    private static final Logger logger = LoggerFactory.getLogger(UploadToQiniuUtil.class);

    public void upload(String fileName, InputStream stream) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);

        //...生成上传凭证，然后准备上传
        String bucket = "yangcongcong007";

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //String key = fileName;

        DefaultPutRet putRet = null;
        try {
            Auth auth = Auth.create(uploadToQiniuUtil.getAk(), uploadToQiniuUtil.getSk());
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(stream,fileName,upToken,null, null);
                //解析上传成功的结果
                putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            } catch (QiniuException ex) {
                Response r = ex.response;
                logger.error("QiniuException:"+r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    ex2.error();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return putRet;
    }
}
