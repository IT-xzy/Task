package com.jnshuboot.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    private String description;

    private static final long serialVersionUID = 1L;
    //增加数据库没有的roles使用；
    private List<SysRole> roles;

}