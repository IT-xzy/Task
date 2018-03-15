package com.myspring.aop.xml;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/7 15:12
 */
@Component
@Data

public class Run {
    
    public void circle() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("1");
        }
        System.out.println();
    }
}
