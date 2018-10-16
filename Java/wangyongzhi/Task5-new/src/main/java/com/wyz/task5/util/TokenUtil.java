package com.wyz.task5.util;

import com.wyz.task5.util.desEncryption.DesUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 生成Token令牌
 */
public class TokenUtil {

    /**
     *@Description: 生成token令牌
     * @param username  String
     * @param loginTime long
     * @param response  HttpServletResponse
     */
    public static void createToken(String username, long loginTime, HttpServletResponse response) {
        String time = longFormString(loginTime);
        time = DesUtil.encrypt(time);
        CookieUtil.addCookie(response, "time", time);
        username = DesUtil.encrypt(username);
        CookieUtil.addCookie(response, "username", username);

    }


    /**
     * 把long类型的时间转换成String
     *
     * @param time long
     * @return byte[]
     */
    public static String longFormString(long time) {
        String logintime = String.valueOf(time);
        return logintime;
    }

    /**
     * 把String类型的时间转换成long
     *
     * @param time String
     * @return byte[]
     */
    public static long stringFormLong(String time) {
        long logintime = Long.parseLong(time);
        return logintime;
    }
}
