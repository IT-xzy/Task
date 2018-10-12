package com.lihoo.jnshu.common.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.lihoo.jnshu.common.util.encrypt.JwtUtils2;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author tengj
 * @date 2017/3/29
 */
public class MyInterceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        boolean flag =true;
//        String ip = request.getRemoteAddr();
//        long startTime = System.currentTimeMillis();
//        request.setAttribute("requestStartTime", startTime);
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        System.out.println("用户:"+ip+",访问目标:"+method.getDeclaringClass().getName() + "." + method.getName());
//
//        StudentListDO studentListDO=(StudentListDO) request.getSession().getAttribute("user");
//        if(null==studentListDO){
//            response.sendRedirect("toLogin");
//            flag = false;
//        }else{
//            flag = true;
//        }
//        return flag;
//    }
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    IStudentListService studentListService;

    //    执行之前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("拦截器启动！！！！");
//        拿到请求中的cookie
        Cookie[] cookies = request.getCookies();
//        判断Cookie中的token有效性判断用户是否登录
        if (cookies != null) {
//            取出token名字的Cookie
            for (int i = 0; i < cookies.length; i++) {
                if ("token".equals(cookies[i].getName())) {
                    logger.info("开始拦截");
//                    取出这个cookie
                    String tokenValue = cookies[i].getValue();
                    logger.info("这个cookie中，名为token的值为：" + tokenValue);
//                    解密token
                    Claims claims = JwtUtils2.parseJWT(tokenValue);
                    System.out.println(claims);
                    String tokenValueDecrypt =  claims.getSubject();
                    System.out.println(tokenValueDecrypt);
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
                    QueryWrapper<StudentList> slqw = new QueryWrapper<>();
                    slqw.eq("username", uname);
                    StudentList stu = studentListService.getOne(slqw);
                    logger.info("用户信息：" + stu);
                    Long dblLogtime = stu.getLogAt();
                    logger.info("数据库存储的登录时间：" + dblLogtime);
                    Long loginTimeLong = Long.parseLong(loginTime);
                    if (loginTimeLong.equals(dblLogtime)) {
                        logger.info("token时间和数据库时间一致！");
                        return true;
                    }
                }
            }
        }
        logger.info("不一致！！！！");
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        long startTime = (Long) request.getAttribute("requestStartTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        // 打印方法执行时间
        if (executeTime > 1000) {
            System.out.println("[" + method.getDeclaringClass().getName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
        } else {
            System.out.println("[" + method.getDeclaringClass().getSimpleName() + "." + method.getName() + "] 执行耗时 : "
                    + executeTime + "ms");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
