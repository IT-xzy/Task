package com.alibaba.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UtilCookie {
    public static void toc(HttpServletRequest request){
        //读cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            String user = "user";
            String pass = "pass";
            String savetime = "savetime";
            for (int i = 0; i < cookies.length; i++)
            {
                Cookie c = cookies[i];
                if(c.getName().equalsIgnoreCase("user"))
                {
                    user = c.getValue();
                }
                else if(c.getName().equalsIgnoreCase("pass"))
                {
                    pass = c.getValue();
                }
                else if(c.getName().equalsIgnoreCase("savetime"))
                {
                    savetime = c.getValue();
                }
            }
        }

    }
}
