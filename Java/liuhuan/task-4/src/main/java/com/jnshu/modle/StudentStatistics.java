package com.jnshu.modle;

/**
 * @program: SSM_Tiles
 * @description: 学生统计信息
 * @author: Mr.xweiba
 * @create: 2018-05-12 11:03
 **/

public class StudentStatistics {
    // 学员人数
    Integer CountStudent;

    // 学员已找到工作人数
    Integer WorkStundet;

    @Override
    public String toString() {
        return "StudentStatistics{" +
                "CountStudent=" + CountStudent +
                ", WorkStundet=" + WorkStundet +
                '}';
    }

    public Integer getCountStudent() {
        return CountStudent;
    }

    public void setCountStudent(Integer countStudent) {
        CountStudent = countStudent;
    }

    public Integer getWorkStundet() {
        return WorkStundet;
    }

    public void setWorkStundet(Integer workStundet) {
        WorkStundet = workStundet;
    }
}
