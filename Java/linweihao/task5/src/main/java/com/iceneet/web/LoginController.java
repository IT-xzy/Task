package com.iceneet.web;

import com.github.qcloudsms.httpclient.HTTPException;
import com.iceneet.entity.User;
import com.iceneet.service.Userservice;
import com.iceneet.untils.*;
import com.qcloud.cos.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationEvent;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class LoginController {

    @Autowired
    private qcloudcos qcloudcos;

    @Autowired
    private qiniuUtils qiniuUtils;

    @Autowired
    private qcloudmail qcloudmail;

    @Autowired
    private qcloudsms qcloudsms;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Userservice userservice;

    private boolean Osssign = true;

    //登录路由
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    public String loginCheck(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        User loginUser = new User();
        loginUser.setUser(user);
        //获取是否有该用户名
        User matchUser = userservice.userMatch(loginUser);
        if (matchUser!= null) {
            //有的话验证
            if (MD5Untils.verify(password, matchUser.getPassword(),matchUser.getSalt())) {
                Long timestamp = System.currentTimeMillis();
                String token = DESUtil.encode(timestamp.toString()+"$"+user);
                CookiesUntil.addCookie(response,"token",token,7*60*60*24,"/");
                System.out.println("验证成功");
                return "redirect:/test";
            } else {
                map.addAttribute("msg", "密码或者用户名错误");
                System.out.println("密码或者用户名错误");
                return "Error";
            }
        } else {
            System.out.println("密码或者用户名错误");
            map.addAttribute("msg", "密码或者用户名错误");
            return "Error";
        }
    }

    @RequestMapping(value = "/registercheck" ,method = RequestMethod.POST)
    @ResponseBody
    public String registercheck(@RequestParam("fileName") MultipartFile file,ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String vaildCode = request.getParameter("vaidcode");
        User registerUser = new User();
        registerUser.setUser(user);
        User matchUser = userservice.userMatch(registerUser);
        if (VaildCode.vaild(phone,email,vaildCode)==true){
            if (matchUser != null) {
                modelMap.addAttribute("msg", "该用户名已存在");
                return "Error";
            } else {
                registerUser.setUser(user);
                String salt = MD5Untils.createUUID();
                registerUser.setPassword(MD5Untils.generate(password, salt));
                registerUser.setSalt(salt);
                if (!file.isEmpty()) {
                    String filetype = file.getContentType();
                    if (FileUpload.isimage(filetype)) {
                        String filename = FileUpload.randomName(filetype);
                        InputStream inputStream = file.getInputStream();
                        ObjectMetadata meta = new ObjectMetadata();
                        meta.setContentLength(file.getSize());
                        TransferContext TransferContext = new TransferContext(Osssign);
                        TransferContext.UploadStream(filename, inputStream,meta);
                        registerUser.setImage(filename);
                        registerUser.setEmail(email);
                        registerUser.setPhone(phone);
                        int change = userservice.insertSelective(registerUser);
                        redisTemplate.delete(phone);
                        redisTemplate.delete(email);
                        return "注册成功";
                    } else {
                        return "文件不是图片类型";
                    }
                } else {
                    return "上传文件为空";
                }
            }
        }else {
            return "验证码错误";
        }
    }
    @RequestMapping(value = "/emailcode",method = RequestMethod.GET)
    @ResponseBody
    public String emailcode(String emailaddress,HttpServletRequest request,HttpServletResponse response) throws MessagingException {
        if (AccountValidatorUtil.isEmail(emailaddress)){
            String result = qcloudmail.send(emailaddress);
            return result;
        }else {
            return "邮箱不符合规范";
        }
    }
    @RequestMapping(value = "/phonecode",method = RequestMethod.GET)
    @ResponseBody
    public String phonecode(String phone,HttpServletRequest request,HttpServletResponse response) throws MessagingException, HTTPException, IOException {
        if (AccountValidatorUtil.isMobile(phone)){
            qcloudsms.SendMsg(phone);
            return "success";
        }else {
            return "手机不符合规范";
        }
    }


    //注销
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response,ModelMap map){
        CookiesUntil.removeCookie(response,"token");
        System.out.println(request.getRequestURI());
        return "redirect:/test";
    }

    @RequestMapping(value = "/showdetail",method = RequestMethod.GET)
    public String showdetail(HttpServletRequest request,HttpServletResponse response,ModelMap map){
        String token = CookiesUntil.getUid(request,"token");
        if (token!=null){
            String detoken = DESUtil.decode(token);
            String username = detoken.split("\\$")[0];
            User user = userservice.selectByName(username);
            TransferContext transferContext = new TransferContext(Osssign);
            System.out.println("image："+user.getImage());
            map.addAttribute("userinfo",user);
            return "showdetail";
        }else {
            return "Error";
        }
    }

}
