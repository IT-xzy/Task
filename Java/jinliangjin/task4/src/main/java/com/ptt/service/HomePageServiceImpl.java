package com.ptt.service;

import com.ptt.Enum.StudySteps;
import com.ptt.dao.IHomePageService;
import com.ptt.mapper.IGraduateStudentMapper;
import com.ptt.mapper.IStudyStepMapper;
import com.ptt.mapper.IStudyStudentMapper;
import com.ptt.pojo.GraduateStudent;
import com.ptt.pojo.StudyStep;
import com.ptt.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.service
 * @ClassName: HomePageServiceImpl
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 19:28
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 19:28
 * @UpdateRemark:
 * @Version: 1.0
 */
@Service
public class HomePageServiceImpl implements IHomePageService {
    @Autowired
    private IGraduateStudentMapper graduateStudent;
    @Autowired
    private IStudyStudentMapper studyStudent;
    @Autowired
    private IStudyStepMapper studyStep;

    @Override
    public Integer getStudyStudentNum(){
        return studyStudent.getCount();
    }

    @Override
    public Integer getGraduateStudentNum(){
        return graduateStudent.getCount();
    }

    @Override
    public List<String> getStudySteps(){
        List<String> strings = new ArrayList<>();
        for(StudySteps studyStep : StudySteps.values()){
            strings.add(studyStep.getDescription());
        }
        return strings;
    }

    @Override
    public List<GraduateStudent> getGraduateStudent(){
        return graduateStudent.getGraduateStudent();
    }
    @Override
    public GraduateStudent getOneGraduateStudent(Integer id){
        return graduateStudent.getGraduateStudentById(id);
    }

    @Override
    public List<StudyStep> getStudyStep(){
        return studyStep.selectAll();
    }

    @Override
    public List<GraduateStudent> getGoodStudent(Integer m){
        List<GraduateStudent> graduateStudents = graduateStudent.getGraduateStudent();
        List<GraduateStudent> goodStudents = null;
        if(graduateStudents.size() == 0){
            return null;
        } else if(graduateStudents.size() < 5){
            goodStudents.addAll(graduateStudents);
            return goodStudents;
        } else {
            List<Integer> numbers = RandomNumber.randomCommon(1,graduateStudents.size(),m);
            for(int i = 0; i < numbers.size(); i++){
                goodStudents.add(this.getOneGraduateStudent(numbers.get(i)));
                return goodStudents;
            }
        }
        return null;
    }
}
