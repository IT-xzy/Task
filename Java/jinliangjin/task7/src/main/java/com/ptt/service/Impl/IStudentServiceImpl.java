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
    private boolean flag;
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
     * @Description: 查询全部
     * @return: java.util.List<com.ptt.pojo.Student>
     * @Date: 2018/6/13 9:38
     */
    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

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
     * @Description: 登录
     * @return: java.lang.Integer
     * 100：账号不存在；101：密码错误；110：登录成功但为勾选记住我；111登录成功并勾选记住我
     * @Date: 2018/6/12 21:59
     */
    @Override
    public Integer login(Student student, String rememberMe, HttpSession session, HttpServletResponse response) {
        int loginResult = 110;
        try {
            String passwordGet = Md5Util.encrypt(student.getPassword());
            if (redis.exist(redisKey, student.getName())) {//缓存存在
                Student studentCache = (Student) redis.getValue(redisKey, student.getName());
                String passwordCache = studentCache.getPassword();
                if (passwordCache.equals(passwordGet)) {
                    session.setAttribute("student", studentCache);
                    if (null != rememberMe) {//勾选记住我
                        String cookieValue =
                                DESUtil.encrypt(studentCache.getName() + "-" + System.currentTimeMillis());
                        logger.info("cookieName：" + cookieName);
                        logger.info("cookieValue：" + cookieValue);
                        redis.add(cookieName, studentCache.getName(), cookieValue);
                        CookieUtil.addCookie(response, cookieName, cookieValue);
                        loginResult = 111;
                        return loginResult;
                    } else {
                        return loginResult;
                    }
                } else {
                    loginResult = 101;
                    return loginResult;
                }
            }
            Student studentMysql = studentMapper.selectByName(student.getName());
            if (studentMysql != null) {//缓存不存在，但是能与数据库中的数据相匹配
                if (passwordGet.equals(studentMysql.getPassword())) {
                    session.setAttribute("student", studentMysql);
                    redis.add(redisKey, student.getName(), studentMysql);
                    if (rememberMe != null) {//勾选记住我
                        String cookieValue =
                                DESUtil.encrypt(studentMysql.getName() + "-" + System.currentTimeMillis());
                        redis.add(cookieName, studentMysql.getName(), cookieValue);
                        CookieUtil.addCookie(response, cookieName, cookieValue);
                        loginResult = 111;
                        return loginResult;
                    }
                } else {
                    loginResult = 101;
                }
            } else {
                loginResult = 100;
            }
        } catch (Exception e) {
            logger.info("fail login.");
        }
        return loginResult;
    }

    /**
     * @Description: 更新
     * @return: boolean
     * @Date: 2018/6/12 21:59
     */
    @Override
    public boolean edit(Student student, HttpServletRequest request, HttpServletResponse response) {
        try {
            student.setUpdateAt(System.currentTimeMillis());
            String passwordGet = student.getPassword();
            student.setPassword(Md5Util.encrypt(passwordGet));
            studentMapper.updateByName(student);
            flag = true;
            String cookieValue = DESUtil.encrypt(student.getName() + "-" + System.currentTimeMillis());
            redis.add(cookieName, student.getName(), cookieValue);
            CookieUtil.editCookie(request, response, cookieName, cookieValue);
            redis.add(redisKey, student.getName(), student);
        } catch (Exception e) {
            logger.info("更新出错");
        }
        return flag;
    }

    /**
     * @Description: 注销
     * @return: boolean
     * @Date: 2018/6/12 22:00
     */
    @Override
    public boolean delete(Student student, HttpServletResponse response, HttpServletRequest request) {
        try {
            studentMapper.updateByPrimaryKeySelective(student);
            flag = true;
            CookieUtil.deleteCookie(request, response, cookieName);
            redis.delete(redisKey, student.getName());
            redis.delete(cookieName, student.getName());
        } catch (Exception e) {
            logger.info("注销失败");
        }
        return flag;
    }

    /**
     * @Description: 退出登录
     * @return: boolean
     * @Date: 2018/6/12 22:00
     */
    @Override
    public boolean logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = DESUtil.decrypt(CookieUtil.getCookieValue(request, cookieName)).split("-")[0];
            CookieUtil.deleteCookie(request, response, cookieName);
            redis.delete(redisKey, name);
            request.getSession().removeAttribute("student");
            flag = true;
        } catch (Exception e) {
            logger.info("退出登录失败");
        }
        return flag;
    }

    /**
     * @Description: 从请求中get name
     * @return: java.lang.String
     * @Date: 2018/6/20 22:56
     */
    @Override
    public String getStudentName(HttpServletRequest request) {
        String result = null;
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        if (student != null) {
            result = student.getName();
            return result;
        } else {
            result = CookieUtil.getCookieValue(request, cookieName);
        }
        return result;
    }

    /**
     * @Description: 上传头像
     * @return: com.ptt.pojo.Student
     * @Date: 2018/6/20 22:59
     */
    @Override
    public Student fileUpload(MultipartFile file, HttpServletRequest request, String name) {
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        String cookieValue = CookieUtil.getCookieValue(request, cookieName);
        logger.info("cookieValue：" + cookieValue);
        if (student != null || cookieValue != null) {
            //登录才能修改。但因为有拦截器做自动登录验证，所以这个判断可不要
            try {
                OSSClient ossClient = ALiYunUtil.getOSSClient();
                String url = ALiYunUtil.uploadFile2OOS(ossClient, MultipartFile2File.trans(file), name);
                Student studentSave = studentMapper.selectByName(name);
                logger.info("url：" + url);
                if (url != null) {
                    if (student != null) {
                        studentSave.setProfilePhoto(url);
                        studentSave.setUpdateAt(System.currentTimeMillis());
                        studentMapper.updateByName(studentSave);
                        session.setAttribute("student", studentSave);
                        redis.add("student", student.getName(), studentSave);
                        return studentSave;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("文件上传失败。" + e.getMessage());
            }
        }
        return null;
    }

    /**
     * @Description: 发送email（6位数验证码）
     * @return: java.lang.String
     * @Date: 2018/6/20 22:59
     */
    @Override
    public String sendEmail(Student student, HttpServletRequest request) {
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

    /**
     * @Description: 校验邮箱验证码
     * @return: java.lang.String
     * @Date: 2018/6/20 23:00
     */
    @Override
    public String vCodeValidation(String vCode, HttpServletRequest request, String name) {
        String vCodeSaved = (String) request.getSession().getAttribute("vCode");
        if (null != vCodeSaved && vCode.equalsIgnoreCase(vCodeSaved)) {
            try {
                //验证通过，更新相应信息
                Student student = studentMapper.selectByName(name);
                student.setEmail((String) request.getSession().getAttribute("email"));
                studentMapper.updateByName(student);//更新数据库
                redis.add(redisKey, name, student);//更新redis
                request.getSession().removeAttribute("email");
                request.getSession().removeAttribute("vCode");
                return "0";//验证成功
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("验证出错：{}", e.getMessage());
                return "100";//验证出错
            }
        }
        return "101";//验证失败
    }

    /**
     * @Description: 发送短信（6位数验证码）
     * @return: java.lang.String
     * @Date: 2018/6/20 23:01
     */
    @Override
    public String sendSMessage(Student student, HttpServletRequest request) {
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

    /**
     * @Description: 校验短信验证码
     * @return: java.lang.String
     * @Date: 2018/6/20 23:03
     */
    @Override
    public String vCodeSMessageValidation(String vCode, HttpServletRequest request, String name) {
        String vCodeSaved = (String) request.getSession().getAttribute("smsVCode");
        logger.info("session中的验证码是{}", vCodeSaved);
        if (null != vCodeSaved && vCode.equalsIgnoreCase(vCodeSaved)) {
            logger.info("验证码相同");
            try {
                //验证通过，更新相应的信息
                Student student = studentMapper.selectByName(name);
                Long tel = (Long) request.getSession().getAttribute("tel");
                student.setTel(tel);
                studentMapper.updateByName(student);//更新数据库
                redis.add(redisKey, name, student);//更新redis
                request.getSession().removeAttribute("tel");
                request.getSession().removeAttribute("smsVCode");
                return "0";//验证成功
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("验证出错，{}", e.getMessage());
                return "100";//验证出错
            }
        }
        return "101";//验证失败
    }
}
