package com.mutesaid.bootdemo.controller;

import com.mutesaid.bootdemo.model.Response;
import com.mutesaid.bootdemo.model.Usr;
import com.mutesaid.bootdemo.service.UsrService;
import com.mutesaid.bootdemo.utils.CookieUtil;
import com.mutesaid.bootdemo.utils.EmailUtil;
import com.mutesaid.bootdemo.utils.JJWTUtil;
import com.mutesaid.bootdemo.utils.MsgUtil;
import io.jsonwebtoken.lang.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class SystemController {

    @Resource
    private UsrService usrService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 验证手机号
     */
    public static final String REGEX_PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    @PostMapping("/a/login")
    public Response login(HttpServletResponse response,
                          @RequestBody Usr usr) {
        log.info("login========" + usr);
        String name = usr.getName();
        String pwd = usr.getPwd();
        ArrayList<Usr> check = usrService.findByValue(name);
        if (Collections.isEmpty(check)) {
            return new Response<>(-1, "用户名不存在", name);
        }
        // 用户密码比对
        if (usrService.matchPwd(pwd, check.get(0))) {
            log.info("用户已登录 id = {}", check.get(0).getId());
            //将用户uid存入cookie
            String uid = JJWTUtil.sign(check.get(0).getId());
            Cookie cookie = new Cookie(CookieUtil.UID, uid);
            cookie.setPath("/");
            //过期时间一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            return new Response<>(0, "success", check.get(0).getId());
        }
        return new Response<>(-1, "密码错误", name);
    }

    @PostMapping("/a/u/logout")
    public Response loginOut(HttpServletRequest request, HttpServletResponse response) {
        Long uid = CookieUtil.getUid(request);
        log.info("登出 uid = {}", uid);

        CookieUtil.loginout(request, response);
        return new Response<>(0, "success", null);
    }

    @PostMapping("/a/sendMsg")
    public Response sendMsg(String phone){
        log.info("发送验证码 phone = {}", phone);
        if(!phone.matches(REGEX_PHONE)){
            log.info("手机号校验错误");
            return new Response<>(-1, "检验错误", phone);
        }
        try{
            Boolean result = MsgUtil.sendMsg(phone);
            if(result){
                return new Response<>(0, "success", phone);
            }else {
                log.info("验证码发送失败");
                return new Response<>(-1, "发送失败", phone);
            }
        }catch (IOException e){
            e.printStackTrace();
            log.info("验证码发送失败 msg = {}", e.getMessage());
            return new Response<>(-1, "发送失败", phone);
        }
    }

    @PostMapping("/a/sendEmail")
    public Response sendEmail(String email){
        log.info("验证邮箱 email = {}", email);
        if(!email.matches(REGEX_EMAIL)){
            log.info("邮箱校验错误");
            return new Response<>(-1, "校验错误", email);
        }
        try{
            Boolean result = EmailUtil.sendMsg(email);
            if(result){
                return new Response<>(0, "success", email);
            }else {
                log.info("邮件发送失败");
                return new Response<>(-1, "发送失败", email);
            }
        }catch (IOException e){
            e.printStackTrace();
            log.info("发送邮件失败");
            return new Response<>(-1, "发送失败", email);
        }
    }

    @PostMapping("/a/verifyPhone")
    public Response matchCode(String code, String phone){
        log.info("验证验证码 code = {}, phone = {}", code, phone);
        if(code == null){
            log.info("验证码为空 code = {}", code);
            return new Response<>(-1, "验证码为空", phone);
        }
        String check = redisTemplate.opsForValue().get(phone);
        if(check == null){
            log.info("号码无记录 phone = {}", phone);
            return new Response<>(-1, "号码无记录", phone);
        }
        if(!check.equals(code)){
            log.info("验证码不匹配 code = {}", code);
            return new Response<>(-1, "验证码不匹配", phone);
        }
        return new Response<>(0, "success", phone);
    }

    @GetMapping("/a/verifyEmail")
    public Response verify(String token){
        log.info("邮箱验证 token = {}", token);
        if(token == null){
            return new Response<>(-1, "令牌无效", token);
        }
        String check = redisTemplate.opsForValue().get(token);
        if(check==null){
            log.info("token无记录");
            return new Response<>(-1, "验证失败", token);
        }
        redisTemplate.opsForValue().set(check, "true");
        redisTemplate.expire(check, 10, TimeUnit.MINUTES);
        log.info("验证成功 email = {}", check);
        return new Response<>(0, "success", check);
    }
}
