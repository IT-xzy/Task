package com.myspring.di.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/1 9:00
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Component
public class Student {
    private long id;
    private String name;
    private int age;
}
