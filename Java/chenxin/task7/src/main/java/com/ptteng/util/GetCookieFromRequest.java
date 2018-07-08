package com.ptteng.util;

import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 这个组件类用于从request中获取本网站的cookie
 * 判断条件是cookie的名字
 */
@Component
public class GetCookieFromRequest {

    @Autowired
    UserService userService;
    @Autowired
    DESAlgorithm des;   //用于解密的工具类。
    //从request 获得cookie
    public Cookie getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();    //从request中获取cookie数组
        if (cookies.length < 0){
            return null;    //如果不存在cookie，返回空值。
        }
        for (Cookie cookie : cookies){  //遍历
            if ("test".equals(cookie.getName())){   //判断条件，相等则返回这个cookie。
                return cookie;
            }
        }

        return null;    //如果以上没有获得cookie，返回空值。
    }

    //解密cookie中的value，获取id和时间戳
    public long getIdFromCookie(Cookie cookie) throws Exception {
        Long id = null;
        //解析cookie中的value，获得用户的id和时间戳。
        String key = "chenxin@#*";  //注册时加密的密钥，此时用来解密。
        //具体的解密过程
        String cookieValue = des.decrypt(cookie.getValue(), key);
        //因为value中的id和时间戳是用点符号来连接在一起的，所以需要截取。
        String idFromCookie = StringUtils.substringBefore(cookieValue, ".");    //截取所用的工具类是，org.apache.commone.lang.StringUtiles提供的方法。
        String createdAtFromCookie = StringUtils.substringAfter(cookieValue, ".");
        System.out.println("cookie中的id："+ idFromCookie +"\n" + "cookie中的时间戳："+createdAtFromCookie);
        //判断下解密得到的时间戳，是否正确。
        User user = userService.getUserById(Long.valueOf(idFromCookie));
        if (user.getCreatedAt() == Long.parseLong(createdAtFromCookie)) {
            id = Long.parseLong(idFromCookie);
        }
        return id;
    }
}
