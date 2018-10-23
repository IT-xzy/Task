package com.jnshutask.util.thirdUtil;

import com.google.gson.Gson;
import com.jnshutask.pojo.servicePojo.QNossAccount;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Vector;

/*
 * 七牛云上传工具类*/
@Slf4j
@Component
public class QNossUtil {
    @Autowired
    QNossAccount qNossAccount;

    /**
     * 上传文件
     *
     * @param localFileName 本地和上传至云存储的文件名称；
     * @param localFilePath 本地的文件路径名称；
     * @return 返回上传后的文件外链；
     */
    public String uploadImage(String localFileName, String localFilePath) {
        String fileUrl = null;
        //构造一个带指定Zone对象的配置类;Zone.zone1()指的是华北地区的服务器机房；
        //其余地区的机房请参考七牛云官网；
        Configuration cfg = new Configuration(Zone.zone1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //生成上传凭证，然后准备上传
        String accessKey = qNossAccount.getAccessKey();
        String secretKey = qNossAccount.getSecretKey();
        String bucket = qNossAccount.getBucketName();
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String filePath = localFilePath + localFileName;
        System.out.println("本地全限定名称为" + filePath);
        //key,上传的文件名称；默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = localFileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            log.info(putRet.key);
            log.info(putRet.hash);
            //fileName = "color.jpg";
            String domainOfBucket = qNossAccount.getDomainOfBucket();
            String encodedFileName = URLEncoder.encode(filePath, "utf-8");
            String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
            //增加图片处理样式，imgType;
            String imgType = qNossAccount.getImgType();
            fileUrl = finalUrl + imgType;
            log.info("文件上传后的外链地址为:{}" , fileUrl);
            return fileUrl;
        } catch (QiniuException ex) {
            Response r = ex.response;
            log.error(r.toString());
            log.error("上传的图片出错{}",ex);
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (Exception e) {
            log.error("上传的图片出错{}",e);
        }
        return fileUrl;
    }

    /**
     * 下载文件
     *
     * @param onlineFileName 要下载的文件名称及保存到本地的名称
     * @param localFilePath  本地的文件路径名称；
     * @return 正确为true
     */
    public Boolean getFile(String onlineFileName, String localFilePath) {
        String fileUrl = qNossAccount.getDomainOfBucket() + onlineFileName + "?attname=" + onlineFileName;
        Boolean boo = false;
        try {
            URL theURL = new URL(fileUrl);
            String filePath = localFilePath;
            URLConnection con = theURL.openConnection();
            //String urlPath = con.getURL().getFile();
            //System.out.println(urlPath);
            String fileFullName = onlineFileName;
            if (fileFullName != null) {
                byte[] buffer = new byte[1024];
                int read;
                String path = filePath + "/" + fileFullName;
                File fileFolder = new File(filePath);
                if (!fileFolder.exists()) {
                    fileFolder.mkdirs();
                }
                InputStream in = con.getInputStream();
                FileOutputStream os = new FileOutputStream(path);
                while ((read = in.read(buffer)) > 0) {
                    os.write(buffer, 0, read);
                }
                os.close();
                in.close();
                boo = true;
            }
        } catch (Exception e) {
            log.error("七牛云从网上下载出错{}",e);
        }
        return boo;
    }

    /**
     * 获取七牛云指定的bucketname的文件列表
     *
     * @param bucketName 指定的bucketname；
     * @return list 文件名称集合
     */
    public List getFileList(String bucketName) {
        //用来存放文件名称的list
        List listFileName = new Vector();
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone1());
        //...其他参数参考类注释
        String accessKey = qNossAccount.getAccessKey();
        String secretKey = qNossAccount.getSecretKey();
//        String bucket = qNossAccount.getBucketName();
        String bucket = bucketName;
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
                //System.out.println(item.key);
                listFileName.add(item.key);
                //System.out.println(item.hash);
                //System.out.println(item.fsize);
                //System.out.println(item.mimeType);
                //System.out.println(item.putTime);
                //System.out.println(item.endUser);
            }
            log.info("指定的bucket中的所有图片名称为:{}",listFileName);
        }
        return listFileName;
    }
}
