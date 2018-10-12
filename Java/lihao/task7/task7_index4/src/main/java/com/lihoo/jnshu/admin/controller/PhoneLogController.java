package com.lihoo.jnshu.admin.controller;

import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.admin.service.IStudentListService;
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


import java.util.concurrent.TimeUnit;

import static com.lihoo.jnshu.common.util.encrypt.AddSalt.getSalt;
import static com.lihoo.jnshu.common.util.encrypt.MD5Utils.getPwdHash;

/**
 * #Title: PhoneLogController
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/3-10:26
 */

@Controller
public class PhoneLogController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IStudentListService studentListService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     请求数据
     */
    @RequestMapping(value ="/phone", method = RequestMethod.GET)
    public String getPhone() {
        logger.info("phone GET 方法被调用……");
        return "phone";
    }

    /**
     * 获取验证码
     */
    @RequestMapping("/iphone")
    public String getPhoneCode(@RequestParam(value = "phone", required = false) String phone,
                               Model model) {
        logger.info("你可以点击获取验证码按钮了");
        if (phone != null) {
//            发送验证码到手机
            String phoneCode = RonglianSendMsgUtil.sendVerifyCode(phone);
//        String phoneCode = "1230";
            logger.info("四位数验证码：" + phoneCode);
////        把验证码放到redis中；
            assert phoneCode != null;
////        把验证码存到缓存中----(记得设置过期时间)
            stringRedisTemplate.opsForValue().set(phone, phoneCode,5*60,TimeUnit.SECONDS);
            return "redirect:/phone";
        } else {
            return "iphone";
        }
    }

    /**
     *手机注册
     */
    @RequestMapping(value = "/phone",method = RequestMethod.POST)
    public String phoneRegist(@RequestParam(value = "phone", required = false) String phone,
                              @RequestParam(value = "verifyCode", required = false) String verifyCode,
                              @RequestParam(value = "password",required = false) String pwd) {
        logger.info("phone POST 方法被调用……");

//        判断手机号
        if (phone != "" && phone != null) {
//            获取缓冲中的验证码
            String codeFromCache = stringRedisTemplate.opsForValue().get(phone);
            logger.info("从Redis中取出的value验证码" + codeFromCache);
//            判断输入的验证码是否等于缓存中的验证码
            if (codeFromCache.equals(verifyCode)) {
                logger.info("验证码正确，可以注册");
                String salt = getSalt();
                String pwdHash = getPwdHash(pwd, salt);
//       创建Student对象
                StudentList phoneUser = new StudentList();
                phoneUser.setPhone(phone);
                phoneUser.setSalt(salt);
                phoneUser.setPwd(pwdHash);
                phoneUser.setLogAt(System.currentTimeMillis());
                phoneUser.setExpireAt(System.currentTimeMillis());
                studentListService.save(phoneUser);
                logger.info("打印注册的用户信息: " + "手机号:"+phone+"密码:"+pwd);
                logger.info("打印注册的用户信息: " + phoneUser);
                return "redirect:/home";
            } else {
                logger.info("手机验证码出现问题");
                logger.info("验证码错误，请输入正确的验证码！");
            }
        }
        return "redirect:/iphone";
    }
}
