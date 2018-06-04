package com.util.aliyunutil;

/**
 * @Author: Jaime
 * @Date: 2018/5/20 2:41
 * @Description: *
 */
public class verificationCodeCreater {
    private int vcode;
    public int getCode(){
        return vcode;
    }
    public void setCode(){
        vcode = (int)(Math.random()*999999)+1000;  //每次调用生成一次六位数的随机数
    }
}
