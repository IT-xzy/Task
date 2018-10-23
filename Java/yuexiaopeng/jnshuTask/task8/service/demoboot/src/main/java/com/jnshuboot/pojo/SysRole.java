package com.jnshuboot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class SysRole implements Serializable {
    private Integer id;

    private String name;

    private String description;


}