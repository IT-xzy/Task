package com.encryption;

import java.util.Random;

public class MyRandom {

   // 获得6位随机数作为验证码
   public static String getVerification(){
       String sources="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
       Random random=new Random();
       StringBuffer flag=new StringBuffer();
       for(int i=0;i<6;i++){
           flag.append(sources.charAt(random.nextInt(61))+"");
       }
       return flag.toString();
   }
}
