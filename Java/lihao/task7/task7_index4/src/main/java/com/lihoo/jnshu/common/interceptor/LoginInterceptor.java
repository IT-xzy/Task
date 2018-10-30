package com.lihoo.jnshu.common.interceptor;

import com.lihoo.jnshu.admin.service.IStudentListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * #Title: LoginInterceptor
 * #ProjectName task5_index1
 * #Description: 拦截器
 * #author lihoo
 * #date 2018/9/6-13:19
 * @author lihoo
 */

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    IStudentListService studentListService;

//    执行之前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("拦截器启动！！！！");
////        拿到请求中的cookie
//        Cookie[] cookies = request.getCookies();
////        判断Cookie中的token有效性判断用户是否登录
//        if (cookies != null) {
////            取出token名字的Cookie
//            for (int i = 0; i < cookies.length; i++) {
//                if ("token".equals(cookies[i].getName())) {
//                    logger.info("开始拦截");
////                    取出这个cookie
//                    String tokenValue = cookies[i].getValue();
//                    logger.info("这个cookie中，名为token的值为：" + tokenValue);
////                    解密token
//                    Claims claims = JwtUtils2.parseJWT(tokenValue);
//                    System.out.println(claims);
//                    String tokenValueDecrypt =  claims.getSubject();
//                    System.out.println(tokenValueDecrypt);
//                    logger.info("解码token得到用户id和登录时间拼接的字符串为：" + tokenValueDecrypt);
////                    因为之前是用","分隔的用户id和登录时间，所以需要拆解成两个部分
//                    String[] arrToken = tokenValueDecrypt.split(",");
//                    logger.info("得到一个数组：" + arrToken);
//                    String uid = arrToken[0];
//                    logger.info("数组索引为“0”的部分是用户id" + uid);
//                    String loginTime = arrToken[1];
//                    logger.info("数组索引为“1”的部分是登录时间" + loginTime);
//                    String uname = arrToken[2];
//                    logger.info("数组索引为“2”的部分是用户名" + uname);
////                    对解码之后的token中的登录时间与数据库保存的登录时间做对比
////                    因为uid是一个String，需要转换为Long类型
//                    StudentListDO stuFindByName = studentListService.selectByUsername(uname);
//                    logger.info("用户信息：" + stuFindByName);
//                    Long dblLogtime = stuFindByName.getLogAt();
//                    logger.info("数据库存储的登录时间：" + dblLogtime);
//                    Long loginTimeLong = Long.parseLong(loginTime);
//                    if (loginTimeLong.equals(dblLogtime)) {
//                        logger.info("token时间和数据库时间一致！");
//                        return true;
//                    }
//                }
//            }
//        }
//        logger.info("不一致！！！！");
//        request.getRequestDispatcher("/login.page").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
