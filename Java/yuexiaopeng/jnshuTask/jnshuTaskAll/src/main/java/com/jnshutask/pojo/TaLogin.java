package com.jnshutask.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 24569
 */
@Data
public class TaLogin implements Serializable {
    /**
     * 创建时间
     */
    private Long createAt;

    /**
     * 更新时间
     */
    private Long updateAt;

    /**
     * 账号id
     */
    private Long loginId;

    /**
     * 通用账号
     */
    private String loginAccount;

    /**
     * 账号密码
     */
    private String loginPassword;

    /**
     * 账号昵称
     */
    private String loginName;

    /**
     * 账号头像
     */
    private String loginPicture;

    /**
     * 加密盐值
     */
    private String loginSalt;

    /**
     * 账号手机
     */
    private String loginMobile;

    /**
     * 账号邮箱
     */
    private String loginMail;


}