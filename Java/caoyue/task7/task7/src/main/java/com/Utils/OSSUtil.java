package com.Utils;

/**
 * @author: 曹樾
 * @program: task7
 * @description: use OSS to upload pictures
 * @create: 2018/5/28 下午7:55
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.UnavailableException;

public class OSSUtil {
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAINW6xnz0Qw2Og";
    private static String accessKeySecret = "HLnU0Varkd6kqjppUFKm3owkyOHKK8";
    private static OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    
    private static String bucketName = "caoyue1-2-3-4";
    
    public static String defaultAvatar = "xxxxxxx";
    
    //获得图片在OSS服务器上的key值
    public static String getImgKey(String userName, String suffix){
        StringBuffer sb = new StringBuffer();
        //下面拼接的相当于是key值，key对应于oss服务器中文件的路径
        sb.append("Avatar/");
        sb.append(userName);
        sb.append("/");
        sb.append(suffix);
        return sb.toString();
    }
    
    //获得图片的访问地址
    public static String getImgUrl(String key){
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append(bucketName);
        sb.append(".");
        sb.append(endpoint);
        sb.append("/");
        sb.append(key);
        //将图缩略成宽度为200，高度为200，按长边优先,拼接在url后面就行
        sb.append("?x-oss-process=image/resize,m_lfit,h_200,w_200");
        return sb.toString();
    }
    
    //通过源字节码的方式上传文件至OSS
    public static void uploadFileToOSS(MultipartFile file,String key) throws UnavailableException {
        try {
            client.putObject(bucketName, key, new ByteArrayInputStream(file.getBytes()));
        } catch (IOException e) {
            throw new UnavailableException("发送时转化为字节码失败");
        } catch (OSSException oe) {
            throw new UnavailableException("OSS服务器处理失败，信息：" + oe.getMessage());
        } catch (ClientException ce) {
            throw new UnavailableException("ESC连接至OSS失败，信息：" + ce.getMessage());
        }
    }
    
}
