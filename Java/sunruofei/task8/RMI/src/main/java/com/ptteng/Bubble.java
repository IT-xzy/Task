package com.ptteng;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * @ClassName Bubble
 * @Description 冒泡排序
 * @Author 孙若飞
 * @Date 2019/3/21  16:49
 * @Version 1.0
 **/
public class Bubble {
    public static void main(String[] args) {
        int[] value = {2, 4, 6, 7, 1, 3};
        int temp = 0;

        for (int j = 0; j < value.length - 1; j++) {
            boolean flag = true;
            for (int i = 0; i < value.length - 1 - j; i++) {
                //比较大小换顺序
                if (value[i] > value[i + 1]) {
                    temp = value[i];
                    value[i] = value[i + 1];
                    value[i + 1] = temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(value));
            }
            if (flag){
                break;
            }
            System.out.println("###############");
        }
    }
}
