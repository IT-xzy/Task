package com.controller;
/**
 * 重置密码控制器
 */
import com.pojo.Trainees;
import com.service.ServiceIF;
import com.tools.PRA;
import com.tools.RedisTool;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/reset")
public class Reset {
    //该控制器日志
    private static Logger logger=Logger.getLogger(Reset.class);
    //业务层接口
    @Resource
    private ServiceIF serviceIF;



    //重置密码主页面
    @RequestMapping(value = "/home")
    public String reset(){
        return "freset";
    }

    //查询账号是否存在
    @RequestMapping(value = "/account_check",method = RequestMethod.POST)
    public String accountCheck(Model model,
                               @RequestParam(value = "account" ,required = true)String account,
                               HttpServletResponse response, HttpServletRequest request){
        if(serviceIF.checkPwd(account)==null){
            model.addAttribute("a","该账号不存在，请重新选择");
            return "fError";
        }
        //有这个账号，用这个session保存对应的账号
        HttpSession session=request.getSession();
        session.setAttribute("account",account);
        return "fselectReset";
    }
    //选择验证方式
    @RequestMapping(value = "/way_verify")
    public String chooseVerify(
            @RequestParam(value = "mail",required = false)String mail
    ){
        //没有传一个mail的值，表明是短信验证
        if (mail==null){
            return "fmessage";
        }else {
            return "fmail";
        }
    }

    //邮箱验证
    @RequestMapping(value ="/mail_check",method = RequestMethod.POST)
    public String mailCheck
    (Model model,
            @RequestParam(value = "password",required = true)String password,
            @RequestParam(value = "account",required = true)String account,
            @RequestParam(value = "mail_check_core",required = true)String mail_check_core)
    {
        logger.info("com.controller.Reset.mailCheck的入参是：" +
                " password ="+password+"  ;"+"account ="+account+"  ;"+"mail_check_core ="+mail_check_core);
        String core= String.valueOf(RedisTool.rdGet(account));
        logger.info("com.controller.Reset.mailCheck的验证码是"+core);
        if (mail_check_core.equals(core)){
            //验证码正确
            serviceIF.updatePwd(password,account);
            model.addAttribute("o","密码重置成功");
            return "fUpdateSuccess";
        }else {
            model.addAttribute("o","验证码错误");
            return "fError";
        }

    }

    //获得邮箱验证码
    @RequestMapping(value ="/get_mail_core" ,method = RequestMethod.POST)
    public String mailString(@RequestParam(value = "mail",required = true)String mail,
                             HttpServletRequest request,Model model){
        logger.info("com.controller.Reset.mailString的传入的参数mail ="+mail );
        //获取该用户的账号
        HttpSession session=request.getSession();
        String account= (String) session.getAttribute("account");
        logger.info("保存在session中的账号是"+account);
        //获取该用户信息
        Trainees trainees=serviceIF.checkPwd(account);
        logger.info("这个用户的邮箱是 "+trainees.getEmail() );
        //判断该用户的邮箱是否正确
        if(mail.equals(trainees.getEmail())){
            serviceIF.getMailCore(mail, account);
            //判断是否超过请求上限
            if (PRA.prevent_R_Attack(mail)){
                model.addAttribute("o","超过今天获取邮箱验证码的次数");
                return "fError";
            }
            return "fmail";
        }else {
            model.addAttribute("o","邮箱错误");
            return "fError";
        }

    }

    //短信验证
    @RequestMapping(value = "/message_check",method = RequestMethod.POST)
    public String messageCheck(
            @RequestParam(value = "account",required = true)String account,
            @RequestParam(value = "password",required = true)String password,
            @RequestParam(value = "messageCore",required = true)String messageCode,
            Model model
    ){
        logger.info("com.controller.Reset.messageCheck的入参是" +
                "account = "+account+"  ; password = "+password+"  ; messageCode = "+messageCode);
        //获取缓存中的验证码
        String code= String.valueOf(RedisTool.rdGet(account));
        //比对验证码是否正确，正确则修改，错误则跳转错误
        if(code.equals(messageCode)){
            serviceIF.updatePwd(password,account);
            return "fUpdateSuccess";
        }else {
            model.addAttribute("o","验证码错误");
            return  "fError";
        }
    }

    //短信验证码
    @RequestMapping(value = "/get_message_core",method = RequestMethod.POST )
    public String messageNum(@RequestParam(value = "phoneNumber")String phoneNumber,
                             Model model,HttpServletRequest request){
        logger.info("com.controller.Reset.messageNum的入参数是 phoneNumber = "+phoneNumber);
        //获取用户的账号
        HttpSession session=request.getSession();
        String account= String.valueOf(session.getAttribute("account"));
        //通过账号获取学员信息
        Trainees trainees=serviceIF.checkPwd(account);
        //判断该手机是否为该学员的手机
        if (phoneNumber.equals(trainees.getPhoneNumber())){
            serviceIF.getMessageCore(phoneNumber,account);
            //是该学员的手机号码，判断是否超过请求上限；
            if(PRA.prevent_R_Attack(phoneNumber)){
                model.addAttribute("o","超过今天电话短信请求的次数，请明天再试");
                return "fError";
            }
            return "fmessage";
        }else {
            model.addAttribute("o","该手机号码有错误");
            return "fError";
        }
    }

}
