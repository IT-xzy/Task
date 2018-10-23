package yxpTask6.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpCookiesToken

{
    static Logger logger=Logger.getLogger(HttpCookiesToken.class);
    public void createCookie(HttpServletRequest request,HttpServletResponse response,
                                 String cookieName, String cookieValue, int cookieMaxAge)
    {

        String url=request.getContextPath();
//        System.out.println(url);
        //从request中读取cookie
        Cookie cookies []=request.getCookies();
        //看下cookies中的信息；
        for(Cookie coo:cookies)
        {
            //默认的cookie中只有名字和值，
            Cookie cookie1=new Cookie(coo.getName(),coo.getValue());
            //删除的话，路劲设置和设定的一样才行；
            //使用getPath(),得不到cookie的路径，request中不包含这个信息；
            cookie1.setPath(url);
            //cookie1.setDomain("localhost");
            //cookie1.setHttpOnly(true);
            cookie1.setMaxAge(0);
            //将每个cookie放入response中
            response.addCookie(cookie1);
        }
            //新建一个cookie，包含token
            Cookie cookie = new Cookie(cookieName, cookieValue);
            //为cookie设置路径权限,不声明使用默认路径；
            cookie.setPath(url);
            //设置读取cookie的权限,不知道这个为什么不能设置这个属性，别的都可以的。。
            //cookie.setHttponly(true);
            //设置cookie的过期时间
            if (cookieMaxAge > 0)
            {
                //cookie的有效期设置为3天；跟token一致；
                cookie.setMaxAge(60*60*24*3);
            }
            //将cookie放在response中返回；
            response.addCookie(cookie);
    }

    public  String getCookieByName(HttpServletRequest request, String name)
        {
		Cookie[] cookies = request.getCookies(); //获取cookie数组
		for(Cookie cookie : cookies)
		{
		    if(cookie.getName().equals(name))
		    {
		    	return cookie.getValue();
		    }
		}
		return null;
	}
}
