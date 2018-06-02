package com.Utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 曹樾
 * @program: task7
 * @description: get the url
 * @create: 2018/5/30 下午5:00
 */


public class IPUtil {
    //获得当前url
    public static String getBasePath(HttpServletRequest request){
        StringBuffer sb = new StringBuffer();
        sb.append(request.getScheme());
        sb.append("://");
        sb.append(request.getServerName());
        sb.append(":");
        sb.append(request.getServerPort());
        sb.append(request.getContextPath());
        return sb.toString();
    }
    
    //反向代理下获取用户ip
    public static String getIP(HttpServletRequest request){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        } else {
            return request.getHeader("x-forwarded-for");
        }
    }
    
    //判断是否是黑名单里面的ip,待完善
    public static boolean blackList(){
        return false;
    }
}
