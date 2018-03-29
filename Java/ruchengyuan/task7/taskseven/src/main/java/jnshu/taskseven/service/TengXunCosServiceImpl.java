package jnshu.taskseven.service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * 腾讯云对象存储 操作
 * @author: Administrator
 * @date: 2017-11-04
 * @Time: 上午 9:52
 * Description:
 **/

public class TengXunCosServiceImpl {

    private static Logger logTengXunCosUtil = LoggerFactory.getLogger(TengXunCosServiceImpl.class);

    String appId ;
    String secretId ;
    String secretKet ;
    String bucketName;
    ClientConfig clientConfig;
    private static COSCredentials cred;
    private static COSClient cosClient;

//    public void setAppId(String appId) {
//        this.appId = appId;
//    }
//
//    public void setSecretId(String secretId) {
//        this.secretId = secretId;
//    }
//
//    public void setSecretKet(String secretKet) {
//        this.secretKet = secretKet;
//    }


    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setClientConfig(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }


    public TengXunCosServiceImpl(String appId, String secretId, String secretKet){
        this.appId = appId;
        this.secretId = secretId;
        this.secretKet = secretKet;
        cred = new BasicCOSCredentials(appId,secretId,secretKet);
    }


    //创建oss链接
    private void inti(){
        if(cosClient != null){
            logTengXunCosUtil.info("ossClient started ");
            return;
        }

        if(cosClient == null ){
            logTengXunCosUtil.info("ossClient need start ");
            cosClient = new COSClient(cred, clientConfig);
        }
    }

    //销毁oss链接
    private void destroy() {
        if(cosClient != null){
            cosClient.shutdown();
            cosClient = null;
            logTengXunCosUtil.info("cos destory");
        }
    }


    /**
     * @Description: uploadStream 上传一个is流
     * @author Jecced
     * @param path     oss路径
     * @param name     文件名
     * @param in       is输入流
     * @param contentType 手动设置文件类型：image/png等
     * @return
     */
    public String uploadStream(String path, String name, InputStream in, String contentType) {

        String fileName = null;
        try {
            //开启一个链接
            inti();
            fileName = name;
            String firstKey = null;
            if(path =="" || path == null){
                firstKey = name;
            }else {
                firstKey = path + "/" + name;
            }
            firstKey = String.format(firstKey);
            logTengXunCosUtil.info(firstKey);
            int count = 0;
            //保证流传输到
            try {
                while (count == 0) {
                    count = in.available();
                }
            } catch (IOException e) {
                e.printStackTrace();
            logTengXunCosUtil.error("IO传输错误");
            }

            logTengXunCosUtil.info("count: "+ count);
            ObjectMetadata meta = null;
            if (contentType != null) {
                meta = new ObjectMetadata();
                //设置上传的文件类型
                meta.setContentType(contentType);
                //设置流的长度
                meta.setContentLength(count);
            }
            logTengXunCosUtil.info("开始上传");
            PutObjectResult putObjectResult = cosClient.putObject(bucketName, firstKey, in, meta);
            String etag = putObjectResult.getETag();
            logTengXunCosUtil.info("etag : "+etag);
            logTengXunCosUtil.info("图片: "+ name +  " 上传成功");
            destroy();
            in.close();

        } catch (CosServiceException cse) {
            // 自定义异常处理比如打印异常等
            cse.printStackTrace();
            logTengXunCosUtil.error("图片: "+ name +  " 上传失败");
            // ...
        } catch (CosClientException cle) {
            // 自定义异常处理比如打印异常等
            cle.printStackTrace();
            logTengXunCosUtil.error("图片: "+ name +  " 上传失败");
            // ...
        }catch (IOException ioe) {
            ioe.printStackTrace();
            logTengXunCosUtil.error("图片: " + name + " 下载失败");
        } catch (Exception e) {
            e.printStackTrace();
            logTengXunCosUtil.error("图片: "+ name +  " 上传失败");
        } finally {
            destroy();
        }
        return fileName;
    }


    public InputStream getFileStream(String path, String name) {
        InputStream in = null;
        return in;
    }

}