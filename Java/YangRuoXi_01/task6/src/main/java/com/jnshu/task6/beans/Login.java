package com.jnshu.task6.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
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
