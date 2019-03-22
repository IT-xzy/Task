package com.jnshu.task4.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {
    private Integer id;
    private String img;
    private String position;
    private String name ;
    private String description;
    private Integer salary;
    private Long createAt;
    private Integer updateAt;

}
