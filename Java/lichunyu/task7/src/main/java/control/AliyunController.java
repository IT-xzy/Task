package control;

import com.aliyuncs.exceptions.ClientException;
import exception.LoginException;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserService;
import service.impl.EmailService;
import service.impl.OssService;
import service.impl.SmsService;
import utils.CookieUtil;
import utils.JwtUtil;
import utils.XmemcachedManager;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 短信发送验证码
 * 邮箱发送验证码
 * 上传图片
 */
@Controller
@RequestMapping
public class AliyunController {

    @Autowired
    SmsService smsService;
    @Autowired
    EmailService emailService;
    @Autowired
    OssService ossService;
    @Autowired
    UserService userService;
    @Autowired
    XmemcachedManager xmemcachedManager;


    private static final String PHONE = "^1[3|5|7|8][0-9]{9}$"; //必须1开头的电话号码
    private static final String E_MAIL = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$"; //邮箱格式的正则表达式，格式必须为example@example.com
    private static final String CHECK_CODE = "^@+[./+%]*[3-8]*[a-gH-N]*+#$";//校验码,@开头，#结尾
    private Logger log = Logger.getLogger(AliyunController.class);

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public ModelAndView sendSms() {
        return new ModelAndView("code");
    }

    /**
     * 发送短信验证码
     * @param phoneNum 从页面获取手机号码
     * @return mav
     */
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public ModelAndView sendSmsCode(@RequestParam("phoneNum") String phoneNum,@RequestParam("checkcode") String checkcode, HttpServletResponse response) throws LoginException {
        ModelAndView modelAndView = new ModelAndView();
        //生成6位数字验证码
        String code ;
        //短信发送验证码
        if (!checkcode.matches(CHECK_CODE) || checkcode.length()<8){
            throw new LoginException("注册邀请码不正确，请输入正确的邀请码");
        }else if (phoneNum.matches(PHONE)) {
            code = String.valueOf(new Random().nextInt(899999) + 100000);
            log.info("sms,发送短信生成随机验证码：" + code);
            try {
                smsService.sendSms(phoneNum, code);
            } catch (ClientException e) {
                log.info("sms,短信验证码发送异常:" + e.getMessage());
                e.printStackTrace();
            }

            //将代码放入缓存
            try {
                xmemcachedManager.set("code", code);
            } catch (InterruptedException | MemcachedException | TimeoutException e) {
                log.info("email,存入缓存异常：" + e.getMessage());
                e.printStackTrace();
            }

        } else {
            throw new LoginException("请输入有效的手机号码");
        }
        modelAndView.addObject("phoneNum", phoneNum);
        //到注册页面
        modelAndView.setViewName("register");
        return modelAndView;
    }


    /**
     * 邮件发送短信验证码
     * @param email 邮箱
     * @return mav
     * @throws LoginException 自定义异常
     */
    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ModelAndView sendEmailCode(@RequestParam("email") String email,@RequestParam("checkcode") String checkcode) throws LoginException {
        ModelAndView modelAndView = new ModelAndView();
        //生成6位数字验证码
        String code ;
        //发送邮件
        if (!checkcode.matches(CHECK_CODE) || checkcode.length()<8){
            throw new LoginException("注册邀请码不正确，请输入正确的邀请码");
        }else if (email.matches(E_MAIL)) {
            code= String.valueOf(new Random().nextInt(899999) + 100000);
            log.info("email,发送邮件生成随机验证码：" + code);
            // 邮箱发送验证码
            try {
                emailService.sendMail(email, code);
            } catch (MessagingException e) {
                log.info("email,邮箱发送验证码异常：" + e.getMessage());
                e.printStackTrace();
            }

            //将代码放入缓存
            try {
                xmemcachedManager.set("code", code);
            } catch (InterruptedException | MemcachedException | TimeoutException e) {
                log.info("email,存入缓存异常：" + e.getMessage());
                e.printStackTrace();
            }

        } else {
            throw new LoginException("请输入有效的邮箱");
        }
        modelAndView.addObject("email", email);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    /**
     *上传页面
     */
    @RequestMapping(value = "/u/photo",method = RequestMethod.GET)
    public ModelAndView uploadPage(){
        return new ModelAndView("upload");
    }

    /**
     * 上传图片到OSS,并将链接放到数据库
     * @param file multipartFile
     * @param request 请求
     * @return mav
     * @throws LoginException 自定义异常
     */
    @RequestMapping(value = "/u/photo", method = RequestMethod.POST)
    public ModelAndView uploadPhoto(@RequestParam MultipartFile file, HttpServletRequest request) throws LoginException {
        ModelAndView modelAndView = new ModelAndView();

        if (file==null) {
            throw new LoginException("上传图片不存在");
        }

        //获得cookie里面用户id
        Map<String, Object> payload;
        String id = "";
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = CookieUtil.getValue(request, "token");
                    payload = new JwtUtil().verifyJwt(token);
                    id = (String) payload.get("id");
                }
            }
        }
        log.info("用户id:"+id);

        //获得图片后缀
        String[] fileName = file.getOriginalFilename().split("\\.");
        String photoSuffix = fileName[fileName.length - 1];
        //判断图片格式
        if (!photoSuffix.equals("jpg") && !photoSuffix.equals("png") && !photoSuffix.equals("img")){
            throw new LoginException("上传图片格式不正确");
        }

        //用登录用户id来创建文件夹,设置图片名称
        String objectName = id + "/" + id + "." + photoSuffix;
        String bucketName = "lichunyu1234";
        try {
            ossService.uploadBytesStream(bucketName, objectName, file.getBytes());
        }catch (Exception e){
            log.info("OSS上传文件异常:"+e.getMessage());
            throw new LoginException("图片上传出错，请重新上传");
        }

        //将上传后的地址存入数据库,将图缩略成宽度为200，高度为200，按长边优先,拼接在url后面就行
        String yunFile = "https://"+bucketName+".oss-cn-shanghai.aliyuncs.com/"+objectName+"?x-oss-process=image/resize,m_lfit,h_200,w_200";
        User user = new User();
        user.setId(id);
        user.setCode(yunFile);
        try {
            userService.updatePhoto(user);
            modelAndView.setViewName("redirect:/u/personal");
        } catch (Exception e) {
            log.info("图片地址上传数据库异常:"+e.getMessage());
            throw new LoginException("数据库异常，请尝试再次上传");
        }
        return modelAndView;
    }


    /**
     * 个人主页
     */
    @RequestMapping(value = "/u/personal",method = RequestMethod.GET)
    public ModelAndView personalPage(HttpServletRequest request) throws LoginException {
        ModelAndView modelAndView = new ModelAndView();
        //获得cookie里面用户id
        String id = "";
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = CookieUtil.getValue(request, "token");
                    Map<String, Object> payload = new JwtUtil().verifyJwt(token);
                    id = (String) payload.get("id");
                }
            }
        }
        log.info("当前用户主页id:"+id);

        //通过id获得对象
        try {
            User user = userService.getUserById(id);
            log.info("当前用户信息："+user);
            modelAndView.addObject("user",user);
        } catch (Exception e) {
            log.info("从数据库获取对象出错:"+e.getMessage());
            throw new LoginException("获取对象异常，请稍后再试");
        }
        modelAndView.setViewName("personal");
        return modelAndView;
    }



}

