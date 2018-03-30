package lujing.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * @author lujing
 * Create_at 2018/1/17 10:55
 */
@Component
public class FileUtils {
   private static final Logger logger = Logger.getLogger(FileUtils.class);
   
    @Autowired
    COSClient cosClient;
    
 
    // 4 bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    static String bucketName = "lujing0613-1255932852";
    
    
    
    //服务器根目录
    static String rootPATH = "https://lujing0613-1255932852.cos.ap-chengdu.myqcloud.com/";
    /**
     *
     * @param picFile 前端的传回来文件
     * @return 返回一个保存后的路径
     */
            public  String uploadxx(MultipartFile picFile) {
                
                
                if (picFile != null) {
                    //获得文件的原始名字
                    String originalFileName = picFile.getOriginalFilename();
                    //新的文件名称=uuid+原始名字的后缀.xxx
                    String newFlieName = UUID.randomUUID() + originalFileName.substring(originalFileName.indexOf("."));
                    
                    //储存地址
                    String key = "student/" + newFlieName;
                
                    //将MultipartFile转换为file.
                    
                    try {
                        //创建一个临时文件
                        File temp = File.createTempFile("temp", null);
                        //将MultipartFile 写入临时文件
                        picFile.transferTo(temp);
                        
                        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, temp);
                         cosClient.putObject(putObjectRequest);
                         
                        logger.info("成功：上传地址：" + rootPATH + key);
                        temp.delete();
                        temp.deleteOnExit();
                        cosClient.shutdown();
                        return rootPATH + key;
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.info("......图片上传失败");
                    }
                }
                return null;
            }
            
            public  void deleteObject(String oldFilePath) throws CosServiceException{
                //处理字符串,去掉  rootPATH
                String cosPath = oldFilePath.replace(rootPATH,"");
                cosClient.deleteObject(bucketName,cosPath);
                cosClient.shutdown();
            }
            public   String  getUrl(String oldFilePath){
                //处理字符串,去掉  rootPATH
                String cosPath = oldFilePath.replace(rootPATH,"");
                String bucketName = "lujing0613-1255932852";
                String key = cosPath;
                GeneratePresignedUrlRequest req =
                        new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        
                Date expirationDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
                req.setExpiration(expirationDate);
                URL downloadUrl = cosClient.generatePresignedUrl(req);
                String downloadUrlStr = downloadUrl.toString();
                System.out.println(downloadUrlStr);
            
                return downloadUrlStr;
            }
    
   
}
