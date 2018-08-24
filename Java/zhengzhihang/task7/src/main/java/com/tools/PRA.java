package com.tools;

public class PRA {
    //设置分钟(我redis设置的timeout是单位是s)
    private final static long min=60;
    //设置小时
    private final static long hour=min*60;
    //设置天
    private final static long day=hour*24;
    //设置月
    private final static long mouth=day*30;
    //设置空缓存有效时间：3min
    private final static long temporary=min*3;
    //生成一个15到30天到随机数
    private long ranTime=(long)(15*day+Math.random()*(30*day-15*day+1));

    //验证该请求验证的key是否超过了指定次数
    public static  boolean prevent_R_Attack(String key){
        int i= (int) RedisTool.rdGet("s"+key);
        //超过次数就返回是;
        return i > 4;
    }

    //发送了一次验证，就对它进行一次自增；
    public static int addKeyvalue(String key){
        System.out.println("com.tools.RPA.addKeyvalue的入参是"+key);
        int i= (int) RedisTool.rdGet("s"+key);
        i=i+1;
        RedisTool.rdSet("s"+key,i,day);
        return i;
    }
}
