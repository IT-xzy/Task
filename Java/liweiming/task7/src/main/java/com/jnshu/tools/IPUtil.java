package com.jnshu.tools;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @program: task7
 * @description:
 * @author: Mr.Lee
 * @create: 2018-08-01 15:38
 **/
public class IPUtil {

    /**
    * @Description: http://127.0.0.1:80/task7
    * @Param: [request]
    * @return: java.lang.String
    * @Author: Mr.Lee
    * @Date: 2018\8\1 0001
    */
    public static String getBasePath(HttpServletRequest request){
        //http://willming.cn/Task7/emailVerify
        StringBuffer sb = new StringBuffer();
            // getLocalHost 返回本地地址
            sb.append(request.getScheme()).append("://").append(request.getServerName())
                    .append(":").append(request.getServerPort()).append(request.getContextPath());
        return sb.toString();
    }

    /** 
    * @Description: http://127.0.0.1:80/task7/emailVerification?token=xxx
    * @Param: [request] 
    * @return: java.lang.String 
    * @Author: Mr.Lee
    * @Date: 2018\8\1 0001 
    */ 
    public static String getEmailLink(HttpServletRequest request){
        StringBuffer sb  = new StringBuffer();
        sb.append(getBasePath(request)).append("/emailVerification").append("?").append("token=");
        return sb.toString();
    }


}
