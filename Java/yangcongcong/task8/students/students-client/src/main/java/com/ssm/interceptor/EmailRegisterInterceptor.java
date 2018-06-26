package com.ssm.interceptor;

import com.ssm.model.UserEmailReg;
import com.ssm.service.UserEmailRegService;
import com.ssm.utils.GetBeanAndRandomSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailRegisterInterceptor extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(EmailRegisterInterceptor.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String e_email = request.getParameter("e_email");
        String e_name = request.getParameter("e_name");
        String e_password = request.getParameter("e_password");
        String emailCode = request.getParameter("emailCode");

        String checkEmail = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(checkEmail);

        //获取redis中的验证码
        String emailCacheCode="";
        if (redisTemplate.opsForValue().get("codeCache" + e_email) != null) {
            emailCacheCode = (String) redisTemplate.opsForValue().get("codeCache" + e_email);
            logger.info("emailCode in cache ::" + emailCacheCode);
        }

        //DB中的用户
        UserEmailRegService userEmailRegService =
                (UserEmailRegService) GetBeanAndRandomSelect.randomSelect("myRMIClientC13", "myRMIClientC23");
        List<UserEmailReg> list = userEmailRegService.getAllEmailReg();
        logger.info("DB中所有用户：" + list);

        //新建一个list集合，用来储存DB中的phoneNum
        List<String> emailList = new ArrayList<>();
        for (UserEmailReg u : list) {
            emailList.add(String.valueOf(u.getE_email()));
        }

        //判断页面传值不为空字符
        if (e_email.length() != 0 && e_name.length() != 0 && e_password.length() != 0 && emailCode.length() != 0) {
            //验证邮箱是否合法
            if (regex.matcher(e_email).matches()) {
                //判断db中是否有重复的用户名
                if (userEmailRegService.getByName(e_name) == null) {
                    //判断是否有重复邮箱
                    if (emailList.contains(e_email)) {
                        logger.info("邮箱重复，转到注册页面");
                        request.getRequestDispatcher("/WEB-INF/jsp/register_email.jsp").forward(request, response);
                    } else {
                        //判断验证码是否相等
                        logger.info("验证码是否相等:{}" + emailCode.equals(emailCacheCode));
                        if (emailCode.equals(emailCacheCode)) {
                            return true;
                        }
                    }
                }
            }
        }

        //不符合条件的，跳转到注册界面
        request.getRequestDispatcher("/WEB-INF/jsp/register_email.jsp").forward(request, response);

        return false;
    }
}
