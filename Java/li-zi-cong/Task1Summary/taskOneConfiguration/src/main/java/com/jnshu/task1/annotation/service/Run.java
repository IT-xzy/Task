package com.jnshu.task1.annotation.service;
import com.jnshu.task1.annotation.mapper.IStudentInfoMapper;
import com.jnshu.task1.annotation.pojo.StudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class Run {
    //创建日志记录其器
    Logger logger = Logger.getLogger(Run.class);
    @Autowired(required = false)//在默认情况下使用 @Autowired 注释进行自动注入时，Spring 容器中匹配的候选 Bean 数目必须有且仅有一个。当找不到一个匹配的 Bean 时，Spring 容器将抛出 BeanCreationException 异常，并指出必须至少拥有一个匹配的 Bean。
    @Qualifier("userMapper")    //用bean名称绑定该接口要注入的bean
    private IStudentInfoMapper userMapper;

    @Test
    public void insertSTU(){
        try {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudent_name("李梓聪2");
            studentInfo.setQq(845634109);
            studentInfo.setLearn_type("JAVA");
            studentInfo.setJoin_time(new Date());
            studentInfo.setSchool("佛山技术学院");
            studentInfo.setStudent_id(165);
            studentInfo.setLink("www.jnshu.com");
            studentInfo.setMotto("为往圣继绝学");
            studentInfo.setBrother("娄文彬");
            studentInfo.setKnow_from("知乎");
            System.out.println("插入的信息"+studentInfo);
            Integer index = userMapper.insertSTU(studentInfo);
            System.out.println("影响行数:"+index+"\t插入返回的主键:"+studentInfo.getId());
        }catch (Exception e){
            e.printStackTrace();
            logger.error("插入错误:",e);
        }
    }
    @Test
    public void deleteSTU() {
        try {
            userMapper.deleteByID(22);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void listTable() {
        try {
            System.out.println("查询列表:");
            List<StudentInfo> studentInfos = userMapper.listTable();
            //studentInfos.toString();
            for (StudentInfo studentInfo : studentInfos){
                System.out.println(studentInfo.toString());
            }
        }catch (Exception e){

        }
    }
    @Test
    public void updateByID(){
        try {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudent_name("李梓聪");
            studentInfo.setQq(845634109);
            studentInfo.setLearn_type("JAVA");
            studentInfo.setJoin_time(new Date());
            studentInfo.setSchool("佛山技术学院");
            studentInfo.setStudent_id(165);
            studentInfo.setLink("www.jnshu.com");
            studentInfo.setMotto("为往圣继绝学");
            studentInfo.setBrother("娄文彬");
            studentInfo.setKnow_from("知乎");
            System.out.println("修改的信息"+studentInfo);
            studentInfo.setId(25);
            userMapper.updateByID(studentInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void findByLikeName(){
        try {
            List<StudentInfo>studentInfos = userMapper.findByLikeName("李梓聪");
            System.out.println("姓名模糊查询结果:");
            for (StudentInfo studentInfo:studentInfos){
                System.out.println(studentInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void findByStudentID(){
        try {
            StudentInfo studentInfo2=userMapper.findByStudentID(25);
            System.out.println("ID查询结果:"+studentInfo2);
        }catch (Exception e){

        }
    }


}


