package com.controller;

import com.bean.GoodStudent;
import com.bean.Mail;
import com.bean.User;
import com.service.IGoodStudentService;
import com.service.IJobsService;
import com.service.UserServiceImpl;
import com.util.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @author Arike
 * Create_at 2017/12/26 20:04
 */
@Controller
public class MyController {
    @Autowired
    IGoodStudentService goodStudentServiceImpl;
    @Autowired
    IJobsService jobsServiceImpl;
    @Autowired
    UserServiceImpl userDao;
    @Autowired
    RedisUtil redisUtil;
    
    /**
     * 首页
     *
     * @param model 用于给页面使用的模型
     * @return 返回tiles框架里的definition的name
     */
    @RequestMapping(value = "/u/jnshu", method = RequestMethod.GET)
    public String jnshu(ModelMap model) {
        List<GoodStudent> list = goodStudentServiceImpl.selectAll();
        model.addAttribute("list", list);
        model.addAttribute("count", goodStudentServiceImpl.count());
        model.addAttribute("countGood", goodStudentServiceImpl.countGood());
        return "jnshu";
    }
    
    /**
     * 职业列表
     *
     * @param model 用于返回给页面使用的模型
     * @return 返回tiles框架里的definition的name
     */
    @RequestMapping("/u/joblist")
    public String job(ModelMap model) {
        model.addAttribute("joblist", jobsServiceImpl.selectJobs());
        return "joblist";
    }
    
    /**
     * 关于页面
     *
     * @return 返回tiles框架里的definition的name(该页面没有动态资源)
     */
    @RequestMapping("/u/cooperation")
    public String cooperation() {
        return "cooperation";
    }
    
    /**
     * 登陆页面
     *
     * @return 返回login页面
     */
    @RequestMapping(value = "/l/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    /**
     * 登陆按钮的URL
     *
     * @param response 用于给与(响应)页面cookie使用
     * @param session  用于记录与cookie验证的key/value以及记录用户的用户名用于页面显示
     * @param model    返回给页面使用显示账密错误情况
     * @param user     接收用户输入的账户名以及密码用于验证登陆
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String checkLogin(HttpServletResponse response, HttpSession session, ModelMap model, User user) {
        if (userDao.checkLogin(user, response, session)) {
            return "redirect:/u/jnshu";
        } else {
            model.addAttribute("intro", "用户名或密码错误,请重新登陆");
            return "redirect:/l/login";
        }
    }
    
    /**
     * @param request 用以获取cookie和session对象,并清除cookie以及session的值.
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String delCookie(HttpServletRequest request) {
//        WebUtils.getCookie(request, "key").setValue(null);
        request.getSession().invalidate();
        return "redirect:/l/login";
    }
    
    /**
     * 注册按钮的URL
     *
     * @param user 接收用户填写的注册信息
     * @return
     */
    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    public String regUser(User user, ModelMap model) {
        userDao.insertUser(user, model);
        return "regUser";
    }
    
    /**
     * 尝试了一下json对象的使用
     *
     * @return 范围一个json
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject json() {
        JSONObject jsonObject = new JSONObject();
        int[] arr = {1, 2, 3, 4, 5};
        jsonObject.put("name", 1);
        jsonObject.put("arr", arr);
        return jsonObject;
    }
    
    /**
     * 对应用户个人设置页面
     *
     * @return
     */
    @RequestMapping(value = "/u/user", method = RequestMethod.GET)
    public String user(ModelMap modelMap, HttpSession session) {
        User user = userDao.selectUser((String) session.getAttribute("name"));
        modelMap.addAttribute("email", user.getEmail());
        modelMap.addAttribute("emailConf", user.getEmailConf());
        modelMap.addAttribute("head", user.getHead());
        modelMap.addAttribute("mailCount", session.getAttribute("mailCount"));
        modelMap.addAttribute("phone", user.getPhone());
        modelMap.addAttribute("phoneConf", user.getPhoneConf());
        modelMap.addAttribute("phoneCount", session.getAttribute("phoneCount"));
    
        return "user";
    }
    
    //上传头像
    @RequestMapping(value = "/u/file", method = RequestMethod.POST)
    public String fileup(MultipartFile file, HttpSession session) throws IOException {
        //获取到输入流
        InputStream is = file.getInputStream();
        //通过split方法用.分割文件名,并获取到最大索引位置的字符串(肯定就是后缀名了,不管他有多少个.)
        String[] name = file.getOriginalFilename().split("\\.");
        String end = name[name.length - 1];
        User user = new User();
        user.setUserName((String) session.getAttribute("name"));
        user.setHead(Oss.fileUp(is, end));
        userDao.upHead(user);
        return "redirect:/u/user";
    }
    
    //下载
    @RequestMapping(value = "/f", method = RequestMethod.GET)
    public void download(HttpServletResponse response) throws IOException {
        //拿到响应流
        ServletOutputStream os = response.getOutputStream();
        //读取需要被下载的文件
        FileInputStream is = new FileInputStream("/soft/1.jpg");
        //这个仅是为了能够使用中文名显示下载的文件.
        String str = "好看的图.jpg";
        str = new String(str.getBytes("utf-8"), "ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + str);
        IOUtils.copy(is, os);
        is.close();
        os.close();
    }
    
    //发送验证邮件
    @RequestMapping(value = "/u/email", method = RequestMethod.GET)
    public String email(HttpServletRequest request, HttpSession session) throws IOException {
        //这两句代码是为了获取请求URL
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        User user = userDao.selectUser((String) session.getAttribute("name"));
        //获取点击链接的密钥,以及密钥ID
        String verifyCode = UUID.randomUUID().toString();
        String verifyCodeKey = user.getId().toString();
        //将密钥存储进redis缓存中用于等待激活验证,存活时间为15分钟
        redisUtil.put("mail", verifyCodeKey, verifyCode, 60 * 15L);
        //统计邮件发送条数,发送1封之后给用户显示已发送.
        session.setAttribute("mailCount", 1);
        Mail mail = new Mail();
        mail.setAddress(user.getEmail());
        mail.setName(user.getUserName());
        //进行验证url的拼接,使用get请求的方式将验证密钥和ID携带在URL中发送给用户邮件
        mail.setUrl(basePath + "/verify?verifyCode=" + verifyCode + "&verifyCodeKey=" + verifyCodeKey);
        //调用邮件发送接口
        SendCloudAPIV2_44.send_template(mail);
        return "redirect:/u/user";
    }
    
    //用户url验证
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verify(String verifyCode, String verifyCodeKey, HttpSession session) {
        //判断用户通过URL  get访问过来的数据是否能和redis中数据配对.
        if (verifyCode.equals(redisUtil.get("mail", verifyCodeKey))) {
            //配对成功更新数据库中的验证字段
            userDao.upEmail(new Long(verifyCodeKey));
            //成功之后删除对应的缓存以及Session字段.
            redisUtil.del("mail", "verifyCode");
            session.removeAttribute("mailCount");
        }
        return "redirect:/u/user";
    }
    
    //发送短信
    @RequestMapping(value = "/u/phone", method = RequestMethod.GET)
    public String sendCode(HttpSession session) {
        User user = userDao.selectUser((String) session.getAttribute("name"));
        String code = Encrypt.code();
        session.setAttribute("code",code);
        Sms.send(code, user.getPhone());
        session.setAttribute("phoneCount", 1);
        return "redirect:/u/user";
    }
    
    //验证短信
    @RequestMapping(value = "/u/phoneCode", method = RequestMethod.POST)
    public String phoneCode(String code,HttpSession session) {
        if(session.getAttribute("code").equals(code)){
            userDao.upPhone((String) session.getAttribute("name"));
            session.removeAttribute("code");
            session.removeAttribute("phoneCount");
        }
        return "redirect:/u/user";
    }
}