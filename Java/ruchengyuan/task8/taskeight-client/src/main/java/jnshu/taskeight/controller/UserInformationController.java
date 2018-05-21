package jnshu.taskeight.controller;

import jnshu.taskeight.APIUtil.AttestSmsService;
import jnshu.taskeight.APIUtil.EmailService;
import jnshu.taskeight.APIUtil.ReadFileService;
import jnshu.taskeight.model.Student;
import jnshu.taskeight.service.StudentService;
import jnshu.taskeight.util.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-31
 * @Time: 下午 9:49
 * Description:
 **/

@Controller
public class UserInformationController {

    // 定义允许上传的文件扩展名

    @Autowired
    ReadFileService readFileService;

    @Autowired
    AttestSmsService attestSmsService;

    @Autowired
    EmailService emailService;

    @Autowired
    StudentService studentService;

    private static Logger loggerUplFilSer = LoggerFactory.getLogger(UserInformationController.class);


    //图片上传后台
    @RequestMapping(value = "/a/u/backstage/file/picture" , method = RequestMethod.POST)
    public void uploadFiles(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String user = CookieUtils.getCookie(request,"user");
        loggerUplFilSer.info("user: " + user);

        loggerUplFilSer.info("开始上传");
        OutputStream out = response.getOutputStream();

        //图片上传
        String message = readFileService.readPicture(request,user);


        loggerUplFilSer.info("message: "+ message);
        //查看在message里的第几个字符起为"u_" ,下标从0开始，如果没有就返回-1
        int sign = message.indexOf("u_");
        loggerUplFilSer.info("sign: " + sign);
        if(sign != -1){
            Student student = new Student();
            //从cookie获取到用户名

            student.setUser(user);
            //生成图片链接
            String imageURL = "http://xiuzhenyuan.oss-cn-beijing.aliyuncs.com/image/" + message + "/xiuzhenyuan_student_picture";
            student.setImages(imageURL);
            loggerUplFilSer.info("imageURL: " +imageURL);
            int i =  studentService.updateStudentUserPicturePhoneEmail(student);
            loggerUplFilSer.info("更改的数据量 ： "+ i);
            out.write(("<script charset=\"utf-8\" language='javaScript'> alert('文件上传成功');</script>").getBytes());
        }
        else{
            out.write(("<script charset=\"utf-8\" language='javaScript'> alert('" +message + "');</script>").getBytes());
        }
    }

    //获取手机验证码后台
    @RequestMapping(value = "/a/u/backstage/information/phone" ,method =  RequestMethod.POST)
    public void phoneNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String phoneNumber = null;
        String message = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        phoneNumber = request.getParameter("phone");
        //格式化出来phoneNumber
        phoneNumber = phoneNumber.replaceAll(" ", "");
        loggerUplFilSer.info("phoneNumber: "+ phoneNumber);
        Integer length = phoneNumber.length();
        loggerUplFilSer.info("phoneNumber length: "+ length);
        HttpSession session =request.getSession();
        if(phoneNumber !=null && length == 11){
            message = attestSmsService.sendVerificationSMS(phoneNumber);
            loggerUplFilSer.info("message: "+ message);
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('手机号输入错误！');</script>".getBytes());
            return;
        }
        if(message != null){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('获取验证码成功！有效期为5分钟');</script>".getBytes());
            session.setAttribute("phoneNumber", phoneNumber);
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码获取失败');</script>".getBytes());
        }
        return;
    }


    //验证验证码
    @RequestMapping(value = "/a/u/backstage/information/sms" ,method =  RequestMethod.POST)
    public void phoneSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String verificationCode = "";
        String smsNumber = "";
        String phoneNumber = "";

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        HttpSession session =request.getSession();
        verificationCode = request.getParameter("verificationCode");
        verificationCode = verificationCode.replaceAll(" ", "");
        loggerUplFilSer.info("verificationCode: "+ verificationCode);
        if(verificationCode == ""){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码不能为空');</script>".getBytes());
            return;
        }


        if(verificationCode != "" && verificationCode.length() == 6){
            phoneNumber = (String) session.getAttribute("phoneNumber");
            loggerUplFilSer.info("phoneNumber: "+ phoneNumber);
        }
        else{
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码错误');</script>".getBytes());
            return;
        }

        if(phoneNumber != ""){
            smsNumber = attestSmsService.getCachePhoneNumber(phoneNumber);
            loggerUplFilSer.info("smsNumber: "+ smsNumber);

        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('手机号不能为空');</script>".getBytes());
            return;
        }
        if( smsNumber == null ){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码已经失效');</script>".getBytes());
            return;
        }
        if(smsNumber.equals(verificationCode)){
            Student student = new Student();
            student.setPhone(phoneNumber);
            String user = CookieUtils.getCookie(request,"user");
            student.setUser(user);
            loggerUplFilSer.info("user: " + user + "phone: "+ phoneNumber);
            Integer sgin =  studentService.updateStudentUserPicturePhoneEmail(student);
            loggerUplFilSer.info("是否更新成功： "+ sgin);
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证成功');</script>".getBytes());
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证失败');</script>".getBytes());
        }
        return;

    }


    @RequestMapping(value = "/a/u/backstage/information/email" , method =  RequestMethod.POST)
    public void acquisitionEmail(HttpServletRequest request, HttpServletResponse response)  throws  IOException{
        String email = request.getParameter("email");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        email = email.replaceAll(" ", "");
        String user = CookieUtils.getCookie(request,"user");
        HttpSession session =request.getSession();
        final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if(email == "" || email == null){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('E-mail不能为空！');</script>".getBytes());
            return;
        }
        if (Pattern.matches(REGEX_EMAIL, email)){
            int message =  emailService.verificationEmail(email,user).length();
            loggerUplFilSer.info("message: "+ message);
            if(message == 6){
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('邮件已经发送！');</script>".getBytes());
                session.setAttribute("email",email);
                return;
            }
            else {
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('邮件发送失败！');</script>".getBytes());
                return;
            }
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('邮件格式错误！');</script>".getBytes());
        }
        return;
    }

    @RequestMapping(value = "/a/u/backstage/information/email/verification" , method =  RequestMethod.POST)
    public void verificationEmail(HttpServletRequest request, HttpServletResponse response)  throws  IOException{
        String verificationCode = "";
        String number = "";
        String email = "";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        HttpSession session =request.getSession();
        verificationCode = request.getParameter("verificationCode");
        verificationCode = verificationCode.replaceAll(" ", "");
        if(verificationCode == "" || verificationCode == null){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码不能为空！');</script>".getBytes());
            return;
        }
        if(verificationCode.length() == 6){
            email  = (String) session.getAttribute("email");
            number = emailService.getCacheEmailNumber(email);
            if(number.equals(verificationCode)){
                Student student = new Student();
                student.setUserEmail(email);
                String user = CookieUtils.getCookie(request,"user");
                student.setUser(user);
                Integer sgin = studentService.updateStudentUserPicturePhoneEmail(student);
                loggerUplFilSer.info("是否更新成功： "+ sgin);
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证成功！');</script>".getBytes());
                return;
            }
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码错误！');</script>".getBytes());
            return;
        }
    }
}