package com.jnshu.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.auth0.jwt.interfaces.Claim;
import com.jnshu.entity.UserDTO;
import com.jnshu.service.BussinessService;
import com.jnshu.tools.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: Tiles
 * @description: 登录注册
 * @author: Mr.Lee
 * @create: 2018-07-04 10:26
 **/
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    BussinessService businessService;
    @Autowired
    OSSClient ossClient;

    /**
     * @Description:   短信
     * @Param: [phone, request]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.Lee
     * @Date: 2018\7\31 0031
     */
    @RequestMapping("/txsms")
    @ResponseBody
    public Map<String ,Object> txsms(String phone, HttpServletRequest request) throws com.github.qcloudsms.httpclient.HTTPException {
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
        String code = RandomUtil.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        session.setMaxInactiveInterval(180);

        String min = "3";
        //"验证码"，"分钟数"

        String[] smsInfo = new String[]{String.valueOf(code),min};
        HashMap<String, Object> result = SendSMS.sendTemplateSMS(phone,"1",smsInfo);
        log.info("=.=" + result);

        json.put("status", 1);
        json.put("message", "手机验证码发送成功，请查收！");
        return json;

    }


    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/registers")
    public String register(UserDTO userDTO, String smsCode, HttpServletRequest request, HttpServletResponse responsev) throws Exception {
        JSONObject json = new JSONObject();

        if (!request.getSession().getAttribute("code").equals(smsCode)){
            Msg.fail().add("msg","验证码错误！");

        }

        String pwd = userDTO.getPassword();
        String username = userDTO.getUsername();
//        MD5加盐加密密码
        pwd = Md5Util.getSaltMD5(pwd);
        userDTO.setPassword(pwd);

        if (businessService.findByUserName(username)==null){
            businessService.register(userDTO);
            log.info("=========注册成功=======");
            return "login";
        }else {
            log.info("=========注册失败=======");
            return "error";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/alogin")
    public String alogin(UserDTO userDTO,HttpServletResponse response){
        if (! businessService.alogin(userDTO)){
            log.error("登录失败！用户名/密码错误");
            return "login";
        }
        String token = null;
        try {
            token = JWTUtil.createToken(userDTO);
            response.addCookie(CookieUtil.getCookie("token",token));
        } catch (Exception e) {
            log.error("JWT生成密钥失败！",e);
        }
        return "redirect:home";
    }


    /**
     * 邮箱验证跳转（绑定邮箱）
     *
     * @return
     */
    @RequestMapping("emailVerify")
    public String emailVerification() {
        return "emailVerification";
    }

    /**
     * @Description: 发送邮件
     * @Param: [userName, email, request, response]
     * @return: java.lang.Object
     * @Author: Mr.Lee
     * @Date: 2018\8\1 0001
     */

    @RequestMapping(value = "/aliEmail", method = RequestMethod.POST)
    public String  sendEmail(String username, String email, HttpServletRequest request, HttpServletResponse response) throws com.aliyuncs.exceptions.ClientException {
        JSONObject json = new JSONObject();

        /*获取邮件验证码，链接给用户，时间15分钟*/
        System.out.println(username);
        System.out.println(email);
        String token1 = null;
        try {
            token1 = JWTUtil.emailToken(username + ":" + email);
        } catch (Exception e) {
            log.error("密钥生成失败！", e);
        }
        System.out.println("密钥：" + token1);
        //将密文token放入cookie中
        Cookie cookie = CookieUtil.getCookie("token1", token1);
        response.addCookie(cookie);

        /*根据服务器地址、邮件验证码构建验证链接*/
        String link = IPUtil.getEmailLink(request) + token1;

        /*发送邮件*/
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIDJQjj6irbhFK", "HDoiq8ig2Zi3eijbubQOsl02PL2tyG");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest mailRequest = new SingleSendMailRequest();
        try {
            //mailRequest.setVersion("2017-06-22");
            mailRequest.setAccountName("mason@willming.cn");
            mailRequest.setFromAlias("Lee");
            mailRequest.setAddressType(1);
            mailRequest.setTagName("register");
            mailRequest.setReplyToAddress(true);
            mailRequest.setToAddress(email);
            mailRequest.setSubject("注册验证通知");
            mailRequest.setHtmlBody("尊敬的用户，您好！" + "<br>" + "请点击验证链接完成验证：" + link + "<br>");

            client.getAcsResponse(mailRequest);
        } catch (ClientException e) {
            e.printStackTrace();
        }


        return "redirect:home";
    }

    /**
     * @Description: 验证邮件
     * @Param: [request, response]
     * @return: java.lang.String
     * @Author: Mr.Lee
     * @Date: 2018\8\1 0001
     */
    @RequestMapping("emailVerification")
    @ResponseBody
    public Msg emailVerification(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /*接受URI参数，并分割验证*/
        String query = request.getQueryString();
        System.out.println(query);
        String[] strings = query.split("=");

        if (strings.length != 2) {
            System.out.println("验证错误");
            log.error("验证错误");
            return Msg.fail().add("验证错误","非法验证");
        }

        /*解析JWT，取出nameAndEmail*/
        String message;
        try {
            Map<String, Claim> map = JWTUtil.verifyToken(strings[1]);
            message = map.get("token").asString();
        } catch (Exception e) {
            System.out.println("token已经过期，请重新发送验证邮件！");
            log.error("token已经过期，请重新发送验证邮件！", e);
            return Msg.fail().add("验证错误" ,"token已经过期");
        }
        /*分割nameAndEmail*/
        System.out.println(message);
        String[] nameAndEmail = message.split(":");
        /*数据库查找是否存在该学员*/
        UserDTO userDTO = businessService.getByUsername(nameAndEmail[0]);


        /*判断用户名邮箱是否匹配*/
        if (! userDTO.getEmail().equals(nameAndEmail[1])){
            System.out.println("用户名和邮箱不匹配！");
            log.info("用户名和邮箱不匹配！");
            return Msg.fail().add("验证错误","用户名和邮箱不匹配");
        }

        userDTO.setEmailState(1);

        businessService.update(userDTO);

        return Msg.success().add("验证成功","请去个人信息查看");
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
    public String uploadPhoto( MultipartFile photo, String username){

        System.out.println(photo.getOriginalFilename());//本地文件名3-160309162601.jpg
        /*得到图片的类型*/
        String[] photoName = photo.getOriginalFilename().split("\\.");
        String photoType = photoName[photoName.length-1];
        /*图片存储路径*/
        String photoKey = "task7/"+username+"."+photoType;
        String bucketName = "willming";

            try {
                ossClient.putObject(bucketName, photoKey, new ByteArrayInputStream(photo.getBytes()));
            } catch (IOException e) {
                ossClient.shutdown();
            }


        /*将图片的地址更新到数据库*/
        UserDTO student = businessService.getByUsername(username);
        System.out.println(student);
        student.setPhoto(photoKey);
        System.out.println(student.getPhoto());
        if (businessService.update(student)){
            log.info("头像上传成功！");
            return "redirect:home";
        } else {
            log.error("头像上传失败！");
            return "error";
        }
    }

    @RequestMapping(value = "/infor",method = RequestMethod.GET)
    public String viePhoto(HttpServletRequest request, Model model){
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append("willming");
        sb.append(".");
        sb.append("oss-cn-shenzhen.aliyuncs.com");
        sb.append("/");


        Cookie cookie = CookieUtil.getCookieByName(request, "token");
        if (cookie == null){
            return "login";
        }
        System.out.println(cookie);
        String username = null;

        try {
            Map<String, Claim> map = JWTUtil.verifyToken(cookie.getValue());
            username = map.get("username").asString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(username);

        UserDTO student = businessService.getByUsername(username);


        sb.append(student.getPhoto());
        sb.append("?x-oss-process=image/resize,m_fill,w_100,h_100,limit_0/auto-orient,1/quality,q_90");
        model.addAttribute("uri", sb.toString());
        model.addAttribute("phone",student.getPhone());
        model.addAttribute("email",student.getEmail());
        model.addAttribute("username",student.getUsername());
        model.addAttribute("emailStatus",student.getEmailState());
        return "myInfo";
    }
}
