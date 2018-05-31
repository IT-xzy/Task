package com.jnshu.controller;
import com.jnshu.model.Checks;
import com.jnshu.model.Student;
import com.jnshu.service.Impl.ChecksServiceImpl;
import com.jnshu.service.Impl.StudentServiceImpl;
import com.jnshu.utils.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class migrationController {
    private Logger logger = LoggerFactory.getLogger(migrationController.class);
    private Cookie cookie;
    @Resource
    private com.jnshu.tactics.migrationContext migrationContext;
    @Resource
    private ChecksServiceImpl checksServiceImpl;
    @Resource
    private StudentServiceImpl studentServiceImpl;
    private static String code = "";
    private static long timeBgein = 0;

    //todo  首页
    //首页：用户看到的第一页  着重与测试功能
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Login";
    }

    //todo 用户登录页
    // 登录页面 采用复旦大学登录页 附带三个注册链接  跳转向不同的注册页面
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Login(HttpServletResponse response, HttpServletRequest request, @RequestParam("user") String user, @RequestParam("password") String password, Model model) throws UnsupportedEncodingException {
        Checks checksPhone = checksServiceImpl.selectByPhone(user);
        Checks checksEmail = checksServiceImpl.selectByEmail(user);
        if (checksEmail == null && checksPhone == null) {
            model.addAttribute("result", "用户名不存在，请输入正确的手机号或者邮箱！");
            return "Login";
        } else {
            Checks checks = null;
            if (checksEmail == null) {
                checks = checksPhone;
            } else {
                checks = checksEmail;
            }
            String msd5 = MD5Util.generate(password + checks.getSalt());
            String s = password + checks.getSalt();
            logger.info("MD5Util.MD5(s):\t" + MD5Util.MD5(s));
            if (!checks.getMd5().equals(MD5Util.MD5(s))) {
                return "Login";
            } else {
                String df = System.currentTimeMillis() + "";//设置日期格式
                String tokenz = user + "," + df;
                String token = EncryUtil.encrypt(tokenz);
                Cookie cookie = new Cookie("name", token);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
                model.addAttribute("result", "密码正确！Cookie病毒已经植入！");
                return "redirect:/students";
            }
        }
    }

    //todo 手机号码输入页客户前往手机页面
    @RequestMapping(value = "/Phone", method = RequestMethod.GET)
    public String Phone() {
        return "Phone";
    }

    //todo 邮箱输入页客户前往邮箱页面
    @RequestMapping(value = "/Email", method = RequestMethod.GET)
    public String Email() {
        return "Email";
    }

    // 验证码,用户注册页
    // 客户手机验证码页面 此处发送验证码
    @RequestMapping(value = "/PhoneSend", method = RequestMethod.POST)
    public String Phonesend(@RequestParam("Phone") String phone, Model model) throws Exception {
        if (!phone.equals("")) {
            int a = checksServiceImpl.countByPhone(phone);
            if (a == 1) {
                model.addAttribute("result", "您的手机号已经注册，请直接登录！");
                return "Login";
            } else {
                code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
                //MoblieMessageUtil.sendSms(phone, code).getCode();
                model.addAttribute("result", "您的验证码为：{}" + code);
                logger.info("发送的验证码为：\t" + code);
                return "registerP";
            }
        } else {
            model.addAttribute("result", "获取验证码失败，请重新输入手机号码！");
            return "Phone";
        }
    }

    // 客户邮箱验证码页面 此处发送验证码
    @RequestMapping(value = "/EmailSend", method = RequestMethod.POST)
    public String EmailSend(@RequestParam("Email") String email, Model model) throws Exception {
        if (!email.equals("")) {
            int a = checksServiceImpl.countByEmail(email);
            if (a == 1) {
                model.addAttribute("result", "您的邮箱已经注册，请直接登录！");
                return "Login";
            } else {
                code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
                //MailUtil.SendMail(email, code);
                model.addAttribute("result", code);
                return "registerE";
                //return "Email";
            }
        } else {
            model.addAttribute("result", "获取验证码失败，请重新输入邮箱地址！");
            return "Email";
        }
    }

    //todo 客户正式注册页面
    //todo 客户手机注册页面
    @RequestMapping(value = "/registerP", method = RequestMethod.POST)
    public String PRegister(Model model, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("password") String password, @RequestParam("check") String check) throws UnsupportedEncodingException {
        if (!(name.equals("") && phone.equals("") && password.equals("") && check.equals(""))) {
            logger.info("name:" + name + "\t" + "phone:" + phone + "\t" + "password" + "\t" + password + "\t" + "check" + "\t" + check);
            int a = checksServiceImpl.countByPhone(phone);
            logger.info("checksServiceImpl.countByPhone(phone):" + a + "\t" + "CODE" + "\t" + code);
            if (a == 0) {
                String salt = UUIDUtils.getUUID();
                String bfMD5 = password + salt;
                String md5 = MD5Util.MD5(bfMD5);
                logger.info("MD5:" + "\t" + md5 + "salt" + "\t" + salt);
                Checks checks = new Checks();
                checks.setTel(phone);
                checks.setEmail(null);
                checks.setTocheck(code);
                checks.setMd5(md5);
                checks.setSalt(salt);
                checks.setStates(1);
                checks.setCreateat(System.currentTimeMillis());
                checks.setUpdateat(System.currentTimeMillis());
                int b = checksServiceImpl.insert(checks);
                if (b == 1) {
                    model.addAttribute("result", "您的手机号已经注册成功！");
                    return "record";
                }
            } else {
                model.addAttribute("result", "您的手机号已经注册！");
                return "Login";
            }
        }
        return "registerP";
    }

    ////todo 客户邮箱注册页面
    @RequestMapping(value = "/registerE", method = RequestMethod.POST)
    public String ERegister(Model model, @RequestParam("name") String name, @RequestParam("Email") String email, @RequestParam("password") String password, @RequestParam("check") String check) throws UnsupportedEncodingException {
        if (!(name.equals("") && email.equals("") && password.equals("") && check.equals(""))) {
            logger.info("name:" + name + "\t" + "phone:" + email + "\t" + "password" + "\t" + password + "\t" + "check" + "\t" + check);
            int a = checksServiceImpl.countByEmail(email);
            if (a != 0) {
                model.addAttribute("result", "您的邮箱已经注册！");
                return "Login";
            } else {
                logger.info("checksServiceImpl.countByEmail(email):" + a + "\t" + "CODE" + "\t" + code);
                String salt = UUIDUtils.getUUID();
                String bfMD5 = password + salt;
                String md5 = MD5Util.MD5(bfMD5);
                logger.info("MD5:" + "\t" + md5 + "salt" + "\t" + salt);
                Checks checks = new Checks();
                checks.setTel(null);
                checks.setEmail(email);
                checks.setTocheck(code);
                checks.setMd5(md5);
                checks.setSalt(salt);
                checks.setStates(1);
                checks.setCreateat(System.currentTimeMillis());
                checks.setUpdateat(System.currentTimeMillis());
                int b = checksServiceImpl.insert(checks);
                if (b == 1) {
                    model.addAttribute("result", "您的邮箱已经注册成功！");
                    return "record";
                }
            }
        }
        return "registerE";
    }

    //todo 客户邮箱链接注册页面
    @RequestMapping(value = "/registerL", method = RequestMethod.GET)
    public String LRegister() {
        return "registerL";
    }

    //todo 用户信息登记页
    // 登记用户详细信息，
    @RequestMapping(value = "/recordP", method = RequestMethod.POST)
    public String recordP(Model model, @RequestParam("name") String name, @RequestParam("qq") String qq, @RequestParam("type") String type, @RequestParam("enrolmenttime") String enrolmenttime, @RequestParam("graduated") String graduated, @RequestParam("number") String number, @RequestParam("daily") String daily, @RequestParam("ambition") String ambition, @RequestParam("responsible") String responsible, @RequestParam("wfrom") String wfrom, @RequestParam("telipone") String telipone, @RequestParam("email") String email) {
        if (!(name.equals("") && qq.equals("") && type.equals("") && enrolmenttime.equals("") && graduated.equals("") && number.equals("") && daily.equals("") && ambition.equals("") && responsible.equals("") && responsible.equals("") && wfrom.equals("") && telipone.equals("") && email.equals(""))) {
            Student student = new Student();
            student.setName(name);
            student.setQq(qq);
            student.setType(type);
            student.setEnrolmenttime(enrolmenttime);
            student.setGraduated(graduated);
            student.setNumber(number);
            student.setDaily(daily);
            student.setAmbition(ambition);
            student.setResponsible(responsible);
            student.setWfrom(wfrom);
            student.setTelipone(telipone);
            student.setEmail(email);
            student.setCreateAt(System.currentTimeMillis());
            student.setUpdateAt(System.currentTimeMillis());
            logger.info(student+"");
            model.addAttribute("result", student.toString());
            int a = studentServiceImpl.insert(student);
            model.addAttribute("result", a);
            //return "redirect:/students";
            return "portrait";
        } else {
            model.addAttribute("result", "信息缺失，请重新输入");
            return "record";
        }
    }

    // 登记用户详细信息，
    @RequestMapping(value = "/recordE", method = RequestMethod.POST)
    public String recordE(Model model, @RequestParam("name") String name, @RequestParam("qq") String qq, @RequestParam("type") String type, @RequestParam("enrolmenttime") String enrolmenttime, @RequestParam("graduated") String graduated, @RequestParam("number") String number, @RequestParam("daily") String daily, @RequestParam("ambition") String ambition, @RequestParam("responsible") String responsible, @RequestParam("wfrom") String wfrom, @RequestParam("telipone") String telipone, @RequestParam("email") String email) {
        logger.info("/recordE POST the params are name:{},qq:{}",name,qq);
        if (!(name.equals("") && qq.equals("") && type.equals("") && enrolmenttime.equals("") && graduated.equals("") && number.equals("") && daily.equals("") && ambition.equals("") && responsible.equals("") && responsible.equals("") && wfrom.equals("") && telipone.equals("") && email.equals(""))) {
            Student student = new Student();
            student.setName(name);
            student.setQq(qq);
            student.setType(type);
            student.setEnrolmenttime(enrolmenttime);
            student.setGraduated(graduated);
            student.setNumber(number);
            student.setDaily(daily);
            student.setAmbition(ambition);
            student.setResponsible(responsible);
            student.setWfrom(wfrom);
            student.setTelipone(telipone);
            student.setEmail(email);
            student.setCreateAt(System.currentTimeMillis());
            student.setUpdateAt(System.currentTimeMillis());
            logger.info(student+"");
            model.addAttribute("result", student.toString());
            int a = studentServiceImpl.insert(student);
            model.addAttribute("result", a);
            //return "redirect:/students";
            return "portrait";
        } else {
            model.addAttribute("result", "信息缺失，请重新输入");
            return "record";
        }
    }

    //todo 用户头像上传页
    //  手机上传用户头像
    @RequestMapping(value = "/portraitP", method = RequestMethod.POST)
    public String portraitP(@RequestParam("file") CommonsMultipartFile file, Model model, HttpServletRequest request, @RequestParam("Phone") String phone) throws IOException {
        if (request.getCookies() != null) {
            String telphone = null;
            Cookie[] cookies = request.getCookies();
            for (Cookie cook : cookies) {
                if (cook.getName().equals("name")) {
                    cookie = cook;
                    String check = EncryUtil.decrypt(cookie.getValue());
                    logger.info("Cookie\t" + check);
                    telphone = StringUtils.substringBefore(check, ",");
                    logger.info("StringUtils.substringBefore(check, \",\")" + StringUtils.substringBefore(check, ","));
                    logger.info("namessss：\t" + telphone);
                    break;
                }
            }
            InputStream in = file.getInputStream();
            String imgUrl = file.getOriginalFilename();
            String typed = imgUrl.indexOf(".") != -1 ? imgUrl.substring(imgUrl.lastIndexOf("."), imgUrl.length()) : null;
            logger.info("typed:\t" + typed);
            if (typed == null) {
                model.addAttribute("result", "上传失败，文件不可为空");
                return "portrait";
            } else {
                String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + typed;
                String a = migrationContext.fileUpload(filename, in);
                logger.info("named:\t" + filename);
                model.addAttribute("result", "上传头像成功！" + filename);
                studentServiceImpl.upPortraitByPhone(filename, phone);
                String url = migrationContext.getUrl(filename);
                logger.info("下载地址为：" + url);
                return "redirect:/students";
            }
        } else {
            return "Login";
        }
    }

    //  手机上传用户头像
    @RequestMapping(value = "/portraitE", method = RequestMethod.POST)
    public String portraitE(@RequestParam("file") CommonsMultipartFile file, Model model, HttpServletRequest request, @RequestParam("Email") String email) throws IOException {
        //todo /portraitE POST
        if (request.getCookies() != null) {
            //    String telphone = null;
            //    Cookie[] cookies = request.getCookies();
            //    for (Cookie cook : cookies) {
            //        if (cook.getName().equals("name")) {
            //            cookie = cook;
            //            String check = EncryUtil.decrypt(cookie.getValue());
            //            logger.info("Cookie\t" + check);
            //            telphone = StringUtils.substringBefore(check, ",");
            //            logger.info("StringUtils.substringBefore(check, \",\")" + StringUtils.substringBefore(check, ","));
            //            logger.info("namessss：\t" + telphone);
            //            break;
            //        }
            //}
            InputStream in = file.getInputStream();
            String imgUrl = file.getOriginalFilename();
            String typed = imgUrl.indexOf(".") != -1 ? imgUrl.substring(imgUrl.lastIndexOf("."), imgUrl.length()) : null;
            logger.info("typed:\t" + typed);
            if (typed == null) {
                model.addAttribute("result", "上传失败，文件不可为空");
                return "portraitE";
            } else {
                String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + typed;
                String a = migrationContext.fileUpload(filename, in);
                logger.info("named:\t" + filename);
                model.addAttribute("result", "上传头像成功！" + filename);
                studentServiceImpl.upPortraitByEmail(filename, email);
                String url = migrationContext.getUrl(filename);
                logger.info("下载地址为：" + url);
                return "redirect:/students";
            }
        } else {
            return "Login";
        }
    }

    // 所有用户页
    // 客户列表页面，显示所有客户
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String students(Model model) {
        List<Student> studentList = studentServiceImpl.studentList();
        Iterator it = studentList.iterator();
        while (it.hasNext()) {
            logger.info(it.next()+"");
        }
        model.addAttribute("studentList", studentList);
        return "students";
    }

    //todo 用户信息查看页
    //todo 客户信息页面，显示头像功能
    @RequestMapping(value = "/student/{name}", method = RequestMethod.GET)
    public String student(@PathVariable String name, Model model) throws IOException {
        logger.info("/student/{}  GET", name);
        logger.info("显示头像：\t" + name);
        String url = migrationContext.getUrl(name);
        logger.info("url" + url);
        if (url != null) {
            model.addAttribute("file", url);
        }
        model.addAttribute("student", studentServiceImpl.selectByName(name));
        return "student";
    }
    //todo 用户信息修改页

    //todo 删除用户功能
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        studentServiceImpl.deleteById(id);
        logger.info("删除成功！！");
        return "redirect:/students";
    }

    //todo  一键图片迁移
    //  图片迁移工程
    @RequestMapping(value = "/migration", method = RequestMethod.GET)
    public String record(Model model, String name) throws IOException {
        name = migrationContext.migrationUp();
        model.addAttribute("result", name);
        return "redirect:/students";
    }
}
