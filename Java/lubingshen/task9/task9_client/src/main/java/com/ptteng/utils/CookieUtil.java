package com.ptteng.utils;

import com.ptteng.pojo.model.Login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/*有效时间为3个小时*/
public class CookieUtil {

    //添加存储Token的Cookie
    public static void addTokenCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("Token", token);
        //设置为"/"时，全服务器都能访问到这个cookie。也可以具体化，使只能有一个webapp才能访问
        cookie.setPath("/");
        //存活时间，删除时设置为0即可（别忘记设置vaule为null）
        cookie.setMaxAge(60 * 60 * 3);
        //本项目使用了JWT，就只需往session里面添加cookie，不需要添加其他东西了
        response.addCookie(cookie);
    }

    public static boolean checkTokenCookie(HttpServletRequest request,HttpServletResponse response) {
        boolean result = false;
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0)
            return false;
        for (Cookie cookie : cookies) {
            //筛选排除无关cookie
            if (!Objects.equals(cookie.getName(), "Token")) {
                continue;
            }
            //获取所有名为“Token”的Cookie的值
            String token = cookie.getValue();
            if (token == null) {
                break;
            }
            Login login;
            //可能会抛出异常，终止方法
            login = JWTUtil.unsign(token, Login.class);
            //如果ip不对应，拒绝访问
            if (!IPUtil.getIP(request).equals(login.getIp())) {
                break;
            }
            //判断session信息
            String userName = (String) request.getSession().getAttribute("name");
            if(userName == null){
                //很有可能是服务器丢失session属性（比如说关闭浏览器，服务器重启，session过期等）导致的，用jetty本地测试时候经常出现的问题
                CookieUtil.clearTokenCookie(response);
                break;
            } else {
                //直到这步才算验证成功
                result = true;
            }
        }
        return result;
    }

    public static void clearTokenCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("Token",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}


