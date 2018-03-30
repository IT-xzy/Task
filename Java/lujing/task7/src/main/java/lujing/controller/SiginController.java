package lujing.controller;

import io.jsonwebtoken.Jwts;
import lujing.Constant;
import lujing.mapper.UserMapper;
import lujing.pojo.User;
import lujing.security.JwtUtils;
import lujing.security.SaltGenerate;
import lujing.serviceimpl.UserServiceImpl;
import lujing.util.SMSUtil;
import lujing.util.SendCloudAPIV2_44;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lujing
 * Create_at 2018/1/19 14:23
 */
@Controller
public class SiginController {
    
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserMapper userMapper;
    
    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping("/siginjsp")
    public String siginJsp() {
        
        return "siginjsp";
    }
    
    /**
     * 发送手机验证码接口
     *
     * @param session
     * @param
     * @return 响应：1代表手机号已被注册。0：发送成功。其他，发送失败
     * 2代表用户名已被注册
     */
    
    @RequestMapping("/phonecode")
    public @ResponseBody
    int phoneCode(HttpSession session, User record) {
        
        /**判断是否已注册.findUserCustom返回值：
         1代表手机号已被注册，0代表可以注册,2代表用户名已被注册,3代表邮箱已被注册。
         */
        
        int a = userServiceImpl.findUserCustom(record);
        
        String phoneCode = SaltGenerate.random(6);
        
        if (a == 0) {
            Integer res = SMSUtil.sendSMS(phoneCode, record.getPhoneNum());
            if (res == 0) {
                //将注册信息同时存入session
                session.setAttribute("phoneCode", phoneCode);
                session.setAttribute("phoneNum",record.getPhoneNum());
                session.setAttribute("name",record.getName());
                
                return 0;
            } else {
                return res;
            }
        }
        return a;
    }
    
    /**
     * 校验邮件注册时用户名与邮箱状态
     *
     * @return 0：可以注册，2：用户名已被注册,3：邮箱已被注册。
     */
    @RequestMapping("/checkNameAndEmail")
    public @ResponseBody
    int checkNameAndEmail(User userRecord) {
        
        int a = userServiceImpl.findUserCustom(userRecord);
        
        return a;
    }
    
    /**
     * 验证码校验
     *
     * @param name    输入的手机验证码
     * @param session 保存、获取验证码
     * @return
     */
    @RequestMapping("/checkCode")
    public @ResponseBody
    int checkCode(String name, String phoneCode,String phoneNum, HttpSession session) {
        
        if (null != phoneCode & "" != phoneCode) {
            String code = (String) session.getAttribute("phoneCode");
            String cphoneNum = (String) session.getAttribute("phoneNum");
            String chname = (String) session.getAttribute("name");
//            String code = "1234";
            if (phoneCode.equals(code)&&name.equals(chname)&&phoneNum.equals(cphoneNum)) {
                return 1;
            }
            return 0;
        }
        return 0;
    }
    
    
    /**
     * @param record   页面回传的数据
     * @param password 输入的密码
     * @return
     */
    @RequestMapping("/sigwithphone")
    public String sigwithphone(User record, String password,Model model) {
        String result = userServiceImpl.siginUser(record, password);
        if (result == Constant.signSuccess) {
            model.addAttribute("message",result);
            return "/login/sigSuccess";
        }
        return null;
    }
    
    /**
     * 邮箱注册，并发送激活链接
     * @param request
     * @param record
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/sigwithemail")
    public String sigwithemail(HttpServletRequest request, User record, String password, Model model) {
        //设置未激活状态
        record.setEmailStatus(0);
        //发送激活连接
        int sendStautus = userServiceImpl.sendActiveEmail(record.getEmail(), record.getName(), request, 1000 * 60*15l);
        if (sendStautus == 0) {
            String result = userServiceImpl.siginUser(record, password);
            
            if (result == Constant.signSuccess) {
                model.addAttribute("message", "注册成功，快进入你的邮箱然后点击激活吧");
                return "/login/sigSuccess";
            }
        }
        model.addAttribute("message", "注册失败……");
        return "/login/sigSuccess";
    }
    
    
    /**
     * 邮箱激活链接
     *
     * @param name
     * @param token
     * @param model
     * @return
     */
    @RequestMapping("/activeEmail")
    public String activeEmail(HttpServletRequest request, String name, String token, Model model) {
        
        try {
            String sub = Jwts.parser().setSigningKey(Constant.siginKey).parseClaimsJws(token).getBody().getSubject();
            if (name.equals(sub)) {
                User update = new User();
                update.setEmailStatus(1);
                update.setName(name);
                userMapper.UpdateByNameSelective(update);
                
                model.addAttribute("message", "恭喜您，激活成功啦，");
                return "login/sigSuccess";
            }
        } catch (Exception e) {
            User act = new User();
            act.setName(name);
            User active = userMapper.findUserCustom(act);
            if (null != active) {
                
                int sendStautus = userServiceImpl.sendActiveEmail(active.getEmail(), name, request, 1000 * 60 * 60l);
                if(sendStautus == 0){
                    model.addAttribute("message", "过期不候哦哦哦,看看有木有新的激活邮件");
                    return "login/sigSuccess";
                } else {
                    model.addAttribute("message", "运气不好没法送成功"+sendStautus);
                    return "login/sigSuccess";
                 }
               
            }
            
        }
        
        
        return "";
    }
}
