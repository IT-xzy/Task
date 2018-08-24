package com.Interceptor;

import org.junit.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class MyInterceptorTest {

    @Test
    public void preHandle() {
        HttpServletRequest request = null;
        Cookie[] cookies=request.getCookies();
        for (int i = 0; i <cookies.length ; i++) {
            System.out.println("cookie的名字"+cookies[i].getName());
            System.out.println("cookie的值"+cookies[i].getValue());
            System.out.println("cookie的有效期"+cookies[i].getMaxAge());

        }
    }
}