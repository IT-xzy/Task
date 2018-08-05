package com.tools;

public  class Tocken {
    public static String tocken(int id){
        long time = System.currentTimeMillis();
        String s= String.valueOf(time+"-"+id);
        return DESUtil.encryptBasedDes(s);
    }
}
