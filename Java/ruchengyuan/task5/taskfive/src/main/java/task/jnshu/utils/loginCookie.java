package task.jnshu.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;

/**
 * Created by Administrator on 17/8/2017.
 */
public class loginCookie {

    private static Logger logCookie = Logger.getLogger(loginCookie.class);

    public Cookie studentLogin(String user,String pass){
        Cookie studentCookie = new Cookie("student",user+":"+pass);
        studentCookie.setMaxAge(60*60);
        logCookie.info("studentCookie: "+ studentCookie.getName());
        String value = studentCookie.getValue();
        String[] elements = value.split(":");
        logCookie.info("Cookie user: "+ elements[0]);
        logCookie.info("Cookie pass: "+ elements[1]);
        return studentCookie;
    }
}
