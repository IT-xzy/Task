package com.student.util;







import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    /**
     * 根据名字获取cookie的值  默认使用“utf-8”编码
     * @param request
     * @param name cookie名字
     * @return
     */
    public static String getCookieValueByName(HttpServletRequest request, String name) throws UnsupportedEncodingException, UnsupportedEncodingException {
        Cookie cookie = getCookieByName(request,name);
        if(cookie!=null&& StringUtils.isNotBlank(cookie.getValue())){
            return URLDecoder.decode(cookie.getValue(),"UTF-8");
        }
        else if (cookie.getValue() == null){
            return null;
        }
        else if(cookie.getValue()!=null){
            return "";
        }else{
            return null;
        }
    }

    /**
     * 根据名字修改cookie
     * @param request
     * @param name cookie名字
     * @param value cookie值
     * @param expire cookie新的过期时间--为0则表示删除
     * @param created cookie不存在是否新建
     * @return
     */
    public static Cookie modCookieByName(HttpServletRequest request,String name,String value, Integer expire,boolean created) throws UnsupportedEncodingException {
        Cookie cookie = getCookieByName(request, name);
        if (null != cookie){
            cookie.setMaxAge(expire);
        cookie.setValue(URLEncoder.encode(value.trim(), "UTF-8"));
    }else{
            if(created){
               cookie=createCookie(name,value,expire);
            }
        }
        return cookie;
    }

    /**
     * 新建cookie  默认path为“/”,默认所有值进行UTF-8编码
     * @param name cookie名字
     * @param value cookie值
     * @param expire cookie过期时间--为0则表示删除
     * @return
     */
    public static Cookie createCookie(String name,String value,Integer expire) throws UnsupportedEncodingException {

        Cookie cookie = new Cookie(name.trim(), URLEncoder.encode(value.trim(),"UTF-8"));
        cookie.setMaxAge(expire);
        cookie.setPath("/");
        return cookie;
    }

    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = cookieMap.get(name.trim());
            return cookie;
        }else{
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
