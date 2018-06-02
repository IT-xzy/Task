package com.task.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 常用cookie处理方法
 */
public class CookieUtil {
    /**
     * 添加cookie的方法
     * @param response
     * @param key cookie主键
     * @param value  cookie值
     */
 public static void addCookie(HttpServletResponse response,String key,String value){
     Cookie cookie=new Cookie(key,value);
     cookie.setPath("/");//设置路径
     cookie.setMaxAge(7*24*60*60);//设置保存时间为7天,单位为s
     response.addCookie(cookie);//通过response.addCookie将此条cookie添加到客户端
    }

    /**
     *删除指定cookie
     * @param response
     * @param request
     * @param key 需要删除的cookie的名称
     */
    public static void delCookie(HttpServletResponse response, HttpServletRequest request,String key){
       Cookie cookies[]=request.getCookies();
       if(cookies!=null){
           for(int i=0;i<cookies.length;i++){
               if(cookies[i].getName().equals(key)){
                   Cookie cookie=new Cookie(key,null);
                   cookie.setPath("/");//此路径需与之前创建时相同
                   cookie.setMaxAge(0);//设置为0即为删除
                   response.addCookie(cookie);
               }
           }
       }
    }

    /**
     * 获取指定key的cookie
     * @param request
     * @param key 输入的需要得到的cookie名
     * @return cookie
     * @throws UnsupportedEncodingException
     */
    public static String getCookieValue(HttpServletRequest request,String key)throws UnsupportedEncodingException {
       //通过request.getCookies获取客户端提交的所有cookie
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(key)) {
                return URLDecoder.decode(cookie.getValue(), "UTF-8");
            }
        }
        return null;
    }
}
