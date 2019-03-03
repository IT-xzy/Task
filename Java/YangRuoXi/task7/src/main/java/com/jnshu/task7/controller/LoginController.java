package com.jnshu.task7.controller;

import com.jnshu.task7.beans.Login;
import com.jnshu.task7.beans.Response;
import com.jnshu.task7.service.LoginService;
import com.jnshu.task7.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class LoginController {

//    private static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @Autowired
    private SendMailUtil sendMailUtil;

    /**
     *  去往注册页面功能
     * @return registration.jsp页面
     *
     */
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String toRegistrationPage(){
        return "registration";
    }

    /**
     *  注册功能
     * @return 注册成功返回0,失败返回-1;
     *
     */
    @ResponseBody
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public Response registration(Login login, String loginName, String pwd , String phone, String email, String phoneCode){
        log.info("add user =" + loginName +  " phone = " + phone + "  phoneCode = " + phoneCode);
        //判断是否为空
        if (loginName == null || pwd == null){
            return new Response(-1,"用户名或密码不能为空",null);
        }
        //判断用户名是否重复
        Login isLogin = loginService.selectLoginByName(loginName);
        if (isLogin != null ){
            log.info("用户名重复 = "+ loginName);
            return new Response(-1 ,"用户名不可以重复",null);
        }
        //判断jedis中是否有验证码;
        JedisPool pool = new JedisPool("localhost",6379);
        Jedis jedis = pool.getResource();
        boolean isPhoneCode = jedis.exists(phone);
        if (isPhoneCode == false){
            log.info("没有验证码或验证码失效,手机号是 =" + phone);
            return new Response<>(-1,"验证码失效",null);
        }
        String phoneCodeInRedis = jedis.get(phone);
//        if (phoneCode != phoneCodeInRedis){
        if (!phoneCode.equals(phoneCodeInRedis)){
            log.info("验证码错误 手机号为 " + phone);
            log.info("输入验证码为:" + phoneCode);
            return new Response(-1,"验证码错误或过期",null);
        }

        //添加用户名
        login.setLoginName(loginName);
        //加密密码
        login.setPwd(Md5Util.digest(pwd));
        //添加手机
        login.setPhone(phone);
        Boolean successLogin =loginService.addLoginAndPwd(login);
        if (!successLogin){
            return new Response(-1,"添加失败",login);
        }
        Long newId = loginService.selectLoginByName(loginName).getId();
        log.info("new login id = " + newId);
        return new Response(0,"success", newId);
    }



    /**
     * 实现登陆功能
     * @param request request域,
     * @param model model对象
     * @param value 用户输入的用户名,手机号 或邮箱
     * @param pwd 用户输入的密码
     * @return 登陆成功,进入到职业页面
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response doLogin(HttpServletRequest request, Model model, String value, String pwd){
        //登陆:
        log.info("登陆名 :" + value );
        if (value == null || value.length() == 0 ||
                pwd == null || pwd.length() == 0){
            return new Response (-1,"用户名或密码不能为空",null);
        }
        Long userId = loginService.selectPwdByNameOrPhoneOrEmail(value);
        //判断是否有用户
        if (userId == null ){
            log.info("用户不存在 = " + value);
            return new Response<>(-1,"用户不存在",null);
        }

        //验证用户名和密码
        Login login = loginService.selectLoginById(userId);
        log.info("用户id = " + userId);
        String loginPwd = Md5Util.digest(pwd);
        log.info("用户输入加密后的密码"+ loginPwd);
        String pwdInDb = login.getPwd();
        if (loginPwd.equals(pwdInDb)){
            request.getSession().setAttribute("loginName",value);
            log.info("登陆名为 =  " + value);
            return new Response(0,"success",userId);
        } else {
            model.addAttribute("message","登陆失败");
            log.info("登陆失败,密码错误,登陆名为"  + value );
            return new Response(-1,"用户名或密码错误",null);
        }
    }


    @RequestMapping(value = "/loginout" )
    public String loginout(HttpSession session){
        session.removeAttribute("isLogin");
        session.removeAttribute("loginName");
        session.invalidate();
        return "redirect:/home";
    }



    @ResponseBody
    @RequestMapping(value = "/PhoneCode" ,method = RequestMethod.POST)
    public Response sendPhoneCode(String phone){
        log.info("发送验证码手机号为 = " + phone);
        String phoneCode = PhoneCodeUtil.createRandomVcode();
        try {
            PhoneCodeUtil.sendPhoneCode(phone,phoneCode);
            log.info("phone = " + phone);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("验证码发送错误 =" + e);
        }
        //存储在redis中 设置5分钟;
        JedisPool jedisPool = new JedisPool("localhost",6379);
        Jedis jedis = jedisPool.getResource();
        //判断是否存在,存在则将以前验证码删除;
        Boolean phoneCdoeInRedis = jedis.exists(phone);
        if (phoneCdoeInRedis == true){
            jedis.del(phone);
        }
        log.info("phoneCode = " + phoneCode);
        jedis.setex(phone,5 * 60,phoneCode);
        return new Response(0,"success",phoneCode);

    }


    @ResponseBody
    @RequestMapping(value = "/email",method = RequestMethod.POST)
    public Response sendEmail(String email){
        log.info("邮件发送 : 邮箱为 = " + email );
        Login login = loginService.selectLoginByEmail(email);
        //验证邮箱是否正确
        if (login == null) {
            log.info("未找到对应邮箱 = " + login);
            return new Response(-1 , "未找到对应邮箱",null);
        }

        //设置token信息
        String loginName = login.getLoginName();
        Long loginId = login.getId();
        String key = loginName + loginId.toString();
        String sale = email;
        Map tokenMap = new HashMap(16);
        tokenMap.put("name",loginName);

        String token = JwtUtil.encode(key,tokenMap,sale);
        log.info("邮箱验证token = " + token);
        //发送邮件;
        try {
            sendMailUtil.sendCommon(email,token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //存储在redis中 时间为半小时;
        JedisPool jedisPool = new JedisPool("localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.setex(token,30 * 60, token);
        log.info("邮件发送成功");
        return new Response(0,"success",null);

    }

    @ResponseBody
    @RequestMapping(value = "/emailVerification",method = RequestMethod.GET)
    public Response checkEmail(String token){
        log.info("验证邮箱 = " + token);
        JedisPool jedisPool = new JedisPool("localhost",6379);
        Jedis jedis = jedisPool.getResource();

        //redis中是否有邮件对应的token
        Boolean success = jedis.exists(token);
        if ( !success) {
            log.info("token 过期 = " + token);
            return new Response(-1 , "邮件token过期",null);
        }
        String tokenInRedis = jedis.get(token);

        //验证token是否相同;
        if(!tokenInRedis.equals(token)){
            log.info("token 验证失败 , 输入token为 :" + token + " redis 中为 =" + tokenInRedis);
            return new Response(-1, "token验证失败", null);
        }
        log.info("邮箱验证成功");
        return new Response(0, "success",null);

    }




    @ResponseBody
    @RequestMapping(value = "/picture",method = RequestMethod.POST)
    public Response uploadPicture(MultipartFile file){
        log.info("上传图片..");
        //判空, 判零
        if (file.isEmpty() || file.getSize() == 0){
            return new Response(-1,"上传文件为空",null);
        }

        //上传文件
        try {
            //上传文件功能实现
            String picNameInALi = AliyunOSSClientUtil.uploadImg2Oss(file);
            //获取文件在服务器上的路径
            log.info("图片名称为:" + picNameInALi);
            //将路径进行裁剪;
            String[] split = picNameInALi.split("\\?");
            //返回相关数据
            return new Response(0, "success",split[0]);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("上传文件失败" + e);
            return new Response(-1,"上传文件失败", null);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/picture2" ,method = RequestMethod.POST)
    public Response uploadPicture2(MultipartFile file){
        //判空
        if (file.isEmpty()){
            return new Response(-1, "文件为空",null);
        }
        //上传文件
        try {
            //具体实现,返回图片路径
            String url = TengXunCosClientUtil.upload(file);
            System.out.println("文件路径为: " + url);
            return new Response (0,"上传文件成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("上传图片失败 图片是: " + file );
            return new Response(-1,"上传图片失败",null);
        }
    }







}