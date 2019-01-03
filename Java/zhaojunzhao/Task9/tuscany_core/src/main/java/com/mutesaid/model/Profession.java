package com.mutesaid.model;

import lombok.Data;

import java.io.Serializable;

/**
 * profession
 *
 * @author
 */
@Data
public class Profession implements Serializable {
    private Long id;

    /**
     * 职业名
     */
    private String name;

    /**
     * 头像位置
     */
    private String img;

    /**
     * 职业方向
     */
    private String direction;

    /**
     * 职业介绍
     */
    private String introduce;

    /**
     * 门槛
     */
    private Byte condition;

    /**
     * 难度
     */
    private Byte difficult;

    /**
     * 成长周期from
     */
    private Byte priodFrom;

    /**
     * 成长周期to
     */
    private Byte priodTo;

    /**
     * 公司需要
     */
    private Integer want;

    /**
     * 正在学习
     */
    private Integer studying;

    /**
     * 提示
     */
    private String prompt;

    /**
     * 一年薪资
     */
    private Integer salaryOne;

    /**
     * 两年薪资
     */
    private Integer salaryTwo;

    /**
     * 三年薪资
     */
    private Integer salaryThree;

    /**
     * 第四年薪资
     */
    private Integer salaryFour;

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