package com.ptt.service.Impl;

import com.aliyun.oss.OSSClient;
import com.ptt.mapper.StudentMapper;
import com.ptt.pojo.Student;
import com.ptt.service.IStudentService;
import com.ptt.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Description: Do CRUD to the student.
 * @Author: Jin
 * @CreateDate: 2018/6/12 10:45
 * @Version: 1.0
 */
@Service
@Transactional
public class IStudentServiceImpl implements IStudentService {
    @Value("${redisKey}")
    private String redisKey;
    @Value("${cookieName}")
    private String cookieName;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisUtil redis;
    private Logger logger = LoggerFactory.getLogger(IStudentService.class);

    /**
     * @Description: 注册
     * @return: java.lang.Integer
     * @Date: 2018/6/12 21:58
     */
    @Override
    public Integer register(Student student) {
        int register = 0;
        try {
            if (redis.exist(redisKey, student.getName()) || studentMapper.selectName(student.getName()) != null) {
                logger.info("用户名已存在");
                return register;
            }
            logger.info("新建用户");
            student.setPassword(Md5Util.encrypt(student.getPassword()));
            student.setCreateAt(System.currentTimeMillis());
            student.setUpdateAt(System.currentTimeMillis());
            student.setProfilePhoto("/task7/images/qy1.png");
            studentMapper.insertSelective(student);
            redis.add(redisKey, student.getName(), student);
            logger.info("注册成功");
            register = 1;
            return register;
        } catch (Exception e) {
            logger.info("注册失败");
        }
        return register;
    }

    /**
     * @Description: 查询
     * @return: com.ptt.pojo.Student
     * @Date: 2018/6/12 21:59
     */
    @Override
    public Student getStudentByName(String name) {
        Student result = studentMapper.selectByName(name);
        logger.info("get student:{}", result);
        return result;
    }

    /**
     * @Description: 登录，返回student或者null。
     * @return: com.ptt.pojo.Student
     * @Date: 2018/6/25 9:46
     */
    @Override
    public Student login(Student student) {
        Student result = null;
        String passwordEntry = Md5Util.encrypt(student.getPassword());
        if(redis.exist(redisKey, student.getName())){
            result = (Student) redis.getValue(redisKey, student.getName());
            if(!result.getPassword().equals(passwordEntry))
                return null;
            return result;
        }
        result = studentMapper.selectByName(student.getName());
        if(null != result && result.getPassword().equals(passwordEntry)){
            redis.add(redisKey, student.getName(), result);
        }
        return result;
    }

    /**
     * @Description: 更新
     * @return: boolean
     * @Date: 2018/6/12 21:59
     */
    @Override
    public Student edit(Student student) {
        try {
            student.setUpdateAt(System.currentTimeMillis());
            String passwordGet = student.getPassword();
            student.setPassword(Md5Util.encrypt(passwordGet));
            studentMapper.updateByName(student);
        } catch (Exception e) {
            logger.info("更新出错");
            return null;
        }
        return student;
    }

    /**
     * @Description: 上传头像
     * @return: com.ptt.pojo.Student
     * @Date: 2018/6/20 22:59
     */
    @Override
    public Student fileUpload(String url, String name) {
        Student student = studentMapper.selectByName(name);
        if(null != student){
            student.setPassword(url);
            studentMapper.updateByName(student);
        }
        return student;
    }

    /**
     * @Description: 发送email（6位数验证码）
     * @return: java.lang.String
     * @Date: 2018/6/20 22:59
     */
    @Override
    public String sendEmail(Student student) {
        String result = null;
        String nameSelect = studentMapper.selectEmail(student.getEmail());
        if (null == nameSelect) {
            String vCode = RandomNumber.randomVCode(6);//6位数验证码
            try {
                SendEmailUtil.send(student.getEmail(), vCode);//发送验证码
                result = vCode;
                return result;
            } catch (Exception e) {
                logger.info("发送邮件出错：{0}", e.getMessage());
                result = "100";//100:发送邮件出错
            }
        } else {
            result = "101";//邮箱已存在
        }
        return result;//出错返回状态码
    }

    @Override
    public Student update(Student student) {
        try {
            String name = student.getName();
            studentMapper.updateByName(student);
            return studentMapper.selectByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 发送短信（6位数验证码）
     * @return: java.lang.String
     * @Date: 2018/6/20 23:01
     */
    @Override
    public String sendSMessage(Student student) {
        String result = null;
        String nameSelect = studentMapper.selectTel(student.getTel());
        if (null == nameSelect) {
            String vCode = RandomNumber.randomVCode(6);//6位数验证码，阿里云短信API最大支持6位数
            try {
                ALiYunUtil.sendShortMessage(student.getTel(), vCode);
//                ALiYunUtil.sendShortMessage(student.getTel(), "**");
                result = vCode;
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("发送短信出错：{}", e.getMessage());
                result = "100";//100：系统出错
            }
        } else {
            result = "101";//101：手机已存在
        }
        return result;
    }
}
