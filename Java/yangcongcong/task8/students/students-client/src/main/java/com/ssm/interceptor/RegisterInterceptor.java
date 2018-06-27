package com.ssm.interceptor;

import com.ssm.model.UserRegister;
import com.ssm.service.UserRegisterService;
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

public class RegisterInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String phoneNum = request.getParameter("phoneNum");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifyCode = request.getParameter("verifyCode");

        //获取redis中的验证码
        String codeCache = "";
        if (redisTemplate.opsForValue().get("codeCache" + phoneNum) != null) {
            codeCache = (String) redisTemplate.opsForValue().get("codeCache" + phoneNum);
            logger.info("verifyCode in cache ::" + codeCache);
        }

        //随机访问
        UserRegisterService userRegisterService =
                (UserRegisterService) GetBeanAndRandomSelect.randomSelect("myRMIClientC12", "myRMIClientC22");

        //查询注册表中所有用户
        List<UserRegister> list = userRegisterService.getAllRegister();
        logger.info("DB中所有用户list::" + list);

        //新建一个list集合，用来储存DB中的phoneNum
        List<String> phoneList = new ArrayList<>();
        for (UserRegister u : list) {
            phoneList.add(String.valueOf(u.getPhoneNum()));
        }

        //判断页面传值不为空字符
        if (phoneNum.length() != 0 && username.length() != 0 && password.length() != 0 && verifyCode.length() != 0) {
            //判断db中是否有重复的用户名
            if (userRegisterService.getByName(username) == null) {
                //判断页面的手机号是否有重复
                if (phoneList.contains(phoneNum)) {
                    logger.info("手机号有重复，转到注册页面");
                    request.getRequestDispatcher("/WEB-INF/jsp/register_phone.jsp").forward(request, response);
                } else {
                    //判断验证码是否相等
                    logger.info("验证码是否相等:{}" + verifyCode.equals(codeCache));
                    if (verifyCode.equals(codeCache)) {
                        return true;
                    }
                }
            }
        }

        //不符合条件的，跳转到注册界面
        request.getRequestDispatcher("/WEB-INF/jsp/register_phone.jsp").forward(request, response);

        return false;
    }
}
