package com.ptt.service;

import com.ptt.pojo.GraduateStudent;
import com.ptt.pojo.StudyStep;

import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.dao
 * @ClassName: IHomePageService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 19:48
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 19:48
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IHomePageService {
    Integer getStudyStudentNum();//在学学生数量
    Integer getGraduateStudentNum();//毕业找到工作的学生数量
    List<GraduateStudent> getGraduateStudent();//所有毕业生
    GraduateStudent getOneGraduateStudent(Integer id);//通过id查询毕业生
    List<StudyStep> getStudyStep();//学习步骤
    List<GraduateStudent> getGoodStudent(Integer m);//随机选取m为优秀学员
}
