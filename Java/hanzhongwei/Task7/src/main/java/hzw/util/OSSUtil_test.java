package hzw.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.UnavailableException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class OSSUtil_test {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    static String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    static String accessKeyId = "";
    static String accessKeySecret = "";
    private static String bucketName = "image-ls";

    // 在这里创建一个唯一的实例，就不用在程序里总是new了
    // private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    public static void upload(MultipartFile file, String key){
        System.out.println("程序到了这里");
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        System.out.println("程序到了这里0");
        try {
            System.out.println(file.getName());
            System.out.println(file.getOriginalFilename()); //可以获取文件原名

            ossClient.putObject(bucketName, key, new ByteArrayInputStream(file.getBytes()));
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
        }catch (IOException e){
            e.getMessage();
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        // 关闭Client。
        //ossClient.shutdown();

    }
    //获得图片在OSS服务器上的key值
    public static String getImgKey(String userName, String suffix) throws UnavailableException {
        StringBuffer sb = new StringBuffer();
        //下面拼接的相当于是key值，key对应于oss服务器中文件的路径 举个例子：portrait/user1/20180101000000.jpg
        sb.append("portrait/");
        sb.append(userName);
        sb.append("_");
        sb.append(DateUtil.longToString(System.currentTimeMillis(), "yyyyMMddHHmmss"));
        sb.append(suffix);
        return sb.toString();
    }

    //获得图片的访问地址
    public static Boolean getImgUrl(String key){
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append(bucketName);
        sb.append(".");
        sb.append(endpoint);
        sb.append("/");
        sb.append(key);
        //将图缩略成宽度为200，高度为200，按长边优先,拼接在url后面就行
        sb.append("?x-oss-process=image/resize,m_lfit,h_200,w_200");
//        return sb.toString();
        return false;
        // https://image-ls.oss-cn-beijing.aliyuncs.com/main/portrait/%E6%8D%95%E8%8E%B7.PNG?Expires=1528388552&OSSAccessKeyId=TMP.AQEyCOl7g8cK_OlhPnsAL3mrw-5GAus6JfDRbZr_DwBMvuR-V8ClFz0gJw00MC4CFQCaGMvmdcNGpRD52s1K2-6XhkPbUQIVALAWeDtjXVTcx9dI7dgQdq9auOYN&Signature=AlApE51meJBQh%2FWx1YYWFBmm0dQ%3D
    }

}
