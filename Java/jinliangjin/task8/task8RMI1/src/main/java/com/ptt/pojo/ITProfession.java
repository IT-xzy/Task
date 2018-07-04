package com.ptt.pojo;

import java.io.Serializable;

/**
 * @ProjectName: task4
 * @Package: com.ptt.pojo
 * @ClassName: ITProfession
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 9:13
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 9:13
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ITProfession implements Serializable {
    private static final long serialVersionUID = 1113L;
    private Integer id;

    private String profession;//职业

    private String description;//描述

    private String type;//职业类型

    private Integer studentsNum;//在学人数

    private Integer entryBarrier;//门槛

    private Integer difficulty;//难度

    private Integer growthCycle;//成长周期

    private Integer companies;//需要此职业的公司数量

    private String salaryZero;//0-1年薪水

    private String salaryOne;//1-3年薪水

    private String salaryThree;//3年以上薪水

    private Integer count;//在学人数

    private String attention;//提示

    private String introduction;//介绍

    public ITProfession(Integer id, String profession, String description, String type, Integer studentsNum,
                        Integer entryBarrier, Integer difficulty, Integer growthCycle, Integer companies,
                        String salaryZero, String salaryOne, String salaryThree, Integer count, String attention,
                        String introduction) {
        this.id = id;
        this.profession = profession;
        this.description = description;
        this.type = type;
        this.studentsNum = studentsNum;
        this.entryBarrier = entryBarrier;
        this.difficulty = difficulty;
        this.growthCycle = growthCycle;
        this.companies = companies;
        this.salaryZero = salaryZero;
        this.salaryOne = salaryOne;
        this.salaryThree = salaryThree;
        this.count = count;
        this.attention = attention;
        this.introduction = introduction;
    }

    public ITProfession() {
        super();
    }

    @Override
    public String toString() {
        return "序号：" + id + "，职业：" + profession + "，描述：" + description + "，职业类型：" + type
                + "，在学人数：" + studentsNum + "，门槛：" + entryBarrier + "，难度：" + difficulty
                + "，成长周期：" + growthCycle + "，需求公司数：" + companies + "，0-1年薪水：" + salaryZero
                + "，1-3年新水：" + salaryOne + "，3年以上新水：" + salaryThree + "，在学人数：" + count
                + "，提示：" + attention + "，介绍：" + introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStudentsNum() {
        return studentsNum;
    }

    public void setStudentsNum(Integer studentsNum) {
        this.studentsNum = studentsNum;
    }

    public Integer getEntryBarrier() {
        return entryBarrier;
    }

    public void setEntryBarrier(Integer entryBarrier) {
        this.entryBarrier = entryBarrier;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(Integer growthCycle) {
        this.growthCycle = growthCycle;
    }

    public Integer getCompanies() {
        return companies;
    }

    public void setCompanies(Integer companies) {
        this.companies = companies;
    }

    public String getSalaryZero() {
        return salaryZero;
    }

    public void setSalaryZero(String salaryZero) {
        this.salaryZero = salaryZero;
    }

    public String getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(String salaryOne) {
        this.salaryOne = salaryOne;
    }

    public String getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(String salaryThree) {
        this.salaryThree = salaryThree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}