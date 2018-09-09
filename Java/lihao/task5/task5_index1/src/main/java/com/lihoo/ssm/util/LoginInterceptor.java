package com.lihoo.ssm.util;

import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * #Title: LoginInterceptor
 * #ProjectName task5_index1
 * #Description: 拦截器
 * #author lihoo
 * #date 2018/9/6-13:19
 * @author lihoo
 */


public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = LogManager.getLogger(LoginInterceptor.class);

    @Autowired
    StudentInfoService studentInfoService;

//    执行之前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        拿到请求中的cookie
        Cookie[] cookies = httpServletRequest.getCookies();
//        判断Cookie中的token有效性判断用户是否登录
        if (cookies != null) {
//            取出token名字的Cookie
            for (int i = 0; i < cookies.length; i++) {
                if ("token".equals(cookies[i])) {
                    logger.info("开始拦截");
//                    取出这个cookie
                    String tokenValue = cookies[i].getValue();
                    logger.info("这个cookie中，名为token的值为：" + tokenValue);
//                    解密token
                    Claims claims = JwtUtils2.parseJWT(tokenValue);
                    System.out.println(claims);
                    String tokenValueDecrypt =  claims.getSubject();
                    System.out.println(tokenValueDecrypt);

//                    String tokenValueDecrypt = DesUtil.decrypt(tokenValue);

                    logger.info("解码token得到用户id和登录时间拼接的字符串为：" + tokenValueDecrypt);
//                    因为之前是用","分隔的用户id和登录时间，所以需要拆解成两个部分
                    String[] arrToken = tokenValueDecrypt.split(",");
                    logger.info("得到一个数组：" + arrToken);
                    String uid = arrToken[0];
                    logger.info("数组索引为“0”的部分是用户id" + uid);
                    String loginTime = arrToken[1];
                    logger.info("数组索引为“1”的部分是登录时间" + loginTime);
                    String uname = arrToken[2];
                    logger.info("数组索引为“2”的部分是用户名" + uname);

//                    对解码之后的token中的登录时间与数据库保存的登录时间做对比
//                    因为uid是一个String，需要转换为Long类型
                    StudentInfo stuFindByName = studentInfoService.selectByUsername(uname);
                    logger.info("用户信息：" + stuFindByName);
                    Long dblLogtime = stuFindByName.getLogAt();
//                    Long dbUid = Long.parseLong(uid);
//                    StudentInfo stu = studentInfoService.selectByPrimaryKey(dbUid);
//                    logger.info("用户信息：" + stu);
//                    Long dblLogtime = stu.getLogAt();
                    logger.info("数据库存储的登录时间：" + dblLogtime);
                    Long loginTimeLong = Long.parseLong(loginTime);
                    if (loginTimeLong.equals(dblLogtime)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
