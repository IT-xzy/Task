package com.jnshu.modle;

import java.util.List;

/**
 * @program: SSM_Tiles
 * @description: 综合信息
 * @author: Mr.xweiba
 * @create: 2018-05-12 10:58
 **/

public class StudentQV {
    // 学员基本信息
    List<StundetCustom> studentList;

    // 学员统计信息
    StudentStatistics studentStatistics;

    // 职业信息
    List<Profession> profession;

    @Override
    public String toString() {
        return "StudentQV{" +
                "studentList=" + studentList +
                ", studentStatistics=" + studentStatistics +
                ", profession=" + profession +
                '}';
    }

    public List<Profession> getProfession() {
        return profession;
    }

    public void setProfession(List<Profession> profession) {
        this.profession = profession;
    }

    public List<StundetCustom> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StundetCustom> studentList) {
        this.studentList = studentList;
    }


    public StudentStatistics getStudentStatistics() {
        return studentStatistics;
    }

    public void setStudentStatistics(StudentStatistics studentStatistics) {
        this.studentStatistics = studentStatistics;
    }
}
