package com.fangyuyang.subsidiary;


import com.fangyuyang.subsidiary.encrption.DES;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class CookieCheck {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public int cookiesCheck(HttpServletRequest request) {
        String time = "1";
        long allTime = 0;
        long endTime = new Date().getTime();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            int count = 0;
            String[] strings = {"JSESSIONID", "loginUserName", "loginDate"};
            for (Cookie cookie : cookies) {
                if (strings[count].equals(cookie.getName())) {
                    logger.info("测试1： {}", strings[count]);
                    count += 1;
                    logger.info("测试2： {}", cookie.getName());
                    if (count == 3) {
                        logger.info("进入解密时间 {}", cookie.getValue());
                        try {
                            DES des = new DES();
                            time = des.decryptDES(cookie.getValue());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        logger.info("开始时间 {}", time);
                        long beginTime = Long.parseLong(time);
                        logger.info("开始时间： {}", beginTime);
                        if ((allTime = endTime - beginTime) <= 120 * 1000) {
                            logger.info("花费时间，{}", allTime / 1000);
                            logger.info("cookie检验完全");
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }

            }
        }
        return 0;
    }

    public void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            int count = 0;
            String[] strings = {"JSESSIONID", "loginUserName", "loginDate"};
            for (Cookie cookie : cookies) {
                if (strings[count].equals(cookie.getName())) {

                    if ("loginUserName".equals(cookie.getName())) {
                        logger.info("销毁name： {}", strings[count]);
                        cookie.setValue(null);
                        cookie.setMaxAge(0);// 立即销毁cookie
                        cookie.setPath("/");
                        System.out.println("被删除的cookie名字为:"+cookie.getName());
                        response.addCookie(cookie);
                    }
                    if ("loginDate".equals(cookie.getName())) {
                        logger.info("销毁date： {}", strings[count]);
                        cookie.setValue(null);
                        cookie.setMaxAge(0);// 立即销毁cookie
                        cookie.setPath("/");
                        System.out.println("被删除的cookie名字为:"+cookie.getName());
                        response.addCookie(cookie);
                    }
                    count += 1;
                    logger.info("销毁2： {}", cookie.getName());
                    if (count == 3) {
                        logger.info("完全销毁");
                    }
                }
            }
        }
    }
}