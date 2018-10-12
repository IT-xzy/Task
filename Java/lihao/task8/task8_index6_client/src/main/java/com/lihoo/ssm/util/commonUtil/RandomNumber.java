package com.lihoo.ssm.util.commonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * #Title: RandomNumber
 * #ProjectName task8_index6
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/12-20:16
 */


public class RandomNumber {
    /**
     * @Description: 随机生成n个大于等于零的不重复整数。
     * * @param min
     * @param max
     * @param n
     * @return: int[]
     * @since: 1.0.0
     * @Date: 2018/5/24 20:49
     */
    public static List<Integer> randomCommon(int min, int max, int n){

        if (n > (max - min + 1) || max < min) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        result.add((int) (Math.random() * (max - min)) + min);
        while(count < n - 1) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < result.size(); j++) {
                if(num == result.get(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.add(num);
                count++;
            }
        }
        return result;
    }
    /**
     * @Description: 随机生成i位验证码（String）
     * @return: java.lang.String
     * @Date: 2018/6/16 12:24
     */
    public static String randomVCode(int i){
        String vCode = "";
        if(i <= 0) {
            return null;
        }
        for (int x = 0; x < i ; x++){
            vCode = vCode + (int)(Math.random()*9);
        }
        return vCode;
    }
}
