package jnshu.tasksix.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Cookie的创建和注销
 * @author: Administrator
 * @date: 2017-10-19
 * @Time: 下午 3:45
 * Description:
 **/
public class CookieUtils {

    public int createCookie(HttpServletResponse response,String cookieName,String value,int time,String path){
        /*设置cookie,  Cookie 里面放的是 用户的id 和 创建时间*/
        Cookie cookie = new Cookie(cookieName,value);
        //2分钟有效时间
        cookie.setMaxAge(time);
        cookie.setPath(path);
        response.addCookie(cookie);
        return 1;
    }

    public int destroyCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookieName.equals(cookies[i].getName())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
        /*同样的cookie名字 可以代替 原来的那个，设置 有效时间为o 就可以注销 */
                cookie.setMaxAge(0);
                /**
                 * 删除 Cookie 时，只设置 maxAge=0 将不能够从浏览器中删除 cookie,
                 * 因为一个 Cookie 应当属于一个 path 与 domain(value)，所以删除时，Cookie 的这两个属性也必须设置。
                 *
                 * 误区: 刚开始时，我没有发现客户端发送到服务器端的 cookie 的 path 与 domain(value) 值为空这个问题。
                 * 因为在登陆系统时，我设置了 Cookie 的 path 与 domain(value) 属性的值, 就误认为每次客户端请求时，都会把 Cookie 的
                 * 这两个属性也提交到服务器端，但系统并没有把 path 与 domain(value) 提交到服务器端 (提交过来的只有 Cookie 的 key，value 值)。
                 */
                // 重点是这里 1, 必须设置 domain 属性的值
//                cookieToken.setValue("");
                // 重点是这里 2, 必须设置 path 属性的值
                cookie.setPath("/");
                response.addCookie(cookie);
                return 0;

            }

        }
        return -1;
    }

}