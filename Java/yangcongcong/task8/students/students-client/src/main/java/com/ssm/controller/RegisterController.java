package com.ssm.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ssm.model.UserRegister;
import com.ssm.service.UserRegisterService;
import com.ssm.utils.GetBeanAndRandomSelect;
import com.ssm.utils.MD5Util2;
import com.ssm.utils.SmsUtil;
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

import static com.ssm.utils.SmsUtil.sendSms;

@Controller
public class RegisterController {
    @Autowired
    private SmsUtil smsUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register/ppage", method = RequestMethod.GET)
    public String toRegister() {
        return "register_phone";
    }

    //注册用户，并返回登陆页面
    @RequestMapping(value = "/register/cellphone", method = RequestMethod.POST)
    public String toLand(UserRegister userRegister) {
        logger.info("/register/cellphone POST received username ：" + userRegister.getUsername());
        userRegister.setPassword(MD5Util2.md5Salt(userRegister.getPassword()));
        userRegister.setCreate_at(System.currentTimeMillis());
        userRegister.setUpdate_at(System.currentTimeMillis());

        //随机访问
        UserRegisterService userRegisterService =
                (UserRegisterService) GetBeanAndRandomSelect.randomSelect("myRMIClientC12","myRMIClientC22");

        userRegisterService.addUser(userRegister);
        return "redirect:/land";
    }

    //验证码
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public void verify(HttpServletRequest request) {
        logger.info("/verify GET phoneNum :"+request.getParameter("phoneNum"));
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        //获取页面手机号
        String phoneNum = request.getParameter("phoneNum");

        //产生6位随机数
        int verifyCode = (int) ((Math.random() * 9 + 1) * 100000);

        //格式化日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String cacheKey = formatter.format(new Date());

            //用户限流，每个手机号限5个/24小时
            if (vos.get(cacheKey+phoneNum) == null) {
                vos.set(cacheKey+phoneNum, "5", 24, TimeUnit.HOURS);
                //调用短信API,发送验证码
                SendSmsResponse smsResponse = sendSms(phoneNum, String.valueOf(verifyCode),smsUtil.getAk(),smsUtil.getSk());
                logger.info("短信是否发送成功（首次）：{}，手机号：{}，缓存值：{}", "OK".equals(smsResponse.getCode()), phoneNum,vos.get(phoneNum));

                if ("OK".equals(smsResponse.getCode())) {
                    //将验证码存入redis，过期时间五分钟
                    vos.set("codeCache" + phoneNum, String.valueOf(verifyCode), 60 * 5, TimeUnit.SECONDS);

                    //打印回执信息
                    SmsUtil.querySendDetails(smsResponse.getBizId(),phoneNum,smsUtil.getAk(),smsUtil.getSk());
                }
            } else {
                if (redisTemplate.boundValueOps(cacheKey+phoneNum).increment(-1) > 0) {
                    SendSmsResponse smsResponse = sendSms(phoneNum, String.valueOf(verifyCode),smsUtil.getAk(),smsUtil.getSk());
                    logger.info("（今日非首次）短信是否发送成功：{}，手机号：{}，缓存值：{}", "OK".equals(smsResponse.getCode()), phoneNum,vos.get(cacheKey+phoneNum));
                    if ("OK".equals(smsResponse.getCode())) {
                        //将验证码存入redis，过期时间五分钟
                        vos.set("codeCache" + phoneNum, String.valueOf(verifyCode), 60 * 5, TimeUnit.SECONDS);

                        SmsUtil.querySendDetails(smsResponse.getBizId(),phoneNum,smsUtil.getAk(),smsUtil.getSk());
                    }
                }
            }
        } catch (ClientException e) {
            logger.info("ClientException:"+e);
            e.printStackTrace();
        }
    }
}
