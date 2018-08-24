package com.AOP;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


// 时间增加的工具类
public class Test {
    private static Date d = new Date();
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Long Date() {

        String currdate = format.format(d);
        System.out.println("增加天数以后的日期：" + currdate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 120);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);
        System.out.println(d.getTime() / 1000);
        return d.getTime() / 1000;

    }

    public static Long elseDate() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 60);
        d = ca.getTime();
        return d.getTime() / 1000;
    }

//    public static void main(String[] args){
//            String codeNum = "";
//            int [] numbers = {0,1,2,3,4,5,6,7,8,9};
//            Random random = new Random();
//            for (int i = 0; i < 6; i++) {
//                int next = random.nextInt(10000);//目的是产生足够随机的数，避免产生的数字重复率高的问题
////              System.out.println(next);
//                codeNum+=numbers[next%10];
//            }
//
//            System.out.println("--------");
//            System.out.println(codeNum);
//
//    }


    public static void main(String[] args) throws IOException {


    }
}
