package com.jnshutask.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 24569
 */
@Data
public class TaUser implements Serializable {
    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_THEME = "green";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 性别
     */
    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";

    public static final String SEX_UNKNOW = "2";
    /**
     * 创建时间
     */
    private Long crateTime;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * 最近访问时间
     */
    private Long lastLoginTime;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    private String status;

    /**
     * 性别 0男 1女
     */
    private String ssex;

    /**
     * 主题
     */
    private String theme;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 描述
     */
    private String description;


}