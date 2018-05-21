package utils;

import org.apache.log4j.Logger;
import org.junit.Test;
import task.jnshu.utils.loginCookie;

import javax.servlet.http.Cookie;

/**
 * Created by Administrator on 17/8/2017.
 */
public class CookieLogin {
    private static Logger logCKT = Logger.getLogger(loginCookie.class);


    @Test
    public void studentLogin(){
        loginCookie cookie = new loginCookie();
        Cookie student = cookie.studentLogin("we","23e");
    }
}
