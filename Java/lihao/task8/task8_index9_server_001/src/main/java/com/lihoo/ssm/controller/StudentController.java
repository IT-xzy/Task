package com.lihoo.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lihoo.ssm.model.StudentHome;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.model.StudentProfession;
import com.lihoo.ssm.service.StudentHomeService;
import com.lihoo.ssm.service.StudentInfoService;
import com.lihoo.ssm.service.StudentListService;
import com.lihoo.ssm.service.StudentProfessionService;
import com.lihoo.ssm.util.JwtUtils2;
import com.lihoo.ssm.util.LoginStatus;
import com.lihoo.ssm.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.lihoo.ssm.util.AddSalt.getSalt;
import static com.lihoo.ssm.util.MD5Utils.getPwdHash;

/**
 * #Title: IndexController
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/8/28-15:18
 * @author lihoo
 */

@SuppressWarnings("unused")
@Controller
//@RestController
public class StudentController {
//    打印日志
    private static Logger logger = LogManager.getLogger(StudentController.class);

    @Autowired
    StudentInfoService studentInfoService;

    /**
     请求注册数据
     */
    @RequestMapping(value ="/join", method = RequestMethod.GET)
    public String joinForm() {
        logger.info("join GET 方法被调用……");
        return "join.page";
    }

    /**
     注册
     */
    @RequestMapping(value ="/join", method = RequestMethod.POST)
    public String join(@RequestParam("username") String username,
                       @RequestParam("pwd") String pwd) {
        logger.info("开始...");
        logger.info("join POST 方法被调用……");
        String salt = getSalt();
        String pwdHash = getPwdHash(pwd, salt);
//       创建StudentInfo对象
        StudentInfo joinUser = new StudentInfo();
        joinUser.setUsername(username);
        joinUser.setSalt(salt);
        joinUser.setPwd(pwdHash);
        joinUser.setLogAt(System.currentTimeMillis());
        joinUser.setExpireAt(System.currentTimeMillis());
        studentInfoService.insert(joinUser);
        logger.info("打印注册的用户信息: " + "用户名:"+username+"密码:"+pwd);
        logger.info("打印注册的用户信息: " + joinUser);
        return "main.home";
    }

    /**
     请求登陆页面(输入账号密码)
     */
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String loginForm() {
        logger.info("login GET 方法被调用……");
        return "login.page";
    }

    /**
     *
     *登录验证，token加密，cookie生成发送
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "pwd",required = false) String pwd,
                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                        Model model) throws Exception {
        //        查询用户列表
        List<StudentInfo> stuList = studentInfoService.selectAll();
        for (StudentInfo list : stuList) {
            list.getId();
//            logger.debug("用户名：" + list.getUsername() + "密码：" + list.getPwd() + "盐：" + list.getSalt());
        }
        //通过用户名取出本条数据
        StudentInfo stu = studentInfoService.selectByUsername(username);
        Long id = stu.getId();
        //设置当前登录时间，一会儿添加到token用
        Long currentTime = System.currentTimeMillis();
        logger.info(id);
        //把当前登录时间更新到数据库
        StudentInfo updateStu = new StudentInfo();
        updateStu.setId(id);
        updateStu.setLogAt(currentTime);
        int addTime = studentInfoService.updateLoginTimeById(updateStu);
        logger.info(addTime);
        logger.info(updateStu);
        logger.info("当前登录时间是：" + currentTime);
        //**********************************************************************************************
//        定义需要加密的token( id + 登录时间 + 用户名 )
        String idAndTimeAndUsername = id + "," + currentTime + "," + username;
        logger.info("看一手这个（ id + 时间 + 用户名 ）的字符串：" + idAndTimeAndUsername );
//        加密，生成Token
        String jwtid = "123456";
        String jwtToken = JwtUtils2.createJWT(jwtid,idAndTimeAndUsername,currentTime);
        System.out.println("****这就是JWT_Token：" + jwtToken);
        //        保存到Cookies
        Cookie cookie = new Cookie("token", jwtToken);
//        设置一下Cookie
//        切记cookie时间设置，当你刷新，超时cookie失效
        cookie.setMaxAge(12*30*24*60*60);
//        cookie.setMaxAge(60);
        cookie.setPath("/");
//        添加到请求中
        httpServletResponse.addCookie(cookie);
        //**********************************************************************************************
//        打印输入的用户名和密码
        logger.info("输入的账户名是：" + username );
        logger.info("输入的账户密码是：" + pwd );
//        扔到service层去看一手**账号**密码**是不是和数据库的对应
        StudentInfo loginUser = new StudentInfo();
        loginUser.setUsername(username);
        loginUser.setPwd(pwd);
//        验证用户名是否在数据库中
        Boolean isNameSame = stu.getUsername().equals(username);
        logger.info(isNameSame);
//        验证密码是否在数据库中MD5加盐加密之后一致
        Boolean isPwdSame = studentInfoService.verifyPwd(loginUser);
        logger.info("是否一致：" + isPwdSame);
////      查找用户是否存在
        if (isNameSame && isPwdSame) {
            logger.info("登录成功");
            logger.info("打印一下cookie：" + cookie);
            logger.info("打印一下cookie的名：" + cookie.getName());
            logger.info("打印一下cookie的值：" + cookie.getValue());
            return "redirect:/index";
        }
        return "error.page";
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
//     用户退出时清除用户session里绑定到指定名称的对象
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        Cookie cookieKiller = new Cookie("token", null);
        cookieKiller.setMaxAge(0);
        cookieKiller.setPath("/");
        response.addCookie(cookieKiller);
        logger.info("退出登录，清除Cookie");
        return "redirect:/index";
    }

    @Autowired
    StudentHomeService studentHomeService;
//  主页
    @RequestMapping("/index")
    public String home(Model model, HttpServletRequest request) throws Exception {
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("我王境泽就是饿死：" + status);
        model.addAttribute("status", status);
        //页面信息
        List<StudentHome> selectGreatStudent = studentHomeService.selectGreatStudent();
        int countAll = studentHomeService.countAll();
        int workingCount = studentHomeService.workingCount();
        model.addAttribute("selectGreatStudent", selectGreatStudent);
        model.addAttribute("countAll", countAll);
        model.addAttribute("workingCount", workingCount);
        return "main.home";
    }
    //给一个Json
    //验证一下RestController
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public List<StudentHome> findStuIndex() throws Exception {
//        logger.info("获取list的Json");
//        return studentHomeService.selectAll();
//    }

    @Autowired
    StudentProfessionService studentProfessionService;

//  职业
    @RequestMapping(value = "/u/profession")
    public String profession(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        System.out.println("****拦截器判断进入**职业展示");
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("从这跳下去：" + status);
        model.addAttribute("status", status);
        //页面信息展示
        List<StudentProfession> selectAll = studentProfessionService.selectAll();
        model.addAttribute("selectAll", selectAll);
        int countAll = studentProfessionService.countAll();
        model.addAttribute("countAll", countAll);
        return "profession.home";
    }
    //给一个Json
//    @RequestMapping(value = "/u/profession" ,method = RequestMethod.GET)
//    public List<StudentProfession> studentProfessions() {
//
//        int countAll = studentProfessionService.countAll();
//
//        List<StudentProfession> selectAll = studentProfessionService.selectAll();
//
//        return selectAll;
//    }


    //  推荐
    @RequestMapping(value = "/u/recommend")
    public String recommend(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        System.out.println("****拦截器会去判断能不能进入**推荐页");
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("也不带吃你们一点东西：" + status);
        model.addAttribute("status", status);
        return "recommend.home";
    }

    @Autowired
    StudentListService studentListService;
    /**
     * 用户列表
     */
    @RequestMapping(value = "/u/userList", method = RequestMethod.GET)
    public String userList(HttpServletRequest request, HttpServletResponse response,
                           Model model, Page page, StudentList studentList) throws Exception {
        System.out.println("****拦截器会去判断能不能进入**用户列表");
        PageHelper.offsetPage(page.getStart(), 10);
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("哎呀，真香：" + status);
        model.addAttribute("status", status);
        //学生列表
        List<StudentList> stusList = studentListService.selectAll();
        int totalPage = (int) new PageInfo<>(stusList).getTotal();
        page.caculateLast(totalPage);
        model.addAttribute("stusList" ,stusList);
        return "userList.home";
    }
    //给一个Json
//    @RequestMapping(value = "/u/userList", method = RequestMethod.GET)
//    public List<StudentList> studentListList() {
//        return studentListService.selectAll();
//    }


    /**
     * 添加用户
     */
    //增加一个学生信息
    @RequestMapping(value = "/u/userList", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request,HttpServletResponse response,
                          Model model,StudentList studentList) throws Exception {
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("摩的炸弹：" + status);
        model.addAttribute("status", status);
        //增加学生
        logger.info("增加学生");
        studentListService.insert(studentList);
        model.addAttribute("userList", studentList);
        return "redirect:/u/userList";
    }
    //给一个Json
//    @RequestMapping(value = "/u/userList", method = RequestMethod.POST)
//    public int addUserJson(@PathVariable StudentList studentList) {
//        return studentListService.insert(studentList);
//    }


    /**
     * 删除一个用户
     */
    @RequestMapping(value = "/u/userList/{id}", method = RequestMethod.DELETE)
    public String delUser(@PathVariable long id,HttpServletRequest request,
                          HttpServletResponse response, Model model) throws Exception {
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("气死偶类：" + status);
        model.addAttribute("status", status);
        //删除用户
        studentListService.deleteByPrimaryKey(id);
        model.addAttribute("id", id);
        return "redirect:/u/userList";
    }


    /**
     * 编辑用户
     */
    @RequestMapping(value = "/u/userList/{id}", method = RequestMethod.GET)
    public StudentList getUserInfo(@PathVariable("id") long id, HttpServletRequest request,
                                HttpServletResponse response, Model model) throws Exception {
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("烤面筋：" + status);
        model.addAttribute("status", status);
        //通过id获取学生信息
        //        model.addAttribute("stu", stu);
        return studentListService.selectByPrimaryKey(id);
    }
    @RequestMapping(value = "/u/userList/{id}", method = RequestMethod.PUT)
    public String editUser(@PathVariable long id, HttpServletRequest request, Model model,
                           HttpServletResponse response, StudentList studentList) throws Exception {
        //header信息展示
        String[] status = LoginStatus.status(request);
        logger.info("我的烤面筋：" + status);
        model.addAttribute("status", status);
        //编辑学生信息
        studentList.setId(id);
        int aaa = studentListService.updateByPrimaryKey(studentList);
        logger.info("成功更新id："+id+"的学生信息");
        return "redirect:/u/userList";
    }

    /**
     请求失败
     */
    @RequestMapping("/error")
    public String error() {
        return "error.page";
    }

}
