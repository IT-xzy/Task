package com.mutesaid.pojo;

import java.io.Serializable;

/**
 * @author 
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Byte getCondition() {
        return condition;
    }

    public void setCondition(Byte condition) {
        this.condition = condition;
    }

    public Byte getDifficult() {
        return difficult;
    }

    public void setDifficult(Byte difficult) {
        this.difficult = difficult;
    }

    public Byte getPriodFrom() {
        return priodFrom;
    }

    public void setPriodFrom(Byte priodFrom) {
        this.priodFrom = priodFrom;
    }

    public Byte getPriodTo() {
        return priodTo;
    }

    public void setPriodTo(Byte priodTo) {
        this.priodTo = priodTo;
    }

    public Integer getWant() {
        return want;
    }

    public void setWant(Integer want) {
        this.want = want;
    }

    public Integer getStudying() {
        return studying;
    }

    public void setStudying(Integer studying) {
        this.studying = studying;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(Integer salaryOne) {
        this.salaryOne = salaryOne;
    }

    public Integer getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(Integer salaryTwo) {
        this.salaryTwo = salaryTwo;
    }

    public Integer getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(Integer salaryThree) {
        this.salaryThree = salaryThree;
    }

    public Integer getSalaryFour() {
        return salaryFour;
    }

    public void setSalaryFour(Integer salaryFour) {
        this.salaryFour = salaryFour;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}