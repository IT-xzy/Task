package com.jnshu.rmi.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@Data
public class Student implements Serializable{

    private static final  long serialVersionUid = 1L;
    public Long id;

    public String userName;

    public String pwd;

    public String phone;

    public Long createAt;


}
