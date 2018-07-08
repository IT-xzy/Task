package com.jnshu.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Component
public class UtilCookie {
    public static void toc(HttpServletRequest request){
        //读cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            String name = "";
            String password = "";
            String option = "";
            for (int i = 0; i < cookies.length; i++)
            {
                Cookie c = cookies[i];
                if(c.getName().equalsIgnoreCase("name"))
                {
                    name = c.getValue();
                }
                else if(c.getName().equalsIgnoreCase("password"))
                {
                    password = c.getValue();
                }
                else if(c.getName().equalsIgnoreCase("option"))
                {
                    option = c.getValue();
                }
            }
        }

    }

}


