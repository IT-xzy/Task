package com.jnshu.task5.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
public class Login implements Serializable {
    private Integer id;
    private String loginName;
    private String pwd;
    private String qq;
    private String email;
    private String phone;

    private Long createAt = System.currentTimeMillis();



}
