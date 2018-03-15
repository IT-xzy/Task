package cn.summerwaves.controller;

import cn.summerwaves.model.User;
import cn.summerwaves.service.IUserService;
import cn.summerwaves.util.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class UserController {
    private static Logger log = Logger.getLogger(SMSUtil.class);

    private IUserService getUserService() {
        return SelectRMIUtil.getUserService();
    }
    /*private IUserService userService;*/

/*    private IUserService checkUserService(IUserService userService) {
        try {
            IUserService userService1 = userService;
            return userService;
        } catch (Exception e) {
            return SelectRMIUtil.getUserService();
        }
    }
    public UserController() {
        this.userService = SelectRMIUtil.getUserService();
    }*/

  /*  @Lazy
    @Autowired(required = false)
    public UserController(IUserService userService1,IUserService userService2) {
        Random random = new Random();
        int i = random.nextInt(2) + 1;
        if (i == 1) {
            try {
                this.userService = userService1;
                log.info("get data from server1");
                System.out.println("get data from server1");
            } catch (BeanCreationException e) {
                this.userService = userService2;
                log.error("get a error,turn to server2");
                System.out.println("get a error,turn to server2");
            }
        } else {
            try {
                this.userService = userService2;
                log.info("get data from server2");
                System.out.println("get data from server2");
            } catch (BeanCreationException e) {
                this.userService = userService1;
                log.info("get a error,turn to server1");
                System.out.println("get a error,turn to server1");
            }
        }

    }*/

   /* public UserController() {
        Random random = new Random();
        int i = random.nextInt(2) + 1;
        if (i == 1) {
            try {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/client-servlet.xml");
                this.userService = (IUserService) ctx.getBean("userService1");
                log.info("get data from server1");
                System.out.println("get data from server1");
            } catch (BeanCreationException e) {
                ApplicationContext ctx =new ClassPathXmlApplicationContext("WEB-INF/client-servlet.xml");
                this.userService = (IUserService) ctx.getBean("userService2");
                log.info("get a error,turn to server2");
                System.out.println("get a error,turn to server2");
            }
        } else {
            try {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/client-servlet.xml");
                this.userService = (IUserService) ctx.getBean("userService2");
                log.info("get data from server2");
                System.out.println("get data from server2");
            } catch (BeanCreationException e) {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/client-servlet.xml");
                this.userService = (IUserService) ctx.getBean("userService1");
                log.info("get a error,turn to server1");
                System.out.println("get a error,turn to server1");
            }
        }
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    //获取阿里云存储全部文件页面
    @RequestMapping(value = "/user/ali",method = RequestMethod.GET)
    public String showALiAllFile(ModelMap modelMap) {
        List<String> aLiAllFile = ALiYunUtil.getAllFileName();
        modelMap.addAttribute("aLiAllFile", aLiAllFile);
        return "aLi";
    }

    //获取七牛云存储全部文件页面
    @RequestMapping(value = "/user/qiniu", method = RequestMethod.GET)
    public String showQiNiuAllFile(ModelMap modelMap) {
        List<String> qiNiuAllFile = QiNiuUtil.getAllFileName();
        modelMap.addAttribute("qiNiuAllFile", qiNiuAllFile);
        return "qiNiu";
    }


    //阿里云存储文件全部迁移到七牛云存储
    @RequestMapping(value = "/alitoqiniu", method = RequestMethod.GET)
    public String aLiToQiNiu(ModelMap modelMap) {

        DataMigrationUtil.AliToQiNiu();
        modelMap.addAttribute("dataMigration", "数据已从阿里云迁移到七牛云！");
        return "dataMigration";
    }

    //骑牛云存储文件全部迁移到阿里云存储
    @RequestMapping(value = "/qiniutoali", method = RequestMethod.GET)
    public String QiNiuToALi(ModelMap modelMap) {
        DataMigrationUtil.QiNiuToALi();
        modelMap.addAttribute("dataMigration", "数据已从七牛云迁移到阿里云！");
        return "dataMigration";
    }

    //获取主页
    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    //获取email注册页面
    @RequestMapping(value = "/email/user", method = RequestMethod.GET)
    public String toEmailRegister() {
        return "registerByEmail";
    }

    //获取短信注册页面
    @RequestMapping(value = "/sms/user", method = RequestMethod.GET)
    public String toSMSRegister() {
        return "registerBySMS";
    }

    //获取全部用户展示页面
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView toShowAllUser() {
        ModelAndView mv = new ModelAndView();
        List<User> users = getUserService().selectIdAvatarUsernameFromAllUser();
        mv.setViewName("showAllUser");
        mv.addObject("users", users);
        return mv;
    }

    //获取单个用户信息页面
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView toShowUser(@PathVariable("id")int id) {
        ModelAndView mv = new ModelAndView();
        User user = getUserService().selectUserById(id);
        if (user.getEmail() == null) {
            user.setEmail("请设置邮箱！");
        }
        if (user.getTel() == null) {
            user.setTel("请设置手机号码！");
        }
        mv.addObject("user",user);

        mv.setViewName("showUser");
        return mv;
    }

    //获取修改用户信息页面
    @RequestMapping(value = "/user/modify", method = RequestMethod.GET)
    public ModelAndView toModify(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        mv.addObject("user", getUserService().selectUserById(id));
        mv.setViewName("modify");
        return mv;
    }

    //修改用户信息
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String Modify(@PathVariable("id") int id, @RequestParam(value = "file")MultipartFile file, User user) throws IOException {
        if (!file.isEmpty()) {
            String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
            String username = user.getUsername();
            InputStream inputStream = file.getInputStream();
            StorageUtil.upLoad(inputStream, username + type);
            user.setAvatar(StorageUtil.getFileUrl(username + type));
        }
        if (Objects.equals(user.getTel(), "")) {
            user.setTel(null);
        }
        if (Objects.equals(user.getEmail(), "")) {
            user.setEmail(null);
        }
        getUserService().updateUser(user);
        return "modifySuccess";
    }

    //提交email注册表单
    @RequestMapping(value = "/email/user", method = RequestMethod.POST)
    public ModelAndView registerByEmail(HttpServletRequest request, User user) {
        ModelAndView mv = new ModelAndView();

        //获取JSP参数
/*        String username = request.getParameter("username");
        String password = request.getParameter("password");*/
        String code = request.getParameter("code");
        String userCode = request.getParameter("userCode");
        String username = user.getUsername();
        String password = user.getPassword();

        //防止重复的用户名，以及用户名、密码为空，并要求用户名要不小于2，验证验证码
        if (getUserService().selectUserByName(username) == null && !username.equals("")
                && !password.equals("") && username.length() >= 2 && code.equals(userCode)) {
            //插入数据库前对密码加盐
            user.setPassword(getUserService().setPasswordBySalt(username, password));
            getUserService().insertUser(user);

            mv.addObject("username", user.getUsername());
            mv.addObject("email", user.getEmail());
            mv.setViewName("registerSuccess");
            return mv;
        }
        mv.setViewName("registerFail");
        return mv;
    }

    //提交短信注册表单
    @RequestMapping(value = "/sms/user", method = RequestMethod.POST)
    public ModelAndView registerBySMS(HttpServletRequest request,User user) {
        ModelAndView mv = new ModelAndView();

        //获取JSP参数
        String code = request.getParameter("code");
        String userCode = request.getParameter("userCode");
        String username = user.getUsername();
        String password = user.getPassword();

        //防止重复的用户名，以及用户名、密码为空，并要求用户名要不小于2，验证验证码
        if (getUserService().selectUserByName(username) == null && !username.equals("") &&
                !password.equals("") && username.length() >= 2 && code.equals(userCode)) {

            //插入数据库前对密码加盐
            user.setPassword(getUserService().setPasswordBySalt(username, password));
            getUserService().insertUser(user);

            mv.addObject("username", user.getUsername());
            mv.setViewName("registerSuccess");
            return mv;
        }

        mv.setViewName("registerFail");
        return mv;
    }

    //制作短信验证码并发送
    @RequestMapping(value = "/sms/code", method = RequestMethod.POST)
    @ResponseBody
    public String sendSMSCode(@RequestBody Map<String, String> map,HttpSession session) {
        session.invalidate();
        int intCode = (int)((Math.random() * 9 + 1) * 1000);
        String code = String.valueOf(intCode);
        String tel = map.get("tel");
        SMSUtil.sendSMS(tel, code, "5");
//        session.setAttribute("code", code);
        log.error("SMS ResponseBody");
        return code;
    }

    //制作email验证码并发送
    @RequestMapping(value = "/email/code", method = RequestMethod.POST)
    @ResponseBody
    public String sendEmailCode(@RequestBody Map<String, String> map,HttpSession session) {
        session.invalidate();
        int intCode = (int)((Math.random() * 9 + 1) * 1000);
        String code = String.valueOf(intCode);
        String tel = map.get("email");
        EmailUtil.sendEmail(tel, code);
//        session.setAttribute("code", code);
        log.error("Email ResponseBody");
        return code;
    }

    //删除阿里云存储所有文件
    @RequestMapping(value = "/alifile",method = RequestMethod.GET)
    public String deleteALiAllFile(ModelMap modelMap) {
        ALiYunUtil.deleteAllFile();
        return "deleteAliAllFile";
    }

    //删除七牛云存储所有文件
    @RequestMapping(value = "/qiniufile",method = RequestMethod.GET)
    public String deleteQiNiuAllFile(ModelMap modelMap) {
        QiNiuUtil.deleteAllFile();
        return "deleteQiNiuAllFile";
    }

}
