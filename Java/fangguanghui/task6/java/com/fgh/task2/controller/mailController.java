package com.fgh.task2.controller;

import com.fgh.task2.Utils.buildRandom;
import com.fgh.task2.Utils.cache.RedisUtils;
import com.fgh.task2.Utils.mailSendCloud;
import com.fgh.task2.model.LoginUser;
import com.fgh.task2.service.login.LoginService;
import com.fgh.task2.tool.UrlParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class mailController {
    @Autowired
    mailSendCloud mailSC;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    LoginService loginService;
    @Autowired
    LoginUser loginUser;
    @Autowired
    UrlParam urlParam;

    Logger logger=LoggerFactory.getLogger(mailController.class);

    @RequestMapping(path = "/mail/{id}")
    public String sms(Model model, @PathVariable int id) throws Exception {
        logger.debug("登录用户id: "+id);
        LoginUser loginUser = loginService.quaryById(id);
        model.addAttribute("userMail",loginUser);
//        try {
//            loginService.updateLogin(loginUser);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return "mailTest";
    }

    /**
     * 发送邮箱验证链接
     * @param request
     *          请求链接
     * @param name
     *          邮箱
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/sendMail",method = RequestMethod.POST)
    public boolean sendMail(HttpServletRequest request ,
                            @RequestParam String name,@RequestParam int id){
        logger.info("绑定邮箱: "+name);
        logger.info("登录id: "+id);
        logger.info("服务器ip: "+ request.getServerName());
        //获取路径
        String realURL=String.valueOf(request.getRequestURL());
        logger.info("邮箱绑定页面URL :"+realURL);
        //过滤字符串，将/sendMail从链接中取出，方便邮箱校验
        String requestURL=realURL.split("/sendMail")[0];
        logger.info("requestURL"+ requestURL);
        String code =buildRandom.Random(8);
        //将验证码和id绑定，验证通过验证码寻找id
        loginUser.setId(id);
        loginUser.setMailcode(code);
        loginService.updateLogin(loginUser);
        //发送邮件
        return mailSC.send_common(name,code, requestURL);
    }

    /**
     * 邮箱校验部分（通过 RequestMapping 截取用户点击验证链接）
     * @param request
     *          请求链接
     * @param verifyCode
     *          验证码
     * @return
     */
    @RequestMapping(path = "/mailVerify/{verifyCode}",method = RequestMethod.GET)
    public String mailVerify(HttpServletRequest request, @PathVariable String verifyCode){
        String mailUrl=String.valueOf(request.getRequestURL());
        logger.info("邮箱中的验证链接?："+mailUrl);
        logger.info("随机验证码："+verifyCode);
        String mail=(String)redisUtils.getkey(verifyCode);
        logger.info("用户邮箱："+mail);
        if (mail!=null) {
            //获取需绑定邮箱的id,绑定邮箱
            LoginUser logUser= loginService.quaryByCode(verifyCode);
            int logUserId= logUser.getId();
            logUser.setId(logUserId);
            logUser.setMailstatus(1);
            logUser.setEmail(mail);
            loginService.updateLogin(logUser);
            //验证成功删除缓存
            redisUtils.delKey(verifyCode);
            return "redirect:/OSS/"+logUserId;
        }else
            return "error";
    }
}
