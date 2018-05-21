package jnshu.tasknine.service.impl;

import com.alibaba.fastjson.JSON;
import jnshu.tasknine.dao.StudentMapper;
import jnshu.tasknine.model.Student;
import jnshu.tasknine.service.StudentService;
import jnshu.tasknine.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 本类完成单个或全体学生信息查询
 * 指定条件的学生数量
 * @author: Administrator
 * @date: 2017-10-17
 * @Time: 下午 4:48
 * Description:
 **/
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    private static Logger logStuSerImpl= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<Student> listStudentTable (){

        List<Student> students = null;

        String deserialization = redisUtil.getValue("listStudentTable");
        if(deserialization != null && !deserialization.equals("null")){
            //对象反序列化
            students = JSON.parseObject(deserialization,List.class);
            logStuSerImpl.info("从缓存获取 listStudentTable");
            return students;
        }
        else {

            try {
                students = studentMapper.listStudentTable();
            } catch (NullPointerException e) {
            /*手动抛出 RuntimeException 异常进行事物回滚*/
                e.printStackTrace();
            }

        }

        //对象序列化
        String serialization = JSON.toJSONString(students);
        boolean success = redisUtil.setCacheValue("listStudentTable",serialization,1000*60*5);
        logStuSerImpl.info("是否成功存入缓存： "+ success);
        return students;
    }

    @Override
    public Student getStudentUser(String user){

        logStuSerImpl.info("user : "+ user);
        Student study = null;
        String deserialization = redisUtil.getValue(user +" information");
        if(deserialization != null && !deserialization.equals("null")){
            //对象反序列化
            study = JSON.parseObject(deserialization,Student.class);
        }
        else {
            logStuSerImpl.info("从数据库获取 getStudentUser");
            try {
                logStuSerImpl.info(user);
                study = studentMapper.getStudentUser(user);
            } catch (Exception t) {
                t.printStackTrace();
            }
        }

        String serialization = JSON.toJSONString(study);
        boolean success = redisUtil.setCacheValue(user +" information",serialization,1000*60*5);
        logStuSerImpl.info("是否成功存入缓存： "+ success);
        return study;
    }



    /**
     * 返回不为0是添加成功，为0是失败，有已经存在的用户名
     * 当添加成功后用getId()得到对应数据库的自增id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertStudentUser(Student study){

        Integer amount = null;
        Long INSERT_TIME = System.currentTimeMillis();
        logStuSerImpl.info("student user_name: "+ study.getUser());
        Integer userNumber = studentMapper.countStudentUser(study);
        logStuSerImpl.info("user name is: "+ study.getUser() + "\tnumber: "+ userNumber);
        if(userNumber == 0) {
            study.setImages("http://xiuzhenyuan.oss-cn-beijing.aliyuncs.com/image/u_qwe-t_1509718420509-r_108232-f_qws.jpg/xiuzhenyuan_student_picture");
            study.setCreateAt(INSERT_TIME);
            study.setUpdateAt(INSERT_TIME);
            Long enrolAt = Long.valueOf(0);
            study.setEnrolAt(enrolAt);
            study.setStatus(-1);
            study.setProfession("IT");
            try {
                amount = studentMapper.insertStudentUser(study);
                boolean status = redisUtil.removeValue("listStudentTable");
                logStuSerImpl.info("listStudentTable 缓存是否删除成功  : " + status);
                logStuSerImpl.info("Returns the number : " + amount);
                logStuSerImpl.info("user Id  : " + study.getId());
            }catch(Exception e){
            /*手动抛出 RuntimeException 异常进行事物回滚*/
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return amount;
        }
        else{
            return -1;
        }
    }


    @Override
    public Integer countStudentUser(Student study){
        Integer userNumber = null;
        String cacheKey = null;


        //根据用户名/学习状态来获取其人数
        if(study.getUser() != null ){
            cacheKey = study.getUser() +" count";
        }
        else if(study.getStatus() == null && study.getUser() == null){
            cacheKey = "status all count";
        }
        else if(study.getStatus() == 0 && study.getUser() == null){
            cacheKey = "status work count";
        }
        else if(study.getStatus() == 1 && study.getUser() == null){
            cacheKey = "status study count";
        }
        else if(study.getStatus() == -1 && study.getUser() == null){
            cacheKey = "status X count";
        }
        String deserialization = redisUtil.getValue(cacheKey);
        if(deserialization != null && !deserialization.equals("null")){
            //对象反序列化
            userNumber = JSON.parseObject(deserialization,Integer.class);
            logStuSerImpl.info("从缓存获取 getStudentUser " + cacheKey);
            return userNumber;
        }
        else {
            try {
                userNumber = studentMapper.countStudentUser(study);
                logStuSerImpl.info("get the number of student based ob user " + cacheKey +" " + userNumber);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        String serialization = JSON.toJSONString(userNumber);
        boolean success = redisUtil.setCacheValue(cacheKey,serialization,1000*60*5);
        logStuSerImpl.info("是否成功存入缓存： "+ success);
        return userNumber;
    }


    /**
     * 更新邮箱/图片/手机
     * @param student
     * @return 修改更改的数据数量
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateStudentUserPicturePhoneEmail(Student student){

        Long updateAt = System.currentTimeMillis();
        student.setUpdateAt(updateAt);
        Integer amount = null;
        logStuSerImpl.info("student user_name: "+ student.getUserEmail());
        try {
            amount = studentMapper.updateStudentUser(student);
            boolean status = redisUtil.removeValue("listStudentTable");
            logStuSerImpl.info("listStudentTable 缓存是否删除成功  : " + status);
            status = redisUtil.removeValue(student.getUser() + " information");
            logStuSerImpl.info(student.getUser() + " information: 缓存是否删除成功  : " + status);
        }catch(Exception e){
            /*手动抛出 RuntimeException 异常进行事物回滚*/
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return amount;
    }


}