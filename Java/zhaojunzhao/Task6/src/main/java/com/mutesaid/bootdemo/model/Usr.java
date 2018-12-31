package com.mutesaid.bootdemo.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class Usr implements Serializable {

    private Long id;

    private String name;

    @Length(min = 6, max = 21, message = "Length.usr.pwd")
    private String pwd;

    private String phone;

    private String email;

    private String pic;

    private Long createAt;

    private Long updateAt;

    private static final long serialVersionUID = 1L;
}