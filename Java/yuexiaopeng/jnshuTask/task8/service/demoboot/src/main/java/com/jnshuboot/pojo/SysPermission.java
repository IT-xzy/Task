package com.jnshuboot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class SysPermission implements Serializable {
    private Integer id;

    private String name;

    private String url;

    private Integer pid;

    private String description;


}