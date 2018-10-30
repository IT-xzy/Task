package com.jnshutask.controller.ControllerUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
public  class UserNameUtil {

    public  String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "haha";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            log.info("登录的用户为" + username);
        } else {
            log.error("获取登录用户失败");
            username = principal.toString();
        }

        return username;
    }

    public static class GetName{
        private  String name="haha";
        public GetName(String name)
        {
            this.name = name;
            System.out.println("heeh");
        }
        public String getName(){return name;}
    }//静态内部类
//    public static String GetName();//静态方法
//    public class GetName();//内部类
//    public String GetName();//方法
//    static GetName();//静态方法
//    static {};//静态块


}
