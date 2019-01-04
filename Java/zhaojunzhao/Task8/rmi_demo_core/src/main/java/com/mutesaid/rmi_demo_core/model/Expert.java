package com.mutesaid.rmi_demo_core.model;

import lombok.Data;

import java.io.Serializable;

/**
 * expert
 *
 * @author
 */
@Data
public class Expert implements Serializable {
    private Long id;

    /**
     * 职位
     */
    private String position;

    /**
     * 优秀学员姓名
     */
    private String name;

    /**
     * 头像
     */
    private String icon;

    /**
     * 介绍
     */
    private String intro;

    /**
     * 工资
     */
    private Integer salary;

    /**
     * 创建时间
     */
    private Long createAt;

    /**
     * 更新时间
     */
    private Long updateAt;

    private static final long serialVersionUID = 1L;
}