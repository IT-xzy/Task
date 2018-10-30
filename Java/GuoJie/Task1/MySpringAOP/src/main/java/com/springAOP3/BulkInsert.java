package com.springAOP3;

import org.springframework.stereotype.Component;

@Component
public class BulkInsert {
    public void Insert(){
        long sum=0;
        for (int i = 0; i <1000000; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
