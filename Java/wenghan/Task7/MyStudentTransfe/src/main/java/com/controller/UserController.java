package com.controller;

import com.aliyuncs.exceptions.ClientException;
import com.encryption.*;
import com.pojo.OccupationReunite;
import com.pojo.SignIn;
import com.pojo.Student;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

    //OSS库标志位
    private boolean OssSign=true;

    private Logger logger=Logger.getLogger(UserController.class);

    //跳转主页面
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        if(OssSign) {
            model.addAttribute("Oss","阿里云Oss库" );
        }else {
            model.addAttribute("Oss","七牛Oss库" );
        }
        return "home";
    }

    //T0页面
    @RequestMapping(value = "/T0", method = RequestMethod.GET)
    public String T0(Model model) {
        //优秀的学生
        List<Student> list = userService.queryStudent("满意");
        //累计在学人数
        model.addAttribute("accumulativeLearning", userService.statisticsInLearning("在学"));
        //找到满意工作的人数
        model.addAttribute("accumulativeWork", userService.statisticaljobSatisfaction("满意"));
        //model封装优秀学员
        model.addAttribute("list", list);
        return "T0Layout";
    }

    //T1页面
    @RequestMapping(value = "/u/T1", method = RequestMethod.GET)
    public String T1(Model model) {
        //职业列表
        List<OccupationReunite> occupationReuniteList = userService.queryOccupationReunite("前端开发");
        //model封装职业
        model.addAttribute("list", occupationReuniteList);
        return "T1Layout";
    }

    //登录按键控制器，按下按键跳转到登录表单页面
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public ModelAndView SignIn() {
        ModelAndView modelAndView = new ModelAndView();
        //进入登录表单页面
        modelAndView.setViewName("Login");
        return modelAndView;
    }

    //登录接收form表单控制器
    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView success(Student student, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginInformation");
        Student student1 = userService.signIn(student);
        if (student1 != null) {
            //设置登录页面信息
            modelAndView.addObject("information", "登录成功");
            //因为JWT没有加密机制，所以登录类封装用户的非私密信息作为荷载
            SignIn signIn = new SignIn();
            signIn.setId(student1.getId());
            signIn.setName(student1.getName());
            //使用cookie封装JWT给到客户端浏览器
            Cookie cookie = new Cookie("JWT", JWT.sign(signIn, 1000L * 60L * 30L));
            //将Cookie丢给浏览器
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            modelAndView.addObject("information", "登录失败");
        }
        return modelAndView;
    }

    //注销登录信息
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(HttpServletResponse response) {
        //通过设置生存期为0,删除掉客户端的Cookie
        Cookie cookie = new Cookie("JWT", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    //跳转注册控制器
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    //注册控制器
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Submission(Student student, Model model, HttpServletRequest request) {
        //账号密码正则表达式判断格式
        if (RegularExpression.checkUsername(student.getAccountNumber()) && RegularExpression.checkPwd(student.getPassword())) {
            //账号重复判断
            if (userService.accountNumberRepeat(student.getAccountNumber())) {
                //如果没有重复则将账号密码保存到Session中
                HttpSession session = request.getSession();
                session.setAttribute("student", student);
            } else {
                model.addAttribute("prompt", "账号已存在");
                return "registerError";
            }
        } else {
            model.addAttribute("prompt", "账号或密码格式错误");
            return "registerError";
        }
        return "verification";
    }

    //通过用户输入邮箱获得验证码
    @RequestMapping(value = "/verificationMail", method = RequestMethod.GET)
    public ModelAndView verificationMail(String mail, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //判断用户输入的邮箱号是否正常
        if (RegularExpression.checkMail(mail)) {
            logger.info("邮箱格式正确");
            int frequency=1;
            //获得用户的Session
            HttpSession session = request.getSession();
            if(RedisUtil.get(mail)!=null){
                frequency=(int)RedisUtil.get(mail);
            }
            logger.info("邮箱验证码已发送"+frequency+"次");
            if(frequency<=3) {
                logger.info("邮箱验证码开始发送");
                //使用Session保存随机数
                session.setAttribute("verificationRegister", MyRandom.getVerification());
                session.setAttribute("mail",mail);
                //调用邮箱推送类，将生成的验证码发送给用户
                try {
                    Sample.mySample((String) session.getAttribute("verificationRegister"), mail);
                }catch (Exception e){
                    logger.info("发送邮箱验证码异常");
                }
                ++frequency;
                RedisUtil.set(mail,frequency,60*60*24);
                modelAndView.setViewName("verificationNumber");
                logger.info("邮箱验证码发送成功");
            }else {
                logger.info("已获得3次验证码");
                modelAndView.addObject("prompt", "验证码已发送，请等待"+RedisUtil.getExpire(mail)+"秒后重新获取");
                modelAndView.setViewName("registerError");
            }
        } else {
            logger.info("邮箱格式错误");
            modelAndView.addObject("prompt", "请输入正确的邮箱号");
            modelAndView.setViewName("registerError");
        }
        return modelAndView;
    }

    //通过用户输入手机号获得验证码
    @RequestMapping(value = "/verificationPhome", method = RequestMethod.GET)
    public ModelAndView verificationPhome(String phome, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //判断用户输入的手机号号是否正常
        if (RegularExpression.checkPhone(phome)) {
            logger.info("用户输入手机号格式正确");
            //获得用户的Session
            HttpSession session = request.getSession();
            int frequency=1;
            if(RedisUtil.get(phome)!=null){
                frequency=(int)RedisUtil.get(phome);
            }
            logger.info("短信验证码已发送"+frequency+"次");
            if(frequency<=3) {
                logger.info("手机验证码开始发送");
                //使用Session保存随机数
                session.setAttribute("verificationRegister", MyRandom.getVerification());
                //调用手机号推送类，将生成的验证码发送给用户
                try {
                    MoblieMessageUtil.sendSms(phome,(String)session.getAttribute("verificationRegister"));
                } catch (ClientException e) {
                    logger.info("发送短信验证码异常");
                }
                ++frequency;
                modelAndView.setViewName("verificationNumber");
                logger.info("发送短信成功");
            }else {
                modelAndView.addObject("prompt", "验证码已发送，请等待"+RedisUtil.getExpire(phome)+"秒后重新获取");
                modelAndView.setViewName("registerError");
            }
        } else {
            logger.info("用户输入的手机号格式错误");
            modelAndView.addObject("prompt", "请输入正确的手机号");
            modelAndView.setViewName("registerError");
        }
        return modelAndView;
    }


    //验证邮箱验证码
    @RequestMapping(value = "/verificationNumber", method = RequestMethod.GET)
    public ModelAndView verificationNumberMail(String verificationNumber, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (verificationNumber.equals(request.getSession().getAttribute("verificationRegister"))) {
            HttpSession session=request.getSession();
            //创建一个用户
            Student student=(Student)session.getAttribute("student");
            userService.registerStudent(student);
            //在插入语句下方获得id值
            student.setId(student.getId());
            //从Session中获得用户输入的邮箱,并更新到数据库中
            if(session.getAttribute("mail")!=null) {
                student.setMailbox((String) session.getAttribute("mail"));
                logger.info(student.getMailbox());
                //更新用户的邮箱信息
                userService.updeteMail(student);
            }else {
                logger.info("用户通过短信完成验证");
            }
            modelAndView.addObject("information", "注册成功");
        } else {
            modelAndView.addObject("information", "验证码错误");
        }
        modelAndView.setViewName("loginInformation");
        return modelAndView;
    }


    //个人主页
    @RequestMapping(value = "/u/User", method = RequestMethod.GET)
    public ModelAndView getUser(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //能进入被拦截页面则说明Session中已经封装有成功登录的用户id
        HttpSession session = request.getSession();
        int UserId = (int) session.getAttribute("signInID");
        //根据ID值查询出用户
        Student student=userService.queryStudnet(UserId);
        //将带有URL的POJO类传递到JSP页面
        modelAndView.addObject("User",student);

        //根据Oss标志位调用阿里云工具类或者七牛工具类
        TransferContext transferContext=new TransferContext(OssSign);
        //获得对应的外链,并封装到MODEL中
        modelAndView.addObject("line",transferContext.getlLink());
        modelAndView.addObject("Jurisdiction",UserId==32);

        if(OssSign) {
            modelAndView.addObject("Oss","切换为七牛Oss库" );
        }else {
            modelAndView.addObject("Oss","切换为阿里云Oss库" );
        }
        modelAndView.setViewName("personalPage");
        return modelAndView;
    }

    //更新个人信息控制器
    @RequestMapping(value = "/u/User", method = RequestMethod.PUT)
    public ModelAndView upUser(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.updeteStudent(student)) {
            modelAndView.setViewName("redirect:/u/User");
        } else {
            modelAndView.setViewName("registerError");
            modelAndView.addObject("prompt", "更新失败");
        }
        return modelAndView;
    }

    //上传图片控制器
    @RequestMapping(value = "/u/uploadFile", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam(value = "file")CommonsMultipartFile file,
                           HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/u/User");
        //创建POJO类封装数据
        Student student = new Student();
        //获得用户的ID，并封装到POJO类中
        student.setId((int) request.getSession().getAttribute("signInID"));
        if(file.getSize()!=0) {

            //获得用户上传文件的名称并和随机生成的UUID拼接
            String fileName = file.getOriginalFilename();
            String key = UUID.randomUUID()+fileName;

            //将用户的头像key保存到用户对应的数据库表记录中
            student.setHeadPortrait(key);
            userService.uploadHeadPortrait(student);

            //根据Oss标志位调用阿里云工具类或者七牛工具类
            TransferContext transferContext=new TransferContext(OssSign);
            //使用对应的上传方法上传图片
            transferContext.uploadImage(file.getInputStream(),key);

        }else {
            modelAndView.setViewName("registerError");
            modelAndView.addObject("prompt", "你还没上传图片呢");
        }
        return modelAndView;
    }

    //更新密码控制器
    @RequestMapping(value = "/u/updatePasswordGetVerification",method = RequestMethod.PUT)
    public ModelAndView updatePasswordGetVerification(String password,HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //判断用户输入的密码是否符合格式
        if(RegularExpression.checkPwd(password)){
            HttpSession session=request.getSession();
            session.setAttribute("pwd",password);
            //获得当前用户的邮箱和手机号
            Student student=userService.queryStudentMailAndPhoneNumber((int)session.getAttribute("signInID"));
            if(student!=null){
                if(session.getAttribute("verification")==null) {
                    //生成验证码并保存到Sessio中
                    session.setAttribute("verification", MyRandom.getVerification());
                    //设置有效时间为90秒
                    session.setMaxInactiveInterval(90);
                    //调用发送邮箱的工具类发送验证码
                    Sample.mySample((String) session.getAttribute("verification"), student.getMailbox());
                    //跳转到输入验证码更新密码的页面
                    modelAndView.setViewName("updatePassword");
                }else {
                    modelAndView.addObject("prompt", "验证码已发送，请等待"+session.getMaxInactiveInterval()+"秒后重新获取");
                    modelAndView.setViewName("registerError");
                }
            }else {
                //不存在这个用户就跳转到报错页面
                modelAndView.setViewName("registerError");
                modelAndView.addObject("prompt", "不存在这个用户");
            }
        }else {
            //不符合跳转到报错页面
            modelAndView.setViewName("registerError");
            modelAndView.addObject("prompt", "密码格式错误");
        }
        return modelAndView;
    }

    //判断验证码是否正确，更新用户密码
    @RequestMapping(value = "/u/updatePassword",method = RequestMethod.GET)
    public ModelAndView updatePassword(String verification,HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //判断用户输入的验证码是否跟Session中的验证码相同
        if(request.getSession().getAttribute("verification").equals(verification)){
            Student student=new Student();
            student.setId((int)request.getSession().getAttribute("signInID"));
            student.setPassword((String) request.getSession().getAttribute("pwd"));
            if(userService.updatePassword(student)){
                //更改密码后注销
                modelAndView.setViewName("redirect:/remove");
            }else {
                //不符合跳转到报错页面
                modelAndView.setViewName("registerError");
                modelAndView.addObject("prompt", "更新失败");
            }
        }else {
            //不符合跳转到报错页面
            modelAndView.setViewName("registerError");
            modelAndView.addObject("prompt", "验证码错误");
        }
        return modelAndView;
    }

    //切换Oss库的控制器
    @RequestMapping(value = "/changeOss",method = RequestMethod.GET)
    public String changeOss(HttpServletRequest request){
        //假设ID为32的用户为管理员
        int ID=(int)request.getSession().getAttribute("signInID");
        if(ID==32) {
            //根据OssSign创建迁移环境类
            TransferContext transferContext=new TransferContext(OssSign);
            //调用对应的迁移方法
            transferContext.TransferImage();
            //执行完迁移操作后，将标志位反转
            OssSign = !OssSign;
        }
        return "redirect:/";
    }
}
