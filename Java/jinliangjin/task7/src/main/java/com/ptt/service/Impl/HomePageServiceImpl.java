package com.ptt.service.Impl;

import com.ptt.mapper.IGraduateStudentMapper;
import com.ptt.mapper.IStudyStepMapper;
import com.ptt.mapper.IStudyStudentMapper;
import com.ptt.pojo.GraduateStudent;
import com.ptt.pojo.StudyStep;
import com.ptt.service.IHomePageService;
import com.ptt.util.RandomNumber;
import com.ptt.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private RedisUtil redis;
    Logger logger = LoggerFactory.getLogger(IHomePageService.class);

    @Override
    public Integer getStudyStudentNum(){
        int studyStudentNum = 0;
        try {
            if(redis.getValue("homePage", "studyStudentNumber") != null){
                logger.info("home page study student number from cache");
                studyStudentNum = (Integer) redis.getValue("homePage", "studyStudentNumber");
                return studyStudentNum;
            }
            studyStudentNum = studyStudent.getCount();
            redis.add("homePage", "studyStudentNumber", studyStudentNum);
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("homePage error:{}",e);
        }
        return studyStudentNum;
    }

    @Override
    public Integer getGraduateStudentNum(){
        return graduateStudent.getCount();
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
