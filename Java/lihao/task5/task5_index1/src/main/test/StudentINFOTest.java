import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import com.lihoo.ssm.util.AddSalt;
import com.lihoo.ssm.util.MD5Encryption;
import com.lihoo.ssm.util.MD5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * #Title: StudentINFOTest
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-15:38
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class StudentINFOTest {
    private static Logger logger = LogManager.getLogger(StudentINFOTest.class);

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Autowired
    StudentInfoService studentInfoService;

//    @Test
//    public void testPwd() {
//        logger.info("开始查询密码");
//        String password = studentInfoMapper.getPwd();
//        logger.info(password);
//    }

    @Test
    public void testFindwithPwd() {
        logger.info("开始查询");
        StudentInfo withPwd = studentInfoService.selectByPwd("123");

        logger.info("通过密码查找出信息::" + withPwd);
        logger.info("李浩:查询结束");
        logger.error("真香警告");

    }

    @Test
    public void testFindwithUsername() {
        logger.info("开始查询");
        StudentInfo  withUsername = studentInfoService.selectByUsername("123");

        logger.info("通过用户名查找出信息::" + withUsername);
        logger.info("通过用户名查找出信息::" + withUsername.getSalt());
        logger.info("查询成功");
    }

    @Test
    public void testAddUser() {
        logger.info("开始注册用户");

        StudentInfo uInfo = new StudentInfo();

        String salt = AddSalt.getSalt();
        uInfo.setUsername("root01w");
        uInfo.setSalt(salt);
        uInfo.setPwd(MD5Utils.getPwdHash("123", salt));
//        uInfo.setPwd(MD5Utils.encryptPwd("123456", "x8s5d4f1"));
//        uInfo.setPwd(MD5Encryption.getEncryption("buquhuisi4835"));
//        uInfo.setLogAt(1534655854000L);
//        uInfo.setExpireAt(1534666995000L);
//        uInfo.setEmail("ojbk@163.com");
//        uInfo.setAddress("劲松一区");
//        uInfo.setPhone(0L);
//        uInfo.setQq(0L);
//        uInfo.setStatus(1);
        studentInfoService.insert(uInfo);

        logger.info(uInfo);
        logger.info("添加成功");

    }

    @Test
    public void testFindAll() {
        logger.info("获取数据库表中全部用户信息");
        List<StudentInfo> studentList = studentInfoService.selectAll();
        for (StudentInfo list : studentList) {
            logger.info("数据库用户信息：" + list);
        }

        logger.info( "用户信息：" + studentList);
    }

    @Test
    public void testAddLoginTime() {
        logger.info("开始添加登录时间");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(58L);
        studentInfo.setUsername("大虎");
        studentInfo.setLogAt(System.currentTimeMillis());

        studentInfoService.insert(studentInfo);

        logger.info(studentInfo);
    }

//    @Test
//    public void testAddLogT() {
//        logger.info("开始添加登录时间");
//        StudentInfo stu = new StudentInfo();
//        stu.setId(58L);
//        stu.setLogAt(System.currentTimeMillis());
//        studentInfoMapper.addLogTime(stu);
//        logger.info(stu);
//        logger.info("************");
//    }

//    @Test
//    public void updateLogTime() {
//        logger.info("测试修改登录时间");
//        StudentInfo stu = new StudentInfo();
//        stu.setId(58L);
//        stu.setLogAt(System.currentTimeMillis());
//
//        studentInfoService.updateByPrimaryKey(stu);
//        logger.info(stu);
//    }


    @Test
    public void testUpdateLogTimeById() {
        logger.info("开始更新时间");
        StudentInfo stu = new StudentInfo();
        stu.setId(55L);
        stu.setLogAt(System.currentTimeMillis());
        studentInfoService.updateLoginTimeById(stu);
//        studentInfoMapper.updateLoginTimeById(stu);
        logger.info(stu);
        logger.info("*************************");
    }

}
