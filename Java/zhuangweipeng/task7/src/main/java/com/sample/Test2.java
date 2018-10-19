package com.sample;

import com.aliyun.oss.OSSClient;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.utils.AliUploadFile;
import com.utils.QiniuUp;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class Test2 {
    @Test
    public void aLiFileList() {
        AliUploadFile aliUploadFile = new AliUploadFile();
        List<String> strings = aliUploadFile.fileList();
        System.out.println(strings);
    }

    @Test
    public void qiNiuToALi() throws QiniuException {
        AliUploadFile aliUploadFile = new AliUploadFile();
        aliUploadFile.transfer();
    }

    @Test
    public void qiNiuList() {
        QiniuUp qiniuUp = new QiniuUp();
        List<String> q = qiniuUp.fileList();
        System.out.println(q);
    }

    @Test
    public void aLiToQiNiu() throws IOException {
        QiniuUp qiniuUp = new QiniuUp();
        qiniuUp.transfer();
    }

    @Test
    public void upLoadLocalFile() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，
        // 请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI2TGWKVTWNgdn";
        String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject("aliyunuploadphoto", "图片.jpg", new File("/C:/Users/Administrator/Desktop/照片/seds.png"));
        // 关闭OSSClient。
        ossClient.shutdown();
    }


    @RequestMapping(value = "/photeUpload", method = RequestMethod.POST)
    public String upLoadPhoto(HttpSession session, @RequestParam("photoPath") MultipartFile photoPath) throws FileNotFoundException {
        if (!photoPath.isEmpty()) {
            File file = new File(photoPath.getName());
            System.out.println(file + "\n\n\n");
            String origionFileName = photoPath.getOriginalFilename();
            System.out.println("上传之前的名称：\n\n" + origionFileName);
            String NewFileName = String.valueOf(UUID.randomUUID()) + origionFileName.substring(origionFileName.lastIndexOf("."));
            System.out.println("上传的名称为：\n\n" + NewFileName);
            String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
            // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，
            // 请登录 https://ram.console.aliyun.com 创建RAM账号。
            String accessKeyId = "LTAI2TGWKVTWNgdn";
            String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流。
            InputStream inputStream = new FileInputStream("photoPath");
            ossClient.putObject("aliyunuploadphoto", "NewFileName", inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return null;
    }

    @Test
    public void qiNiuPhotoUpLoad() {
        //
        //    //构造一个带指定Zone对象的配置类
        //    Configuration cfg = new Configuration(Zone.zone0());
        //    //...其他参数参考类注释
        //    UploadManager uploadManager = new UploadManager(cfg);
        //    //...生成上传凭证，然后准备上传
        //    String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
        //    String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
        //    String bucket = "zwposs";
        //    //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        //    String localFilePath = "C:\\Users\\Administrator\\Desktop\\QQ图片20180910161443.png";
        //    //默认不指定key的情况下，以文件内容的hash值作为文件名
        //    String key = null;
        //    Auth auth = Auth.create(accessKey, secretKey);
        //    String upToken = auth.uploadToken(bucket);
        //    try {
        //        Response response = uploadManager.put(localFilePath, key, upToken);
        //        //解析上传成功的结果
        //        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        //        System.out.println(putRet.key);
        //        System.out.println(putRet.hash);
        //    } catch (QiniuException ex) {
        //        Response r = ex.response;
        //        System.err.println(r.toString());
        //        try {
        //            System.err.println(r.bodyString());
        //        } catch (QiniuException ex2) {
        //            //ignore
        //        }
        //    }
        //}

    }

}
