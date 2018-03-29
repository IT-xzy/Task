package jnshu.taskseven.controller;

import jnshu.taskseven.model.Profession;
import jnshu.taskseven.model.Student;
import jnshu.taskseven.service.CountNumberService;
import jnshu.taskseven.service.ProfessionService;
import jnshu.taskseven.service.StudentService;
import jnshu.taskseven.util.DesUtils;
import jnshu.taskseven.util.Md5Utils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-20
 * @Time: 下午 2:35
 * Description:
 **/

@Controller
public class CommonController {

    @Autowired
    private StudentService studentService;

    @Autowired
    ProfessionService professionService;

    @Autowired
    CountNumberService countNumberService;

    @Autowired
    Md5Utils md5;

    private static Logger loggerCommCon = LoggerFactory.getLogger(CommonController.class);

    String DES_KEY = "12345678";

    /**
     * 首页
     * 所有人都可以查看
     */
    @RequestMapping(value = "/a/home",method = RequestMethod.GET)
    public String homeDetail(HttpServletRequest request, HttpServletResponse response, Model model){

        Long begin = System.currentTimeMillis();
        Student student = new Student();
        int entire = studentService.countStudentUser(student);
        loggerCommCon.info("There are "+ entire + " people studying");
        student.setStatus(0);
        int graduation = studentService.countStudentUser(student);
        loggerCommCon.info("There are "+ graduation + " people who have work");
        List<Student> students = studentService.listStudentTable();
        loggerCommCon.info("list students number : "+ students.size());

        model.addAttribute("graduation",graduation);
        model.addAttribute("entire",entire);
        model.addAttribute("students",students);

        Long end = System.currentTimeMillis();
        loggerCommCon.info("controller time : "+ (end-begin));

        return "task10/task10";
    }

    /**
     * 可以列出所有职业介绍
     */
    @RequestMapping(value="/a/profession",method = RequestMethod.GET)
    public String professionDetail(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<Profession> professions = professionService.listProfession();
        loggerCommCon.info("list professions number: "+ professions.size());
        //根据职业表从学生表查询

        try {
            Integer[] professionStudyNumber = countNumberService.countProfessionStudy(professions);
            loggerCommCon.info(" professionStudyNumber number: " + professionStudyNumber.length);
            model.addAttribute("professions", professions);
            model.addAttribute("professionStudyNumber", professionStudyNumber);
        }catch (Throwable t) {
            t.printStackTrace();
            loggerCommCon.error("t.getMessage() : " + t.getMessage());
        }
        return "task11/task11";

    }


    /**
     * 进入登陆界面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="/a/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model){
        return "task5/login";
    }

    /**登陆验证
     *
     * @param request
     * @param response
     * @param model
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/a/login/verification",method = RequestMethod.POST)
    public void verification(HttpServletRequest request, HttpServletResponse response, Model model)  throws ServletException, IOException
    {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        loggerCommCon.info("user-jsp: "+user);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();

        Student student = new Student();

        //非法字符判断
        int signal = sensitiveWords(request,response);
        if(signal == 0){
            return;
        }

        //判空处理
        if(user != "" && pass !="")
        {
            student.setUser(user);
            int userBeing = studentService.countStudentUser(student);
            loggerCommCon.info("userBeing is:" + userBeing);

            /**
             * 当用户名存在时
             */
            if(userBeing != 0) {

                try {
                    Student study = studentService.getStudentUser(user);
                    loggerCommCon.info("study user name : " + study.getUser());

                    md5 = new Md5Utils();
                    pass = md5.getMD5(pass);
                    if (pass.equals(study.getPass())) {
                        //用户加密和存储
                        userEncryptionAndStorage(request, response,study);

                /* 将页面跳转到被拦截器拦截的url如果没有就到首页*/
                        if (request.getSession().getAttribute("lastUrl") != null) {
                            //获取名为lastUrl的session的value
                            String lastUrl = (String) request.getSession().getAttribute("lastUrl");
                            loggerCommCon.info("lastUrl: " + lastUrl);
                            request.getSession().removeAttribute("lastUrl");
                            response.sendRedirect(lastUrl);
                        } else {
                            response.sendRedirect(request.getContextPath() + "/a/home");
                        }
                    }
                /* 密码错误回到登陆*/
                    else {
                        out.write("  <script charset=\"utf-8\" language=\"javaScript\"> alert('密码错误');</script>".getBytes());
                        response.setHeader("refresh", "0;url=/a/login");
                    }
                }catch (Throwable t){
                    t.printStackTrace();
                    loggerCommCon.error(t.getMessage());
                }

            }
            /*当useBeing 为0时没有这个用户名*/
            else{
                    out.write(" <script charset=\"utf-8\" language='javaScript'> alert('用户名不存在');</script>".getBytes());
                    response.setHeader("refresh", "0;url=/a/login");
                }
            }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('用户名密码不能为空');</script>".getBytes());
            response.setHeader("refresh", "0;url=/a/login");
        }
    }





    /**
     * 退出登陆
     * @param request
     * @param response
     * @param model
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/a/logout",method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response, Model model)  throws ServletException, IOException{
        //查看当前所有cookie
        Cookie[] cookies = request.getCookies();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        loggerCommCon.info("退出登录--cookie数量: " + cookies.length);
        for(int i = 0;i<cookies.length;i++){
            if("token".equals(cookies[i].getName()) || "user".equals(cookies[i].getName()) ){
                Cookie cookieToken = new Cookie(cookies[i].getName(),null);
                 /*同样的cookie名字 可以代替 原来的那个，设置 有效时间为o 就可以注销 */
                cookieToken.setMaxAge(0);
                /**
                 * 删除 Cookie 时，只设置 maxAge=0 将不能够从浏览器中删除 cookie,
                 * 因为一个 Cookie 应当属于一个 path 与 domain(value)，所以删除时，Cookie 的这两个属性也必须设置。
                 *
                 * 误区: 刚开始时，我没有发现客户端发送到服务器端的 cookie 的 path 与 value 值为空这个问题。
                 * 因为在登陆系统时，我设置了 Cookie 的 path 与 value属性的值, 就误认为每次客户端请求时，都会把 Cookie 的
                 * 这两个属性也提交到服务器端，但系统并没有把 path 与 domain(value) 提交到服务器端 (提交过来的只有 Cookie 的 key，value 值)。
                 */
                // 重点是这里 2, 必须设置 path 属性的值
                cookieToken.setPath("/");
                response.addCookie(cookieToken);
                loggerCommCon.info("token name: "+cookies[i].getName());
                loggerCommCon.info("token value: "+cookies[i].getValue());
                loggerCommCon.info("token已经消除 ");
                continue;
            }
        }
        /*不仅cookie 要注销，用户也要注销*/

        HttpSession session = request.getSession();
/*        一、把user的value赋值为null
        session.setAttribute("user", null);*/
        //二、清空user的值
        session.removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/a/login");
    }


    /**
     * 注册新用户 ，输入qq,user,key
     * @param request
     * @param response
     * @param model
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/a/enrollment",method = RequestMethod.POST)
    public void enrollment(HttpServletRequest request, HttpServletResponse response, Model model)  throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        Integer qq = new Integer(request.getParameter("qq"));

        String requestUri = request.getRequestURI();
        loggerCommCon.info("user-jsp: "+user + "\nqq-jsp: "+ qq);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();

        //非法字符判断,为0时有非法字符
        int signal = sensitiveWords(request,response);
        if(signal == 0){
            return;
        }

        Student student =new Student();
        try {
            student.setUser(user);

            md5 = new Md5Utils();
            pass = md5.getMD5(pass);
            student.setPass(pass);
            student.setQq(qq);
            loggerCommCon.info("注册的用户名为： " + student.getUser());
            Integer userNumber = studentService.insertStudentUser(student);

            loggerCommCon.info("注册的用户名为： " + student.getUser());
            if (userNumber == -1) {
                loggerCommCon.info("用户名已注册： " + student.getUser());
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('该用户名已经存在');</script>".getBytes());
                response.setHeader("refresh", "0;url=/a/login");
            }
            else if (userNumber == 1) {
                //用户加密和存储
                userEncryptionAndStorage(request, response, student);
                if (request.getSession().getAttribute("lastUrl") != null) {
                    //获取名为lastUrl的session的value,然后设为null
                    String lastUrl = (String) request.getSession().getAttribute("lastUrl");
                    loggerCommCon.info("lastUrl: " + lastUrl);
                    request.getSession().setAttribute("lastUrl", null);
                    loggerCommCon.info((String) request.getSession().getAttribute("lastUrl"));
                    out.write("<script charset=\"utf-8\" language='javaScript'> alert('已成功注册');</script>".getBytes());
                    //得到根路径后的url
                    response.setHeader("refresh", "0;url=" + lastUrl);
                } else {
                    out.write("<script charset=\"utf-8\" language='javaScript'> alert('已成功注册');</script>".getBytes());
                    response.setHeader("refresh", "0;url=/a/home");
                }
            } else {
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('注册失败');</script>".getBytes());
                response.setHeader("refresh", "0;url=/a/login");
            }
        }catch (Throwable t){
            t.printStackTrace();
            loggerCommCon.error(t.getMessage());
        }

    }


    /**
     * 用户加密和存储
     * @param request
     * @param response
     * @param study
     */
    public void  userEncryptionAndStorage(HttpServletRequest request, HttpServletResponse response,Student study) {
        //生成session
        HttpSession session = request.getSession();
        session.setAttribute("user", study.getUser());

        //对用户 id 和登陆时间进行DES加密
        DesUtils desUtils = new DesUtils();

        String id = study.getId().toString();
        byte[] str1 = desUtils.desCrypto(id.getBytes(), DES_KEY);
        String createDate = String.valueOf(System.currentTimeMillis());
        byte[] str2 = desUtils.desCrypto(createDate.getBytes(), DES_KEY);
        //对加密后的id和登陆时间字符进行Base64编码
        String results = Base64.encodeBase64String(str1) + ":" + Base64.encodeBase64String(str2) ;

    /*设置cookie,  Cookie 里面放的是 用户的id 和 创建时间*/
        Cookie cookieToken = new Cookie("token", results);

        cookieToken.setMaxAge(60*30);
        cookieToken.setPath("/");
        response.addCookie(cookieToken);


        Cookie cookieUser = new Cookie("user",study.getUser());
        cookieUser.setMaxAge(60*30);
        cookieUser.setPath("/");
        response.addCookie(cookieUser);
        loggerCommCon.info("cookies number: " + request.getCookies().length);
    }


    /**
     * 获取非法字符的判断
     */
    public int sensitiveWords(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        //获取非法字符
        try{
            String errorMessage = request.getAttribute("errorMessage").toString();
            if(errorMessage != "1") {
                String script = "<script charset=\"utf-8\" language='javaScript'> alert('" + errorMessage + "');</script>";
                out.write(script.getBytes());
                response.setHeader("refresh", "0;url=/a/login");
                return 0;
            }
        }catch (Throwable t){
            t.printStackTrace();
            loggerCommCon.error("t.getMessage() : "+ t.getMessage());
        }
        return 1;
    }
}
