package hzw.service.impl;

import com.aliyuncs.exceptions.ClientException;
import hzw.model.User;
import hzw.service.StudentRmi;
import hzw.service.StudentService;
import hzw.util.*;
import org.apache.commons.codec.binary.Base64;
import org.oasisopen.sca.annotation.Remotable;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;

@Service
@Component
public class StudentRmiImpl implements StudentRmi {
    @Autowired
    StudentService studentService;
    @Autowired
    SMSUtil smsUtil;
    @Autowired
    SendMailSDK sendMailSDK;
    @Autowired
    AliyunOSSAPI aliyunOSSAPI;

    private static final String skey = "zhongwei";
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentRmiImpl.class);

    @Override
    public boolean nameLogin(String userName, String password) {
        //对密码加盐加密，然后和数据库里的比较
        String passwordMD5 = MD5Util.stringToMD5(password+userName);
        logger.info("加盐加密后的密码："+passwordMD5);
        User user = studentService.findNameUser(userName);
        logger.info("根据用户名查询数据库"+user);
        if (user != null && (user.getUserName()).equals(userName) && (user.getPassword()).equals(passwordMD5)) {
            logger.info("登录成功");
            return true;
        }
        return false;
    }

    @Override
    public boolean iphoneVerify(String userIphone) throws ClientException {
        User user = studentService.findIphone(userIphone);
        if (user != null) {
            String userCode = RandNum.getRandLength(6);
            logger.info("userCode======="+userCode);
            user.setUserCode(userCode);
            studentService.updateUser(user);
            boolean flag = smsUtil.SMSclient(userIphone, userCode);
            logger.info("返回值"+flag);
            return flag;
        }
        return false;
    }

    @Override
    public boolean iphoneLogin(String userIphone, String Code) {
        User user = studentService.findIphone(userIphone);
        if (user != null && Code.equals(user.getUserCode())){
            return true;
        }
        return false;
    }

    @Override
    public Cookie getCookie(String userName) throws Exception {
        User user = studentService.findNameUser(userName);
        Long id = user.getUserId();
        // 使用用户ID+系统当前时间生成唯一token, 格式为键值对
        String token = id + "|" + id + "|" + System.currentTimeMillis();
        logger.info("生成的token是:"+token);
        // 用DES加密key 必须8位
        byte[] bytes = DESUtil.encrypt(token,skey);
        logger.info("加密后的token: " + DESUtil.toHexString(bytes).toUpperCase());
        logger.info("加密后的Base64 token: " + Base64.encodeBase64String(bytes));
        //org.apache.commons.codec.binary.Base64;依赖包
        Cookie cookie = new Cookie("token",Base64.encodeBase64String(bytes));
        // 设置 Cookie 过期时间 单位为秒
        cookie.setMaxAge(7000);
        // 设置 Cookie 有效路径
        cookie.setPath("/");
        logger.info("新生成的Cookie-效时间-值: " + cookie.getName() + "-->" + cookie.getMaxAge() + "-->" + cookie.getValue() + cookie.getPath());
        return cookie;
    }

    @Override
    public boolean register(User user) {
        logger.info("前台传进来的信息："+user.toString());
        User u =  studentService.findNameUser(user.getUserName());
        if (u != null){
            logger.info("已经存在用户");
            return false;
        }else {
            logger.info("开始注册");
            //以用户名为盐
            String salt = user.getUserName();
            //对密码加盐和md5加密
            String passwordMD5 = MD5Util.stringToMD5(user.getPassword() + salt);
            logger.info("加盐加密后的密码：" + passwordMD5);
            user.setPassword(passwordMD5);
            studentService.insertUser(user);
            logger.info("注册的信息是：" + user);
            return true;
        }
    }

    @Override
    public boolean sendMail(String url, User user) {
        String httpUrl = url.split("/sendMail")[0] + "/verifyMail";
        logger.info("访问项目网址为: " + httpUrl);
//        String httpUrl = request.getRequestURI().toString().split("/sendMail")[0] + "/verifyMail";
//        logger.info("访问项目网址为: " + httpUrl);
        String randInt = RandNum.getRandLength(6);
        logger.info("生成的验证码是"+randInt);
        user.setEmailState(0);
        user.setUserCode(randInt);
        studentService.updateUser(user);
        return sendMailSDK.sendMail(httpUrl,user,randInt);
    }

    @Override
    public boolean verifyMail(String userCode) {
        User user = studentService.findCodeUser(userCode);
        if (studentService.findCodeUser(userCode) != null && (user.getUserCode()).equals(userCode)){
            user.setEmailState(1);
            studentService.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean mailLogin(String userEmail, String password) {
        User user = studentService.findMailUser(userEmail);
        if (user != null){
            //对密码加盐加密，然后和数据库里的比较
            String passwordMD5 = MD5Util.stringToMD5(password+user.getUserName());
            logger.info("加盐加密后的密码："+passwordMD5);
            if ((user.getPassword()).equals(passwordMD5) && user.getEmailState() == 1){
                logger.info("登录成功");
                return true;
            }
        }
        logger.info("登录失败");
        return false;
    }

    @Override
    public boolean uploadPicture(MultipartFile file, Long userId) {
        String fileName = MD5Util.getMultipartFileMd5(file);
        Boolean a = aliyunOSSAPI.updateFile(userId,file,fileName);
        if (a){
            logger.info("成功上传阿里云");
            String url = aliyunOSSAPI.geturl1(fileName);
            logger.info("返回的阿里云url为  "+url);
            User user = new User(userId,url);
            studentService.updateUser1(user);
            return true;
        }
        return false;
    }


}
