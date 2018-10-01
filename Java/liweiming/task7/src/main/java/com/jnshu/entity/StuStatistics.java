package com.jnshu.entity;

/**
 * @program: Tiles
 * @description: 学员统计
 * @author: Mr.Lee
 * @create: 2018-06-29 20:21
 **/
public class StuStatistics {

    private Integer stuCount;
    private Integer workCount;


    @Override
    public String toString() {
        return "StuStatistics{" +
                "stuCount=" + stuCount +
                ", workCount=" + workCount +
                '}';
    }

    public Integer getStuCount() {
        return stuCount;
    }

    public void setStuCount(Integer stuCount) {
        this.stuCount = stuCount;
    }

    public Integer getWorkCount() {
        return workCount;
    }

    public void setWorkCount(Integer workCount) {
        this.workCount = workCount;
    }


}
