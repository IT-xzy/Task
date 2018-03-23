package com.service.imp;

import com.mapper.StudentMapper;
import com.model.Student;
import com.service.StudentService;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SendEmail sendEmail;
    @Autowired
    private SendShortMessage sendShortMessage;
    @Autowired
    private College college;
    @Autowired
    private OOS oos;

    @Override
    public int selectByUnique(Student student) {
        return studentMapper.selectByUnique(student);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectByStatus(Integer status) {
        return studentMapper.selectByStatus(status);
    }

    @Override
    public List<Student> selectCollege() {
        return studentMapper.selectCollege();
    }

    @Override
    public int selectByclass(String classname) {
        return studentMapper.selectByclass(classname);
    }

    @Override
    public Student selectByuserName(String userName) {
        return studentMapper.selectByuserName(userName);
    }

    //发普通邮件
    @Override
    public void sendEmail(String email, String userName, String addressCode) throws Throwable{
        sendEmail.send_common(email,userName,addressCode);
    }
    //发短信
    @Override
    public void sendSMS(String security){
        sendShortMessage.SDKTestSendTemplateSMS(security);
    }
    //人机识别验证码
    @Override
    public String getAuthCode(){
        return AuthCode.getAuthCode();
    }
    @Override
    public BufferedImage getAuthImg(String Code){
        return AuthCode.getAuthImg(Code);
    }

    //优秀学员
    @Override
    public Map<Integer, String> GetCollegeMap(){
        return college.GetCollegeMap();
    }
    @Override
    public List<Student> GetCollegeList(){
        return college.GetCollegeList();
    }
    @Override
    public Map<String, String> GetCollegeStringMap(){
        return college.GetCollegeStringMap();
    }

    //云存储
    @Override
    public void doSelect() throws IOException{
        oos.doSelect();
    }
    @Override
    public void doUp(String name){
        oos.doUp(name);
    }
    @Override
    public String geturl(){
        return oos.geturl();
    }

    //TokenUtil
//    @Override
//    public boolean VerifyToken(HttpServletRequest httpServletRequest){
//        return TokenUtil.VerifyToken(httpServletRequest);
//    }
    @Override
    public String ProduceToken(String id, String logtime){
        return TokenUtil.ProduceToken(id,logtime);
    }


}
