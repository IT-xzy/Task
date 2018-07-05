package com.ptt.controller;

import com.ptt.dao.GroupEmail;
import com.ptt.dao.GroupLogin;
import com.ptt.dao.GroupRegister;
import com.ptt.dao.GroupTelephone;
import com.ptt.pojo.Company;
import com.ptt.pojo.GraduateStudent;
import com.ptt.pojo.Student;
import com.ptt.service.IHomePageService;
import com.ptt.service.IRecommendService;
import com.ptt.service.IStudentService;
import com.ptt.service.ITProfessionService;
import com.ptt.util.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/13 10:11
 * @Version: 1.0
 */
@Controller
@RequestMapping("/it")
public class StudentController {
    private String redisKey = "student";
    private String cookieName = "taskSeven";
    @Autowired
    private RedisUtil redis;
    @Autowired
    private IHomePageService homePageService;
    private IStudentService studentService;
    @Autowired
    private ITProfessionService professionService;
    @Autowired
    private IRecommendService recommendService;
    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    public void setStudentService() {
        this.studentService = StudentServiceFactory.getInstance();
    }
    /*    {
        AbstractApplicationContext aac =
                new ClassPathXmlApplicationContext("classpath:spring/applicationContext-RMI.xml");
        int num = Integer.parseInt(RandomNumber.randomVCode(1)) % 2;
        logger.info("number：{}", num);
        if (0 == 0) {
            try {
                logger.info("调用studentService2");
                this.studentService = (IStudentService) aac.getBean("studentService2");
            } catch (Exception e) {
                logger.info("studentService2异常：{}", e.getMessage());
                this.studentService = (IStudentService) aac.getBean("studentService1");
            }
        } else {
            try {
                logger.info("调用studentService1");
                this.studentService = (IStudentService) aac.getBean("studentService1");
            } catch (Exception e) {
                logger.info("studentService2异常：{}", e.getMessage());
                this.studentService = (IStudentService) aac.getBean("studentService2");
            }
        }
    }*/

    /**
     * @Description: 主页
     * @return: java.lang.String
     * @Date: 2018/6/20 9:58
     */
    @RequestMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("graduateStudentCount", homePageService.getGraduateStudentNum());
        model.addAttribute("studyStudentCount", homePageService.getStudyStudentNum());
        model.addAttribute("studySteps", homePageService.getStudyStep());
        List<GraduateStudent> graduateStudents = homePageService.getGraduateStudent();
//        List<GraduateStudent> goodStudents = homePageService.getGoodStudent(4);
        model.addAttribute("goodStudents", graduateStudents);
        return "homePage";
    }

    /**
     * @Description: ProfessionPage, show all it professions.
     * @return: java.lang.String
     * @Date: 2018/5/25 18:43
     */
    @RequestMapping("/profession")
    public String query(Model model) {
        model.addAttribute("professions_fe", professionService.getProfessions("前端"));
        model.addAttribute("professions_be", professionService.getProfessions("后端"));
        model.addAttribute("professions_mobile", professionService.getProfessions("移动"));
        model.addAttribute("professions_op", professionService.getProfessions("运维"));
        model.addAttribute("professions_fs", professionService.getProfessions("整站"));
        return "profession";
    }

    /**
     * @Description: 推荐页
     * @return: java.lang.String
     * @Date: 2018/5/26 15:30
     */
    @RequestMapping("/u/recommend")
    public String recommend(Model model, HttpServletRequest request) {
        List<Company> companies = recommendService.getCompanies();
        model.addAttribute("companies", companies);
        return "recommend";
    }

    /**
     * @Description: 前端
     * @return: java.lang.String
     * @Date: 2018/5/25 18:45
     */
    @RequestMapping("/profession/fe")
    public String professionFe(Model model) {
        model.addAttribute("professions_fe", professionService.getProfessions("前端"));
        return "profession_fe";
    }

    /**
     * @Description: 后端
     * @return: java.lang.String
     * @Date: 2018/5/25 18:45
     */
    @RequestMapping("/profession/be")
    public String professionBe(Model model) {
        model.addAttribute("professions_be", professionService.getProfessions("后端"));
        return "profession_be";
    }

    /**
     * @Description: 移动开发
     * @return: java.lang.String
     * @Date: 2018/5/25 18:45
     */
    @RequestMapping("/profession/mobile")
    public String professionMobile(Model model) {
        model.addAttribute("professions_mobile", professionService.getProfessions("移动"));
        return "professions_mobile";
    }

    /**
     * @Description: 全站开发
     * @return: java.lang.String
     * @Date: 2018/5/25 18:46
     */
    @RequestMapping("/profession/fs")
    public String professionFs(Model model) {
        model.addAttribute("professions_fs", professionService.getProfessions("整站"));
        return "professions_fs";
    }

    /**
     * @Description: 运维
     * @return: java.lang.String
     * @Date: 2018/5/25 18:46
     */
    @RequestMapping("/profession/op")
    public String professionOp(Model model) {
        model.addAttribute("professions_op", professionService.getProfessions("运维"));
        return "professions_op";
    }

    /**
     * @Description: 注册信息填写
     * @return: java.lang.String
     * @Date: 2018/6/20 9:58
     */
    @RequestMapping("/register")
    public String preRegister() {
        return "register";
    }

    /**
     * @Description: 注册结果
     * @return: java.lang.String
     * @Date: 2018/6/20 9:59
     */
    @RequestMapping("/register/result")
    public String register(Model model, @Validated(value = GroupRegister.class) Student student, BindingResult result) {
        if (result.hasErrors()) {
            logger.info("something wrong.");
            for (ObjectError error : result.getAllErrors())
                logger.info("error:{}", error);
            model.addAttribute("errors", result.getAllErrors());
            return "register";
        }
        int register = studentService.register(student);
        if (register == 1) {
            model.addAttribute("message", "注册成功，请登录");
            return "login";
        }
        if (register == 0) {
            model.addAttribute("message", "注册失败");
        }
        return "register";
    }

    /**
     * @Description: 登录账密填写页面
     * @return: java.lang.String
     * @Date: 2018/6/20 10:00
     */
    @RequestMapping("/login")
    public String preLogin() {
        return "login";
    }

    /**
     * @Description: 登录结果
     * @return: java.lang.String
     * @Date: 2018/6/20 10:00
     */
    @RequestMapping("/login/result")
    public String login(HttpServletResponse response, HttpServletRequest request, Model model, String rememberMe,
                        @Validated(value = GroupLogin.class) Student student, BindingResult result) {
        if (result.hasErrors()) {
            logger.info("something wrong.");
            for (ObjectError error : result.getAllErrors())
                logger.info("error:{}", error);
            model.addAttribute("errors", result.getAllErrors());
            return "login";
        }
        this.setStudentService();
        Student loginResult = studentService.login(student);
        logger.info("url:{}", loginResult.getProfilePhoto());
        if (loginResult == null) {
            model.addAttribute("message", "账号或密码错误");
            return "forward:/it/login";
        } else {
            request.getSession().setAttribute("student", loginResult);
            model.addAttribute("message", "登录成功");
            model.addAttribute("student", loginResult);
            if (rememberMe != null) {
                String cookieValue = DESUtil.encrypt(loginResult.getName() + "-" +
                        System.currentTimeMillis());
                CookieUtil.addCookie(response, cookieName, cookieValue);
                redis.add(cookieName, loginResult.getName(), cookieValue);
            }
            return "forward:/it/u/recommend";
        }
    }

    /**
     * @Description: 退出登录
     * @return: java.lang.String
     * @Date: 2018/6/20 10:00
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            String name = DESUtil.decrypt(CookieUtil.getCookieValue(request, cookieName)).split("-")[0];
            CookieUtil.deleteCookie(request, response, cookieName);
            redis.delete(redisKey, name);
            request.getSession().removeAttribute("student");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("退出登录出错：{}", e.getMessage());
        }
        model.addAttribute("message", "已退出登录。");
        return "login";
    }

    /**
     * @Description: 修改信息
     * @return: java.lang.String
     * @Date: 2018/6/20 10:01
     */
    @RequestMapping("/u/student")
    public String preEdit(String name, Model model) {
        try {
            this.setStudentService();
            Student student = studentService.getStudentByName(name);
            logger.info("get student：{}", student);
            model.addAttribute("student", student);
        } catch (Exception e) {
            logger.info("查询出错");
        }
        return "student";
    }

    /**
     * @Description: 完成修改
     * @return: java.lang.String
     * @Date: 2018/6/20 10:02
     */
    @RequestMapping(value = "/u/student", method = RequestMethod.PUT)
    @ResponseBody
    public String edit(Model model, HttpServletRequest request, HttpServletResponse response,
                       @Validated(value = GroupRegister.class) Student student, BindingResult result) {
        if (result.hasErrors()) {
            logger.info("something wrong.");
            for (ObjectError error : result.getAllErrors())
                logger.info("error:{}", error);
            model.addAttribute("errors", result.getAllErrors());
            return "redirect:/it/u/student";
        }
        this.setStudentService();
        Student editResult = studentService.edit(student);
        if (editResult != null) {
            String cookieValue = DESUtil.encrypt(editResult.getName() + "-" + System.currentTimeMillis());
            redis.add(cookieName, editResult.getName(), cookieValue);
            CookieUtil.editCookie(request, response, cookieName, cookieValue);
            redis.add(redisKey, editResult.getName(), editResult);
            return "success";
        }
        return "fail";
    }

    /**
     * @Description: 上传头像
     * @return: java.lang.String
     * @Date: 2018/6/20 10:02
     */
    @RequestMapping("/u/photo")
    public String preProfilePhoto(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "photo";
    }

    /**
     * @Description: 执行头像上传
     * @return: java.lang.String
     * @Date: 2018/6/20 10:02
     */
    @RequestMapping(value = "/u/photo/result", method = RequestMethod.POST)
    public String profilePhoto(@RequestParam("file") MultipartFile file, Model model, @RequestParam("name") String name,
                               HttpServletRequest request) {
        String url = ALiYunUtil.uploadFile2OOS(ALiYunUtil.getOSSClient(), MultipartFile2File.trans(file), name);
        this.setStudentService();
        Student student = studentService.fileUpload(url, name);
        if (student == null) {
            model.addAttribute("message", "上传失败");
            return "forward:/it/u/recommend";
        }
        request.getSession().setAttribute("student", student);
        redis.add(redisKey, student.getName(), student);
        model.addAttribute("student", student);
        return "forward:/it/u/recommend";
    }

    /**
     * @Description: 填写email
     * @return: java.lang.String
     * @Date: 2018/6/20 10:03
     */
    @RequestMapping("/u/email")
    public String preEmail(@RequestParam("name") String name, HttpSession session) {
        session.setAttribute("name", name);
        return "email";
    }

    /**
     * @Description: 发送验证码
     * @return: java.lang.String
     * @Date: 2018/6/20 10:03
     */
    @RequestMapping("/u/email/vcode")
    public String sendEmail(HttpSession session, Model model,
                            @Validated(value = GroupEmail.class) Student student, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                logger.info("邮箱格式有误：{error}", error);
            }
            model.addAttribute("errors", result.getAllErrors());
            return "forward:/it/u/email";
        }
        this.setStudentService();
        String vCode = studentService.sendEmail(student);
        if (vCode.equals("100")) {
            model.addAttribute("massage", "系统出错，请稍后再试");
            return "forward:/it/u/email";
        } else if (vCode.equals("101")) {
            model.addAttribute("message", "邮箱已存在");
            return "forward:/it/u/email";
        } else {
            session.setAttribute("vCode", vCode);
            session.setAttribute("email", student.getEmail());
            model.addAttribute("message", "验证码已发送");
            return "vCode";
        }
    }

    /**
     * @Description: 比对验证码
     * @return: java.lang.String
     * @Date: 2018/6/20 10:03
     */
    @RequestMapping("/u/email/result")
    public String sendEmailResult(@RequestParam("vCode") String vCode, HttpServletRequest request, Model model) {
        if (StringUtils.isNotBlank(vCode)) {
            String vCodeSaved = (String) request.getSession().getAttribute("vCode");
            if (vCodeSaved != null && vCode.equalsIgnoreCase(vCodeSaved)) {
                String name = (String) request.getSession().getAttribute("name");
                String email = (String) request.getSession().getAttribute("email");
                Student student = new Student();
                student.setName(name);
                student.setEmail(email);
                this.setStudentService();
                Student result = studentService.update(student);
                if (result == null) {
                    model.addAttribute("message", "系统出错，请稍后再试");
                    return "forward:/it/u/email";
                }
                redis.add(redisKey, name, result);
                model.addAttribute("message", "绑定邮箱成功");
                model.addAttribute("student", result);
                return "forward:/it/u/recommend";
            }
            model.addAttribute("message", "验证码错误请重新输入");
            return "vCode";
        }
        model.addAttribute("message", "验证码不能为空");
        return "vCode";
    }

    /**
     * @Description: 填写tel
     * @return: java.lang.String
     * @Date: 2018/6/20 23:05
     */
    @RequestMapping("/u/tel")
    public String preShortMessage(@RequestParam("name") String name, HttpSession session) {
        session.setAttribute("name", name);
        return "shortMessage";
    }

    /**
     * @Description: 发送短信
     * @return: java.lang.String
     * @Date: 2018/6/20 23:05
     */
    @RequestMapping("/u/tel/vcode")
    public String sendShortMessage(HttpServletRequest request, HttpSession session, Model model,
                                   @Validated(value = GroupTelephone.class) Student student, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors())
                logger.info("电话格式错误：{}", error);
            model.addAttribute("errors", result.getAllErrors());
            return "forward:/it/u/tel";
        }
        this.setStudentService();
        String smsVCode = studentService.sendSMessage(student);
        logger.info("短信验证码是：{}", smsVCode);
        if (smsVCode.equals("100")) {
            model.addAttribute("message", "系统出错，请稍后再试");
            return "forward:/it/u/tel";
        } else if (smsVCode.equals("101")) {
            model.addAttribute("message", "手机号已被绑定，请重新输入");
            return "forward:/it/u/tel";
        } else {
            session.setAttribute("smsVCode", smsVCode);
            session.setAttribute("tel", student.getTel());
            model.addAttribute("message", "请输入短信验证码");
            return "sMessageVCode";
        }
    }

    /**
     * @Description: 对比短信验证码
     * @return: java.lang.String
     * @Date: 2018/6/20 23:06
     */
    @RequestMapping("/u/tel/result")
    public String sendShortMessageResult(@RequestParam("vCode") String vCode, HttpServletRequest request, Model model) {
        if (StringUtils.isNotBlank(vCode)) {
            String smsVCode = (String) request.getSession().getAttribute("smsVCode");
            if (smsVCode != null && vCode.equalsIgnoreCase(smsVCode)) {
                String name = (String) request.getSession().getAttribute("name");
                long tel = (Long) request.getSession().getAttribute("tel");
                Student student = new Student();
                student.setName(name);
                student.setTel(tel);
                this.setStudentService();
                Student result = studentService.update(student);
                if (result == null) {
                    model.addAttribute("message", "系统出错，请稍后再试");
                    return "forward:/it/u/tel";
                }
                redis.add(redisKey, name, result);
                model.addAttribute("message", "绑定手机号码成功");
                model.addAttribute("student", result);
                return "forward:/it/u/recommend";
            }
            model.addAttribute("message", "验证码错误请重新输入");
            return "sMessageVCode";
        }
        model.addAttribute("message", "验证码为空，请重新输入");
        return "sMessageVCode";
    }
}
