package yxpTask6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import yxpTask6.pojo.Login;
import yxpTask6.service.LoginService;
import yxpTask6.util.HttpCookiesToken;
import yxpTask6.util.JwtUtils;
import yxpTask6.util.LoginStatus;
import yxpTask6.util.TaskException;
import yxpTask6.util.loginUtil.LoginVerifyUtil;
import yxpTask6.util.loginUtil.Md5Salt;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
