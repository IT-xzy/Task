package com.fml.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.auth0.jwt.interfaces.Claim;
import com.fml.pojo.Student;
import com.fml.service.EmailService;
import com.fml.service.StudentService;
import com.fml.utils.*;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.qcloud.cos.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    StudentService studentService;
    @Autowired
    EmailService emailService;
    @Autowired
    //private MyOSSClient ossClient;
    OSSClient ossClient;
    @Autowired
    MyCOSClient cosClient;
    @Autowired
    ObjectMetadata objectMetadata;
    /**
     * 注册跳转
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * （腾讯云）短信验证
     * @param phone
     * @param request
     */
    @ResponseBody
    @RequestMapping("tencentsms")
    public Map<String,Object> tencentSMS(String phone, HttpServletRequest request){
        JSONObject json = new JSONObject();
        /*验证手机号是否为空*/
        if (phone == null || phone.equals("")){
            json.put("status", -1);
            json.put("message", "手机号为空");
            return json;
        }
        /*验证手机号是否合法*/
        if (!phone.matches("^[1][3578]\\d{9}$")){
            json.put("status", -1);
            json.put("message", "手机号非法格式！");
            return json;
        }

        /*生成手机验证码，并限定有效时间。*/
        String code = VerificationUtil.getVerificationCode();
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        session.setMaxInactiveInterval(180);


        int appid = 1400081087; // 短信应用SDK AppID
        String appkey = "1c3794ed0ce290f07922b3208e364d30";// 短信应用SDK AppKey

        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phone,
                    "您的验证码是"+code+"，请在三分钟内完成验证。", "", "");
            LOGGER.info(result+"");
            json.put("status", 1);
            json.put("message", "手机验证码发送成功，请查收！");
            return json;
        } catch (HTTPException e) { //这种异常，后端返回给前端异常码，前端给用户提示短信发送失败
            // HTTP响应码错误
            e.printStackTrace();
            json.put("status", -1);
            return json;
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
            json.put("status", -1);
            return json;
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
            json.put("status", -1);
            return json;
        }
    }

    /**
     * 注册提交
     * @param entity
     * @return
     */
    @RequestMapping(value = "subRegister",method = RequestMethod.POST)
    public String subRegister(@Valid Student entity, BindingResult result, String smsCode, HttpServletRequest request, HttpServletResponse response){
        //System.out.println(entity);
        JSONObject json = new JSONObject();
        /*参数校验*/
        if (result.hasErrors()){
            //FieldError fieldError = result.getFieldError();
            LOGGER.error("注册时参数格式不正确！");
            json.put("message", "注册时参数格式不正确！");
            return "register";
        }

        /*判断验证码是否匹配*/
        if (!request.getSession().getAttribute("code").equals(smsCode)){
            json.put("message", "验证码错误!");
            return "register";
        }

        /*判断该用户是否已经存在*/
        Student student = studentService.getByUserName(entity.getUserName());
        if (student != null){
            json.put("message", "用户已存在！");
            return "register";
        }

        if (studentService.add(entity)){
            LOGGER.info(entity.getUserName() + "注册成功！");
            //直接保存用户信息登录
            String token = null;
            try {
                token = JWTUtil.createToken(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //令牌信息存入Cookie
            response.addCookie(CookieUtil.getCookie("token",token));
            LOGGER.info(DateUtil.format(new Date()) + ":" + entity.getUserName() + "登录成功！");

            return "home";
        } else{
            LOGGER.error(DateUtil.format(new Date()) + ":" + entity.getUserName() + "注册失败！原因待查...");
            json.put("message", "程序出错，用户注册失败！");
            return "error";
        }
    }

    /**
     * 登录跳转
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(HttpServletResponse response){
        //response.setContentType("application/html;charset=UTF-8");
        return "login";
    }

    /**
     * 登录提交
     * @param entity
     * @return
     */
    @RequestMapping(value = "subLogin", method = RequestMethod.POST)
    public String subLogin(Student entity, HttpServletResponse response){
        if (!studentService.login(entity)){
            LOGGER.error("登录失败！用户名/密码错误");
            return "login";
        }
        /*生成token*/
        try {
            String token = JWTUtil.createToken(entity);
            //令牌信息存入Cookie
            response.addCookie(CookieUtil.getCookie("token", token));
            LOGGER.info(DateUtil.format(new Date()) + ": 用户登录成功！");
        } catch (Exception e) {
            LOGGER.error("JWT生成密钥失败！", e);
        }
        return "redirect:home";
    }

    /**
     * 邮箱验证跳转（绑定邮箱）
     * @return
     */
    @RequestMapping(value = "emailVerifi",method = RequestMethod.GET)
    public String emailVerification(){
        return "emailVerification";
    }


    /**
     * 发送邮件
     * @param email
     * @param request
     */
    @ResponseBody
    @RequestMapping(value = "aliEmail",method = RequestMethod.POST)
    public Object sendEmail(String userName, String email, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        /*先应该判断用户的身份token是否过期*/


        /*先查看是否已经发送过邮件*/
        long stuId = studentService.getByUserName(userName).getStuId();
        long lastSendTime = System.currentTimeMillis() - 15*60*1000;
        if (emailService.getCount(stuId, lastSendTime) == 1){
            json.put("status", "-1");
            LOGGER.info("邮箱已经发送过，请去邮箱查收验证！");
            return json;
        }
        /*限定每日最多发送10封邮件*/
        long dailySendTime = CalendarUtil.getDailyStartTime().getTime();
        if (emailService.getCount(stuId, dailySendTime) > 10) {
            json.put("status", "-1");
            LOGGER.info("今日发送邮件已达10封，暂停发送！");
            return json;
        }


        /*获取邮件验证码，链接给用户，时间15分钟*/
        System.out.println(userName);
        System.out.println(email);
        String token = null;
        try {
            token = JWTUtil.emailToken(userName + ":" + email);//用username和email进行JWT加密
        } catch (Exception e) {
            LOGGER.error("密钥生成失败！", e);
        }
        System.out.println("密钥：" + token);
        //将密文token放入cookie中
        Cookie cookie = CookieUtil.getCookie("token", token);
        response.addCookie(cookie);

        /*根据服务器地址、邮件验证码构建验证链接*/
        String link = IPUtil.getEmailLink(request) + token;

        /*发送邮件*/
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIKZZR5he1rKBk", "D1Nq9I5olH01GCDn8PQWhbjDu5G1en");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest mailRequest = new SingleSendMailRequest();
        try {
            //mailRequest.setVersion("2017-06-22");//这句话必须注释掉，否则报错
            mailRequest.setAccountName("dwk@osmanthuswine.cn");
            mailRequest.setFromAlias("段文凯");
            mailRequest.setAddressType(1);
            mailRequest.setTagName("register");
            mailRequest.setReplyToAddress(true);
            mailRequest.setToAddress(email);
            mailRequest.setSubject("技能树注册验证通知");
            mailRequest.setHtmlBody("尊敬的用户，您好！" + "<br>" + "请点击验证链接完成验证：" + link + "<br>" + "或者复制该链接进行验证。");

            client.getAcsResponse(mailRequest);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        /*成功返回0*/
        json.put("status", 0);
        return json;
    }


    /**
     * 验证邮件是否满足要求
     * @param request
     * @return
     */
    @RequestMapping(value = "emailVerification",method = RequestMethod.GET)
    public String emailVerification(HttpServletRequest request, HttpServletResponse response){



        /*接受URI参数，并分割验证*/
        String query = request.getQueryString();
        System.out.println(query);
        String[] strings = query.split("=");

        if (strings.length != 2){
            LOGGER.error("验证错误");
            return "error";
        }


        /*解析JWT，取出nameAndEmail*/
        String message;
        try {
            Map<String, Claim> map = JWTUtil.verifyToken(strings[1]);
            message = map.get("token").asString();
        } catch (Exception e) {
            LOGGER.error("token已经过期，请重新发送验证邮件！", e);
            return "error";
        }
        /*分割nameAndEmail*/
        System.out.println(message);
        String[] nameAndEmail = message.split(":");
        /*数据库查找是否存在该学员*/
        Student student = studentService.getByUserName(nameAndEmail[0]);

        if (student == null){
            LOGGER.info("该用户不存在！");
            return "error";
        }

        /*判断用户名邮箱是否匹配*/
        if (!student.getEmail().equals(nameAndEmail[1])){
            LOGGER.info("用户名和邮箱不匹配！");
            return "error";
        }

        student.setEmailStatus(1);/*更新数据库中邮箱的绑定标记*/
        studentService.update(student);

        /*这时候用户的信息会丢失，Http500错误,该怎么解决呢？*/
        System.out.println(student);
        /*生成token*/
        String token;
        try {
            token = JWTUtil.createToken(student);
            System.out.println(token);
            //令牌信息存入Cookie
            Cookie cookie = CookieUtil.getCookie("token",token);
            //response.setHeader();
            response.addCookie(cookie);
            LOGGER.info(DateUtil.format(new Date()) + ": 用户邮箱验证成功！");
        } catch (Exception e) {
            LOGGER.error("JWT生成密钥失败！", e);
        }
        return "home";
    }


    /**
     * 上传头像跳转
     * @return
     */
    @RequestMapping(value = "uploadPhoto",method = RequestMethod.GET)
    public String uploadPhoto(){
        return "uploadPhoto";
    }


    /**
     * 上传头像提交
     * @param
     * @return
     */
    @RequestMapping(value = "subUpload", method = RequestMethod.POST)
    public String uploadPhoto(@Value("${aliyun.oss.bucket.name}") String bucketName, @Value("${yun.type}") String type, MultipartFile photo, String userName){
        //System.out.println(photo.getName());//取出jsp中的namephoto
        //System.out.println(photo.getContentType());//文件的类型image/jpeg
        System.out.println(photo.getOriginalFilename());//本地文件名3-160309162601.jpg
        /*得到图片的类型*/
        String[] photoName = photo.getOriginalFilename().split("\\.");
        String photoType = photoName[photoName.length-1];
        /*图片存储路径*/
        String photoKey = "Task7/"+userName+"."+photoType;


        /*在配置文件中配置是使用OSS还是COS,进行文件上传*/
        if (type.equals("oss")){
            try {
                ossClient.putObject(bucketName, photoKey, new ByteArrayInputStream(photo.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.shutdown();
        }
        if (type.equals("cos")){
            objectMetadata.setContentLength(photo.getSize());
            try {
                cosClient.upload(photoKey,photo.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            cosClient.close();
        }






        /*将图片的地址更新到数据库*/
        Student student = studentService.getByUserName(userName);
        System.out.println(student);
        student.setPhoto(photoKey);
        System.out.println(student.getPhoto());
        if (studentService.update(student)){
            LOGGER.info("头像上传成功！");
            return "success";
        } else {
            LOGGER.error("头像上传失败！");
            return "error";
        }
    }

    /**
     * 个人信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String viePhoto(HttpServletRequest request, Model model){
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append("dwkfcml");
        sb.append(".");
        sb.append("oss-cn-hangzhou.aliyuncs.com");
        sb.append("/");


        Cookie cookie = CookieUtil.getCookieByName(request, "token");
        if (cookie == null){
            return "login";
        }
        System.out.println(cookie);
        String userName = null;

        try {
            Map<String, Claim> map = JWTUtil.verifyToken(cookie.getValue());
            userName = map.get("userName").asString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userName);

        Student student = studentService.getByEmail(userName);
        if (student == null){
            student = studentService.getByUserName(userName);
            if (student == null){
                student = studentService.getByPhone(userName);
                if (student == null){
                    LOGGER.error("该学员不存在");
                    return "error";
                }
            }
        }
        sb.append(student.getPhoto());
        sb.append("?x-oss-process=image/resize,m_fill,w_200,h_200,limit_0/auto-orient,1/quality,q_90");

        model.addAttribute("uri", sb.toString());
        model.addAttribute("phone",student.getPhone());
        model.addAttribute("email",student.getEmail());
        model.addAttribute("userName",student.getUserName());
        model.addAttribute("emailStatus",student.getEmailStatus());
        return "myInfo";
    }
}
