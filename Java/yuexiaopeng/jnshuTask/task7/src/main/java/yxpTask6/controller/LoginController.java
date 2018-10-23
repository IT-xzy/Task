package yxpTask6.controller;

import freemarker.ext.beans.StringModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import yxpTask6.pojo.Login;
import yxpTask6.pojo.Student;
import yxpTask6.service.LoginService;
import yxpTask6.service.StudentService;
import yxpTask6.util.*;
import yxpTask6.util.loginUtil.LoginVerifyUtil;
import yxpTask6.util.loginUtil.Md5Salt;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

/*
* 账号的验证；账号注册；账号修改密码及修改其他信息；使用login开头*/
@Controller
public class LoginController
{

    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginVerifyUtil loginVerifyUtil;
    @Autowired
    private HttpCookiesToken httpCookiesToken;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private Md5Salt md5Salt;
    @Autowired
    private LoginStatus loginStatus;
//    @Autowired
//    private Task6Exception task6Exception;
    //对登录账号进行验证
    @RequestMapping("login/logining")
//    public String loginVerify(@PathVariable(value="type")String s, Login login)
    public ModelAndView loginVerify(HttpServletRequest request, HttpServletResponse response,
                                    Login login)
    {
        ModelAndView modelAndView=new ModelAndView();
        String status[]=loginStatus.status(request);
        modelAndView.addObject("status",status);
        //进行登录账号和密码的验证,利用工具类loginVerify
        boolean boo=loginVerifyUtil.loginVerify(login.getLoginAccount(),login.getLoginPassword());
        if(boo)
                {
//              //验证成功后，生成token
                String token=jwtUtils.creatToken(login);
                //使用md5,生成特别的cookie name；
                String cookieName=md5Salt.encrypt(login.getLoginAccount(),token);
                // 将token放入cookie中,设置必要的属性；
                httpCookiesToken.createCookie(request,response,cookieName,token,10);
                // 将数据传送到model;
                modelAndView.setViewName("loginSuccessPage");

                return modelAndView;
        }
        modelAndView.setViewName("loginFailPage");
        return modelAndView;
    }
    //对注册账号进行验证
    @RequestMapping("login/registering")
    public String loginRegisterVerify(HttpServletRequest request,HttpServletResponse response,
                                      Login login,Model model)
    {
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        //进行登录账号和密码的验证,利用工具类loginVerify
        boolean boo=loginVerifyUtil.loginRegisterVerify(login.getLoginAccount(),login.getLoginPassword());
        //格式正确，进行数据库的插入操作；
        if(boo)
        {
            //设置账号的创建时间,更新时间,默认昵称及其他必要信息；对验证后的密码进行加盐加密；
            login.setCreateAt(System.currentTimeMillis());
            login.setUpdateAt(System.currentTimeMillis());
            login.setLoginPicture("///");
            login.setLoginName("wokong");
            login.setLoginSalt("salt11");
            login.setLoginId("2");
            //对密码进行加密；
            String encryptPass=md5Salt.encrypt(login.getLoginPassword(),login.getLoginSalt());
            login.setLoginPassword(encryptPass);
            //插入到数据库中；
            loginService.registerLogin(login);
            //验证成功后，生成token
            String token=jwtUtils.creatToken(login);
            //使用md5,生成特别的cookie name；
            String cookieName=md5Salt.encrypt(login.getLoginAccount(),token);
            // 将token放入cookie中,设置必要的属性；
            httpCookiesToken.createCookie(request,response,cookieName,token,10);
            return "loginSuccessPage";
        }
        return "loginFailPage";
    }
    //修改密码及其他信息；
    @RequestMapping("login/setting")
    public String loginSettingAllController(HttpServletRequest request,Model model, Login login)
    {
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        //System.out.println(login);
        String name=login.getLoginName();
        String picture=login.getLoginPicture();
        //先判断密码的格式；
        boolean boo=loginVerifyUtil.loginUpdateVerify(login.getLoginAccount(),login.getLoginPassword());
        //密码格式正确
        if(boo)
        {
            // 判断name和picture输入的信息不为空
            if(name!=null&&picture!=null)
            {
                //进行信息的修改；同时修改更新时间；
                login.setUpdateAt(System.currentTimeMillis());
                //从后台取得存在的数据，为了取得盐值
                Login login1=loginService.selectLogin(login.getLoginAccount());
                //对新密码进行加密
                String encryptPass=md5Salt.encrypt(login.getLoginPassword(),login1.getLoginSalt());
                login.setLoginPassword(encryptPass);
                //数据库操作；
                loginService.updateLogin(login);
                //返回成功页面
                return "loginSuccessPage";
            }
            //name和picture有空值；
            return "loginFailPage";
        }
        //密码不正确；
        return "loginFailPage";
    }
    //只修改修改密码
    @RequestMapping("login/passwording")
    public String loginSettingController(HttpServletRequest request,HttpServletResponse response,
                                        Model model,Login login)
    {
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        //System.out.println(login);
        //判断密码的格式；
        boolean boo=loginVerifyUtil.loginUpdateVerify(login.getLoginAccount(),login.getLoginPassword());
        //格式正确
        if(boo)
        {
            //进行密码修改；
            login.setUpdateAt(System.currentTimeMillis());
            //从后台取得存在的数据，为了取得盐值
            Login login1=loginService.selectLogin(login.getLoginAccount());
            //对新密码进行加密
            String encryptPass=md5Salt.encrypt(login.getLoginPassword(),login1.getLoginSalt());
            login.setLoginPassword(encryptPass);
            //修改数据
            loginService.updatePassword(login);
            //验证成功后，生成token
            String token=jwtUtils.creatToken(login);
            //使用md5,生成特别的cookie name；
            String cookieName=md5Salt.encrypt(login.getLoginAccount(),token);
            // 将token放入cookie中,设置必要的属性；
            httpCookiesToken.createCookie(request,response,cookieName,token,10);
            return "loginSuccessPage";
        }
        //格式错误，返回错误页面
        return "loginFailPage";
    }
    //账户信息
    @RequestMapping("login/det")
    public ModelAndView loginDetail(HttpServletRequest request)
    {
        ModelAndView modelAndView=new ModelAndView("loginDetailPage");
        String status[]=loginStatus.status(request);
        String account=status[4];
        Login login=loginService.selectLogin(account);
        modelAndView.addObject("status",status);
        modelAndView.addObject("login",login);
        return modelAndView;

    }
    //login登录跳转
    @RequestMapping("login/log")
    public ModelAndView tilesLoginController(HttpServletRequest request)
    {
        //暂时不需要传参
        ModelAndView modelAndView=new ModelAndView("loginPage");
        String status[]=loginStatus.status(request);
        modelAndView.addObject("status",status);
        return modelAndView;
    }
    //账号注册跳转页
    @RequestMapping("login/reg")
    public String loginRegisterController(HttpServletRequest request,Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);

        return "loginRegisterPage";
    }
    //账号设置跳转页
    @RequestMapping("login/set")
    public String loginSettingController(HttpServletRequest request,Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        Login login=loginService.selectLogin(status[4]);
        model.addAttribute("login",login);
        return "loginSettingPage";
    }
    //需要登录的跳转页面
    @RequestMapping("login/need")
    public String loginNeedController(HttpServletRequest request,Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        return "loginNeedPage";
    }
    //需要登录的跳转页面
    @RequestMapping("login/pas")
    public String loginPasswordUpdateController(HttpServletRequest request,Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        return "loginUpdatePassword";
    }
    //需要登录的跳转页面
    @RequestMapping("login/can")
    public String loginCancelController(HttpServletRequest request,HttpServletResponse response,Model model)
    {
        //用model传数据，用string传视图；
//        String status[]=loginStatus.status(request);
//        model.addAttribute("status",status);
        //清除request中cookie内容
        String url=request.getContextPath();
//        System.out.println(url);
        //从request中读取cookie
        Cookie cookies []=request.getCookies();
        //看下cookies中的信息；
        for(int i=0;i<cookies.length;i++)
        {
            //默认的cookie中只有名字和值，
            Cookie cookie1=new Cookie(cookies[i].getName(),cookies[i].getValue());
            //删除的话，路劲设置和设定的一样才行；
            //使用getPath(),得不到cookie的路径，request中不包含这个信息；
            cookie1.setPath(url);
            //cookie1.setDomain("localhost");
            //cookie1.setHttpOnly(true);
            cookie1.setMaxAge(0);
            //将每个cookie放入response中
            response.addCookie(cookie1);
        }
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);

        return "loginSuccessPage";
    }
    //短信验证码跳转页面
    @Autowired
    private SMSUtil smsUtil;
    @RequestMapping("login/test/pas")
    public String loginSMSController(HttpServletRequest request,HttpServletResponse response,
                                     Login login,String loginCode,String loginMobile,Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        System.out.println("**********");
        System.out.println("提交的手机号码为"+loginMobile);
        System.out.println("提交的验证码为"+loginCode);
        System.out.println("注册按钮的账户信息"+login.getLoginAccount());
        String mess=null;
        //验证码不为空准确
            if(loginCode!=null&&loginCode.equals(codeFF))
            {
                //验证码正确
                System.out.println("验证码验证成功：okkkkkk");
            //进行登录账号和密码的验证,利用工具类loginVerify，格式及账户是否存在
            boolean boo=loginVerifyUtil.loginRegisterVerify(login.getLoginAccount(),login.getLoginPassword());
            //格式正确，进行账户存在的判断；
                if(boo)
                {
                        //设置账号的创建时间,更新时间,默认昵称及其他必要信息；对验证后的密码进行加盐加密；
                        login.setCreateAt(System.currentTimeMillis());
                        login.setUpdateAt(System.currentTimeMillis());
                        login.setLoginPicture("https://yxp-picture.oss-cn-beijing.aliyuncs.com/test.png?x-oss-process=style/userImg");
                        login.setLoginName("testttttt");
                        login.setLoginSalt("salt11");
                        login.setLoginId("66");
                        //对密码进行加密；
                        String encryptPass=md5Salt.encrypt(login.getLoginPassword(),login.getLoginSalt());
                        login.setLoginPassword(encryptPass);
                        //插入到数据库中；
                        loginService.registerLogin(login);
                        //验证成功后，生成token
                        String token=jwtUtils.creatToken(login);
                        //使用md5,生成特别的cookie name；
                        String cookieName=md5Salt.encrypt(login.getLoginAccount(),token);
                        // 将token放入cookie中,设置必要的属性；
                        httpCookiesToken.createCookie(request,response,cookieName,token,10);
                        return "loginSuccessPage";

                }
                mess="账户格式不正确或账户已存在";
                model.addAttribute("loginAccount",login.getLoginAccount());
                model.addAttribute("loginPassword",login.getLoginPassword());
                model.addAttribute("loginMobile",loginMobile);
                model.addAttribute("message",mess);
                return "loginRegisterPage";
            }
        mess="验证码错误";
            if(login.getLoginAccount()==null&&login.getLoginPassword()==null&&loginCode==null)
            {mess=null;}
        //密码验证不成功，将填写的信息携带到原页面；
        model.addAttribute("loginAccount",login.getLoginAccount());
        model.addAttribute("loginPassword",login.getLoginPassword());
        model.addAttribute("loginMobile",loginMobile);
        model.addAttribute("message",mess);
        return "loginRegisterPage";
    }
    //手机号验证成功后，更改这个为发送的验证码；
    static String codeFF="1123";
    @RequestMapping("login/test/code")
    public String loginCodeController(HttpServletRequest request,HttpServletResponse response,
                                      String loginMobile,Login login,Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        System.out.println("申请的手机号码是："+loginMobile);
        //格式验证
        String regex="^[0-9]{11}$";
        Boolean booMoblie=Pattern.matches(regex,loginMobile);
        if(booMoblie){
            //格式正确，进入密码注册阶段
            System.out.println("手机号码格式正确*****");
            codeFF=smsUtil.getSMS(loginMobile);
//            codeFF="7980";
            model.addAttribute("loginMobile",loginMobile);
            return "forward:/login/test/pas";
        }
        else{
            System.out.println("手机号码格式错误*****");
            model.addAttribute("loginMobile",loginMobile);
            String mobileError="手机号码格式错误";
            model.addAttribute("mobileError",mobileError);
            model.addAttribute("loginAccount",login.getLoginAccount());
            model.addAttribute("loginPassword",login.getLoginPassword());
            return "loginRegisterPage";
        }
    }
//    @Autowired
//    private LoginService loginService;
    @RequestMapping("login/test/111")
    public String login111Controller(HttpServletRequest request,HttpServletResponse response,
                                      String loginAccount,String loginPassword,String loginMobile,
                                   Model model)
    {
        //用model传数据，用string传视图；
        String status[]=loginStatus.status(request);
        model.addAttribute("status",status);
        Login login=loginService.selectLogin(loginAccount);
        String mss="账户可用";
        if(login!=null){
//            账户存在
            mss="账户不可用";
        }
        System.out.println("button1的按钮的账户信息"+loginAccount);
        System.out.println("button1的注册按钮的账户信息"+loginPassword);
        System.out.println("button1的注册按钮的手机信息"+loginMobile);
        model.addAttribute("loginAccount",loginAccount);
        model.addAttribute("loginPassword",loginPassword);
        model.addAttribute("loginMobile",loginMobile);
        model.addAttribute("accountMessage",mss);
//        String code="7980";
////        String code=smsUtil.getSMS(loginMobile);
//        model.addAttribute("loginMobile",loginMobile);
//        model.addAttribute("code",code);
        return "forward:/login/test/pas";
    }
    @Autowired
     ImageAliyun imageAliyun;
    @RequestMapping("login/test/img")
    public String upload(MultipartFile multipartFile,Model model,HttpSession session,Login login) throws Exception
    {
        // 得到文件的原始名称，如：美女.png
//        String fileName = multipartFile.getOriginalFilename();
        System.out.println("前段传过来的文件为："+multipartFile.getBytes());
        if (multipartFile!=null)
        {
            if (multipartFile.getSize() > 0) {
                // 得到项目在服务器的真实根路径，如：/home/tomcat/webapp/项目名/images
                //服务器路径
                String path = "/home/imgFile/";
                //windows下的目录写法；
                //String path="C:\\gongzuofile\\springTask6\\src\\main\\webapp\\img\\upload";
//                String path="\\imgFile\\";
                System.out.println("项目的真实路径为"+path);
                // 得到文件的原始名称
                String fileName = multipartFile.getOriginalFilename();
                System.out.println("图片的名称为："+fileName);
                // 通过文件的原始名称，可以对上传文件类型做限制，如：只能上传jpg和png的图片文件
                FileOutputStream fileOutputStream=null;
                if (fileName.endsWith("jpg") || fileName.endsWith("png")||fileName.endsWith("gif")) {
                    File file = new File(path, fileName);
                    fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(multipartFile.getBytes());
//                    multipartFile.transferTo(file);
                    String img=imageAliyun.uploadImg(fileName,path+fileName);
                    model.addAttribute("img",fileName);
                    model.addAttribute("online",img);
                    model.addAttribute("login",login);
                    System.out.println("上传后的图片链接为"+img);
                    System.out.println("前端的图片的名称为："+fileName);
                    return "loginSettingPage";
                }
            }
        }
        model.addAttribute("login",login);
        return "loginSettingPage";
    }
    @Autowired
    SendMaiUtil sendMaiUtil;
    static String mailCodeFinal="123456";
    @RequestMapping("login/test/mail")
    public String updateMail(Login login,Model model) throws Exception
    {
        String mailCode=null;
        //对邮箱发送验证码,会进行验证
            if(login!=null) {
                if(login.getLoginMail()!=null){
//                    mailCode = sendMaiUtil.sendCommon(login.getLoginMail());
                    mailCode="867667";
                }

            }
            //验证码不正确，返回同页面
            if(mailCode==null){
                //存在验证码，返回同页面；将信息返回
                model.addAttribute("mailError","邮箱不存在");
                model.addAttribute("login",login);
                System.out.println("邮箱不存在");
                return "testMail" ;
            }

        //验证码正确，修改静态变量为结果，进行转发；
        mailCodeFinal=mailCode;
        model.addAttribute("login",login);
        System.out.println("邮箱正确"+mailCode);
        return "forward:/login/test/mailing" ;
    }
    @RequestMapping("/login/test/mailing")
    public String updateMailing(Login login,String loginMailCode,Model model) throws Exception
    {

        //验证码正确，将邮箱账号添加到数据库中
        if(mailCodeFinal.equals(loginMailCode)){
            //进行数据库的更新
            login.setUpdateAt(System.currentTimeMillis());
            loginService.updateSecAccount(login);
            model.addAttribute("login",login);
            System.out.println("更新成功");
            return "testSuccess" ;
        }
        //验证码不正确，返回同页面进行转发；
        model.addAttribute("login",login);
        model.addAttribute("loginError","验证码或提交的格式不正确");
        System.out.println("更新失败");
        return "testMail" ;
    }
    @RequestMapping("/login/test/secAccount")
    public String updateSecAccount(Login login)
    {
        //增加第二账户；
        return "testSuccess";
    }
}
