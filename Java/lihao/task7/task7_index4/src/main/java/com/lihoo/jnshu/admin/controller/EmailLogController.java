package com.lihoo.jnshu.admin.controller;

import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.lihoo.jnshu.common.util.emailUtil.SendCommonPostMail;
import com.lihoo.jnshu.common.util.msgUtil.RonglianSendMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.lihoo.jnshu.common.util.encrypt.AddSalt.getSalt;
import static com.lihoo.jnshu.common.util.encrypt.MD5Utils.getPwdHash;

/**
 * #Title: EmailLogController
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/3-20:52
 */

@Controller
public class EmailLogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IStudentListService studentListService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     请求数据
     */
    @RequestMapping(value ="/email", method = RequestMethod.GET)
    public String getEmail() {
        logger.info("email GET 方法被调用……");
        return "email";
    }

    /**
     * 获取验证码
     */
    @RequestMapping("/iemail")
    public String getEmailCode(@RequestParam(value = "email", required = false) String email,
                               Model model) throws IOException {
        logger.info("你可以点击获取验证码按钮了");
        if (email != null) {
//            发送验证码到邮箱
            String code = RonglianSendMsgUtil.get4Code();
            SendCommonPostMail.sendEmailCode(email, code);

//            String emailCode = "1230";
            logger.info("四位数验证码：" + code);
////        把验证码放到redis中；
            assert code != null;
////        把验证码存到缓存中----(记得设置过期时间)
            stringRedisTemplate.opsForValue().set(email, code,5*60,TimeUnit.SECONDS);
            return "redirect:/email";
        } else {
            return "iemail";
        }
    }


    /**
     邮箱注册
     */
    @RequestMapping(value ="/email", method = RequestMethod.POST)
    public String emailRegist(@RequestParam(value = "email",required = false) String email,
                        @RequestParam(value = "verifyCode", required = false) String verifyCode,
                        @RequestParam(value = "password", required = false) String pwd) {
        logger.info("email POST 方法被调用……");

//        判断手机号
        if (email != "" && email != null) {
//            获取缓冲中的验证码
            String codeFromCache = stringRedisTemplate.opsForValue().get(email);
            logger.info("从Redis中取出的value验证码" + codeFromCache);
//            判断输入的验证码是否等于缓存中的验证码
            if (codeFromCache.equals(verifyCode)) {
                logger.info("验证码正确，可以注册");
                String salt = getSalt();
                String pwdHash = getPwdHash(pwd, salt);
//       创建Student对象
                StudentList emailUser = new StudentList();
                emailUser.setEmail(email);
                emailUser.setSalt(salt);
                emailUser.setPwd(pwdHash);
                emailUser.setLogAt(System.currentTimeMillis());
                emailUser.setExpireAt(System.currentTimeMillis());
                studentListService.save(emailUser);
                logger.info("打印注册的用户信息: " + "邮箱:"+email+"密码:"+pwd);
                logger.info("打印注册的用户信息: " + emailUser);
                return "redirect:/home";
            } else {
                logger.info("邮箱验证码出现问题");
                logger.info("验证码错误，请输入正确的验证码！");
            }
        }
        return "redirect:/iemail";
    }
}
