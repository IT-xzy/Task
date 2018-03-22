package com.pojo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class lianxi {

    @Test
    public void ary(){
        int[] a = {1,2,3,4,5};
        int[] b = Arrays.copyOfRange(a,0,3);
        HashMap<String,String> maap = new HashMap<String, String>();
        maap.put("a","apple");
        maap.put("b","banane");
        System.out.println(maap.get("a"));

        ArrayList numbers = new ArrayList();
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);
        String st = Arrays.toString(b);
        System.out.println(st);
        for(int i:b){
            System.out.println(i);
        }
        System.out.println("数字1出现的位置"+Arrays.binarySearch(a,4));

    }
}
