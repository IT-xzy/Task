package utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;

import java.io.File;
import java.io.IOException;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pojo.User;

@Component
public class QiniuyunUtils {
    private String ACCESS_KEY ="CubMCWzNkQ4arRMdJMU9bXH7o2dPvtLa6rFwjJdF";
    private String SECRET_KEY = "vQm_Ewc8FNRDem7UNvjWrS6kc5jA357-xJE0d4Is";
    private Logger logger = LoggerFactory.getLogger(Ossutils.class);

    public String getACCESS_KEY() {
        return ACCESS_KEY;
    }

    public void setACCESS_KEY(String ACCESS_KEY) {
        this.ACCESS_KEY = ACCESS_KEY;
    }

    public String getSECRET_KEY() {
        return SECRET_KEY;
    }

    public void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }

    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    private Zone z = Zone.autoZone();
    private Configuration c = new Configuration(z);
    //创建上传对象
    private UploadManager uploadManager = new UploadManager(c);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    private String getUpToken() {
        String bucketname = "eriri";
        return auth.uploadToken(bucketname);
    }
    public boolean uploadimage(MultipartFile multipartFile,  User user) {
        String fileName = multipartFile.getOriginalFilename();
        String[] filename = fileName.split("\\.");
        String fileName1 = user.getName()+"headimage"+System.currentTimeMillis()+"."+filename[filename.length-1];
        try {
            //调用put方法上传
            Response res = null;
            try {
                res = uploadManager.put(multipartFile.getBytes(), fileName1 , getUpToken());
            } catch (IOException e) {
                logger.error("上传失败"+e.getMessage(),e);
                return false;
            }
            //打印返回的信息
            logger.info(res.bodyString());
            return true;
        }
        catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            logger.error(r.toString());
            try {
                //响应的文本信息
                logger.error(r.bodyString());
                return false;
            } catch (QiniuException e1) {
                //ignore
                return false;
            }
        }
    }
}
