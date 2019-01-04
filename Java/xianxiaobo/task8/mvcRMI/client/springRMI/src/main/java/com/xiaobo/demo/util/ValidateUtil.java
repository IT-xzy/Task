package com.xiaobo.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.xiaobo.demo.pojo.PhoneCode;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.CommonService;
import com.xiaobo.demo.service.PhoneCodeService;
import com.xiaobo.demo.service.RMIService;
import com.xiaobo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ValidateUtil {
    @Autowired
    User user;
    @Autowired
    RMIService rmiService;
    @Autowired
    PhoneCode phoneCode;
    @Autowired
    CaptchaUtil captchaUtil;

    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z][a-zA-Z0-9]{3,15}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_PHONE = "^[1][3,4,5,7,8][0-9]{9}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^\\w+@[a-zA-Z0-9]{2,10}(?:\\.[a-z]{2,4}){1,3}$";

    /**
     * 正则表达式：验证短信验证码
     */
    public static final String REGEX_CODE = "^\\d{6}$";
    public String checkLoginParam(JSONObject data){
        String username = data.getString("username");
        String password = data.getString("password");
        User user = new User();
        if(username==null||password==null||username.length()==0||password.length()==0){
            return "用户名和密码不能为空";
        }
        if(username.matches(REGEX_USERNAME)){
            user.setUsername(username);
        }else if(username.matches(REGEX_EMAIL)){
            user.setEmail(username);
        }else if(username.matches(REGEX_PHONE)){
            user.setPhone(username);
        }else{
            return "用户名无法通过正则校验";
        }
        User userResult = rmiService.getUserService().getUser(user);
        if(userResult==null){
            return "用户名不存在";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password,userResult.getPassword())){
            return "密码错误";
        }
        if(userResult.getStatus()==User.USER_DEFAULT_STATUS){
            return "该账号尚未激活，请检查你的邮箱中的邮件。如果你填的邮箱账号不是你的，请联系管理员帮你重置邮箱。";
        }
        return "true";
    }
    public Long getUserId(JSONObject data){
        String username = data.getString("username");
        if(username.matches(REGEX_USERNAME)){
            user.setUsername(username);
        }
        if(username.matches(REGEX_EMAIL)){
            user.setEmail(username);
        }
        if(username.matches(REGEX_PHONE)){
            user.setPhone(username);
        }
        User userResult = rmiService.getUserService().getUser(user);
        return userResult.getId().longValue();
    }
    public String checkRegisterParam(JSONObject data){
        String username = data.getString("username");
        String password = data.getString("password");
        String email = data.getString("email");
        String phone = data.getString("phone");
        String code = data.getString("code");
        if(username==null||!username.matches(REGEX_USERNAME)){
            return "用户名由英文字母和数字组成的4-16位字符，以字母开头";
        }
        if(password==null||!password.matches(REGEX_PASSWORD)){
            return "密码长度应为6-20位，且只能包含数字和字母";
        }
        if(email==null||!email.matches(REGEX_EMAIL)){
            return "邮箱地址不能通过正则校验";
        }
        if(phone==null||!phone.matches(REGEX_PHONE)){
            return "手机号码不能通过正则校验";
        }
        if(code==null||!code.matches(REGEX_CODE)){
            return "短信验证码不能通过正则校验";
        }
        if(rmiService.getCommonService().isDataExist("user","username",username)){
            return "用户名已存在";
        }
        if(rmiService.getCommonService().isDataExist("user","phone",phone)){
            return "手机号已存在";
        }
        if(rmiService.getCommonService().isDataExist("user","email",email)){
            return "邮箱已存在";
        }
        PhoneCode phoneCode = rmiService.getPhoneCodeService().selectByPhone(phone);
        if(phoneCode==null||!code.equals(phoneCode.getCode())){
            return "短信验证码错误";
        }
        if(System.currentTimeMillis()-phoneCode.getUpdateAt()>180000){
            return "短信验证码已过期";
        }
        return "true";
    }
    public String checkCaptchaParam(String token,String phone){
        // 判断手势验证码是否为空
        if(token==null||token.length()==0){
            return "手势验证码不能为空";
        }
        // 判断手机号码是否能通过正则
        if(phone==null||!phone.matches(REGEX_PHONE)){
            return "手机号码不能通过正则校验";
        }
        // 判断该手机号是否已注册
        if(rmiService.getCommonService().isDataExist("user","phone",phone)){
            return "该手机号已注册";
        }
        // 判断手势验证码是否有效
        try{
            if(!captchaUtil.isTokenValid(token)){
                return "手势验证码错误或者已过期";
            }
        }catch(Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return "true";
    }
}
