package com.myspring.di.properties;

import lombok.Data;

/**
 * @author Arike
 * Create_at 2017/11/29 19:14
 */
@Data
public class StudentReferenceImpl implements IStudent {
   /* @Autowired(required = false)*///使用Autowired,自定义类就会自动注入到bean类中.
    public StudentUtil studentUtil;
    private String ceshi = "试一下";
}
