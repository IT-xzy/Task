package com.task4.service;

import org.junit.Test;

import java.util.Date;

/**
 * Create by SongWu on 2018/7/6
 */
public class Test1 {
    @Test
    public void testSplit() {
//        String[] aa = "aaa*bbb*ccc".split("*");

//        这样才能得到正确的结果
        String[] aa = "aaa-bbb-ccc".split("\\-");

        for (int i = 0 ; i <aa.length ; i++ ) {

            System.out.println("--"+aa[i]);

        }
    }

    @Test
    public void testTime() {
        long createAt=System.currentTimeMillis();
        Date date=new Date();
        date.setTime(createAt);
        System.out.println(date.getTime());
    }


}
