package com.ev.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.UnavailableException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class OSSUtil {

    private final String endpoint;
    private final String accessKeyId;
    private final String accessKeySecret;
    private final String bucketName;

    public OSSUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endpoint = endpoint;
        this.bucketName=bucketName;
        client = new OSSClient(this.endpoint, this.accessKeyId, this.accessKeySecret);
    }

    private OSSClient client;

    public static String defaultAvatar = "xxxxxxx";

    public static String getImgKey(String userName, String suffix) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("Avatar/");
        sb.append(userName);
        sb.append("/");
        sb.append(TimeFormatUtil.longToString(System.currentTimeMillis()));
        sb.append(suffix);
        return sb.toString();
    }

    //获得图片的访问地址
    public String getImgUrl(String key) {
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
    public  void uploadFileToOSS(MultipartFile file, String key) throws UnavailableException {
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
