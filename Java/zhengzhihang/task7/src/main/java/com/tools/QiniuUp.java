package com.tools;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class QiniuUp {
    @Resource
    private AliUploadFile aliUploadFile;
    @Resource
    private UrlStream urlStream;

   private  String accessKey;// "7Y4VP0R3JGggsd3g4Pw_O8JEP_nUNP7VpkSuTC0j";
   private  String secretKey;// "Y__Fus7V0jxciwOMqFXuVPCvkiyhtTgLAkFwp7UW";
   private  String bucket;// "arnold-cheng";
   private  String format;
    private  String remoteSrcUrl;//https://arnold-cheng.oss-cn-shenzhen.aliyuncs.com/

    public String getRemoteSrcUrl() {
        return remoteSrcUrl;
    }
    public void setRemoteSrcUrl(String remoteSrcUrl) {
        this.remoteSrcUrl = remoteSrcUrl;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 上传文件
     * @param file
     * @param objectName
     */
    public  void uploadFile(CommonsMultipartFile file, String objectName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket,objectName+format);
            InputStream inputStream = null;
            try {
                inputStream =file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Response response = null;
                try {
                    response = uploadManager.put(inputStream, objectName+format, upToken, null, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //解析上传成功的结果
                assert response != null;
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }catch (Exception e){
            e.getMessage();
        }

    }

    /**
     * 获得文件列表
     */
    public  List<String> fileList(){
        List<String> list=new ArrayList<>();
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
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
            for (FileInfo item  : items) {
                list.add(item.key);
                System.out.println(item.key);
            }
        }
        return list;
    }

    /**
     * 文件迁移： 阿里下载到七牛
     */
    public void transfer(){
//构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        List<String> list=aliUploadFile.fileList();
        String url=aliUploadFile.getRemoteSrcUrl();
        UploadManager uploadManager = new UploadManager(cfg);
        for (String objectname : list) {
            String upToken = auth.uploadToken(bucket,objectname);
            String encodeObjectName=null;
            try {
              encodeObjectName=URLEncoder.encode(objectname, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String lastUrl =String.format("%s/%s",url,encodeObjectName);
            try {
                Response response = null;
                try {
                    response = uploadManager.put(urlStream.urlInputstream(lastUrl), objectname, upToken, null, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //解析上传成功的结果
                assert response != null;
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }
        }
    }



