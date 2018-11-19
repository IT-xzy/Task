package task7.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import task7.service.thumbnail.Thumbnail;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 阿里云 OSS文件类
 *
 * @author YuanDuDu
 */
public class OSSClientUtil {

    private static Logger logger = Logger.getLogger(OSSClientUtil.class);
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIYJkbrR5aHKIX";
    private static String accessKeySecret = "NPfctvHtPjIfS0f3Z5F1YgM3lHK4ut";
    private static String bucketName = "tas7haiqing";
    private static String urlPrefix = "http://tas7haiqing.oss-cn-beijing.aliyuncs.com/";

    //文件存储目录
    private static String filedir = "data/";

    /**
     * 初始化
     */
    private static OSSClient ossClient;

    static {
        if (ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
    }


    /**
     * 销毁
     */
    public static void destory() {
        ossClient.shutdown();
    }

    /**
     * 上传图片
     *
     * @param url
     */
    public static void uploadImg2Oss(String url) {
        File fileOnServer = new File(url);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            uploadFile2OSS(fin, split[split.length-1]);
        } catch (FileNotFoundException e) {
            logger.error("图片上传失败");
        }
    }


    public static String uploadImg2Oss(MultipartFile file) {
        if (file.getSize() > 1024 * 1024) {
            logger.info("上传图片大小不能超过1M！");
        }

        String originalFilename = file.getOriginalFilename();
        String substring = null;
        if (originalFilename != null) {
            substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        }
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            Thumbnail.generateThumbnail(file);
            InputStream inputStream = file.getInputStream();
            uploadFile2OSS(inputStream, name);
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public static String getImgUrl(String fileUrl) {
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return getUrl(filedir + split[split.length - 1]);
        }
        return null;
    }

    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public static String uploadFile2OSS(InputStream instream, String fileName) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
            logger.info(ret);
        } catch (IOException e) {
            logger.info(e.getMessage());
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
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
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
    public static String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 列举一个文件夹下所有的url
     *
     * @return 所有链接的集合
     */
    public static List<String> getListUrl() {
        ObjectListing objectListing = ossClient.listObjects(bucketName, filedir);
        List<OSSObjectSummary> summaries = objectListing.getObjectSummaries();
        List<String> keys = new ArrayList<>();
        for (OSSObjectSummary s : summaries) {
            keys.add(urlPrefix + s.getKey());
        }
        return keys;
    }

    public static String captureResource(String url) {
        String ll = null;
        if (url != null) {
            String fileName = url.substring(url.lastIndexOf("/") + 1);
            logger.info(fileName);
            try {
                //URL url1 = new URL(url);// 构造URL
                //HttpURLConnection con = (HttpURLConnection)url1.openConnection();
                uploadFile2OSS(new URL(url).openStream(), fileName);
                ll = getImgUrl(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        //List<String> keys = getListUrl();
        //for (String s : keys) {
        //    System.out.println(s);
        //}
        System.out.println(captureResource("http://editerupload.eepw.com.cn/201809/61001537857032.jpg"));
    }

}