package service.impl;

import dao.StudentMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Student;
import service.StudentService;
import util.XmemcachedManager;

@Service
public class StudentServiceImpl implements StudentService {
    private Logger log = Logger.getLogger(StudentServiceImpl.class);
    @Autowired
    XmemcachedManager xmemcachedManager ;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) throws Exception {
        studentMapper.insertStudent(student);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        studentMapper.deleteById(id);
    }

    @Override
    public Integer getLearningStudentCount() throws Exception {//累计在线学习学生数
        Integer count;
        if (xmemcachedManager.get("LearningCount")!=null){
            count = (Integer) xmemcachedManager.get("LearningCount");
            log.info("LearningCount-out:"+count);
        }else {
            count= studentMapper.getLearningStudentCount();
            xmemcachedManager.set("LearningCount",count);
            log.info("LearningCount-in:"+count);
        }
        return count;

    }

    @Override
    public Integer getGraduatedStudentCount() throws Exception { //已经毕业找到满意工作的学员
        Integer count;
        if (xmemcachedManager.get("graduatedCount")!=null){
            count = (Integer) xmemcachedManager.get("graduatedCount");
            log.info("graduate-out:"+count);
        }else {
            count= studentMapper.getGraduatedStudentCount();
            xmemcachedManager.set("graduatedCount",count);
            log.info("graduate-in:"+count);
        }
        return count;
    }

    @Override
    public Student getExcellentStudent(Integer studentNum) throws Exception {
        Student student;
        if (xmemcachedManager.get("excellent"+studentNum)!=null){
            student = (Student) xmemcachedManager.get("excellent"+studentNum);
            log.info("取出缓存："+studentNum);
        }else {
            student = studentMapper.getExcellentStudent(studentNum);
            xmemcachedManager.set("excellent"+studentNum,student);
            log.info("存入缓存："+studentNum);
        }
        return student;
    }

    @Override
    public Integer getCareerTypeCount(String career) throws Exception {
        Integer count;
        if (xmemcachedManager.get("type"+career)!=null){
            count = (Integer) xmemcachedManager.get("type"+career);
            log.info("CareerTypeCount-out:"+count);
        }else {
            count= studentMapper.getCareerTypeCount(career);
            xmemcachedManager.set("type"+career,count);
            log.info("CareerTypeCount-in:"+count);
        }
        return count;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        studentMapper.updateStudent(student);
    }

}
