package com.jnshutask.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author 24569
 */
@Data
public class TaStudent implements Serializable {
    /**
     * 序号
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 创建时间
     */
    private Long createAt;

    /**
     * 更新时间
     */
    private Long updateAt;

    /**
     * QQ号码
     */
    private Integer qq;

    /**
     * 学习类型
     */
    @NotBlank(message = "修真类型不能为空")
    private String studyType;

    /**
     * 加入时间
     */
    private Long joinTime;

    /**
     * 大学
     */
    private String university;

    /**
     * 学号
     */
    @NotBlank(message = "学院id不能为空")
    private String studyId;

    /**
     * 日报
     */
    private String dailyLink;

    /**
     * 宣言
     */
    private String slogen;

    /**
     * 师兄
     */
    private String master;


}