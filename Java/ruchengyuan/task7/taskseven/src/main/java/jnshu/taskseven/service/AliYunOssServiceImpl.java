package jnshu.taskseven.service;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 阿里云上传文件
 * @author: Administrator
 * @date: 2017-10-30
 * @Time: 下午 8:24
 * Description:
 **/


public class AliYunOssServiceImpl implements FileService {

    private static Logger logAliOssUtil = LoggerFactory.getLogger(AliYunOssServiceImpl.class);
    private  String endpoint;
    private  String accessKeyId ;
    private  String accessKeySecret ;
    private  String bucketName;
    private  ClientConfiguration clientConfiguration;
    private static OSSClient ossClient;

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }


    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setClientConfiguration(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
    }


    /**
     * 创建oss链接
     */
    private void inti(){

        if (ossClient != null) {
            logAliOssUtil.info(" ossClient started ");
            return;
        }

        if (ossClient == null) {
            logAliOssUtil.info("ossClient need start ");
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, clientConfiguration);
        }

    }

    /**
     * 销毁oss链接
     */
    private static void destroy() {
        if(ossClient != null){
            ossClient.shutdown();
            ossClient = null;
            logAliOssUtil.info("oss destory");
        }
    }


//
//    static {
//        if (ossClient == null) {
//            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, clientConfiguration);
//        }
//        if(ossClient.doesBucketExist(bucketName)){
//            loggerAliOss.info("您已经创建Bucket：" + bucketName + "。");
//        }
//        else{
//            loggerAliOss.info("您的Bucket不存在，创建Bucket：" + bucketName + "。");
//            // 创建Bucket。
//            ossClient.createBucket(bucketName);
//        }
//    }

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

        String fileNme = null;
        try {
            //开启一个链接
            inti();
            fileNme = name;
            String firstKey = null;
            if(path =="" || path == null){
                firstKey = name;
            }else {
                firstKey = path + "/" + name;
            }
            firstKey = String.format(firstKey);

            int count = 0;
            //保证流传输到
            try {
                while (count == 0) {
                    count = in.available();

                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                logAliOssUtil.error("IO传输错误");
            }

        /*
         * 每上传一个Object，都需要指定和Object关 联的ObjectMetadata
         * ObjectMetaData是用户对该object的描述，由一系列name-value对组成；
         * 其中 ContentLength是必须设置的，以便SDK可以正确识别上传Object的大小。
         * Put Object请求处理成功后，OSS会将收到文件的MD5值放在返回结果的ETag中。
         * 用户可以根据ETag检验上传的文件与本地的是否一致。
         *
         * 如果上传文件还要设置ContentLength： meta .ContentLength(file.length())
         */
            ObjectMetadata meta = null;
            if (contentType != null) {
                meta = new ObjectMetadata();
                //设置上传的文件类型
                meta.setContentType(contentType);
                //设置流的长度
                meta.setContentLength(count);
            }

            logAliOssUtil.info("开始上传");
            ossClient.putObject(bucketName, firstKey, in, meta);
            logAliOssUtil.info("图片: "+ name +  " 上传成功");
            destroy();
            in.close();
        }
        catch (OSSException oe) {
            oe.printStackTrace();
            logAliOssUtil.error("图片: "+ name +  " 上传失败");
        } catch (ClientException ce) {
            ce.printStackTrace();
            logAliOssUtil.error("图片: "+ name +  " 上传失败");
        }catch (IOException ioe) {
            ioe.printStackTrace();
            logAliOssUtil.error("图片: " + name + " 下载失败");
        } catch (Exception e) {
            e.printStackTrace();
            logAliOssUtil.error("图片: "+ name +  " 上传失败");
        } finally {
            destroy();
        }
        return fileNme;
    }

    /**
     * 下载文件以流的方式
     * @param path
     * @param name
     * @return 文件的流
     */
    public InputStream getFileStream(String path, String name) {

        inti();
        String firstKey = null;
        if(path =="" || path == null){
            firstKey = name;
        }else {
            firstKey = path + "/" + name;
        }

        firstKey = String.format(firstKey);
        OSSObject ossObject = null;

        //把数据流缓存起来，就可以任意的读取数据了
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            //获取文件
            ossObject = ossClient.getObject(bucketName, firstKey);
            //获取文件元信息
            ObjectMetadata metadata = ossObject.getObjectMetadata();
            Long fileLength = metadata.getContentLength();
            logAliOssUtil.info(name + " fileLength: " + fileLength);
            InputStream in = ossObject.getObjectContent();

            //获取文件流内容到缓存
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            try {
                while ((len = in.read(buffer)) > -1 ) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                byteArrayOutputStream.flush();
            } catch (IOException e) {
                logAliOssUtil.error(e.getMessage(), e);
            }



            logAliOssUtil.info("文件下载完成！");
        } catch (OSSException oe) {
            oe.printStackTrace();
            logAliOssUtil.error("图片: "+ name +  " 下载失败");
        } catch (ClientException ce) {
            ce.printStackTrace();
            logAliOssUtil.error("图片: " + name + " 下载失败");
        } catch (Exception e) {
            e.printStackTrace();
            logAliOssUtil.error("图片: "+ name +  " 下载失败");

        } finally {
            destroy();
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

    }


    /**
     * 获取prefix路径下的所有文件的信息
     * @param prefix
     * @return 返回类型为list的文件信息列表
     */
    public List<String> listFileName (String prefix){

        inti();
        final int maxKeys = 200;
        ObjectListing objectListing;
        String nextMarker = null;
        List<String> fileInformation = new LinkedList<String>();

        try {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);

            if (prefix != null) {
                listObjectsRequest.setPrefix(prefix);
            }
            listObjectsRequest.setMaxKeys(maxKeys);

            do {
                objectListing = ossClient.listObjects(listObjectsRequest);
                List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
                logAliOssUtil.info("" + sums.size());
                for (OSSObjectSummary s : sums) {
                    fileInformation.add(s.getKey());
                }
                nextMarker = objectListing.getNextMarker();

            } while (objectListing.isTruncated());
        }catch (OSSException oe) {
            oe.printStackTrace();
            logAliOssUtil.error("图片list获取失败");
        } catch (ClientException ce) {
            ce.printStackTrace();
            logAliOssUtil.error("图片list获取失败");
        } catch (Exception e) {
            e.printStackTrace();
            logAliOssUtil.error("图片list获取失败");
        } finally {
            destroy();
        }
        return fileInformation;

    }


}