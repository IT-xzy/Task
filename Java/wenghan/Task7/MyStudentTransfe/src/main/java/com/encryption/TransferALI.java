package com.encryption;

import com.aliyun.oss.OSSClient;
import com.qiniu.storage.UploadManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TransferALI implements Transfer{

    //外链
    private final String Line="https://wh-test-bucket.oss-cn-shenzhen.aliyuncs.com/";

    //迁移
    @Override
    public void TransferImage() {
        //获得阿里云操作对象
        OSSClient ossClient=OssUtils.getOSSClient();
        //获得键值列表
        List<String> list=OssUtils.getFileList(ossClient,"wh-test-bucket");
        for(int i=0;i<list.size();i++){
            list.get(i);
            //根据键值获取URL的字符串格式
            String urlString=OssUtils.getUrl(ossClient,"wh-test-bucket",list.get(i));
            try {
                //根据URL的字符串创建URL
                URL url=new URL(urlString);
                try {
                    //调用URL的获取输入流方法，获取到键值对应的文件的输入流
                    InputStream inputStream=url.openStream();
                    //获得七牛操作对象
                    UploadManager uploadManager=qiniuMySevenCattle.getUploadManager();
                    //调用七牛的根据输入流上传的方法
                    qiniuMySevenCattle.uploadFile(uploadManager,inputStream,list.get(i));
                    //关闭输入流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        //关闭阿里云操作对象
        OssUtils.shutDownOssClient(ossClient);
    }

    //上传
    @Override
    public void uploadImage(InputStream inputStream,String objectName) {
        //获得操作对象
        OSSClient ossClient=OssUtils.getOSSClient();
        //上传，根据文件流，设置键名
        OssUtils.setFile(ossClient,inputStream,"wh-test-bucket",objectName);
        //关闭操作对象
        OssUtils.shutDownOssClient(ossClient);
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
