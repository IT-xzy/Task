package com.service;

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


public class UploadHead {

    private String accessKey;
    private String secretKey;
    private String bucket;
    private String path;
    private Logger logger = (Logger) LoggerFactory.getLogger(UploadHead.class);

    public void setAccessKey(String accessKey) {this.accessKey = accessKey;}

    public void setSecretKey(String secretKey) {this.secretKey = secretKey;}

    public void setBucket(String bucket) {this.bucket =bucket;}
    
    public void setPath(String path) { this.path = path;}
    
    
    //传入图片的名称
    public  void UploadAndGetName(String pictureName) {
        String headName = null;
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传

//如果是Windows情况下，格式是 D:\\qiniu\\test.png,这里需要自定义。
        //String localFilePath = "files"+name;
        //String localFilePath = "../../../files/"+name;
        String localFilePath = path + pictureName;
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = pictureName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //System.out.println(putRet.key);
            //System.out.println(putRet.hash);
            headName = putRet.hash; //返回图片名
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                Response x = ex2.response;
                System.err.println(r.toString());
                //ignore
            }
        }
    }


}
