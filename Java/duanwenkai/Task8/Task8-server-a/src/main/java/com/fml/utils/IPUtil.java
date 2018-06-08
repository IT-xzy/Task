package com.fml.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {
    /**
     * http://127.0.0.1:80/Task7
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request){
        StringBuffer sb = new StringBuffer();
        try {
            InetAddress address = InetAddress.getLocalHost();
            sb.append(request.getScheme()).append("://").append(address.getHostAddress()).append(":")
                    .append(request.getServerPort()).append(request.getContextPath());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * http://127.0.0.1:80/Task7/emailVerification?token=xxx
     * @param request
     * @return
     */
    public static String getEmailLink(HttpServletRequest request){
        StringBuffer sb = new StringBuffer();
        sb.append(getBasePath(request)).append("/emailVerification").append("?").append("token=");
        return sb.toString();
    }


    /**
     * 获取客户端真实IP
     * @param request
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
