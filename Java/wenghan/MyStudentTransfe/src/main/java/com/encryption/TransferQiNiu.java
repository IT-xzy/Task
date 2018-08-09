package com.encryption;

import com.aliyun.oss.OSSClient;
import com.qiniu.storage.UploadManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TransferQiNiu implements Transfer {

    //外链
    private final String Line="http://pcau07bz8.bkt.clouddn.com/";

    //迁移
    @Override
    public void TransferImage() {
        //获得七牛的操作对象
        UploadManager uploadManager=qiniuMySevenCattle.getUploadManager();
        //获得库中的所有键值
        List<String> list=qiniuMySevenCattle.getFileList();
        for(int i=0;i<list.size();i++){
            //获得当前键值对应的URL字符串
            String urlString=qiniuMySevenCattle.downloadFileURL(list.get(i));
            try {
                //根据URL字符串创建URL对象
                URL url=new URL(urlString);
                try {
                    //调用URL的方法获得键值的输入流
                    InputStream inputStream=url.openStream();
                    //获得阿里云的操作对象
                    OSSClient ossClient=OssUtils.getOSSClient();
                    //调用阿里云工具类的文件流上传方法
                    OssUtils.setFile(ossClient,inputStream,"wh-test-bucket",list.get(i));
                    //关闭阿里云操作对象
                    OssUtils.shutDownOssClient(ossClient);
                    //关闭输入流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    //上传
    @Override
    public void uploadImage(InputStream inputStream, String objectName) {
        //获得操作对象
        UploadManager uploadManager=qiniuMySevenCattle.getUploadManager();
        //上传，根据文件流，设置键名
        qiniuMySevenCattle.uploadFile(uploadManager,inputStream,objectName);
        try {
            //关闭输入流
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获得外链
    @Override
    public String getlLink() {
        return Line;
    }

}
