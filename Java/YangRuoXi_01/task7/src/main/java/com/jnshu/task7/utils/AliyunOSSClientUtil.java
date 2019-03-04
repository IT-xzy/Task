package com.jnshu.task7.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.jnshu.task7.beans.api.Picture;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;

@Slf4j
@Component
public class AliyunOSSClientUtil {
    /**
     * 阿里云所需配置
     */
    private static String bucketName = "yrx-test";
    // 文件存储目录
    /**
     * 阿里云所需配置
     */
    private static String filedir = "test/";

    private static String endpoint = Picture.ENDPOINT;

    private static String accessKeyId = Picture.ACCESS_KEY_ID;

    private static String accessKeySecret = Picture.ACCESS_KEY_SECRET;

    private static String pictureUrl = Picture.PICTUREURL;

//    @Autowired
//    private PictureParams pictureParams;

    private static  OSSClient ossClient;

    public AliyunOSSClientUtil() {
        ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
    }

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
    }

    /**
     * 销毁
     */
    public void destory() {
        ossClient.shutdown();
    }



    /**
     * 上传图片
     *
     * @param url
     */
    public static void uploadImg2Oss(String url) throws Exception {
        File fileOnServer = new File(url);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            uploadFile2OSS(fin, split[split.length - 1]);
        } catch (FileNotFoundException e) {
            throw new Exception("图片上传失败");
        }
    }

    public static String uploadImg2Oss(MultipartFile file) throws Exception {
        log.info("上传图片..");
        //获取文件名称
        String originalFilename = file.getOriginalFilename();
        //获取文件类型
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        //获取随机数
        Random random = new Random();
        //使用随机数和时间戳来命名文件
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            //创建文件流
            InputStream inputStream = file.getInputStream();
            //使用流文件来上传文件和命中
            uploadFile2OSS(inputStream, name);
            //返回图片的名字
            String url = pictureUrl + filedir + name;
            return url;
        } catch (Exception e) {
            throw new Exception("图片上传失败");
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public static String getImgUrl(String fileUrl) {
        log.info("获取图片的路径.." + fileUrl);
        if (!StringUtil.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return getUrl(filedir + split[split.length - 1]);
        }
        log.info("获取图片失败.");
        return null;
    }

    /**
     * 上传到OSS服务器 如果同名文件会覆盖服务器上的
     *
     * @param instream
     *            文件流
     * @param fileName
     *            文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public static String uploadFile2OSS(InputStream instream, String fileName) {
        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentEncoding("UTF-8");
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param filenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    @NotNull
    public static String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10

        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

}
