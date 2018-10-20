package com.lihoo.jnshu.common.util.COSUtil;

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

import javax.swing.*;

/**
 * #Title: QiniuyunCOSUtil
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/4-19:36
 * @author lihoo
 */

public class QiniuyunCOSUtil {

    private static Logger logger = LoggerFactory.getLogger(QiniuyunCOSUtil.class);

    public static void picUp(String picturepath) {
        logger.info("进入到七牛云上传方法。");
        try {
            String filePath = picturepath;
            //String fileName = "" + fileChooser.getSelectedFile().getName();
            System.out.println("选择文件路径： " + filePath);
            //System.out.println("选择文件的文件名： " + fileName);
            logger.info("路径转换完成");

            String newURL = filePath.replaceAll("\\\\", "/");
            System.out.println("转义后的文件路径：" + newURL);


            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone1());
            //...其他参数参考类注释
            UploadManager uploadManager = new UploadManager(cfg);
            //...生成上传凭证，然后准备上传
            String accessKey = "K4TAdLO3lavKxOHm-SQ_7VOh5ya0CzjA6EzR2ue_";
            String secretKey = "U6pwAQ_-lPosXG6K8xHj1nFyxv28Z5GYhEQUy66M";
            String bucket = "my-test-001";
            //如果是Windows情况下，格式是 D:\\qiniu\\test.png
            String localFilePath = newURL;
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            String key = null;
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(localFilePath, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println("打印key:" + putRet.key);
                System.out.println("打印Hash:" + putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                //ignore
                }
            }
        } catch (Exception e) {
            System.out.println("七牛云上传图片模块有错误");
            e.printStackTrace();
        }
    }
}
