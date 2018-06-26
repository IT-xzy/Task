package com.ptt.mapper;

import com.ptt.pojo.GraduateStudent;

import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.mapper
 * @ClassName: IGraduateStudentMapper
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 19:16
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 19:16
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IGraduateStudentMapper {
    //查询毕业学生人数
    Integer getCount();
    List<GraduateStudent> getGraduateStudent();
    GraduateStudent getGraduateStudentById(Integer id);
}
