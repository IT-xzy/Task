package controller;

import exercise.Base64UtilTest;
import exercise.DesUtilTest;
import model.StuInfo;
import model.Users;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ProfService;
import service.StuInfoService;
import service.UsersService;
import service.utils.GetUserUtil;
import utils.CookieUtil;
import utils.EncryptionUtil;
import utils.RegexUtil;
import utils.TokenProccessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class StuInfoController {

    public static Logger logger = LogManager.getLogger(StuInfoController.class);

    @Autowired
    StuInfoService stuInfoService;
    @Autowired
    ProfService profService;
    @Autowired
    UsersService usersService;
    @Autowired
    GetUserUtil getUserUtil;

    //原版不使用缓存
    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView listStudent(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        //增加检查cookie并展示用户名模块
        Users user = getUserUtil.getUser(request);
        mav.addObject("user", user);


        StuInfo stu = new StuInfo();
        stu.setStatus("在学");
        int countstudy = stuInfoService.selectStudyWork(stu);
        stu.setStatus("工作");
        int countwork = stuInfoService.selectStudyWork(stu);
        mav.addObject("countwork", countwork);
        mav.addObject("countstudy", countstudy);

        StuInfo one = new StuInfo();
        StuInfo two = new StuInfo();
        StuInfo three = new StuInfo();
        StuInfo four = new StuInfo();
        one.setId(1);
        two.setId(2);
        three.setId(3);
        four.setId(4);
        one = stuInfoService.getById(one);
        two = stuInfoService.getById(two);
        three = stuInfoService.getById(three);
        four = stuInfoService.getById(four);
        mav.addObject("one", one);
        mav.addObject("two", two);
        mav.addObject("three", three);
        mav.addObject("four", four);
        mav.setViewName("homepage");
        return mav;
    }

    //学习tiles测试的方法
    @RequestMapping(value = "/test")
    public String testView() {
        return "layout";//这里的myView为layout.xml中配置的视图名称，根据返回值，去匹配对应的jsp页
    }


    //登录模块
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //此处@RequestParam作用是从前台获取参数，如果参数名相同，无需注明名称，如果不同，得注明。
    // required=true，则参数必须要传（为了防止前台为null，后台为类似int的基本类型）
    //defaultValue属性可以设置默认值
    public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String username,
                          @RequestParam(name = "pd", required = true, defaultValue = "000000") String password) {
        ModelAndView mav = new ModelAndView();

        Users user = usersService.getByName(username);

        //严重注意，此处只能用==判断，不可以用equals方法
        if (user == null) {
            mav.setViewName("errorLogin");
            return mav;
        }
        String salt = user.getSalt();
        password = EncryptionUtil.getSHA256Str(password + salt);
        if (user.getPassword().equals(password)) {

            //对登录时间和用户名加密模块
            long loginTime = System.currentTimeMillis();
            user.setLoginTime(loginTime);
            usersService.updateloginTime(user);
            String time = DesUtilTest.longFormString(loginTime);
            time = DesUtilTest.encrypt(time);
            CookieUtil.addCookie(response, "time", time);
            username = DesUtilTest.encrypt(username);
            CookieUtil.addCookie(response, "username", username);

            HttpSession session = request.getSession();
//            CookieUtil.addCookie(response, "username", username);
//            CookieUtil.addCookie(response, "password", password);
            CookieUtil.addCookie(response, "sessionid", session.getId());

//            CookieUtil.delCookie(request, response, "username");
//            CookieUtil.delCookie(request, response, "password");

            //注意，此处用的是重定向
            mav.setViewName("redirect:/homepage");
            return mav;
        } else {
            mav.setViewName("errorLogin");
            return mav;
        }
    }

    //把login页面放入了受保护的文件里。所以需要针对get方式提交定义一个方法
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String refreshLogin() {
        return "login";
    }


    //注册模块
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(HttpServletRequest request, HttpServletResponse response) {

        String token = TokenProccessor.getInstance().makeToken();//创建令牌

        System.out.println("生成的token是：" + token);

        HttpSession session = request.getSession(); //在服务器使用session保存token(令牌)

        session.setAttribute("token", token);

        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam String username, String password, String repassword) {
        ModelAndView mav = new ModelAndView();
        boolean b = isRepeatSubmit(request);
        if (b) {
            System.out.println("请不要重复提交表单");
            mav.setViewName("redirect:/register");
            return mav;
        }
        request.getSession().removeAttribute("token");
        System.out.println("处理用户提交请求！");



        Map<String, String> msg = new HashMap<String, String>();
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setRepassword(repassword);
        if (!RegexUtil.validate(username, password, repassword, msg)) {
            user.setMsg(msg);
            mav.addObject("user", user);
            mav.setViewName("register");
            return mav;
        }
        //严重注意，此处只能用==判断，不可以用equals方法
        //查询数据库里是否有重复的用户注册信息
        else if (usersService.getByName(username) != null) {
            msg.put("username", "用户名重复，请重新输入");
//            user.getMsg().put("username", "用户名重复，请重新输入");
            user.setMsg(msg);
            mav.addObject("user", user);
            mav.setViewName("register");
            return mav;
        }
//        //两次密码是否相等
//        else if(!password.equals(repassword)){
//            mav.setViewName("errorpage");
//            return mav;
//        }
        //最终符合，注册并跳转
        else {

            //让当前的线程睡眠3秒钟，模拟网络延迟而导致表单重复提交的现象
//            try {
//                Thread.sleep(3 * 1000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }

            String salt = EncryptionUtil.getNextSalt();
            password = EncryptionUtil.getSHA256Str(password + salt);
            user.setSalt(salt);
            user.setPassword(password);
            user.setCreateAt(System.currentTimeMillis());
            usersService.insert(user);

            //对登录时间和用户名加密模块
            long loginTime = System.currentTimeMillis();
            user.setLoginTime(loginTime);
            usersService.updateloginTime(user);
            String time = DesUtilTest.longFormString(loginTime);
            time = DesUtilTest.encrypt(time);
            CookieUtil.addCookie(response, "time", time);
            username = DesUtilTest.encrypt(username);
            CookieUtil.addCookie(response, "username", username);

            mav.setViewName("redirect:/homepage");
            return mav;
        }
    }

    /**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     *
     * @param request
     * @return true 用户重复提交了表单
     * false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {

        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if (client_token == null) {
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if (server_token == null) {
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if (!client_token.equals(server_token)) {
            return true;
        }
        return false;
    }


    //修改密码模块
    @RequestMapping(value = "/updatepassword", method = RequestMethod.GET)
    public String refreshUpdatePassword() {
        return "updatepassword";
    }

    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    public ModelAndView updatePassword(@RequestParam String username,
                                       String oldpassword, String newpassword, String repassword) {
        ModelAndView mav = new ModelAndView();
        Map<String, String> msg = new HashMap<String, String>();
        Users user = new Users();

        //为了把用户输入的数据返回到文本框里
        user.setUsername(username);

        if (usersService.getByName(username) == null) {
            user.getMsg().put("username", "该用户名不存在，请重新输入");
            mav.addObject("user", user);
            mav.setViewName("updatepassword");
            return mav;
        }

        user = usersService.getByName(username);
        String salt = user.getSalt();
        String str = EncryptionUtil.getSHA256Str(oldpassword + salt);

        if (!user.getPassword().equals(str)) {

            user.getMsg().put("password", "密码不正确，请重新输入");
            user.setPassword(null);
            mav.addObject("user", user);
            mav.setViewName("updatepassword");
            return mav;

        } else if (!RegexUtil.validate(newpassword, repassword, msg)) {
            user.setMsg(msg);
            user.setPassword(oldpassword);
            user.setRepassword(repassword);
            mav.addObject("newpassword", newpassword);
            mav.addObject("user", user);
            mav.setViewName("updatepassword");
            return mav;
        } else {
            newpassword = EncryptionUtil.getSHA256Str(newpassword + salt);
            user.setPassword(newpassword);
            usersService.update(user);
            mav.setViewName("redirect:/login");
            return mav;
        }
    }

    //登出功能
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.delCookie(request, response, "time");
        CookieUtil.delCookie(request, response, "username");
        return "redirect:homepage";
    }
}
