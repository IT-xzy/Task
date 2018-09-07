package com.iceneet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class QcloudConfig {
    private static String Appid;

    @Value("${Qcloud.Cos.APPID}")
    public void setAppid(String APPID){
        Appid =APPID;
    }

    public static void test(){
        System.out.println(Appid);
    }
}
