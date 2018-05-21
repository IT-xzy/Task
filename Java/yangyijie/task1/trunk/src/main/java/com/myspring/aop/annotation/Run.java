package com.myspring.aop.annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
