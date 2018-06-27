package hzw.service;


import com.aliyuncs.exceptions.ClientException;
import hzw.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;

public interface StudentRmi {

    //账户登录(返回boolean)
    boolean nameLogin(String userName,String password);

    //手机验证
    boolean iphoneVerify(String userIphone) throws ClientException;

    //手机登录
    boolean iphoneLogin(String userIphone,String Code);

    //获取cookie
    Cookie getCookie(String userName) throws Exception;

    //注册
    boolean register(User user);

    //发送邮件验证
    boolean sendMail(String url,User user);

    //邮件验证
    boolean verifyMail(String userCode);

    //邮箱登录部分
    boolean mailLogin(String userEmail,String password);

    //图片上传部分
    boolean uploadPicture(MultipartFile file, Long userId);

}
