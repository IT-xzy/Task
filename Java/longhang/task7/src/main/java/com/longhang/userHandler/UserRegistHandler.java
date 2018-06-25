package com.longhang.userHandler;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserRegistHandler extends UserHandler {
    private static Logger logger=Logger.getLogger( "UserRegistHandler.class");
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        String v = request.getParameter("verification");
        System.out.println("v::::"+v);
        //获取当前手机号
        String ph=request.getParameter("phone");
        HttpSession session = request.getSession();
        //获取session中的code(对应自己的phone)
        if(session.getAttribute(ph+"phone")!=null) {
            String code = session.getAttribute(ph + "code").toString();
            //获取session中的phone
            String phone1 = session.getAttribute(ph + "phone").toString();
            //获取session中的验证次数
            String count = session.getAttribute(ph + "count").toString();
            //获取session中的验证时间
            String gettime = session.getAttribute(ph + "outtime").toString();
            //获取现在时
            Long thistime = System.currentTimeMillis();
            logger.info("电话1::::" + phone1);
            logger.info("验证次数::::" + count);
            logger.info("code:::::" + code);
            //判断form表单中的验证码是否为空，等于code，验证次数是否大于等于1，验证时效
            if (v != null && v.equals(code) && (Integer.valueOf(count) >0) && (thistime - Long.valueOf(gettime)) < 5 * 60 * 1000) {
                //移除每次获取的code使其失效
                session.removeAttribute(ph + "code");
                return true;
            } else {
                //移除每次获取的code使其失效
                session.removeAttribute(ph + "code");
                return false;
            }
        }
        return false;
    }
}
