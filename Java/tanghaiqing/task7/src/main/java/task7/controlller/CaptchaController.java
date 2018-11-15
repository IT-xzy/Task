package task7.controlller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import task7.util.DysSmsUtil;
import task7.util.RedisUtil;
import task7.util.SendMailUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CaptchaController {
    private static Logger logger = Logger.getLogger(CaptchaController.class);
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    //手机验证码接口
    @RequestMapping(value = "/captcha")
    public void sendSms(@RequestParam("telephone") String telephone, HttpSession session) {
        logger.info("进入sendSms()");
        //调用短信工具发送验证码
        Integer i =(Integer) redisUtil.get(86+telephone);
        System.out.println(i);
        if (i==null){
            i=1;
        }
        boolean flag = false;
        if (i <= 3) {
            flag = DysSmsUtil.sendSms(telephone);
            i++;
        }
        if (flag) {
            logger.info("验证码发送成功！");
            //发送成功后绑定验证码到缓存里面，用于注册提交的时候判断验证码是否正确,设置有效期为200秒
            redisUtil.set(telephone, DysSmsUtil.number, 200);
            redisUtil.set(86+telephone,i,60*60*24);
        }
    }

    //验证码接口
    @RequestMapping(value = "/mailCaptcha")
    public void sendMail(@RequestParam("emailaccount") String emailaccount) {
        logger.info("进入sendMail();");
        logger.info(emailaccount);
        //调用邮件的工具类发送验证码
        SendMailUtil.sendMail(emailaccount);
        //发送成功后绑定验证码到缓存里面，用于注册提交的时候判断验证码是否正确,设置有效期为200秒
        redisUtil.set(emailaccount, SendMailUtil.number, 200);
    }
}
