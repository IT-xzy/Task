package com.jnshu.task7.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
public class Login implements Serializable {
    private static final long serialVersionUid = 1L;

    private Long id;
    private String loginName;
    private String pwd;
    private String qq;
    private String email;
    private String phone;

    /**
     * 邮箱验证状态,0表示未激活,1表示激活;
     */
    private Integer emailState;
    /**
     * 邮箱验证码,为对应的token值;
     */
    private String emailCode;

    private Long createAt = System.currentTimeMillis();



}
