package com.jnshu.task7.beans;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class User implements Serializable{
    private static final long serialVersionUid = 1L;

    private Integer id;
    private String img;
    private String position;
    private String name ;
    private String description;
    private Integer salary;
    private Long createAt;
    private Integer updateAt;

}
