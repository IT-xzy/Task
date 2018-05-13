package controller;

import com.qiniu.util.Json;
import dao.UserMapper;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import pojo.User;
import service.UserService;
import utils.Ossutils;
import utils.VerificationCode;
import utils.json.JsonResult;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    Ossutils ossutils;

    private Logger logger = LoggerFactory.getLogger(Ossutils.class);

    @RequestMapping(value = "/phonecode", method = RequestMethod.GET)
    public @ResponseBody JsonResult phonecode(HttpSession httpSession, User user) {
        return userService.phonecode(httpSession, user);
    }

    @RequestMapping(value = "/phoneregister",method = RequestMethod.POST)
    public @ResponseBody JsonResult phoneregister(HttpSession httpSession,User user, @RequestParam("phonecode") String phonecode,HttpServletRequest httpServletRequest){
        return userService.testphonecode(httpSession,phonecode,user,httpServletRequest);
    }

    @RequestMapping(value = "/emailcode",method = RequestMethod.GET)
    public @ResponseBody JsonResult emailcode(HttpSession httpSession,User user){
        return userService.emailcode(httpSession,user);
    }

    @RequestMapping(value = "/emailregister",method = RequestMethod.POST)
    public @ResponseBody JsonResult emailregister(HttpSession httpSession,User user,@RequestParam("emailcode")String emailcode,@RequestParam("signcode") String signcode){
        return userService.testemailcode(httpSession,emailcode,user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody JsonResult register(HttpSession httpSession,User user,@RequestParam("signcode")String signcode){
        return userService.testcommon(user,signcode,httpSession);
    }

    @RequestMapping(value = "/phonelogin",method = RequestMethod.POST)
    public @ResponseBody JsonResult phonelogin(User user,@RequestParam("phonecode") String phonecode,HttpSession httpSession){
        return userService.phonelogin(user,phonecode,httpSession);
    }

    @RequestMapping(value = "/emaillogin",method = RequestMethod.POST)
    public @ResponseBody JsonResult emaillogin(User user,@RequestParam("emailcode") String emailcode,HttpSession httpSession,@RequestParam("signcode") String signcode){
        return userService.emaillogin(user,emailcode,httpSession,signcode);
    }

    @RequestMapping(value = "/commonlogin",method = RequestMethod.POST)
    public @ResponseBody JsonResult commonlogin(User user,@RequestParam("signcode") String signcode,HttpSession httpSession){
        return userService.commonlogin(user,signcode,httpSession);
    }

    @RequestMapping(value = "/u",method = RequestMethod.GET)
    public String profile(Integer id,HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest) {
        User user = userMapper.selectbyid(id);
        //取出url放进image filed里面传回前端
        user.setImage(ossutils.getCutUrl(user.getImage()));
        httpServletRequest.setAttribute("user", user);
        return "profile";

    }

    @RequestMapping(value = "/u/test",method = RequestMethod.GET)
    public String utest(HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest) {
        return "utest";
    }

    //就一个修改头像功能，修改密码都没有~~，更新头像之后还没删掉之前那个
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public JsonResult update(@RequestParam User user, HttpServletRequest httpServletRequest) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        String fileName =  multipartHttpServletRequest.getFile("photo").getOriginalFilename();
        String[] filename = fileName.split("\\.");
        String fileName1 = user.getName()+"headimage"+System.currentTimeMillis()+"."+filename[filename.length-1];
        if (ossutils.uploadimage(multipartHttpServletRequest.getFile("photo"),user,fileName1)){
            return new JsonResult(0,"头像修改成功",null);
        }
        else return new JsonResult(-1,"图片上传失败",null);
    }

    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public String loginout(){
        Subject subject = SecurityUtils.getSubject();
        //session里面东西取不到但是可以登出，有毒吧
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            if (logger.isDebugEnabled()) {
                logger.debug("用户"+"退出登录");
            }
        }
        return "home";
    }

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String admin() {return "admin";}

    @RequestMapping(value = "/signcode", method = RequestMethod.GET)
    public void service(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws ServletException, IOException {
        VerificationCode verificationCode = new VerificationCode();
        //获取验证码图片
        BufferedImage bufferedImage = verificationCode.getImage();
        //获取验证码内容
        String text = verificationCode.getText();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("signcode", randomCode.toString());
        System.out.println("session-signcode" + randomCode.toString());
        // 禁止图像缓存
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        // 将图像输出到Servlet输出流中
        ImageIO.write(bufferedImage, "jpeg", servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
    }
}
