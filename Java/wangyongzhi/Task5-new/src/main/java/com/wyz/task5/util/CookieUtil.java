package com.wyz.task5.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 常用cookie处理方法
 */
public class CookieUtil {

    /***
     * 读取cookie数组，之后迭代出各个cookie
     * @param request
     * @return
     */
    public void showCookies(HttpServletRequest request) {
        //根据请求数据，找到cookie数组
        Cookie[] cookies = request.getCookies();
        //如果没有cookie数组
        if (cookies == null) {
            System.out.println("没有cookie");
        } else {
            for (Cookie cookie : cookies) {
                System.out.println("cookieName:" + cookie.getName() + ",cookieValue:" + cookie.getValue());
            }
        }
    }

    /**
     * 添加cookie的方法
     *
     * @param response
     * @param key      cookie主键
     * @param value    cookie值
     */
    public static void addCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        //设置访问路径,即作用域
        cookie.setPath("/");
        //设置保存时间为3天，默认以秒为单位
        cookie.setMaxAge(3 * 24 * 60 * 60);
        response.addCookie(cookie);
    }

    public static void editCookie(HttpServletRequest request,
                                  HttpServletResponse response, String key, String value) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("没有cookies");
        } else {
            for (Cookie cookie : cookies) {
                //迭代时如果发现与指定cookieName相同的cookie，就修改相关数据
                if (cookie.getName().equals(key)) {
                    //修改value
                    cookie.setValue(value);
                    cookie.setPath("/");
                    // 修改存活时间
                    cookie.setMaxAge(10 * 60);
                    //将修改过的cookie存入response，替换掉旧的同名cookie
                    response.addCookie(cookie);
                    break;
                }
            }

        }

    }

    /**
     * 删除指定cookie
     *
     * @param response
     * @param request
     * @param key      cookie主键
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String key) {
        //从浏览器发出的请求中得到cookies
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("对不起，未找到cookie");
        } else {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key)) {
                    cookies[i].setValue(null);
                    cookies[i].setPath("/");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                    break;
                }
            }
        }
    }

    /**
     * 通常开发时先用以下的代码将获取的cookie进行封装
     * <p>
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
