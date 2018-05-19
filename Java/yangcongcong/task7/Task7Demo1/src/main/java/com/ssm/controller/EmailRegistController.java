package com.ssm.controller;

import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.ssm.model.UserEmailReg;
import com.ssm.service.UserEmailRegService;
import com.ssm.utils.MD5Util2;
import com.ssm.utils.SendEmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Controller
public class EmailRegistController {

    private final Logger logger = LoggerFactory.getLogger(EmailRegistController.class);

    @Autowired
    private UserEmailRegService userEmailRegService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SendEmailUtil sendEmailUtil;

    //注册页面
    @RequestMapping(value = "/register/epage", method = RequestMethod.GET)
    public String toEmail() {
        return "register_email";
    }

    //注册用户
    @RequestMapping(value = "/register/email", method = RequestMethod.POST)
    public String register(UserEmailReg userEmailReg) {
        logger.info("/register/epage GET received e_name:" + userEmailReg.getE_name());
        userEmailReg.setE_password(MD5Util2.md5Salt(userEmailReg.getE_password()));
        userEmailReg.setCreate_at(System.currentTimeMillis());
        userEmailReg.setUpdate_at(System.currentTimeMillis());
        userEmailRegService.addUserEmail(userEmailReg);
        return "redirect:/land";
    }

    //验证邮箱
    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public void verifyEmail(HttpServletRequest request) {
        logger.info("/verifyEmail  GET  e_email address:" + request.getParameter("e_email"));
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        //获取页面邮箱
        String e_email = request.getParameter("e_email");

        //产生6位随机数
        int emailCode = (int) ((Math.random() * 9 + 1) * 100000);

        //格式化日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String cacheKey = formatter.format(new Date());

            //调用邮件推送API
            if (vos.get(cacheKey+e_email) == null) {
                //对每个邮箱限流，5个/24小时
                vos.set(cacheKey+e_email, "5", 24, TimeUnit.HOURS);
                //调用api
                SingleSendMailResponse mailResponse = SendEmailUtil.send(e_email, String.valueOf(emailCode),sendEmailUtil.getAk(),sendEmailUtil.getSk());
                logger.info("RequestId : " + mailResponse.getRequestId());

                //邮箱验证码存入redis，5分钟
                vos.set("emailCode" + e_email, String.valueOf(emailCode), 5 * 60, TimeUnit.SECONDS);
                logger.info("emilCode+e_email:"+vos.get("emailCode"+e_email));
            } else {
                if (redisTemplate.boundValueOps(cacheKey+e_email).increment(-1) > 0) {
                    logger.info("e_email:{} , cache:{} ", e_email, vos.get(cacheKey+e_email));

                    SingleSendMailResponse mailResponse = SendEmailUtil.send(e_email, String.valueOf(emailCode),sendEmailUtil.getAk(),sendEmailUtil.getSk());
                    logger.info("RequestId : " + mailResponse.getRequestId());

                    vos.set("emailCode" + e_email, String.valueOf(emailCode), 60 * 5, TimeUnit.SECONDS);
                    logger.info("emilCode+e_email:"+vos.get("emailCode"+e_email));
                }
            }
        } catch (Exception e) {
            logger.info("Exception:"+e);
            e.printStackTrace();
        }
    }
}
