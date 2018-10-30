package com.lihoo.ssm.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * #Title: ValidateCookie
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/10-13:45
 */


public class ValidateCookie {
    private static Logger logger = LogManager.getLogger(ValidateCookie.class);


//    public String cookieHere(HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//
//        String tokenValue = cookies[i].getValue();
//        logger.info("这个cookie中，名为token的值为：" + tokenValue);
////                        解密token
//        Claims claims = JwtUtils2.parseJWT(tokenValue);
//        System.out.println(claims);
//        String tokenValueDecrypt =  claims.getSubject();
//        System.out.println(tokenValueDecrypt);
//        logger.info("解码token得到用户id和登录时间拼接的字符串为：" + tokenValueDecrypt);
//        String[] arrToken = tokenValueDecrypt.split(",");
//        logger.info("得到一个数组：" + arrToken);
//        String uid = arrToken[0];
//        logger.info("数组索引为“0”的部分是用户id:" + uid);
//        String loginTime = arrToken[1];
//        logger.info("数组索引为“1”的部分是登录时间:" + loginTime);
//        String uname = arrToken[2];
//        logger.info("数组索引为“2”的部分是用户名:" + uname);
//        StudentInfo stuFindByName = studentInfoService.selectByUsername(uname);
//        logger.info("用户信息：" + stuFindByName);
//        Long dblLogtime = stuFindByName.getLogAt();
//        logger.info("数据库存储的登录时间：" + dblLogtime);
//        Long loginTimeLong = Long.parseLong(loginTime);
//    }
}
