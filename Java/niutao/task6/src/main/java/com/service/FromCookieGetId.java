package com.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class FromCookieGetId {
    public static int getId(HttpServletRequest request) {
        int id = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("id")) {
                id = Integer.parseInt(c.getValue());
                break;
            }
        }
        return id;
    }
}

