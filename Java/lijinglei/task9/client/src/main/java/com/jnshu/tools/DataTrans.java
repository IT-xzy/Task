package com.jnshu.tools;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DataTrans {


    QnOssUntil qnOssUntil = new QnOssUntil();

    @Autowired
    COSClient cosClient;

    /**
     * 七牛云文件列表
     */
    public List qnList() {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        String accessKey = qnOssUntil.getAccessKey();
        String secretKey = qnOssUntil.getSecretKey();
        String bucket = qnOssUntil.getBucket();
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
        List<String> list = new ArrayList<>();
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                list.add(item.key);
            }

        }
        return list;
    }

    public void tranToCos() throws IOException {
        String domainOfBucket = "http://pdotd3prr.bkt.clouddn.com/";
        List list = qnList();
        String bucketName = "logic-1255663509";
        ObjectMetadata objectMetadata = new ObjectMetadata();

        for (Object key : list) {
            String fileName = (String) key;
            String encodedFileName = URLEncoder.encode(fileName, "utf-8");
            String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName) + "?attname=" + fileName;
            System.out.println(finalUrl);
//            URL url = new URL(finalUrl);
//            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
//            uc.connect();
//            InputStream iputstream = uc.getInputStream();
//            int fileLength= uc.getContentLength();
//            objectMetadata.setContentLength(fileLength);
//            System.out.println(fileName+iputstream+objectMetadata+fileLength);
//            cosClient.putObject(bucketName, fileName, iputstream, objectMetadata);
//            System.out.println(fileName+"存入腾讯云成功"+"长度"+fileLength);

            String fileUrl="http://pdotd3prr.bkt.clouddn.com//0286f06382904beea34962e28a1c6371.png?attname=0286f06382904beea34962e28a1c6371.png";
            URL url = new URL(fileUrl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.connect();
            InputStream iputstream = uc.getInputStream();
            int l =  uc.getContentLength();

            System.out.println("\nHTTP"+l);
            objectMetadata.setContentLength(l);
            System.out.println(fileName+iputstream+objectMetadata);

            cosClient.putObject(bucketName,fileName,iputstream,objectMetadata);


        }
        cosClient.shutdown();

    }
}


